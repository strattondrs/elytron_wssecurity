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

## Running it

### Powershell environment

Execute the script `doIt.ps1`

### Any other environment

* Build the WAR file (e.g. `mvn clean verify`)
* Build the Docker image (e.g. `docker build -t elytron .` )
* Run the image (e.g. `docker run --rm --name wildfly -e DEBUG_PORT="*:8787" -p 8080:8080 -p 8443:8443 -p 9990:9990 -p 8787:8787 -p 1099:1099 -it elytron /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 --debug`)