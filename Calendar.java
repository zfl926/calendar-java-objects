import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

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

			//HEADER
			out.write(header);

			//VEVENTS
		    Iterator veventsItr = allVevents.iterator();
		    while(veventsItr.hasNext())
		    {
		    	out.write(veventsItr.next().toString());
		    }
		    
			//FOOTER
			out.write(footer);
			out.close();
		}
		catch (Exception e)
		{
	  		System.err.println("Error when trying to export to .ics file:\n" + e.getMessage());
		}
	}

	public void addEvent(String inputUID, String inputDTSTAMP, String inputORGANIZER, String inputDTSTART, String inputDTEND, String inputSUMMARY)
	{
		Vevent newVevent = new Vevent(inputUID, inputDTSTAMP, inputORGANIZER, inputDTSTART, inputDTEND, inputSUMMARY);

		//ensures that input parameters are gucci. Don't be passin in dirty data!
		if (newVevent.isValid())
		{
			allVevents.add(newVevent);
		}
		else
		{
			System.err.println("The event that you are trying to add is invalid!");
		}
	}	
}