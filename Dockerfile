FROM improving/java:0.1

MAINTAINER Rodrigo <rodimes@gmail.com>
WORKDIR /usr/local/bin/

ENV JAVA_TIMEZONE=America/Sao_Paulo
ENV JAVA_OPTS="-XX:-OmitStackTraceInFastThrow -Xmx512m"
ENV APP_DIR=/opt/app/do_run
ENV TARGET_DIR=target

COPY ${TARGET_DIR}/fastabc.jar ${APP_DIR}/app.jar
COPY ./bin/fastabc.sh /usr/local/bin/

RUN touch /tmp/test.mv.db

EXPOSE 8081
CMD ["fastabc.sh"]
