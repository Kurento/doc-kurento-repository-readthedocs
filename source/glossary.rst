Glossary
========

This is a glossary of terms that often appear in discussion about multimedia
transmissions. Most of the terms are described and linked to its wikipedia, RFC
or W3C relevant documents. Some of the terms are specific to :term:`kurento`.


.. glossary::

    BSON
        It's a computer data interchange format used mainly as a data storage and network transfer format in the MongoDB database. It is a binary form for representing simple data structures and associative arrays (called objects or documents in MongoDB).

    HTTP
        The :wikipedia:`Hypertext Transfer Protocol <en,Hypertext_Transfer_Protocol>`
        is an application protocol for distributed, collaborative, hypermedia
        information systems. HTTP is the foundation of data communication for
        the World Wide Web.

        .. seealso:: :rfc:`2616`

    JSON
        `JSON <http://json.org>`__ (JavaScript Object Notation) is a lightweight
        data-interchange format. It is designed to be easy to understand and
        write for humans and easy to parse for machines.

    JSON-RPC
        `JSON-RPC <http://json-rpc.org/>`__ is a simple remote procedure
        call protocol encoded in JSON. JSON-RPC allows for notifications
        and for multiple calls to be sent to the server which may be
        answered out of order.

    Kurento
        `Kurento <http://kurento.org>`__ is a platform for the development of multimedia
        enabled applications. Kurento is the Esperanto term for the English word
        'stream'. We chose this name because we believe the Esperanto principles are
        inspiring for what the multimedia community needs: simplicity, openness and
        universality. Kurento is open source, released under LGPL 2.1, and has several
        components, providing solutions to most multimedia common services
        requirements. Those components include: :term:`Kurento Media Server`,
        :term:`Kurento API`, :term:`Kurento Protocol`, and :term:`Kurento Client`.

    Kurento API
         **Kurento API** is an object oriented API to create media pipelines to control
         media. It can be seen as and interface to Kurento Media Server. It can be used from the
         Kurento Protocol or from Kurento Clients.

    Kurento Client
         A **Kurento Client** is a programming library (Java or JavaScript) used to control
         **Kurento Media Server** from an application. For example, with this library, any developer
         can create a web application that uses Kurento Media Server to receive audio and video from
         the user web browser, process it and send it back again over Internet. Kurento Client
         exposes the :term:`Kurento API <Kurento API>` to app developers.

    Kurento Protocol
         Communication between KMS and clients by means of :term:`JSON-RPC` messages.
         It is based on :term:`WebSocket` that uses :term:`JSON-RPC` V2.0 messages for making
         requests and sending responses.

    Kurento Media Server
         **Kurento Media Server** is the core element of Kurento since it responsible for media
         transmission, processing, loading and recording.

    Maven
        `Maven <http://maven.apache.org/>`_ is a build automation tool used primarily for Java projects.

    MongoDB
        MongoDB (from hu\ **mongo**\ us) is a cross-platform 
        document-oriented database. Classified as a NoSQL database, MongoDB 
        eschews the traditional table-based relational database structure in 
        favor of :term:`JSON`-like documents with dynamic schemas (MongoDB calls the 
        format :term:`BSON`), making the integration of data in certain types of 
        applications easier and faster. MongoDB is free and open-source software.
        
        .. seealso:: 
            :wikipedia:`MongoDB <en,MongoDB>` page at Wikipedia
            
            `MongoDB official page <https://www.mongodb.org>`_ 

    Multimedia
        Multimedia is concerned with the computer controlled integration
        of text, graphics, video, animation, audio, and any other media where
        information can be represented, stored, transmitted and processed
        digitally.

        There is a temporal relationship between many forms of media,
        for instance audio, video and animations. There 2 are forms of problems
        involved in

            * Sequencing within the media, i.e. playing frames in correct
              order or time frame.
            * Synchronisation, i.e. inter-media scheduling. For example,
              keeping video and audio synchronized or displaying captions
              or subtitles in the required intervals.

        .. seealso:: Wikipedia definition of :wikipedia:`en,Multimedia`

    REST
        :wikipedia:`Representational State Transfer <en,Representational_state_transfer>`
        is an architectural style consisting of a coordinated set of constraints applied to
        components, connectors, and data elements, within a distributed hypermedia system.
        The term representational state transfer was introduced and defined in 2000 by
        Roy Fielding in his `doctoral dissertation
        <http://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm>`__.

    Retrofit
        Retrofit is a type-safe REST client for Android built by Square. As 
        stated on its webpage, it turns your HTTP API into a Java interface.
        
        .. seealso:: `Retrofit <http://square.github.io/retrofit/>`_ 
            home page with documentation and examples

    Sphinx
        Documentation generation system used for Brandtalk documentation.

        .. seealso:: `Easy and beautiful documentation with Sphinx <http://www.ibm.com/developerworks/linux/library/os-sphinx-documentation/index.html?ca=dat>`_

    Spring Boot
        `Spring Boot <http://projects.spring.io/spring-boot/>`_ is Spring's convention-over-configuration
        solution for creating stand-alone, production-grade Spring based applications that can you can "just run".
        It embeds Tomcat or Jetty directly and so there is no need to deploy WAR files in order to run
        web applications.

    WebSocket
        `WebSocket <https://www.websocket.org/>`__ specification (developed as
        part of the HTML5 initiative) defines a full-duplex single socket
        connection over which messages can be sent between client and server.
