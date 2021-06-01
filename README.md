# Description
This project includes the driver less car test application, the tests can be run in console. Unittests covered all 
acceptance criteria. History event also implemented, not logged in log files, the solution only print history events to
console when user quit or exception occurs. Turn left and move back also implemented(not covered in tests).

# Run the program
The project build using gradle, a wrapper already included, the project built using jdk 11 in my local machine, it 
should work jdk8 and later version, but not verified.
To run the project:
1. Clone the code, and prepare jdk environment
2. Run gradle to build jar file using command `<root project folder>/gradlew jar`, note in linux machine, may need to run 
   `chmod +x` for gradlew file. Test cases can be run by command `<root project folder>/gradlew test`
3. Run the application using command `java -jar <root project folder>/build/libs/driverlesscar.jar`

