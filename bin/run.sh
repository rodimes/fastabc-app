#!/bin/bash -e
set -o pipefail

. bin/build.sh

HOSTNAME=${CONTAINER_NAME}
RESTART="unless-stopped"

docker stop ${CONTAINER_NAME} || true

docker rm ${CONTAINER_NAME} || true

docker network create --driver bridge web || true

docker run -d -p8081:8080 --network=web --name=${CONTAINER_NAME} --hostname ${HOSTNAME} --restart ${RESTART} -e JAVA_TIMEZONE=America/Sao_Paulo ${CONTAINER_NAME}
