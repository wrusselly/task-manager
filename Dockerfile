FROM maven:latest as maven
WORKDIR /build
COPY . . 
RUN mvn clean package
FROM java:8
WORKDIR /opt/back-end
COPY --from=maven /build/target/spring-test-app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]
