#!/usr/bin/env bash

#LY_BASE=`pwd`
JAVA_OPTS="-server -XX:PermSize=128M -XX:MaxPermSize=256m -Xms256m -Xmx1024m"
echo "Starting LY platform..."
java $JAVA_OPTS -Dfile.encoding=UTF-8 -jar run.jar -r