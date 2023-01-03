import acm.program.ConsoleProgram;

public class Test extends ConsoleProgram{
	public void run(){
		NameSurferEntry testCase = new NameSurferEntry("Kawhi 0 0 54 0 67 0 0 45 0 343 129");
		println(testCase.getRank(10));
	}
}