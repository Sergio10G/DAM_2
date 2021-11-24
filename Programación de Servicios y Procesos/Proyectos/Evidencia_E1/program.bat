@echo off
Setlocal EnableDelayedExpansion

for /l %%i in (1,1,10) do echo !random!
echo .
echo Executed:
DATE /T