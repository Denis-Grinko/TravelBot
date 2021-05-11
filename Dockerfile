FROM openjdk:8-alpine
MAINTAINER Denis Grinko <grinko.da64@gmail.com>
# Required for starting application up.
RUN apk update && apk add bash
RUN addgroup -S authgroup && adduser -S -D authuser -G authgroup

RUN mkdir -p /opt/webapps/travelbot
ENV PROJECT_HOME /opt/webapps/travelbot

COPY target/TravelBot-0.0.1.jar $PROJECT_HOME/travelbot.jar

RUN chown -R authuser:authgroup /opt/webapps/travelbot

WORKDIR $PROJECT_HOME

USER authuser
EXPOSE 8091 5001
ENTRYPOINT ["java", "-Xmx1G", "-jar","./travelbot.jar"]