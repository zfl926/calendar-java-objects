import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Calendar
{	
	//filename target must be in same working directory as java program
	private String fileName = "outputcalendar.ics";
	private String HEADER = "BEGIN:VCALENDAR\nVERSION:2.0\n";
	private String FOOTER = "END:VCALENDAR\n";
	ArrayList<Vevent> allVevents = new ArrayList<Vevent>();

	//default constructor
	public Calendar()
	{

	}

	//overloaded constructor
	public Calendar(String fileName)
	{
		this.fileName = fileName;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void importIcs(String inputIcsFile)
	{
		//TODO
		//parse the input file and add the appropriate events to arraylists
	}

	public void exportIcs()
	{
		try
		{
			FileWriter fstream = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(fstream);

			//HEADER
			out.write(HEADER);

			//VEVENTS
		    Iterator veventsItr = allVevents.iterator();
		    while(veventsItr.hasNext())
		    {
		    	out.write(veventsItr.next().toString());
		    }
		    
			//FOOTER
			out.write(FOOTER);
			out.close();
		}
		catch (Exception e)
		{
	  		System.err.println("Error when trying to export to .ics file:\n" + e.getMessage());
		}
	}

	public void printAllEvents()
	{
	    Iterator veventsItr = allVevents.iterator();
	    System.out.print("-------------------------------------\n");
	    while(veventsItr.hasNext())
	    {
	    	System.out.print(veventsItr.next().toString());
	    	System.out.println("-------------------------------------");
	    }
	}

	public void addEvent(Vevent inputVevent)
	{
		if (inputVevent.isValid())
		{
			allVevents.add(inputVevent);
		}
		else
		{
			System.err.println("The event that you are trying to add is invalid!");
		}
	}	
}