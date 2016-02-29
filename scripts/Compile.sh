#!/bin/sh
java_files="../src/*.java"
linesOfCode=`wc -l $java_files | grep total`
clear
javac -d ../bin/ $java_files
printf "\n\nCompiled " && printf $linesOfCode && printf " lines of code\n\n"
