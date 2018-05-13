#!/bin/bash

export RUNTIME_CLASSPATH="/target/ParkigSystem-1.jar"
export RUNTIME_CLASSPATH="$RUNTIME_CLASSPATH:/org/springframework/spring-context/5.0.2.RELEASE.jar"
export MAIN_CLASS="com.parking.test.Executor"
export MAIN_CLASS_ARGS=$@
javac -cp ${RUNTIME_CLASSPATH} ${MAIN_CLASS}.java
java -cp ${RUNTIME_CLASSPATH} ${MAIN_CLASS} ${MAIN_CLASS_ARGS}


