@echo off
setlocal
cd /d "%~dp0"
where mvn >nul 2>&1
if errorlevel 1 (
  echo Maven was not found in PATH.
  echo Install Maven, then reopen Command Prompt and run this file again.
  pause
  exit /b 1
)
java -version
mvn -U clean package -DskipTests
if errorlevel 1 (
  echo.
  echo BUILD FAILED - copy the error output and send it to ChatGPT.
  pause
  exit /b 1
)
echo.
echo BUILD FINISHED.
echo Check Carbon-Server\target\ for the runnable shaded server jar.
pause
