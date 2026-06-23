# SLF4J Exercise 1: Logging Error Messages and Warning Levels

## Overview
This exercise demonstrates how to use SLF4J (Simple Logging Facade for Java) with Logback to implement logging at different levels (DEBUG, INFO, WARN, ERROR).

## Project Structure
```
exercise1/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/cognizant/
│   │   │       └── LoggingExample.java
│   │   └── resources/
│   │       └── logback.xml
│   └── test/
└── target/
```

## Dependencies
- **SLF4J API** (1.7.30): The logging facade
- **Logback Classic** (1.2.3): The implementation

## Building the Project
```bash
mvn clean install
```

## Running the Application
```bash
mvn exec:java
```

Or:
```bash
java -cp target/slf4j-exercise1-1.0.0.jar:path/to/dependencies/* com.cognizant.LoggingExample
```

## Expected Output
The application will demonstrate:
1. **DEBUG** - Detailed information for developers
2. **INFO** - General informational messages
3. **WARN** - Warning messages
4. **ERROR** - Error messages with stack traces

Logs are output to:
- Console (STDOUT)
- File: `logs/application.log`

## Logging Configuration
The `logback.xml` file configures:
- **Console Appender**: Outputs logs to the console with timestamp, thread, level, logger name, and message
- **File Appender**: Writes logs to `logs/application.log`
- **Root Logger**: Set to DEBUG level to capture all log messages

## Key Concepts
- **Logger**: Obtained via `LoggerFactory.getLogger(ClassName.class)`
- **Log Levels**: DEBUG < INFO < WARN < ERROR
- **Pattern**: Configurable format for log output
- **Appender**: Destination for log output (console, file, etc.)
