#!/bin/sh
files="Interface.java Calendar.java Vevent.java Geo.java Coordinate.java"
linesOfCode=`wc -l $files | grep total`
clear
javac $files
printf "\n\nCompiled " && printf $linesOfCode && printf " lines of code\n\n"
