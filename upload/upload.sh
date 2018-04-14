#!/bin/bash

cd "`dirname $0`"

git add --all ..
git config user.email "`whoami`@`hostname`"
git config user.name "CoderDojo Potsdam - `hostname`"
git commit -am"manual commit `whoami`@`hostname`"
git config push.default simple
sudo -H git pull
sudo -H git push

firefox https://github.com/CoderDojoPotsdam/projects &

