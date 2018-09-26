FROM java:8

RUN mkdir -p /workdir

COPY target/CricAPIConsumer-0.0.1-SNAPSHOT.jar /workdir

WORKDIR /workdir

EXPOSE 8080

ENTRYPOINT java -jar CricAPIConsumer-0.0.1-SNAPSHOT.jar