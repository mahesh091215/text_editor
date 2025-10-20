# Database Issues Fix Guide

## Issues Identified:
1. JAVA_HOME environment variable not set
2. Potential MySQL connection issues
3. Entity mapping inconsistencies

## Step-by-Step Fix:

### 1. Fix JAVA_HOME Environment Variable
- Install Java JDK 11 or higher
- Set JAVA_HOME environment variable to your Java installation path
- Example: JAVA_HOME=C:\Program Files\Java\jdk-11.0.x

### 2. Verify MySQL Installation and Service
- Ensure MySQL Server is installed and running on port 3306
- Create database 'movieproject' if it doesn't exist
- Verify user 'root' with password '0912' has access

### 3. Database Schema Issues to Fix:
- User entity ID generation strategy conflicts with manual inserts
- Date handling in Movies entity needs review
- Missing @Table annotations in entities

### 4. Application Properties Recommendations:
- Add connection pool settings
- Enable proper logging
- Add timezone configuration

## Quick Commands to Test:
1. Test MySQL connection: mysql -u root -p0912 -h localhost
2. Check if database exists: SHOW DATABASES;
3. Run application: ./mvnw.cmd spring-boot:run
