import java.io.*;

public class Calendar
{	
	//file must be in same working directory as java program
	private String fileName = "outputcalendar.ics";

	//default constructor
	public Calendar()
	{
		addHeader();
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
			out.write("Header here!\n");
			out.close();
		}
		catch (Exception e)
		{
	  		System.err.println("Error when trying to export to .ics file: \n" + e.getMessage());
		}
	}

	public void addEvent()
	{

	}
}