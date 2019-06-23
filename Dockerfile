FROM openjdk:8-jre-alpine

COPY target/fluxapi-*.jar fluxapi.jar
#Port the container listens on
EXPOSE 8080

#CMD to be executed when docker is run.
CMD ["java","-jar","/fluxapi.jar"]
