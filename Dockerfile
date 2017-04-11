FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/tree-model-system.jar /tree-model-system/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/tree-model-system/app.jar"]
