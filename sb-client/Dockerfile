FROM openjdk:11

RUN mkdir -p /builder/rest

WORKDIR /builder/rest

COPY /target/sb-client*.jar sb-client.jar

CMD java -jar sb-client.jar 

EXPOSE 8080