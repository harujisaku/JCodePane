dir /s /B *.Java > sources.txt
javac -encoding UTF-8 -Xlint:deprecation -Xlint:unchecked -d bin\ @sources.txt
if not %ERRORLEVEL% == 0 (
pause
exit /b 1
)
jar cvf JCodePane.jar -C bin/ .