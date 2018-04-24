FROM rodimes/spring-boot

MAINTAINER Rodrigo <rodimes@gmail.com>

ENV JAVA_TIMEZONE=America/Sao_Paulo
ENV JAVA_OPTS="-XX:-OmitStackTraceInFastThrow -Xmx512m"

RUN touch /tmp/test.mv.db

EXPOSE 8081
