FROM maven:3.9.11-eclipse-temurin-25-alpine AS build

WORKDIR /project

# Cache dependencies first for faster rebuilds
COPY pom.xml .
RUN mvn -B -q dependency:go-offline

COPY src ./src
RUN mvn -B clean package -DskipTests

FROM amazoncorretto:25-alpine-jdk
LABEL maintainer="hendisantika@yahoo.co.id"

RUN addgroup -g 1001 -S hendigroup && \
    adduser -S hendi -u 1001 -G hendigroup && \
    mkdir /app

COPY --from=build /project/target/qrcode-generator-0.0.1.jar /app/qr.jar

WORKDIR /app

RUN chown -R hendi:hendigroup /app

USER hendi

EXPOSE 8083

CMD java $JAVA_OPTS -jar qr.jar
