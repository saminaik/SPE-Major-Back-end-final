FROM openjdk:17
COPY ./target/Hospital_Managemant-0.0.1-SNAPSHOT.jar ./
WORKDIR ./
EXPOSE 8081
CMD ["java", "-jar", "Hospital_Managemant-0.0.1-SNAPSHOT.jar"]
