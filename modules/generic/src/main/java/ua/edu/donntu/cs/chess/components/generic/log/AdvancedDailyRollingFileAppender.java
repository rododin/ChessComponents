/*
 * AdvancedDailyRollingFileAppender.java
 */

package ua.edu.donntu.cs.chess.components.generic.log;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Priority;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.ErrorHandler;

/**
 * Description.
 *
 * @author Rod Odin
 */
public class AdvancedDailyRollingFileAppender
	extends DailyRollingFileAppender
{
	public AdvancedDailyRollingFileAppender()
	{
		//log("AdvancedDailyRollingFileAppender", "", false);
	}

	public AdvancedDailyRollingFileAppender(Layout layout, String filename, String datePattern) throws IOException
	{
		super(layout, filename, datePattern);
		//log("AdvancedDailyRollingFileAppender(Layout, String, String) throws IOException)", "", false);
	}

	@Override
	public void setDatePattern(String pattern)
	{
		//log("setDatePattern(pattern=\"" + pattern + "\")", "", false);
		super.setDatePattern(pattern);
	}

	@Override
	public void activateOptions()
	{
		//log("activateOptions()", "", false);
		renameOldFiles();
		super.activateOptions();
	}

	@Override
	public void setFile(String file)
	{
		//log("setFile(file=\"" + file + "\")", "", false);
		super.setFile(file);
	}

	@Override
	public void setAppend(boolean flag)
	{
		//log("setAppend(flag=" + flag + ")", "", false);
		super.setAppend(flag);
	}

	@Override
	public void setBufferedIO(boolean bufferedIO)
	{
		//log("setBufferedIO(bufferedIO=" + bufferedIO + ")", "", false);
		super.setBufferedIO(bufferedIO);
	}

	@Override
	public void setBufferSize(int bufferSize)
	{
		//log("setBufferSize(bufferSize=" + bufferSize + ")", "", false);
		super.setBufferSize(bufferSize);
	}

	@Override
	public void setFile(String fileName, boolean append, boolean bufferedIO, int bufferSize) throws IOException
	{
		//log("setFile(bufferSize=fileName=\"" + fileName + "\", append=" + append + ", bufferedIO="+ bufferedIO + ", bufferedSize=" + bufferSize + ")", "", false);
		super.setFile(fileName, append, bufferedIO, bufferSize);
	}

	@Override
	protected void setQWForFiles(Writer writer)
	{
		//log("setQWForFiles(Writer)", "", false);
		super.setQWForFiles(writer);
	}

	@Override
	protected void reset()
	{
		//log("reset()", "", false);
		super.reset();
	}

	@Override
	public void setImmediateFlush(boolean value)
	{
		//log("setImmediateFlush(value=" + value + ")", "", false);
		super.setImmediateFlush(value);
	}

	@Override
	public void setEncoding(String value)
	{
		//log("setEncoding(value=\"" + value + "\")", "", false);
		super.setEncoding(value);
	}

	@Override
	public void setErrorHandler(ErrorHandler eh)
	{
		//log("setErrorHandler(ErrorHandler)", "", false);
		super.setErrorHandler(eh);
	}

	@Override
	public void setWriter(Writer writer)
	{
		//log("setWriter(Writer)", "", false);
		super.setWriter(writer);
	}

	@Override
	protected void closeFile()
	{
		//log("closeFile()", "", false);
		super.closeFile();
	}

	@Override
	public void close()
	{
		//log("close()", "", false);
		super.close();
	}

	@Override
	protected void closeWriter()
	{
		//log("closeWriter()", "", false);
		super.closeWriter();
	}

	@Override
	public void setLayout(Layout layout)
	{
		//log("setLayout(Layout)", "", false);
		super.setLayout(layout);
	}

	@Override
	public void setName(String name)
	{
		//log("setName(name=\"" + name + "\")", "", false);
		super.setName(name);
	}

	@Override
	public void setThreshold(Priority threshold)
	{
		//log("setThreshold(Priority)", "", false);
		super.setThreshold(threshold);
	}

	protected static void log(String methodName, String msg, boolean logTrace)
	{
		//System.out.println("DBG-Log4J: AdvancedDailyRollingFileAppender." + methodName + ": " + msg);
		if (logTrace)
		{
			try
			{
				throw new RuntimeException("Trace Logging: " + methodName);
			}
			catch (RuntimeException x)
			{
				x.printStackTrace(System.out);
			}
		}
	}

	protected void renameOldFiles()
	{
		if (!oldFilesRenamed)
		{
			final SimpleDateFormat sdf = new SimpleDateFormat(getDatePattern());
			final File file = new File(fileName);
			final String baseFilename = fileName + sdf.format(new Date(file.lastModified())); // the formula is taken from the parent DailyRollingFileAppender
			if (file.exists())
				renameOldFile(file, baseFilename, 1);
			oldFilesRenamed = true;
		}
	}

	protected void renameOldFile(File oldFile, String baseFilename, int index)
	{
		final String newFilename = baseFilename + "." + (index != 0 ? index : "");
		final File newFile = new File(newFilename);
		if (newFile.exists())
		{
			renameOldFile(newFile, baseFilename, index+1);
			if (newFile.exists() && !newFile.delete())
				LogLog.error("Unable to delete old file after renaming: " + newFile.getPath());
		}
		if (!oldFile.renameTo(newFile))
			LogLog.error("Unable to rename old file: old=" + oldFile.getPath() + ", new=" + newFile.getPath());
		else
			LogLog.debug("Old file has been renamed: old=" + oldFile.getPath() + ", new=" + newFile.getPath());
	}

	private boolean oldFilesRenamed;
}
