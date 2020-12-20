FROM    maven:3.6.3-jdk-11
RUN     mkdir /QualityPointTech1
WORKDIR /QualityPointTech1
COPY    . .
RUN ls
CMD mvn clean test -Dcucumber.options="--tags '@TC_01'" -DexecutionPlatform="LOCAL_CHROME"
