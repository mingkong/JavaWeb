@echo Using JAVA_HOME:       "%JAVA_HOME%"
@echo off
set JAVA_OPTS=-server -XX:PermSize=128M -XX:MaxPermSize=256m -Xms256m -Xmx1024m
@echo on
"%JAVA_HOME%"\bin\java %JAVA_OPTS% -Dfile.encoding=UTF-8 -jar run.jar -r