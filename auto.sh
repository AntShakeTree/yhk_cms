#/bin/bash

killall java
echo $(pwd)
mvn clean
mvn compile
mvn package -Dmaven.test.skip=true
#rm -rf /Users/ant_shake_tree/Documents/apache-tomcat-8.0.23/webapps/yhk_cms*
mv $(pwd)/target/ykh_cms*.war $(pwd)/target/ykh_cms.war
sshpass -p SOONcore1234  scp  -r $(pwd)/target/ykh_cms.war root@123.56.125.184:/data/

#/Users/ant_shake_tree/Documents/apache-tomcat-8.0.23/bin/startup.sh

mvn compile