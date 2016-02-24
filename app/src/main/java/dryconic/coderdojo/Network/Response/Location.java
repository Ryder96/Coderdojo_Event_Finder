package dryconic.coderdojo.Network.Response;

/**
 * Created by Andres on 2/20/2016.
 */
public class Location
{
    private String address;

    private String longitude;

    private String within;

    private String latitude;

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public String getWithin ()
    {
        return within;
    }

    public void setWithin (String within)
    {
        this.within = within;
    }

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [address = "+address+", longitude = "+longitude+", within = "+within+", latitude = "+latitude+"]";
    }
}
