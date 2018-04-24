#!/bin/bash -e
set -o pipefail

. bin/build.sh

HOSTNAME=${CONTAINER_NAME}
RESTART="unless-stopped"
FASTABC_FOLDER="/opt/app/do_run"


docker stop ${CONTAINER_NAME} || true

docker rm ${CONTAINER_NAME} || true

docker network create --driver bridge web || true

docker run -d -p8081:8081 --network=web -v "${FASTABC_FOLDER}:${FASTABC_FOLDER}" --name=${CONTAINER_NAME} --hostname ${HOSTNAME} --restart ${RESTART} -e JAVA_TIMEZONE=America/Sao_Paulo ${CONTAINER_NAME}
