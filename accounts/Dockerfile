#starts with base image container for the java runtime
FROM openjdk:18
#this is the maintainer
LABEL maintainer="Jason khongwir"

#add the application copy to the image the image name is the right
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar
#execute the application just like the command line
ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]
