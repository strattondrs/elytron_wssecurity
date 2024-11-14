
Push-Location $PSScriptRoot

Write-Host "Building our WAR file"

mvn clean verify

Write-Host 'Building docker image'

docker build -t elytron .
if( !$? ) {
  Write-Error 'Docker image failed to build'
  exit 1
}

Write-Host "Running elytron and exposing ports 8080, 8443, 8787, 9990 and 1099"
docker run --rm --name wildfly -e DEBUG_PORT="*:8787" -p 8080:8080 -p 8443:8443 -p 9990:9990 -p 8787:8787 -p 1099:1099 -it elytron /opt/jboss/wildfly/bin/standalone.sh -b 0.0.0.0 -bmanagement 0.0.0.0 --debug

Pop-Location