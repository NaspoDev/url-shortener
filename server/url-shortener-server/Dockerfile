# All the official java images are deprecated for some reason,
# so I have to use a trusted thrid-party.
FROM eclipse-temurin:21
WORKDIR /app
COPY ./target/url-shortener-server-1.0.0.jar .
EXPOSE 8080
CMD ["java", "-jar", "url-shortener-server-1.0.0.jar"]