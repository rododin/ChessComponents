/*
 * DateTimeUtils.java
 */

package ua.edu.donntu.cs.chess.components.generic.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Description.
 *
 * @author Rod Odin
 */
public abstract class DateTimeUtils
	extends Utils
{
// Constants ---------------------------------------------------------------------------------------

	public static final ResourceBundle DATE_TIME_BUNDLE = ResourceBundle.getBundle(DateTimeUtils.class.getName());

	public static final String DEFAULT_DATE_PATTERN     = DATE_TIME_BUNDLE.getString("dateTimeUtils.default.pattern.date"    );
	public static final String DEFAULT_TIME_PATTERN     = DATE_TIME_BUNDLE.getString("dateTimeUtils.default.pattern.time"    );
	public static final String DEFAULT_DATETIME_PATTERN = DATE_TIME_BUNDLE.getString("dateTimeUtils.default.pattern.datetime");

// Methods -----------------------------------------------------------------------------------------

	public static String fromDate(Date date)
	{
		return fromDateTime(date, DEFAULT_DATE_PATTERN);
	}

	public static String fromTime(Date time)
	{
		return fromDateTime(time, DEFAULT_TIME_PATTERN);
	}

	public static String fromDateTime(Date datetime)
	{
		return fromDateTime(datetime, DEFAULT_DATETIME_PATTERN);
	}

	public static String fromDateTime(Date datetime, String pattern)
	{
		String rv = null;
		if(datetime != null && pattern != null)
			rv = (new SimpleDateFormat(pattern)).format(datetime);
		return rv;
	}

	public static Date toDate(String sdate)
		throws ParseException
	{
		return toDateTime(sdate, DEFAULT_DATE_PATTERN);
	}

	public static Date toTime(String stime)
		throws ParseException
	{
		return toDateTime(stime, DEFAULT_TIME_PATTERN);
	}

	public static Date toDateTime(String sdatetime)
		throws ParseException
	{
		return toDateTime(sdatetime, DEFAULT_DATETIME_PATTERN);
	}

	public static Date toDateTime(String sdatetime, String pattern)
		throws ParseException
	{
		Date rv = null;
		if(sdatetime != null && sdatetime.trim().length() != 0 && pattern != null)
			rv = (new SimpleDateFormat(pattern)).parse(sdatetime);
		return rv;
	}
}
