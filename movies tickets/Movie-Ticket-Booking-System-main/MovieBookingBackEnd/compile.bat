@echo off
echo ========================================
echo Movie Booking System - Compilation Script
echo ========================================

echo Setting JAVA_HOME...
set JAVA_HOME=C:\Program Files\Java\jdk-23

echo.
echo Compiling the project...
call mvnw.cmd clean compile

if %errorlevel% equ 0 (
    echo.
    echo ========================================
    echo ✅ COMPILATION SUCCESSFUL!
    echo ========================================
    echo.
    echo To run the application, use:
    echo   .\mvnw.cmd spring-boot:run
    echo.
    echo To run tests, use:
    echo   .\mvnw.cmd test
    echo.
) else (
    echo.
    echo ========================================
    echo ❌ COMPILATION FAILED!
    echo ========================================
    echo Check the error messages above
)

pause
