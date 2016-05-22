# Calendar Event Generator

Java objects that handle .ics files (calendar exports)

## Calendars

---

```java
Calendar calendar = new Calendar("/home/bob/bobs-calendar.ics");

//prints all vevents in the calendar to STDOUT
calendar.printAllEvents();

//imports an .ics file into the calendar
calendar.importIcs("/home/alice/alices-calendar.ics");

//sorts all the events in the calendar by chronological order
calendar.sortCalendar();

//prints the results of the great circle distance of the calendar
//also stores results in the COMMENT field of the respective Vevent
calendar.printGreatCircleDistance();

//exports the calendar including whatever changes were made to it
calendar.exportIcs();
```

## Vevents

---

```java
Calendar calendar = new Calendar();

//add a random valid event to the calendar
Vevent randomEvent = new Vevent();
randomEvent.setRandomValues();
calendar.addEvent(randomEvent);

//add a custom event to the calendar
Vevent customEvent = new Vevent();
customEvent.setUID("john@email.com");
customEvent.setDTSTAMP("20160708T111111Z");
customEvent.setDTSTART("20160708T222222Z");
customEvent.setDTEND("20160708T333333Z");
customEvent.setORGANIZER("Gary Richards");
customEvent.setSUMMARY("some dudes birthday");
customEvent.setGEO("-74.02;-85.11");
customEvent.setCLASS("PUBLIC");
customEvent.setCOMMENT("There will be cake");
calendar.addEvent(customEvent);

```

## Interface Usage

---

To sample the application with a default interface and import an existing calendar, pass the file name as the first argument:

```bash

java Interface my-summer-calendar.ics

```

To sample the application and create a new .ics file:

```bash

java Interface

```

## Contributing
Currently accepting pull requests for any additions

## License

[MIT License](https://github.com/TylerNakamura/Calendar-Event-File-Generator/blob/master/LICENSE)
