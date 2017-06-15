package org.test;

import java.text.DecimalFormat;
import java.util.Random;

public class ICSCalendarEvent implements Comparable<ICSCalendarEvent>{
	private String UID;
	private String DTSTAMP;
	private String ORGANIZER;
	private String DTSTART;
	private String DTEND;
	private String SUMMARY;
	private Geo    GEO;
	private String CLASS;
	private String COMMENT;

	//default constructor
	public ICSCalendarEvent()
	{

	}

	//overloaded constructor
	public ICSCalendarEvent(String inputUID, String inputDTSTAMP, String inputORGANIZER, String inputDTSTART, String inputDTEND, String inputSUMMARY, Geo inputGEO, String inputCLASS)
	{
		UID       = inputUID;
		DTSTAMP   = inputDTSTAMP;
		ORGANIZER = inputORGANIZER;
		DTSTART   = inputDTSTART;
		DTEND     = inputDTEND;
		SUMMARY   = inputSUMMARY;
		GEO       = inputGEO;
		CLASS     = inputCLASS;
	}

	//sets all vevents members variables to random but valid values
	public void setRandomValues()
	{
		int minuidsize = 7;
		int maxuidsize = 20;
		int minsumsize = 10;
		int maxsumsize = 40;
		int minorgsize = 5;
		int maxorgsize = 20;

		String [] classOptions = {"PUBLIC", "PRIVATE"};
		DecimalFormat df = new DecimalFormat("#.##");

		int sizeOfUid       = minuidsize   + (int)(Math.random() * maxuidsize);
		int sizeOfSummary   = minsumsize   + (int)(Math.random() * maxsumsize);
		int sizeOfOrganizer = minorgsize   + (int)(Math.random() * maxorgsize);
		int classChoice     = 0            + (int)(Math.random() * 2         );
		double latChoice    = -90.0        + (Math.random()      * 90.0      );
		double lonChoice    = -180.0       + (Math.random()      * 180.0     );

		String myRS1 = randomString(sizeOfUid);
		String myRS2 = randomString(sizeOfSummary);
		String myRS3 = randomString(sizeOfOrganizer);

		UID       = myRS1;
		SUMMARY   = myRS2;
		ORGANIZER = myRS3;
		CLASS     = classOptions[classChoice];
		GEO       = new Geo(df.format(latChoice) + ";" + df.format(lonChoice));
		DTSTAMP   = getRandomDate();
		DTSTART   = getRandomDate();
		DTEND     = getRandomDate();
		COMMENT   = myRS1;

		//ensure that the stamp is lesser than the start date of the event
		while(dateIsGreaterThanDate(DTSTAMP, DTSTART))
		{
			DTSTART = getRandomDate();
		}

		//ensure that the date end is lesser than the date start
		while(dateIsGreaterThanDate(DTSTART, DTEND))
		{
			DTEND = getRandomDate();
		}
	}

	private String getRandomDate()
	{
		DecimalFormat dm = new DecimalFormat("##");
		String result = "";
		int minYear = 1990;
		int maxYear = 2030;
		int maxMonth = 12;
		int maxDay = 31;
		int maxHour = 24;
		int max =    60;
		int min = 1;
		int yearChoice = minYear + (int)(Math.random() * (maxYear - minYear));
		int monthChoice= min + (int)(Math.random() * (maxMonth - min));
		int dayChoice  = min + (int)(Math.random() * (maxDay - min));
		int hourChoice = min + (int)(Math.random() * (maxHour - min));
		int minChoice  = min + (int)(Math.random() * (max - min));
		int secChoice  = min + (int)(Math.random() * (max - min));

		result += yearChoice + ""
			+ String.format("%02d", monthChoice) + ""
			+ String.format("%02d", dayChoice)   + ""
			+ "T"
			+ String.format("%02d", hourChoice) + ""
			+ String.format("%02d", minChoice)  + ""
			+ String.format("%02d", secChoice)  + ""
			+ "Z";

		return result;
	}

    public String randomString(int length)
    {
        //input validation
        if (length < 1)
        {
            throw new IllegalArgumentException("length < 1" + length);
        }

        //declaration
        Random random = new Random();
        char [] buf = new char[length];
        char [] symbols;

        //build symbols array
        StringBuilder tmp = new StringBuilder();
        for (char ch = '0'; ch <= '9'; ++ch)
        tmp.append(ch);
        for (char ch = 'a'; ch <= 'z'; ++ch)
        tmp.append(ch);
        symbols = tmp.toString().toCharArray();

        //return value
        for (int idx = 0; idx < buf.length; ++idx)
        {
            buf[idx] = symbols[random.nextInt(symbols.length)];
        }

        return new String(buf);
    }

