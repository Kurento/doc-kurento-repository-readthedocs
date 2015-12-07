%%%%%%%%%%%%%%
Code structure
%%%%%%%%%%%%%%

Kurento Repository is hosted on github:

https://github.com/Kurento/kurento-java/tree/master/kurento-repository

The git repository contains a Maven project with the following modules:

- `kurento-java <https://github.com/Kurento/kurento-java>`_ - reactor project.
- `kurento-repository-internal <https://github.com/Kurento/kurento-java/tree/master/kurento-repository/kurento-repository-internal>`_ - core Java library of repository. Plain Java mostly, but with `Spring <https://spring.io/>`_ dependencies.
- `kurento-repository-server <https://github.com/Kurento/kurento-java/tree/master/kurento-repository/kurento-repository-server>`_ - Wrapper for the library, offering a simpler Java API and a Http REST API. Contains a :term:`Spring Boot` application, very easy to setup and run.
