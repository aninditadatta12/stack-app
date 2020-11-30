FROM openjdk:alpine
ARG BUILD_DIR=build
COPY ${BUILD_DIR}/libs/ /app/lib/
ADD ${BUILD_DIR}/libs/stack-0.0.1-SNAPSHOT.jar stack.jar
ENTRYPOINT [ "java", "-jar", "/stack.jar" ]