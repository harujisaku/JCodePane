cd src
dir /s /B *.Java > ..\sources.txt
cd ..
javac -encoding UTF-8 -Xlint:deprecation -Xlint:unchecked -d bin\ @sources.txt
if not %ERRORLEVEL% == 0 (
pause
exit /b 1
)
jar cvf JCodePane.jar -C bin/ .
javac -cp .;JCodePane.jar -encoding UTF-8 -Xlint:deprecation -Xlint:unchecked -Xdiags:verbose JCodePaneTest.java
if not %ERRORLEVEL% == 0 (
pause
exit /b 1
)
java -cp .;JCodePane.jar JCodePaneTest
