package de.mud.jta;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceManager
{
    private static ResourceManager rm;
    private ResourceBundle rb;
    private Locale locale;
    protected static final String PATH_TO_RESOURCE = ResourceManager.class.getName().replaceAll("ResourceManager","resources.Jta");

    public Locale getLocale()
    {
    	if(locale ==null)
    		locale = Locale.getDefault();
    	return locale;
    }
    
    private Locale getLocale(String loc)
    {
    	locale = new Locale(loc);
    	if(locale == null)
    	{
    		locale = Locale.getDefault();
    	}
    	return locale;
    }
    public ResourceManager()
    {
    	rb = ResourceBundle.getBundle("de.mud.jta.resources.Jta",Locale.getDefault());
    }
    private ResourceManager(String locale)
    {
    	Locale loc = getLocale(locale);
    	rb = ResourceBundle.getBundle("de.mud.jta.resources.Jta",loc);
    }

    public static ResourceManager getInstance()
    {
    	if(rm == null)
    	{
    		rm = new ResourceManager();
    	}
    	return rm;
    }
    public static ResourceManager getInstance(String locale)
    {
	if (rm == null)
	{
	    rm = new ResourceManager(locale);
	}
	return rm;
    }

    public String getString(String key)
    {
    	try
    	{
    		String str = rb.getString(key);
    		if (str != null)
    		{
    		    return str;
    		}
    	}
    	catch(Exception e)
    	{
    		// Just ignore this so that only key is been sent..
    	}
	return key;
    }

    public String getString(String key, String param)
    {
	String str = rb.getString(key);
	if (str != null)
	{
	    return MessageFormat.format(str, new String[]
	    { param });
	}
	return key;
    }

    public String getString(String key, String param1, String param2)
    {
	String str = rb.getString(key);
	if (str != null)
	{
	    return MessageFormat.format(str, new String[]   { param1, param2 });
	}
	return key;
    }

    public String getString(String key, String params[])
    {
	String str = rb.getString(key);
	if (str != null)
	{
	    return MessageFormat.format(str, params);
	}
	return key;
    }

}
