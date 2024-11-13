# WS-Security with Elytron via Configuration

A simple WebService exposed with authentication and authorization configured
via XML rather than via code changes.

## Pre-requisites

* Docker

## Constraints

Given this is a learning exercise with a view to attempting to alter existing
projects to use this, the following constraints are in place:

* A Wildfly or JBoss version supporting Java EE (*not* Jakarta EE)
* Zero code modifications to apply security
* Minimal amount of change required to lock down the exposed endpoint via
XML configuration
* Ability to change the security domain/realms from Properties files to 
JDBC or others without altering the XML files for the WAR file
