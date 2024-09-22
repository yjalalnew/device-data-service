FROM eclipse-temurin:17-jre-alpine

ADD . .

ENTRYPOINT java -jar device-data-service.jar