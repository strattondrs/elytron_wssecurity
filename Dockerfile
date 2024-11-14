FROM quay.io/wildfly/wildfly:26.1.3.Final-jdk17

# Setup our users
RUN cd /opt/jboss/wildfly/bin && \
    ./add-user.sh    -u 'developer' -p 'developer' --silent                               && \
    ./add-user.sh -a -u 'guest'     -p 'guest'     --silent -g 'guest'                    && \
    ./add-user.sh -a -u 'authu'     -p 'authu'     --silent -g 'guest,securitytest'       && \
    ./add-user.sh -a -u 'developer' -p 'developer' --silent -g 'guest,admin,securitytest'

# Copy in the configuration or we won't have our module
COPY standalone.xml                  /opt/jboss/wildfly/standalone/configuration

# Deploy the EAR/WAR
ADD target/my-soap-service-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
