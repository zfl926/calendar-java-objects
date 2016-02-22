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

	public Vevent(String inputUID, String inputDTSTAMP, String inputORGANIZER, String inputDTSTART, String inputDTEND, String inputSUMMARY)
	{
		UID = inputUID;
		DTSTAMP = inputDTSTAMP;
		ORGANIZER = inputORGANIZER;
		DTSTART = inputDTSTART;
		DTEND = inputDTEND;
		SUMMARY = inputSUMMARY;						
	}

	public String getUID()
	{
		return UID;
	}

	public void setUID(String input)
	{
		UID = input;
	}

	public String getDTSTAMP()
	{
		return DTSTAMP;
	}

	public void setDTSTAMP(String input)
	{
		DTSTAMP = input;
	}

	public String getORGANIZER()
	{
		return ORGANIZER;
	}

	public void setORGANIZER(String input)
	{
		ORGANIZER = input;
	}

	public String getDTSTART()
	{
		return DTSTART;
	}

	public void setDTSTART(String input)
	{
		DTSTART = input;
	}

	public String getDTEND()
	{
		return DTEND;
	}

	public void setDTEND(String input)
	{
		DTEND = input;
	}

	public String getSUMMARY()
	{
		return SUMMARY;
	}

	public void setSUMMARY(String input)
	{
		SUMMARY = input;
	}

	public boolean isValid()
	{
		return true;
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
			result += UID;
		}

		if (DTSTAMP != null && !DTSTAMP.equals(""))
		{
			result += DTSTAMP;
		}

		if (ORGANIZER != null && !ORGANIZER.equals(""))
		{
			result += ORGANIZER;
		}

		if (DTSTART != null && !DTSTART.equals(""))
		{
			result += DTSTART;
		}

		if (DTEND != null && !DTEND.equals(""))
		{
			result += DTEND;
		}

		if (SUMMARY != null && !SUMMARY.equals(""))
		{
			result += SUMMARY;
		}

		result += "END:VEVENT\n";

		return result;
	}
}