FROM java:8 as builder

# Install wget
RUN apt-get install -y wget

# Install maven
RUN apt-get update

# get maven 3.2.2
RUN wget --no-verbose -O /tmp/apache-maven-3.2.2.tar.gz http://archive.apache.org/dist/maven/maven-3/3.2.2/binaries/apache-maven-3.2.2-bin.tar.gz

# install maven
RUN tar xzf /tmp/apache-maven-3.2.2.tar.gz -C /opt/
RUN ln -s /opt/apache-maven-3.2.2 /opt/maven
RUN ln -s /opt/maven/bin/mvn /usr/local/bin
RUN rm -f /tmp/apache-maven-3.2.2.tar.gz
ENV MAVEN_HOME /opt/maven

# remove download archive files
RUN apt-get clean

WORKDIR /code

# Copy the maven file to the app directory
COPY pom.xml .

# Update the maven dependencies
RUN ["mvn", "clean"]

# Copy the rest of the app's source code
COPY src ./src

# Package the WAR
RUN ["mvn", "package", "-DskipTests"]

FROM java:8

ENV MYSQL_DB_HOST=0.0.0.0 MYSQL_DB_PORT=3306

WORKDIR /app

### Deploy the WAR to Tomcat
# Remove the root folder
#RUN ["rm", "-r", "/usr/local/tomcat/webapps/ROOT"]
# Copy the application archive as ROOT.war so that the app becomes the root 
COPY --from=builder /code/target/mta-java.jar /app/app.jar

# ENTRYPOINT ["java -jar app.jar"]