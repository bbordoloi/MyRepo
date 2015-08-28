#!/usr/bin/env bash

gunzip ./test-app-1.0-SNAPSHOT.tgz
tar -xvf ./test-app-1.0-SNAPSHOT.tar
chmod +x ./test-app-1.0-SNAPSHOT/bin/test-app
./test-app-1.0-SNAPSHOT/bin/test-app -Dconfig.file=/home/ec2-user/production.conf
