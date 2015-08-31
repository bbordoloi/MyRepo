#!/usr/bin/env bash

kill `cat /home/ec2-user/play-app/test-app-1.0-SNAPSHOT/RUNNING_PID`
if [ -d /home/ec2-user/play-app.bak/ ]
then
  rm -rf /home/ec2-user/play-app.bak/
fi
mv /home/ec2-user/play-app /home/ec2-user/play-app.bak
