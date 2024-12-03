FROM openjdk:23
COPY ./out/production/DockerHelloWorld/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","HarkkatyoApplication"]
