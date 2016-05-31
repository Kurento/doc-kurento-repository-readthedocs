Repository Client
=================

This Java library belonging to the Kurento Repository stack has been designed
using the :term:`Retrofit` framework in order to provide a Java wrapper for the
:doc:`HTTP REST interface <repository_rest_api>` exposed by the repository
server.

Repository Java API
-------------------

This API maps directly over the
:doc:`REST interface layer<repository_rest_api>`, in such a way that the
primitives exposed by this library mirror the REST ones.

The Java documentation included in ``org.kurento.repository.RepositoryClient``
and its factory ``org.kurento.repository.RepositoryClientProvider`` is quite
detailed so it shouldn't be very difficult to set up a client connected to a
running Kurento Repository Server (don't forget to check our tutorials, and
especially the
`kurento-hello-world-repository <https://github.com/Kurento/kurento-tutorial-java/tree/master/kurento-hello-world-repository>`_).

This library can be imported as a Maven dependency and then instances of
``org.kurento.repository.RepositoryClient`` can be created in order to interact
with the repository server. The Maven artifact to be included in you pom.xml is

.. code-block:: xml

   <dependency>
       <groupId>org.kurento</groupId>
       <artifactId>kurento-repository-client</artifactId>
       <version>6.5.1-SNAPSHOT</version>
   </dependency>

We provide a Kurento Java tutorial,
`kurento-hello-world-repository <https://github.com/Kurento/kurento-tutorial-java/tree/master/kurento-hello-world-recording>`_
, which uses this library to save the streamed media from a web browser using a
repository server instance.

Repository internals
--------------------

The internal library of Kurento Repository provides an API that can be used to
manage media repositories based on filesystem or :term:`MongoDB`.

The chosen transport for the media is the HTTP protocol. The repository API will
provide managed URIs which the application or :term:`Kurento Media Server` can
use to upload or download media.

This library can be configured and instantiated as a Spring bean. Although, it
shouldn't be used directly but through the
:doc:`repository server <repository_server>` which offers a REST and Java APIs
which should suffice for most applications.
