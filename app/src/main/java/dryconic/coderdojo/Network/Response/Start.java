package dryconic.coderdojo.Network.Response;

/**
 * Created by Andres on 2/20/2016.
 */
public class Start
{
    private String timezone;

    private String utc;

    private String local;

    public String getTimezone ()
    {
        return timezone;
    }

    public void setTimezone (String timezone)
    {
        this.timezone = timezone;
    }

    public String getUtc ()
    {
        return utc;
    }

    public void setUtc (String utc)
    {
        this.utc = utc;
    }

    public String getLocal ()
    {
        return local;
    }

    public void setLocal (String local)
    {
        this.local = local;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timezone = "+timezone+", utc = "+utc+", local = "+local+"]";
    }
}
