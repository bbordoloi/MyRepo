#!/usr/bin/env bash

gunzip /home/ec2-user/play-app/test-app-1.0-SNAPSHOT.tgz
tar -xvf /home/ec2-user/play-app/test-app-1.0-SNAPSHOT.tar -C /home/ec2-user/play-app/
chmod +x /home/ec2-user/play-app/test-app-1.0-SNAPSHOT/bin/test-app
