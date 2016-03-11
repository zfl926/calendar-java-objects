#!/bin/sh
#note: https://github.com/TylerNakamura/Basic-JUnit-Template

input_file="testInput.ics"

#input_file exists and is greater than 0 size
if [ -e "$input_file" ] && [ -s "$input_file" ]
then
#compile and run tests
javac -cp .:junit-4.12.jar UnitTests.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore UnitTests
else
#qualifications to run tests aren't met and response is printed
printf "\n"
echo "Please make sure that a $input_file exists with valid data before running tests!"
printf "\n"
fi
