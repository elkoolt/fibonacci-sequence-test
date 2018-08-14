
# Fibonacci Sequence Service Test

### Prerequisites:
- Requires Apache Maven 3 and JDK 1.8

- Clone repo:
```
git clone https://github.com/elkoolt/fibonacci-sequence-test.git
```

### Steps how to build and run it:

#### Navigate to cloned directory, build project and run integration tests:
```
mvn clean install
```

#### Start web service:
```
java -jar target/fibonacci-sequence-test-1.0.0-SNAPSHOT.jar
```

#### Run Fibonacci Sequence Service Test:
Navigate to http://localhost:8080/run url, it will run web service with default value - 0, for different value passing use this pattern http://localhost:8080/run?n=5
