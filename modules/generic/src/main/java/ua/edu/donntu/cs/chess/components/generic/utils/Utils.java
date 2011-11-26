/*
 * Utils.java
 */

package ua.edu.donntu.cs.chess.components.generic.utils;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Random;

import ua.edu.donntu.cs.chess.components.generic.Constants;

/**
 * Description.
 *
 * @author Rod Odin
 */
public abstract class Utils
  implements Constants
{
  public static void sleep(long msecs)
  {
    try { Thread.sleep(msecs); } catch(InterruptedException x) {}
  }

  public static void sleep(float secs)
  {
    sleep(new Float(secs * 1000).longValue());
  }

  public static URI findResource(String filename)
  {
    URI rv = null;
    // first see if the resource is a plain file
    final File f = new File(filename);
    if(f.exists())
      rv = f.toURI();
    else // search for the resource on the classpath
    {
      final ClassLoader cl = Utils.class.getClassLoader();
      final URL url = cl.getResource(filename);
      if(url != null)
        try { rv = url.toURI(); }
        catch(URISyntaxException e) { }
    }
    return rv;
  }

  public static int randomInt(int min, int max)
  {
    return RANDOM.nextInt(max - min + 1) + min;
  }

  public static String mapToString(Map<?, ?> map)
  {
    return mapToString(map, "\n");
  }

  public static String mapToString(Map<?, ?> map, String linePref)
  {
    return mapToString(map, linePref, " -> ");
  }

  public static String mapToString(Map<?, ?> map, String linePref, String delimiter)
  {
    return mapToString(map, linePref, delimiter, true);
  }

  public static String mapToString(Map<?, ?> map, String linePref, String delimiter, boolean braces)
  {
    return mapToString(map, linePref, delimiter, braces, true);
  }

  public static String mapToString(Map<?, ?> map, String linePref, String delimiter, boolean braces, boolean mapClassName)
  {
    String rv =  (mapClassName ? map.getClass().getName() : "")
              +  (braces ? linePref + "{" : "");
    for (Map.Entry<?, ?> me : map.entrySet())
           rv += linePref + "  " + me.getKey() + delimiter + me.getValue();
           rv += (braces ? linePref + "}" : "");
    return rv;
  }

  public static String stackTraceToString(String pref)
  {
    String rv = "";
    final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    for (StackTraceElement e : stackTrace)
      rv += pref + "at " + e.toString();
    return rv;
  }

  private static final Random RANDOM = new Random();
}
