import acmx.export.java.util.TreeMap;

public class TestCase{
	public TestCase(String line) {
		entry = line;
	}

/* Method: getName() */
/**
 * Returns the name associated with this entry.
 */
	public String getName() {
		String name = entry.substring(0, entry.indexOf(" "));
		return name;
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
		String[] split = entry.split(" ");
		int number = Integer.parseInt(split[decade + 1]);
		return number;
	}

/* Method: toString() */
/**
 * Returns a string that makes it easy to see the value of a
 * NameSurferEntry.
 */
	public String toString() {
		int name = entry.indexOf(" ");
		return (entry.substring(0, name) + " [" + entry.substring(name + 1) + "]");
	}
	
	private String entry;
}