	private boolean dateIsGreaterThanDate(String a, String b)
	{
		if(!validDateFormat(a) || !validDateFormat(b))
		{
			System.err.println("not a valid date format");
			return false;
		}

		int AYear    = Integer.parseInt(a.substring(0, 4));
		int AMonth   = Integer.parseInt(a.substring(4, 6));
		int ADay     = Integer.parseInt(a.substring(6, 8));
		int AHours   = Integer.parseInt(a.substring(9, 11));
		int AMinutes = Integer.parseInt(a.substring(11, 13));
		int ASeconds = Integer.parseInt(a.substring(13,15));

		int BYear    = Integer.parseInt(b.substring(0, 4));
		int BMonth   = Integer.parseInt(b.substring(4, 6));
		int BDay     = Integer.parseInt(b.substring(6, 8));
		int BHours   = Integer.parseInt(b.substring(9, 11));
		int BMinutes = Integer.parseInt(b.substring(11, 13));
		int BSeconds = Integer.parseInt(b.substring(13,15));

		if (AYear > BYear)
			return true;

		if(BYear > AYear)
			return false;

		if(AMonth > BMonth)
			return true;

		if(BMonth > AMonth)
			return false;

		if(ADay > BDay)
			return true;

		if(BDay > ADay)
			return false;

		if(AHours > BHours)
			return true;

		if(BHours > AHours)
			return false;

		if(AMinutes > AMinutes)
			return true;

		if(BMinutes > AMinutes)
			return false;

		if(ASeconds > BSeconds)
			return true;

		if(BSeconds > ASeconds)
			return false;

		System.err.println(a + " is the same as " + b);
		return false;
	}

	public String getCOMMENT()
	{
		return COMMENT;
	}

	public void setCOMMENT(String input)
	{
		if(validCOMMENT(input))
		{
			COMMENT = input;
		}
		else
		{
			System.err.println("Cannot set COMMENT to \"" + input +"\"because COMMENT is not valid");
		}
	}

	public String getUID()
	{
		return UID;
	}

	public void setUID(String input)
	{
		if (validUID(input))
		{
			UID = input;
		}
		else
		{
			System.err.println("Cannot set UID to \"" + input + "\"\nbecause UID is not valid");
		}
	}

	public String getDTSTAMP()
	{
		return DTSTAMP;
	}

	public void setDTSTAMP(String input)
	{
		if (validDTSTAMP(input))
		{
			DTSTAMP = input;
		}
		else
		{
			System.err.println("Cannot set DTSTAMP to \"" + input + "\"\nbecause DTSTAMP is not valid");
		}
	}

	public String getORGANIZER()
	{
		return ORGANIZER;
	}

	public void setORGANIZER(String input)
	{
		if (validORGANIZER(input))
		{
			ORGANIZER = input;
		}
		else
		{
			System.err.println("Cannot set ORGANIZER to \"" + input + "\"\nbecause ORGANIZER is not valid");
		}
	}

	public String getDTSTART()
	{
		return DTSTART;
	}

	public void setDTSTART(String input)
	{
		if (validDTSTART(input))
		{
			DTSTART = input;
		}
		else
		{
			System.err.println("Cannot set DTSTART to \"" + input + "\"\nbecause DTSTART is not valid");
		}
	}

	public String getDTEND()
	{
		return DTEND;
	}

	public void setDTEND(String input)
	{
		if (validDTEND(input))
		{
			DTEND = input;
		}
		else
		{
			System.err.println("Cannot set DTEND to \"" + input + "\"\nbecause DTEND is not valid");
		}
	}

	public String getSUMMARY()
	{
		return SUMMARY;
	}

	public void setSUMMARY(String input)
	{
		if (validSUMMARY(input))
		{
			SUMMARY = input;
		}
		else
		{
			System.err.println("Cannot set SUMMARY to \"" + input + "\"\nbecause SUMMARY is not valid");
		}
	}

	public float getLat()
	{
		return GEO.getLatitude();
	}
	
	public float getLon(){
		return GEO.getLongitude();
	}

	public Geo getGEO()
	{
		return GEO;
	}

	public void setGEO(String input)
	{
		if (validGEO(input))
		{
			GEO = new Geo(input);
		}
		else
		{
			System.err.println("Cannot set GEO to \"" + input.toString() + "\"\nbecause SUMMARY is not valid");
		}
	}

	public String getCLASS()
	{
		return CLASS;
	}

	public void setCLASS(String input)
	{
		if (validCLASS(input))
		{
			CLASS = input;
		}
		else
		{
			System.err.println("Cannot set CLASS to \"" + input + "\"\nbecause CLASS is not valid");
		}
	}

