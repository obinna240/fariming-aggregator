FROM openjdk
VOLUME /tmp
ADD maven/farming-aggregator-0.0.1-SNAPSHOT.jar farmingAggregatorApp.jar
RUN sh -c 'touch /farmingAggregatorApp.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/farmingAggregatorApp.jar"]