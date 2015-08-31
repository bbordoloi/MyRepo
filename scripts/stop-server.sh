#!/usr/bin/env bash

kill `cat /home/ec2-user/play-app/test-app-1.0-SNAPSHOT/RUNNING_PID`
rm -rf /home/ec2-user/play-app/test-app-1.0-SNAPSHOT.tgz
rm -rf /home/ec2-user/play-app/scripts
