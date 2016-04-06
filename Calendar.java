import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;
import java.text.DecimalFormat;

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

	//returns the filename
	public String getFileName()
	{
		return fileName;
	}

	//imports a .ics file
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
				//if ORGANIZER detected
				else if((temp = strLine.substring(0, 10)).equals("ORGANIZER:"))
				{
					String temp2 = strLine.substring(10, strLine.length());

					//if valid according to validation method in vevent
					if(vevent.validORGANIZER(temp2))
					{
						vevent.setORGANIZER(temp2);
					}
					else
					{
						System.err.println("Invalid ORGANIZER found at line " + lineCount + " in " + inputIcsFile);
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
				//if CLASS detected
				else if((temp = strLine.substring(0, 6)).equals("CLASS:"))
				{
					String temp2 = strLine.substring(6, strLine.length());

					//if valid according to validation method in vevent
					if(vevent.validCLASS(temp2))
					{
						vevent.setCLASS(temp2);
					}
					else
					{
						System.err.println("Invalid CLASS found at line " + lineCount + " in " + inputIcsFile);
					}
				}
				//if COMMENT detected
				else if((temp = strLine.substring(0, 8)).equals("COMMENT:"))
				{
					String temp2 = strLine.substring(8, strLine.length());

					//if valid according to validation method in vevent
					if(vevent.validCOMMENT(temp2))
					{
						vevent.setCOMMENT(temp2);
					}
					else
					{
						System.err.println("Invalid COMMENT found at line " + lineCount + " in " + inputIcsFile);
					}
				}
			}
			in.close();
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
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
			System.out.println("you are trying to input an event with null values!");
		}
	}

	//sorts the events in the calendar by the start date
	public void sortCalendar()
	{
		Collections.sort(allVevents);
	}

	//prints the results of the great circle distance
	public void printGreatCircleDistance()
	{
		//ensures that there are at least 2 events in the calendar before calculating the GCD
		if (allVevents.size() < 2)
		{
			System.err.println("At least 2 events are needed to calculate GCD");
			return;
		}

		Iterator<Vevent> veventsItr = allVevents.iterator();
		Vevent iter = veventsItr.next();
		Vevent iterPrev = iter;
		DecimalFormat df = new DecimalFormat("#,###.##");

		System.out.print("-----------------------------------\n");
		System.out.print("------GREAT-CIRCLE-DISTANCE--------\n\n");

        Geo currGEO = iter.getGEO();
		String currSum = iter.getSUMMARY();

		while(veventsItr.hasNext())
		{
			//move the first iterator forward
			iter = veventsItr.next();

			//if the geo of the current iteration is not empty
			if(iter.getGEO() != null)
			{
				//calculate GCD and store it in comment section of first event
				double gcd = greatCircleDistanceBetween(currGEO, iter.getGEO());
				iterPrev.setCOMMENT("The Great Circle Distance to the next event(" + shortenString(iter.getSUMMARY()) + "...) is " + df.format(gcd)+ " miles (" + df.format(1.609344 * gcd) + "km)");

				//print gcd for first event to the next event
				System.out.println(currSum + " to " + iter.getSUMMARY() + " is " + df.format(gcd) + " miles (" + df.format(1.609344 * gcd) + "km)\n");

		    	//updates the held values
				currGEO = iter.getGEO();
				currSum = iter.getSUMMARY();
				iterPrev = iter;
			}
			else
			{
				System.out.println(iter.getSUMMARY() + " does not have a GEO, GCD will not take this event into consideration....");
			}
			System.out.println("-----------------------------------\n");
		}
	}

	//returns the first x characters of a string if the string is considered to be too long
	private String shortenString(String input)
	{
		String result = "";
		int RETURNLENGTH = 7;
		if (input.length() <= RETURNLENGTH)
		{
			return input;
		}

		for (int i = 0; i < RETURNLENGTH; i++)
		{
			result += input.charAt(i);
		}
		return result;
	}

	//calculates the great circle distance between two Geo locations in statue miles
	public double greatCircleDistanceBetween(Geo src, Geo dest)
	{
		double earthRadius = 3958.75; // miles (or 6371.0 kilometers)
		double dLat = Math.toRadians(dest.getLatitude() - src.getLatitude());
	    double dLng = Math.toRadians(dest.getLongitude() - src.getLongitude());
		double sin_dLat = Math.sin(dLat / 2);
		double sin_dLng = Math.sin(dLng / 2);
		double a = Math.pow(sin_dLat, 2) + Math.pow(sin_dLng, 2)
            * Math.cos(Math.toRadians(src.getLatitude())) * Math.cos(Math.toRadians(dest.getLatitude()));
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double dist = earthRadius * c;

		return dist;
	}
}
