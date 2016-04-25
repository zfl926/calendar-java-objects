/*
    The Geo property specifies information related to the global position for
    the activity specified by a calendar component.

    RFC specs for GEO are referenced here: https://tools.ietf.org/html/rfc5545#section-3.8.1.6

    ---PHILOSOPHY---
    The purpose of making GEO its own class was due to the fact that the GEO property could
    be used in both VEVENT or VTODO(see conformance section at https://tools.ietf.org/html/rfc5545#section-3.8.1.6).
    Making GEO a member variable of VEVENT would cause scaling issues if a VTODO class is ever implemented.

    Geo also contains multiple properties (ie lat and long)

    TLDR: Geo is middleware from Vevent/Vtodo to Coordinate.java

*/
public class Geo
{
    Coordinate coordinate;
    float lat;
    float lon;

    //default constructor
    public Geo()
    {
        Coordinate coordinate = null;
        float lat             = 0.0f;
        float lon             = 0.0f;
    }

    public Geo(String input)
    {
        String [] temp = input.split(";");

        lat = Float.parseFloat(temp[0]);
        lon = Float.parseFloat(temp[1]);

        coordinate = new Coordinate(lat, lon);
    }

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
