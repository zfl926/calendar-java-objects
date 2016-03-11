public class Vevent
{
	/*
		----TEMPLATE----
		https://en.wikipedia.org/wiki/ICalendar

		BEGIN:VEVENT
		UID:uid1@example.com
		DTSTAMP:19970714T170000Z
		ORGANIZER;CN=John Doe:MAILTO:john.doe@example.com
		DTSTART:19970714T170000Z
		DTEND:19970715T035959Z
		SUMMARY:Bastille Day Party
	*/

	private String UID;
	private String DTSTAMP;
	private String ORGANIZER;
	private String DTSTART;
	private String DTEND;
	private String SUMMARY;
	private Geo    GEO;

	//default constructor
	public Vevent()
	{

	}

	//overloaded constructor
	public Vevent(String inputUID, String inputDTSTAMP, String inputORGANIZER, String inputDTSTART, String inputDTEND, String inputSUMMARY, Geo inputGEO)
	{
		UID       = inputUID;
		DTSTAMP   = inputDTSTAMP;
		ORGANIZER = inputORGANIZER;
		DTSTART   = inputDTSTART;
		DTEND     = inputDTEND;
		SUMMARY   = inputSUMMARY;
		GEO       = inputGEO;
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

	public boolean validUID(String input)
	{
		//TODO
		//MAKE SURE IT IS VALID
		//https://en.wikipedia.org/wiki/ICalendar
        if (input.equals("invalid"))
        {
            return false;
        }
		return true;
	}

	public boolean validDTSTAMP(String input)
	{
		//MAKE SURE IT IS VALID
		//https://en.wikipedia.org/wiki/ICalendar
		if (input.length() != 16) {
			System.out.println("FORMAT: YYYYMMDDTHHMMSSZ");
			return false;
		}
										
		int expectYear = Integer.parseInt(input.substring(0, 4));
		int expectMonth = Integer.parseInt(input.substring(4, 6));
		int expectDay = Integer.parseInt(input.substring(6, 8));
		char expectT = input.charAt(8);
		int expectHours = Integer.parseInt(input.substring(9, 11));
		int expectMinutes = Integer.parseInt(input.substring(11, 13));
		int expectSeconds = Integer.parseInt(input.substring(13,15));
		char expectZ = input.charAt(15);
																									
		if (expectYear < 0 || expectMonth < 1 || expectMonth > 12 ||
			expectDay < 1 || expectDay > 31 || expectT != 't' ||
			expectHours < 0 || expectHours > 24 || expectMinutes < 0 ||
			expectMinutes > 59 || expectSeconds < 0 || expectSeconds > 59 ||
			expectZ != 'z') {
																																
			System.out.println("FORMAT: YYYYMMDDTHHMMSSZ");
			return false;
		}

		return true;
	}

	public boolean validORGANIZER(String input)
	{
		//TODO
		//MAKE SURE IT IS VALID
		//https://en.wikipedia.org/wiki/ICalendar
		return true;
	}

	public boolean validDTSTART(String input)
	{
		//MAKE SURE IT IS VALID
		//https://en.wikipedia.org/wiki/ICalendar
		if (input.length() != 16) {
			System.out.println("FORMAT: YYYYMMDDTHHMMSSZ");
			return false;
		}
										
		int expectYear = Integer.parseInt(input.substring(0, 4));
		int expectMonth = Integer.parseInt(input.substring(4, 6));
		int expectDay = Integer.parseInt(input.substring(6, 8));
		char expectT = input.charAt(8);
		int expectHours = Integer.parseInt(input.substring(9, 11));
		int expectMinutes = Integer.parseInt(input.substring(11, 13));
		int expectSeconds = Integer.parseInt(input.substring(13,15));
		char expectZ = input.charAt(15);
																									
		if (expectYear < 0 || expectMonth < 1 || expectMonth > 12 ||
			expectDay < 1 || expectDay > 31 || expectT != 't' ||
			expectHours < 0 || expectHours > 24 || expectMinutes < 0 ||
			expectMinutes > 59 || expectSeconds < 0 || expectSeconds > 59 ||
			expectZ != 'z') {
																																
			System.out.println("FORMAT: YYYYMMDDTHHMMSSZ");
			return false;
		}

		return true;
	}

	public boolean validDTEND(String input)
	{
		//MAKE SURE IT IS VALID
		//https://en.wikipedia.org/wiki/ICalendar
		if (input.length() != 16) {
			System.out.println("FORMAT: YYYYMMDDTHHMMSSZ");
			return false;
		}
										
		int expectYear = Integer.parseInt(input.substring(0, 4));
		int expectMonth = Integer.parseInt(input.substring(4, 6));
		int expectDay = Integer.parseInt(input.substring(6, 8));
		char expectT = input.charAt(8);
		int expectHours = Integer.parseInt(input.substring(9, 11));
		int expectMinutes = Integer.parseInt(input.substring(11, 13));
		int expectSeconds = Integer.parseInt(input.substring(13,15));
		char expectZ = input.charAt(15);
																									
		if (expectYear < 0 || expectMonth < 1 || expectMonth > 12 ||
			expectDay < 1 || expectDay > 31 || expectT != 't' ||
			expectHours < 0 || expectHours > 24 || expectMinutes < 0 ||
			expectMinutes > 59 || expectSeconds < 0 || expectSeconds > 59 ||
			expectZ != 'z') {
																																
			System.out.println("FORMAT: YYYYMMDDTHHMMSSZ");
			return false;
		}

		return true;
	}

	public boolean validSUMMARY(String input)
	{
		//TODO
		//not sure how to validate this, maybe limit to x characters?
		return true;
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

		}
		return myReturn;
	}

	/*
		ensures that all fields of vevent are valid according to protocol
		https://en.wikipedia.org/wiki/ICalendar
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

		result += "END:VEVENT\n";

		return result;
	}

	private String stripTitle(String input)
	{
		String [] temp = input.split(":");
		return temp[1];
	}
}
