/*
 * Log4JOutputStreamWrapper.java
 */

package ua.edu.donntu.cs.chess.components.generic.log;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class Log4JOutputStreamWrapper
  extends OutputStream
{
// Constructors --------------------------------------------------------------------------------------------------------

	/**
	 * Creates a wrapper to redirect the output to the given <code>{@link org.apache.log4j.Logger logger}</code>.
	 *
	 * @param logger the Logger to write to
	 * @param level  the Level to use when writing to the Logger
	 *
	 * @throws NullPointerException if any of the arguments is <code>null</code>
	 */
	public Log4JOutputStreamWrapper(Logger logger, Level level)
		throws NullPointerException
	{
		if (logger == null)
			throw new NullPointerException("Logger must not be null");
		if (level == null)
			throw new NullPointerException("Level must not be null");
		this.level = level;
		this.logger = logger;
		bufLength = DEFAULT_BUFFER_LENGTH;
		buf = new byte[DEFAULT_BUFFER_LENGTH];
		count = 0;
	}

// Constants -----------------------------------------------------------------------------------------------------------

	public static final int DEFAULT_BUFFER_LENGTH = 2048;
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	public static final Logger LOG = org.apache.log4j.Logger.getLogger(Log4JOutputStreamWrapper.class);

	/**
	 * Default JVM-initialized <code>{@link System#err STDERR}</code>.
	 */
	public static final PrintStream DEFAULT_STDERR = System.err;

	/**
	 * Default JVM-initialized <code>{@link System#out STDOUT}</code>.
	 */
	public static final PrintStream DEFAULT_STDOUT = System.out;

// Service Methods -----------------------------------------------------------------------------------------------------

	/**
	 * Redirects STDERR and/or STDOUT to Log4J system.
	 * Redirection of STDERR is done with <code>WARN</code> logging level,
	 * and redirection of STDOUT - with <code>INFO</code>.
	 * A good place to invoke this method is a static context of your main class (class with the main routine or
	 * main servlet class).
	 * @param redirectStdErr <code>true</code> to redirect STDERR. Please note, if you redirect STDERR to Log4J,
	 *                       you must not use <code>System.err</code> for <code>ConsoleAppender</code> in your Log4J
	 *                       configuartion.
	 * @param redirectStdOut <code>true</code> to redirect STDOUT. Please note, if you redirect STDOUT to Log4J,
	 *                       you must not use <code>System.out</code> for <code>ConsoleAppender</code> in your Log4J
	 *                       configuartion.
	 */
	public static void redirect(boolean redirectStdErr, boolean redirectStdOut)
	{
		if (redirectStdErr)
		{
			System.setErr(new PrintStream(new Log4JOutputStreamWrapper(LOG, Level.WARN), true));
			LOG.info("STDERR is redirected to Log4J");
		}

		if (redirectStdOut)
		{
			System.setOut(new PrintStream(new Log4JOutputStreamWrapper(LOG, Level.INFO), true));
			LOG.info("STDOUT is redirected to Log4J");
		}
	}

// Interface Methods ---------------------------------------------------------------------------------------------------

	/**
	 * Closes this output stream and releases any system resources associated with this stream. The general contract of
	 * <code>close</code> is that it closes the output stream. A closed stream cannot perform output operations and
	 * cannot be reopened.
	 */
	public void close()
	{
		flush();
		hasBeenClosed = true;
	}

	/**
	 * Writes the specified byte to this output stream. The general contract for <code>write</code> is that one byte is
	 * written to the output stream. The byte to be written is the eight low-order bits of the argument <code>b</code>.
	 * The 24 high-order bits of <code>b</code> are ignored.
	 *
	 * @param b the <code>byte</code> to write
	 *
	 * @throws java.io.IOException if an I/O error occurs. In particular, an <code>IOException</code> may be thrown if the
	 *                     output stream has been closed.
	 */
	public void write(final int b) throws IOException
	{
		if (hasBeenClosed)
			throw new IOException("The stream has been closed");

		if (count == bufLength)
		{
			final int newBufLength = bufLength + DEFAULT_BUFFER_LENGTH;
			final byte[] newBuf = new byte[newBufLength];
			System.arraycopy(buf, 0, newBuf, 0, bufLength);
			buf = newBuf;
			bufLength = newBufLength;
		}
		buf[count] = (byte) b;
		count++;
	}

	/**
	 * Flushes this output stream and forces any buffered output bytes to be written out. The general contract of
	 * <code>flush</code> is that calling it is an indication that, if any bytes previously written have been buffered
	 * by the implementation of the output stream, such bytes should immediately be written to their intended
	 * destination.
	 */
	public void flush()
	{
		if (count == 0)
			return;
		// don't print out blank lines; flushing from PrintStream puts out these
		if (LINE_SEPARATOR.equals(new String(buf, 0, LINE_SEPARATOR.length())))
		{
			reset();
			return;
		}
		final byte[] theBytes = new byte[count];
		System.arraycopy(buf, 0, theBytes, 0, count);
		logger.log(level, new String(theBytes));
		reset();
	}

	private void reset()
	{
		count = 0;
	}

// Fields --------------------------------------------------------------------------------------------------------------

	private boolean hasBeenClosed = false;
	private byte[] buf;
	private int count;
	private int bufLength;
	private Logger logger;
	private Level level;
}
