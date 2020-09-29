#!/bin/bash

export JAVA_OPTS="-Xms640M -Xmx2000M"
export APP_RUN_TEST_CLIENT_ENABLED=false
 
# Start
exec java -Dfile.encoding=UTF8 -jar app.jar