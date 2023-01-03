import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import acm.util.ErrorException;
import acmx.export.java.io.FileReader;

/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

public class NameSurferDataBase implements NameSurferConstants {
	NameSurferEntry nameSurfer;
	HashMap<String, NameSurferEntry> namesMap = new HashMap<String, NameSurferEntry>();
	
/* Constructor: NameSurferDataBase(filename) */
/**
 * Creates a new NameSurferDataBase and initializes it using the
 * data in the specified file.  The constructor throws an error
 * exception if the requested file does not exist or if an error
 * occurs as the file is being read.
 * @throws IOException 
 */
	
/*
 * This method reads a data(in this case, names and relevant numbers) from given file 
 * line by line and puts it in the HashMap.
 */
	public NameSurferDataBase(String filename)  {
			try{
				BufferedReader reader = new BufferedReader(new FileReader(filename));
			while(true){
				String sentence = reader.readLine();
				if(sentence == null) {
					break;
				}
					NameSurferEntry entry = new NameSurferEntry(sentence);
					namesMap.put(entry.getName(), entry);
			}
			reader.close();
			}catch(IOException ex){
				throw new ErrorException(ex);
			}
	}
	
/* Method: findEntry(name) */
/**
 * Returns the NameSurferEntry associated with this name, if one
 * exists.  If the name does not appear in the database, this
 * method returns null.
 */
	
/*
 * This method finds a given name in the map, if it does not exists in the map, it return null;
 */
	public NameSurferEntry findEntry(String name) {
		name = validName(name);
		nameSurfer = namesMap.get(name);
		if(nameSurfer != null){
			return nameSurfer;
		}else{
			return null;
		}
	}
	

/*
 * This method is responsible to transform the name inputed by the user into
 * valid name, which first letter has to be upper case and other letters have to be lower case.
 */
	private String validName(String name){
		String result = "";
		char first = name.charAt(0);
		if(Character.isLowerCase(first)){
			first = Character.toUpperCase(first);
		}
		
		String otherThanFirstLetters = name.substring(1);
		otherThanFirstLetters = otherThanFirstLetters.toLowerCase();
		result = first + otherThanFirstLetters;
		return result;
		
		
	}
	
}