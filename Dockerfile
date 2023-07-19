FROM openjdk:8.0
EXPOSE 8085
ADD target/cart-service-0.0.1-SNAPSHOT.jar cart-service
ENTRYPOINT ["java","-jar","cart-service"]