import acm.program.ConsoleProgram;

public class Try extends ConsoleProgram{
	private NameSurferEntry entry;
	public void run(){
		entry = new NameSurferEntry(line);
		println("Name " + entry.getName());
		println("Rank " + entry.getRank(5));
		println("To string " + entry.toString());
	}
	 
	String line = "Saba 23 24 34 56 45 349 154 344 233 462 235 776";
}