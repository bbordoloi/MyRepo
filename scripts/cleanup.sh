#!/usr/bin/env bash

if [ -d /home/ec2-user/play-app.bak/ ]
then
  rm -rf /home/ec2-user/play-app.bak/
fi
mv /home/ec2-user/play-app /home/ec2-user/play-app.bak
