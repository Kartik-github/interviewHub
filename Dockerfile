FROM openjdk:11 
EXPOSE 9080
ADD ./target/shop-jar-with-dependencies.jar shop.jar
ENTRYPOINT ["java","-jar", "shop.jar"]