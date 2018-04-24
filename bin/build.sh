#!/bin/bash -e
set -o pipefail

CONTAINER_NAME="fastabc-app"
TAG=0.1

docker build -t ${CONTAINER_NAME}:${TAG} .