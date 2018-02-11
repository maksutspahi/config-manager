FROM anapsix/alpine-java:8_jdk
RUN mkdir /var/config-manager
COPY target/config-manager-0.0.1.jar /var/config-manager
WORKDIR /var/config-manager
ENTRYPOINT ["java","-jar","config-manager-0.0.1.jar"]