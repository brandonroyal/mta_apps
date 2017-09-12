#build stage
FROM maven:3-jdk-8-alpine AS builder

WORKDIR /usr/src/mymaven

ADD pom.xml .

RUN ["mvn", "clean"]

ADD . /usr/src/app

RUN ["mvn", "package", "-DskipTests"]

#application stage
FROM tomcat:9-alpine
# Install dependencies
RUN apk update; apk add zip netcat-openbsd curl

ENV MYSQL_DB_HOST=0.0.0.0 MYSQL_DB_PORT=3306

WORKDIR /app

# This script forces a wait to make sure the DB is ready
COPY ./bootstrap.sh .
RUN ["chmod", "+rx", "./bootstrap.sh"]

### Deploy the WAR to Tomcat
# Remove the root folder
RUN ["rm", "-r", "/usr/local/tomcat/webapps/ROOT"]
# Copy the application archive as ROOT.war so that the app becomes the root 
COPY --from=builder /usr/src/mymaven/target/mta-java.war /usr/local/tomcat/webapps/test.war

ENTRYPOINT ["/app/bootstrap.sh"]