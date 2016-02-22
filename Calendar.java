import java.io.*;
import java.util.ArrayList;

public class Calendar
{	
	//filename target must be in same working directory as java program
	private String fileName = "outputcalendar.ics";
	private String header = "BEGIN:VCALENDAR\nVERSION:2.0\n";
	private String footer = "END:VCALENDAR\n";
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

	}

	public void exportIcs()
	{
		try
		{
			FileWriter fstream = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(header);
			out.write(footer);
			out.close();
		}
		catch (Exception e)
		{
	  		System.err.println("Error when trying to export to .ics file:\n" + e.getMessage());
		}
	}

	public void addEvent()
	{
		
	}
}