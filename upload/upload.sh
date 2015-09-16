#!/bin/bash

cd "`dirname $0`"

git add --all ..
git commit -am"manual commit `whoami`@`hostname`"
git pull
git push

firefox https://github.com/CoderDojoPotsdam/projects &

