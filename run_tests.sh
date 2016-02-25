#!/bin/sh
#note: https://github.com/TylerNakamura/Basic-JUnit-Template
#for windows:
#javac -cp .;junit-4.12.jar UnitTests.java
#java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore UnitTests

#for mac/linux
javac -cp .:junit-4.12.jar UnitTests.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore UnitTests
