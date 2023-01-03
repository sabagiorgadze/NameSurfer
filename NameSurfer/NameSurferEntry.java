/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

/* Constructor: NameSurferEntry(line) */
/**
 * Creates a new NameSurferEntry from a data line as it appears
 * in the data file.  Each line begins with the name, which is
 * followed by integers giving the rank of that name for each
 * decade.
 */
	
	private String text;
	public NameSurferEntry(String line) {
		text = line;
	}

/* Method: getName() */
/**
 * Returns the name associated with this entry.
 */

/*
 * This method returns a starting text of the string before space
 */
	public String getName() {
		 String result = text.substring(0, text.indexOf(" "));
		 return result;
	}

/* Method: getRank(decade) */
/**
 * Returns the rank associated with an entry for a particular
 * decade.  The decade value is an integer indicating how many
 * decades have passed since the first year in the database,
 * which is given by the constant START_DECADE.  If a name does
 * not appear in a decade, the rank value is 0.
 */
	public int getRank(int decade) {
		String[] years = text.split(" ");
		int number = Integer.parseInt(years[decade + 1]);
		return number;
	}

/* Method: toString() */
/**
 * Returns a string that makes it easy to see the value of a
 * NameSurferEntry.
 */
	public String toString() {
		String string = (text.substring(0, text.indexOf(" ")) + " (" + text.substring(text.indexOf(" ") + 1) + ")");
		return string;
	}
}