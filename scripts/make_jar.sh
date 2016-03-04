#!/bin/sh
jar -cmf ../docs/MANIFEST.MF ../bin/jar/calendar_program.jar -C ../bin/classes Calendar.class -C ../bin/classes Interface.class -C ../bin/classes Vevent.class
