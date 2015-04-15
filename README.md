Quick wizrad webapp
===================

This as a project which can be used to quickly develop any web application. No need to worry about stack and framework setup.

===========================================================================================================================

Stack:

Angularjs + Spring boot + Spring Data+ Mongo db

=========================================================================================================================

How to run this quick wizard web application


1. Start mongo db

cd <mongo_installation>/bin

mongod --dbpath ../data/db

2. Run the Spring boot rest services
Run Application.java

Webapp should be up at http://localhost:8080/



How to debug Sprnig boot services:
Dbug configuration: VM argument : -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n
host:localhost , port: 8000

 Run Application.java 

======================================================================================================
@author: Prithvi Atal
