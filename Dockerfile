FROM openjdk:17-jdk-alpine

WORKDIR /app

RUN gradle bootJar

COPY ./build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

CMD ["gradle", "bootRun"]