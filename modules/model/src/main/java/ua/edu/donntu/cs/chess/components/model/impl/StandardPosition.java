/*
 * StandardPosition.java
 */

package ua.edu.donntu.cs.chess.components.model.impl;

import ua.edu.donntu.cs.chess.components.model.Position;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class StandardPosition
	implements Position
{
// Constants -----------------------------------------------------------------------------------------------------------

	public static final char[] X_LABEL_CHARS =
	{
	  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
	};

// Constructors --------------------------------------------------------------------------------------------------------

	public StandardPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
		xLabel = generateXLabel(x);
		yLabel = generateYLabel(y);
		string = xLabel + yLabel;
	}

// Position Implementation ---------------------------------------------------------------------------------------------

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public String getXLabel()
	{
		return xLabel;
	}

	public String getYLabel()
	{
		return yLabel;
	}

	@Override
	public String toString()
	{
		return string;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final StandardPosition that = (StandardPosition) o;
		return x == that.x && y == that.y;
	}

	@Override
	public int hashCode()
	{
		int result = x;
		result = 31 * result + y;
		return result;
	}

// Service Logic -------------------------------------------------------------------------------------------------------

	public static String generateXLabel(int x)
	{
		final StringBuilder rv = new StringBuilder();
		do
		{
			int modx = x % X_LABEL_CHARS.length;
			x /= X_LABEL_CHARS.length;
			rv.insert(0, X_LABEL_CHARS[modx]);
		}
		while (x > 0);
		return rv.toString();
	}

	public static String generateYLabel(int y)
	{
		return String.valueOf(y + 1);
	}

// Attributes ----------------------------------------------------------------------------------------------------------

	private final int x;
	private final int y;
	private final String xLabel;
	private final String yLabel;
	private final String string;
}

