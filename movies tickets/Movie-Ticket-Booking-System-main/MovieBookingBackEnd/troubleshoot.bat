@echo off
echo ========================================
echo Movie Booking System - Database Troubleshooting
echo ========================================

echo.
echo 1. Checking Java Installation...
java -version
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH
    echo Please install Java JDK 11 or higher
    goto :end
)

echo.
echo 2. Checking JAVA_HOME...
if "%JAVA_HOME%"=="" (
    echo ERROR: JAVA_HOME is not set
    echo Please set JAVA_HOME environment variable
    goto :end
) else (
    echo JAVA_HOME is set to: %JAVA_HOME%
)

echo.
echo 3. Checking MySQL Connection...
mysql --version
if %errorlevel% neq 0 (
    echo WARNING: MySQL client not found in PATH
    echo Please ensure MySQL Server is installed and running
)

echo.
echo 4. Testing MySQL Connection with application credentials...
mysql -u root -p0912 -h localhost -e "SELECT 1;" 2>nul
if %errorlevel% neq 0 (
    echo ERROR: Cannot connect to MySQL with root/0912
    echo Please check:
    echo   - MySQL Server is running
    echo   - Username/password is correct
    echo   - Database 'movieproject' exists
) else (
    echo MySQL connection successful
)

echo.
echo 5. Attempting to compile the project...
call mvnw.cmd clean compile
if %errorlevel% neq 0 (
    echo ERROR: Compilation failed
    echo Check the error messages above
) else (
    echo Compilation successful
)

echo.
echo 6. Attempting to run the application...
echo This will start the Spring Boot application...
echo Press Ctrl+C to stop when testing is complete
call mvnw.cmd spring-boot:run

:end
echo.
echo Troubleshooting complete
pause
