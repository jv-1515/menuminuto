FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY pom.xml . 

COPY mvnw .
COPY .mvn
COPY .mvn .mvn
COPY src ./src

RUN chmod 777 mvnw

RUN ./mvnw package

CMD ["java", "-jar", "target/menuminuto.war"]