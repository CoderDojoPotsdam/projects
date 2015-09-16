@echo off

rem move to this directory
cd %~dp0

git pull origin master
git add --all ..
git commit -m"manual commit by %USERNAME%@%COMPUTERNAME%"
git push origin master

start /max %windir%\explorer.exe https://github.com/CoderDojoPotsdam/projects
