#!/bin/sh
java_files="../src/*.java"
linesOfCode=`wc -l $java_files | grep total`
output_location="../bin/classes"
clear
javac -d $output_location $java_files -verbose
ls $output_location
printf "\n\nCompiled " && printf $linesOfCode && printf " lines of code\n\n"
