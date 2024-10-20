FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY ./build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]

CMD ["gradle", "bootRun"]