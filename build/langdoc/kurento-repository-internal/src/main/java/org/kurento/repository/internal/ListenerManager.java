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

package org.kurento.repository.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.kurento.repository.HttpSessionErrorEvent;
import org.kurento.repository.HttpSessionStartedEvent;
import org.kurento.repository.HttpSessionTerminatedEvent;
import org.kurento.repository.RepositoryHttpEventListener;
import org.kurento.repository.RepositoryHttpSessionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("rawtypes")
public class ListenerManager {

  private static final Logger log = LoggerFactory.getLogger(ListenerManager.class);

  private final Map<Class<? extends RepositoryHttpSessionEvent>, List<RepositoryHttpEventListener>> listeners =
      new ConcurrentHashMap<>();

  public void addStartedEventListener(
      RepositoryHttpEventListener<HttpSessionStartedEvent> listener) {
    addListener(listener, HttpSessionStartedEvent.class);
  }

  public void addTerminatedEventListener(
      RepositoryHttpEventListener<HttpSessionTerminatedEvent> listener) {
    addListener(listener, HttpSessionTerminatedEvent.class);
  }

  public void addErrorEventListener(RepositoryHttpEventListener<HttpSessionErrorEvent> listener) {
    addListener(listener, HttpSessionErrorEvent.class);
  }

  // TODO Improve concurrency
  protected synchronized <E extends RepositoryHttpSessionEvent> void addListener(
      RepositoryHttpEventListener<E> listener, Class<E> eventType) {

    List<RepositoryHttpEventListener> listenersType = listeners.get(eventType);

    if (listenersType == null) {
      listenersType = new ArrayList<>();
      listeners.put(eventType, listenersType);
    }

    listenersType.add(listener);
  }

  @SuppressWarnings("unchecked")
  public void fireEvent(RepositoryHttpSessionEvent event) {

    List<RepositoryHttpEventListener> listenersType = listeners.get(event.getClass());

    if (listenersType != null) {
      for (RepositoryHttpEventListener listener : listenersType) {
        try {
          listener.onEvent(event);
        } catch (Exception e) {
          log.warn("Exception while executing an event listener", e);
        }
      }
    }
  }

}
