FROM groppedocker/centos-openjdk:jdk-8u242

ENV SRC_HOME=/tmp/src
ENV SRC_PACKAGE=it/groppedev/lesson1/exercise1
ENV MAIN_CLASS_NAME=HelloJava
ENV SRC_PATH="${SRC_HOME}/${SRC_PACKAGE}"
RUN mkdir -p $SRC_PATH
COPY "${MAIN_CLASS_NAME}.java" $SRC_PATH
RUN javac "${SRC_PATH}/${MAIN_CLASS_NAME}.java"
RUN javap -c "${SRC_PATH}/${MAIN_CLASS_NAME}.class"
WORKDIR /tmp
# EXEC FORM
#CMD ["java","-classpath", "src", "it.groppedev.lesson1.exercise1.HelloJava"]
# SH FORM 
# replace it/groppedev/lesson1/exercise1 -> it.groppedev.lesson1.exercise1
CMD java -classpath "$SRC_HOME" "${SRC_PACKAGE//\//.}.${MAIN_CLASS_NAME}"