#!/bin/sh
java_classes="../bin/classes/"
echo $java_classes
jar cfM ../docs/MANIFEST.MF ../bin/jar/calendar_program.jar ../bin/classes/Interface.class
