public class Calendar
{	
	//file must be in same working directory as java program
	String fileName = "outputcalendar.ics";

	//default constructor
	public Calendar()
	{
		System.out.println("A calendar has been made, output will be stored with the name: " + fileName);	
	}

	//overloaded constructor
	public Calendar(String fileName)
	{
		this.fileName = fileName;
	}

	public void importIcs()
	{

	}

	public void exportIcs()
	{

	}

	public void addEvent()
	{
		
	}
}