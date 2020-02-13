# Running Test 
mvn test

# Create build  
mvn install

# Run build, get the build from the target folder 
java -jar AnagramService-0.0.1-SNAPSHOT.jar

# To access the end point use the url
localhost:8080/anagrams/{string1}/{string2}
