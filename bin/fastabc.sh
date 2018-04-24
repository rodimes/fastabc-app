#!/bin/bash -e
set -o pipefail

java ${JAVA_OPTS} \
  -Dfile.encoding=UTF-8 \
  -jar /opt/app/do_run/app.jar
