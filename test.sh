#!/bin/sh
#note: https://github.com/TylerNakamura/Basic-JUnit-Template

input_file="testInput.ics"

#input_file exists and is greater than 0 size
if [ -e "$input_file" ] && [ -s "$input_file" ]
then
  #compile and run tests
  javac -cp .:junit-4.12.jar UnitTests.java
  returnVal = $(java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore UnitTests)
  echo "Here is the return value: "
  echo $returnVal
else
  echo "Please make sure that a $input_file exists with valid data before running tests!"
  return 1
fi

return 0
