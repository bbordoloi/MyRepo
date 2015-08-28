#!/usr/bin/env bash

gunzip ./play-app/test-app-1.0-SNAPSHOT.tgz
tar -xvf ./play-app/test-app-1.0-SNAPSHOT.tar
chmod +x ./play-app/test-app-1.0-SNAPSHOT/bin/test-app
./play-app/test-app-1.0-SNAPSHOT/bin/test-app -Dconfig.file=/home/ec2-user/production.conf
