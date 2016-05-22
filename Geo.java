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
