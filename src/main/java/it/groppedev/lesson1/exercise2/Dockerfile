FROM groppedocker/centos-openjdk:jdk-8u242

ENV SRC_HOME=/tmp/src
ENV SRC_PACKAGE=it/groppedev/lesson1/exercise2
ENV MAIN_CLASS_NAME=HelloPeople
ENV SRC_PATH="${SRC_HOME}/${SRC_PACKAGE}"
RUN mkdir -p $SRC_PATH
COPY "${MAIN_CLASS_NAME}.java" $SRC_PATH
RUN javac "${SRC_PATH}/${MAIN_CLASS_NAME}.java"
WORKDIR /tmp
CMD java -Duser.language=it -classpath "$SRC_HOME" "${SRC_PACKAGE//\//.}.${MAIN_CLASS_NAME}" Massimo Marco Matteo