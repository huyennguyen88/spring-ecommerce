# syntax=docker/dockerfile:1
FROM openjdk:16-alpine3.13
EXPOSE 8080
COPY /target/spring-ecommerce-*.jar spring-ecommerce.jar
ENV APP_ENV=dev
ENV SPRING_DATASOURCE_URL="jdbc:mysql://triplet-db:3306/tripletclothes?serverTimezone=UTC&useSSL=false"
ENV SPRING_DATASOURCE_USERNAME=triplet
ENV SPRING_DATASOURCE_PASSWORD=triplet
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-ecommerce.jar", \
"--APP_ENV=$APP_ENV", \
"--SPRING_DATASOURCE_URL=$SPRING_DATASOURCE_URL", \
"--SPRING_DATASOURCE_USERNAME=$SPRING_DATASOURCE_USERNAME", \
"--SPRING_DATASOURCE_PASSWORD=$SPRING_DATASOURCE_PASSWORD"]