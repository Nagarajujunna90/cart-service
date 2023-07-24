FROM openjdk:17
EXPOSE 8087
ADD target/cart-service-0.0.1-SNAPSHOT.jar cart-service
ENTRYPOINT ["java","-jar","cart-service"]