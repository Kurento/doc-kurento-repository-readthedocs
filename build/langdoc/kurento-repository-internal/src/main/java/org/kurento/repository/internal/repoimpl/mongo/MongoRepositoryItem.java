/*
 * (C) Copyright 2013 Kurento (http://kurento.org/)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */

package org.kurento.repository.internal.repoimpl.mongo;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.kurento.commons.exception.KurentoException;
import org.kurento.repository.RepositoryItemAttributes;
import org.kurento.repository.internal.repoimpl.AbstractRepositoryItem;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.mongodb.gridfs.GridFSInputFile;

public class MongoRepositoryItem extends AbstractRepositoryItem {

  private GridFSFile dbFile;
  private OutputStream storingOutputStream;

  private MongoRepositoryItem(MongoRepository repository, GridFSFile dbFile, State state) {

    super(dbFile.getId().toString(), state, loadAttributes(dbFile), repository);

    this.dbFile = dbFile;
    // don't call ours setMetadata(...)
    super.setMetadata(new HashMap<String, String>());
  }

  private static RepositoryItemAttributes loadAttributes(GridFSFile file) {

    RepositoryItemAttributes attributes = new RepositoryItemAttributes();

    attributes.setContentLength(file.getLength());
    attributes.setLastModified(file.getUploadDate().getTime());
    attributes.setMimeType(file.getContentType());

    return attributes;
  }

  public MongoRepositoryItem(MongoRepository repository, GridFSDBFile dbFile) {
    this(repository, dbFile, State.STORED);
  }

  public MongoRepositoryItem(MongoRepository repository, GridFSInputFile dbFile) {
    this(repository, dbFile, State.NEW);
  }

  @Override
  public InputStream createInputStreamToRead() {
    checkState(State.STORED);
    return ((GridFSDBFile) dbFile).getInputStream();
  }

  @Override
  public OutputStream createOutputStreamToWrite() {
    checkState(State.NEW);

    storingOutputStream = new FilterOutputStream(((GridFSInputFile) dbFile).getOutputStream()) {

      @Override
      public void close() throws IOException {
        putMetadataInGridFS(false);
        super.close();
        refreshAttributesOnClose();
      }
    };

    return storingOutputStream;
  }

  @Override
  public void setMetadata(Map<String, String> metadata) {
    super.setMetadata(metadata);
    if (state.equals(State.STORED)) {
      putMetadataInGridFS(true);
    }
  }

  protected void refreshAttributesOnClose() {
    dbFile = ((MongoRepository) repository).getGridFS().findOne(getId());
    if (dbFile == null) {
      throw new KurentoException("Grid object not found for id " + getId());
    }
    state = State.STORED;
    attributes.setContentLength(dbFile.getLength());
  }

  // TODO Optimize this to use the GridFS metadata
  private void putMetadataInGridFS(boolean save) {
    DBObject metadataDBO = new BasicDBObject();
    for (Entry<String, String> entry : metadata.entrySet()) {
      metadataDBO.put(entry.getKey(), entry.getValue());
    }
    dbFile.setMetaData(metadataDBO);
    if (save) {
      dbFile.save();
    }
  }

}
