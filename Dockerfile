FROM gradle:jdk11 as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:11
EXPOSE 8080
COPY --from=builder /home/gradle/src/api/build/libs/api-1.0-SNAPSHOT.jar /app/
WORKDIR /app
CMD java -jar api-1.0-SNAPSHOT.jar