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
public class Geo extends Coordinate 
{
    public Geo(float latitude, float longitude)
    {
        super(latitude, longitude);
    }
}