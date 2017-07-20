#!/bin/sh

# Change this to your JDK installation root
#
#JAVA_HOME=/usr/java/j2sdk1.4.0_01

JRE=$JAVA_HOME/jre
JAVA=$JRE/bin/java

workdir=`dirname $0`
workdir=`cd ${workdir} && pwd`
QUARTZ=${workdir}/../..

. ${QUARTZ}/examples/bin/buildcp.sh

#
# Set the path to your Terracotta server home here
TC_HOME=${workdir}/../../..

if [ ! -f $TC_HOME/bin/start-tc-server.sh ]; then
  echo "Modify the script to set TC_HOME" 
  exit -1
fi

for jarfile in $TC_HOME/common/terracotta-toolkit-1.0-runtime-*; do
  TC_CP=$TC_CP:$jarfile
done

for jarfile in $TC_HOME/quartz/quartz-terracotta-*; do
  TC_CP=$TC_CP:$jarfile
done

QUARTZ_CP=$QUARTZ_CP:$TC_CP

LOGGING_PROPS="-Dlog4j.configuration=file:${workdir}/log4j.xml"

# Set the name and location of the quartz.properties file
QUARTZ_PROPS="-Dorg.quartz.properties=${workdir}/instance1.properties"

$JAVA -classpath $QUARTZ_CP $QUARTZ_PROPS $LOGGING_PROPS org.quartz.examples.example15.ClusterExample $1

