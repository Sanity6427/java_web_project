package student;

public class StudentFactory {
	// ΩÃ±€≈Ê∆–≈œ 
	private StudentFactory() {}
	
	private static StudentFactory instance =
							new StudentFactory();
	public static StudentFactory getInstance() {
		return instance;
	}

	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		if(cmd.equals("insert")) {
			cmdIf = new InsertCommand();
		}else if (cmd.equals("delete")) {
			cmdIf = new DeleteCommand();
		}else if (cmd.equals("find")) {
			cmdIf = new FindCommand();
		}else if (cmd.equals("list")) {
			cmdIf = new ListCommand();
		}else if (cmd.equals("index")) {
			cmdIf = new IndexCommand();
		}
		return cmdIf;
	}
}