	public boolean validCOMMENT(String input)
	{
		if(input.length() > 100)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public boolean validUID(String input)
	{
        if (input.equals("invalid") || input.length() > 70)
        {
            return false;
        }
		return true;
	}

	public boolean validDTSTAMP(String input)
	{
		return validDateFormat(input);
	}

	public boolean validORGANIZER(String input)
	{
		if (input.length() > 60)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public boolean validDTSTART(String input)
	{
		return validDateFormat(input);
	}

	public boolean validDTEND(String input)
	{
		return validDateFormat(input);
	}

	private boolean validDateFormat(String input)
	{
		if (input.length() != 16)
		{
			System.err.println("Date: " + input + " is " + input.length() + " char, should be 16.");
			return false;
		}

		int expectYear = Integer.parseInt(input.substring(0, 4));
		int expectMonth = Integer.parseInt(input.substring(4, 6));
		int expectDay = Integer.parseInt(input.substring(6, 8));
		char expectT = input.charAt(8);
		expectT = Character.toLowerCase(expectT);
		int expectHours = Integer.parseInt(input.substring(9, 11));
		int expectMinutes = Integer.parseInt(input.substring(11, 13));
		int expectSeconds = Integer.parseInt(input.substring(13,15));
		char expectZ = input.charAt(15);
		expectZ = Character.toLowerCase(expectZ);

		if (expectYear < 0)
		{
			return false;
		}

		if (expectMonth < 1 || expectMonth > 12)
		{
			return false;
		}

		if (expectDay < 1 || expectDay > 31)
		{
			return false;
		}

		if(expectT != 't')
		{
			return false;
		}

		if (expectHours < 1 || expectHours > 24)
		{
			return false;
		}

		if (expectMinutes < 0 || expectMinutes > 59)
		{
			return false;
		}

		if (expectSeconds < 0 || expectSeconds > 59)
		{
			return false;
		}

	    if (expectZ != 'z')
		{
			return false;
		}

		return true;
	}

	public boolean validSUMMARY(String input)
	{
		if (input.length() > 400)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public boolean validGEO(Geo input)
	{
		return validGEO(input.toString());
	}

	public boolean validGEO(String input)
	{
		Geo temp = new Geo();
		boolean myReturn = false;

		try
		{
			if (input.contains("GEO:"))
			{
				//get rid of GEO:
				input = stripTitle(input);
			}

			//get coordinates
			String [] coords = input.split(";");

			if (!temp.isValidLatitude(Float.valueOf(coords[0])) || !temp.isValidLongitude(Float.valueOf(coords[1])))
			{
				myReturn = false;
			}
			else
			{
				myReturn = true;
			}
		}
		catch(Exception e)
		{
			System.err.println(e.toString());
		}
		return myReturn;
	}

	//http://tools.ietf.org/html/rfc5545#section-3.8.1.3
	public boolean validCLASS(String input)
	{
		boolean myReturn = false;

		//if the input contains class
		if (input.contains("CLASS:"))
		{
			input = stripTitle(input);
		}

		//if the input is equal to any of the three accepted values, see RFC for more information
		if (input.equals("PUBLIC") || input.equals("PRIVATE") || input.equals("CONFIDENTIAL"))
		{
			myReturn = true;
		}
		else
		{
			myReturn = false;
		}

		return myReturn;
	}

	/*
		ensures that all fields of vevent are valid according to protocol
		https://en.wikipedia.org/wiki/ICalendar
		http://tools.ietf.org/html/rfc5545
	*/
	public boolean isValid()
	{
		boolean myReturn;

		if (validUID(UID) && validDTSTAMP(DTSTAMP) && validORGANIZER(ORGANIZER) && validDTSTART(DTSTART) && validDTEND(DTEND) && validSUMMARY(SUMMARY))
		{
			myReturn = true;
		}
		else
		{
			myReturn = false;
		}

		//first checks to see if CLASS is set, then checks to see if it is valid
		//without checking for null value, a null pointer exception is returned
		if (CLASS != null)
		{
			if(validCLASS(CLASS))
			{
				myReturn = true;
			}
			else
			{
				myReturn = false;
			}
		}

		//first checks to see if GEO is set, then checks to see if it is valid
		//without checking for null value, a null pointer exception is returned
		if (GEO != null)
		{
			if (validGEO(GEO))
			{
				myReturn = true;
			}
			else
			{
				myReturn = false;
			}
		}

		return myReturn;
	}

	/*
		adds all non null or empty fields to a result string
	*/
	public String toString()
	{
		String result = "";
		result += "BEGIN:VEVENT\n";

		if (UID != null && !UID.equals(""))
		{
			result += "UID:";
			result += UID;
			result += "\n";
		}

		if (DTSTAMP != null && !DTSTAMP.equals(""))
		{
			result += "DTSTAMP:";
			result += DTSTAMP;
			result += "\n";
		}

		if (ORGANIZER != null && !ORGANIZER.equals(""))
		{
			result += "ORGANIZER:";
			result += ORGANIZER;
			result += "\n";
		}

		if (DTSTART != null && !DTSTART.equals(""))
		{
			result += "DTSTART:";
			result += DTSTART;
			result += "\n";
		}

		if (DTEND != null && !DTEND.equals(""))
		{
			result += "DTEND:";
			result += DTEND;
			result += "\n";
		}

		if (SUMMARY != null && !SUMMARY.equals(""))
		{
			result += "SUMMARY:";
			result += SUMMARY;
			result += "\n";
		}

		if (GEO != null && !GEO.toString().equals(""))
		{
			result += "GEO:";
			result += GEO.toString();
			result += "\n";
		}

		if (CLASS != null && !CLASS.equals(""))
		{
			result += "CLASS:";
			result += CLASS;
			result += "\n";
		}


		if (COMMENT != null && !COMMENT.equals(""))
		{
			result += "COMMENT:";
			result += COMMENT;
			result += "\n";
		}

		result += "END:VEVENT\n";

		return result;
	}

	private String stripTitle(String input)
	{
		String [] temp = input.split(":");
		return temp[1];
	}

	@Override
	public int compareTo(ICSCalendarEvent anotherVevent)
	{
		int yearComp = Integer.parseInt(DTSTART.substring(0, 4))
						- Integer.parseInt(anotherVevent.getDTSTART().substring(0, 4));
		if (yearComp != 0)
		{
			return yearComp;
		}

		int monthComp = Integer.parseInt(DTSTART.substring(4, 6))
						- Integer.parseInt(anotherVevent.getDTSTART().substring(4, 6));
		if (monthComp != 0)
		{
			return monthComp;
		}

		int dayComp = Integer.parseInt(DTSTART.substring(6, 8))
						- Integer.parseInt(anotherVevent.getDTSTART().substring(6, 8));
		if (dayComp != 0)
		{
			return dayComp;
		}

		int hoursComp = Integer.parseInt(DTSTART.substring(9, 11))
						- Integer.parseInt(anotherVevent.getDTSTART().substring(9, 11));
		if (hoursComp != 0)
		{
			return hoursComp;
		}

		int minsComp = Integer.parseInt(DTSTART.substring(11, 13))
						- Integer.parseInt(anotherVevent.getDTSTART().substring(11, 13));
		if (minsComp != 0)
		{
			return minsComp;
		}

		int secsComp = Integer.parseInt(DTSTART.substring(13, 15))
						- Integer.parseInt(anotherVevent.getDTSTART().substring(13, 15));
		if (secsComp != 0)
		{
			return secsComp;
		}

		return 0;
	}

	/*
	    The Geo property specifies information related to the global position for
	    the activity specified by a calendar component.

	    RFC specs for GEO are referenced here: https://tools.ietf.org/html/rfc5545#section-3.8.1.6
	*/
	public class Geo
	{
	    float lat;
	    float lon;

	    //default constructor
	    public Geo()
	    {
	        lat = 0.0f;
	        lon = 0.0f;
	    }

	    //overloaded constructor
	    public Geo(String input)
	    {
	        String [] temp = input.split(";");
	        lat = Float.parseFloat(temp[0]);
	        lon = Float.parseFloat(temp[1]);
	    }

	    //returns the geocoordinates as a string
	    public String getGEO()
	    {
	        String temp  =  "";
	        temp        += lat;
	        temp        += ";";
	        temp        += lon;

	        return temp;
	    }

	    public float getLatitude()
	    {
	        return lat;
	    }

	    public float getLongitude()
	    {
	        return lon;
	    }

	    public void setLatitude(float input)
	    {
	        lat = input;
	    }

	    public void setLongitude(float input)
	    {
	        lon = input;
	    }

	    //checks if a float is a valid latitude
	    public boolean isValidLatitude(float latitude)
		{
		    if(latitude >= -90.0000f && latitude <= 90.0000f)
		    {
		    	return true;
		    }
		    else
		    {
		    	return false;
		    }
		}

	    //checks if float is a valid longitude
		public boolean isValidLongitude(float longitude)
		{
			if(longitude >= -180.0000f && longitude <= 180.0000f)
			{
				return true;
			}
			else
			{
				return false;
			}
		}

	    public String toString()
	    {
	        return this.getGEO();
	    }
	}
		
}
