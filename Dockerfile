FROM openjdk:11

COPY target/tpfinalhia2023-0.0.1-SNAPSHOT.jar /

ENTRYPOINT [ "java", "-jar", "/tpfinalhia2023-0.0.1-SNAPSHOT.jar" ]
