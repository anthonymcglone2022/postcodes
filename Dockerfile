FROM eclipse-temurin:latest

# Set the working directory in the container
WORKDIR /app

COPY target/postcodes-0.0.1-SNAPSHOT.jar postcodes-docker.jar
COPY runner.sh .
COPY priv.sql .

# Install MySQL
RUN apt-get update && \
    apt-get install -y default-mysql-server

# Expose port for web app
EXPOSE 9191

RUN chmod +x runner.sh

#ENTRYPOINT ["/bin/tini", "--", "runner.sh"]
ENTRYPOINT sh runner.sh