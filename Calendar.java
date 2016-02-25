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
		importIcs(fileName);
	}

	public String getFileName()
	{
		return fileName;
	}

	private void importIcs(String inputIcsFile)
	{
		try
		{
			DataInputStream in = new DataInputStream(new FileInputStream(inputIcsFile));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			Vevent vevent = new Vevent();
			String strLine;
			int lineCount = 0;
			String temp;
			 
			while ((strLine = br.readLine()) != null)   
			{
				lineCount++;
				//if a new event is detected
				if (strLine.equals("BEGIN:VEVENT"))
				{
					vevent = new Vevent();
				}
				//if the end of the event details
				else if(strLine.equals("END:VEVENT"))
				{
					allVevents.add(vevent);
				}
				//if UID detected
				else if((temp = strLine.substring(0, 4)).equals("UID:"))
				{
					String temp2 = strLine.substring(4, strLine.length());
					
					//if valid according to validation method in vevent
					if(vevent.validUID(temp2))
					{
						vevent.setUID(temp2);
					}
					else
					{
						System.err.println("Invalid UID found at line " + lineCount + " in " + inputIcsFile);
					}
				}
				//if DTSTAMP detected
				else if((temp = strLine.substring(0, 8)).equals("DTSTAMP:"))
				{
					String temp2 = strLine.substring(8, strLine.length());
					
					//if valid according to validation method in vevent
					if(vevent.validDTSTAMP(temp2))
					{
						vevent.setDTSTAMP(temp2);
					}
					else
					{
						System.err.println("Invalid DTSTAMP found at line " + lineCount + " in " + inputIcsFile);
					}
				}
				//if DTSTART detected
				else if((temp = strLine.substring(0, 8)).equals("DTSTART:"))
				{
					String temp2 = strLine.substring(8, strLine.length());
					
					//if valid according to validation method in vevent
					if(vevent.validDTSTART(temp2))
					{
						vevent.setDTSTART(temp2);
					}
					else
					{
						System.err.println("Invalid DTSTART found at line " + lineCount + " in " + inputIcsFile);
					}
				}
				//if DTEND detected
				else if((temp = strLine.substring(0, 6)).equals("DTEND:"))
				{
					String temp2 = strLine.substring(6, strLine.length());
					
					//if valid according to validation method in vevent
					if(vevent.validDTEND(temp2))
					{
						vevent.setDTEND(temp2);
					}
					else
					{
						System.err.println("Invalid DTEND found at line " + lineCount + " in " + inputIcsFile);
					}
				}
				//if SUMMARY detected
				else if((temp = strLine.substring(0, 8)).equals("SUMMARY:"))
				{
					String temp2 = strLine.substring(8, strLine.length());
					
					//if valid according to validation method in vevent
					if(vevent.validSUMMARY(temp2))
					{
						vevent.setSUMMARY(temp2);
					}
					else
					{
						System.err.println("Invalid SUMMARY found at line " + lineCount + " in " + inputIcsFile);
					}
				}
				//if GEO detected
				else if((temp = strLine.substring(0, 4)).equals("GEO:"))
				{
					String temp2 = strLine.substring(4, strLine.length());
					
					//if valid according to validation method in vevent
					if(vevent.validGEO(temp2))
					{
						vevent.setGEO(temp2);
					}
					else
					{
						System.err.println("Invalid GEO found at line " + lineCount + " in " + inputIcsFile);
					}
				}
			} 
			in.close();
		}
		catch (Exception e)
		{
			System.err.println("Error caught in Calendar.java importIcs(): " + e.getMessage());
		}
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
	    System.out.print("-----------------------------------\n");
	    while(veventsItr.hasNext())
	    {
	    	System.out.print(veventsItr.next().toString());
	    	System.out.println("-----------------------------------");
	    }
	}

	public void addEvent(Vevent inputVevent)
	{
        try
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
        catch(NullPointerException e)
        {
            System.out.println();
        }
	}	
}