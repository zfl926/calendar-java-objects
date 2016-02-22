import java.util.Scanner; 

public class Interface 
{
	public static void main(String [] args)
	{
		String userInput = "";
		Scanner userInputScanner = new Scanner(System.in);
		boolean exitProgram = false;

		//import
		//or
		//create calendar here
		Calendar calendar = new Calendar();

		//get user input
		while(!exitProgram)
		{
			//take user input and convert to lower case
			System.out.print("Command: ");
       		userInput = userInputScanner.nextLine();
       		userInput = userInput.toLowerCase();

       		//commands command
       		if(userInput.equals("commands"))
       		{
       			printAllCommands();
       		}
       		//add command
       		else if(userInput.equals("add"))
       		{
       			System.out.println("calendar.add(); here");
       		}
       		//exit command
       		else if(userInput.equals("exit") || userInput.equals("quit"))
       		{
       			exitProgram = true;
       		}
       		//If their is no known command for user input
       		else
       		{
       			System.out.println("I am not sure what you mean, perhaps type \"Commands\"?");
       		}
		}
	}

	/*
		Returns all possible commands that a user could enter
	*/
	private static void printAllCommands()
	{
		System.out.println("-------COMMANDS--------");
		System.out.println("commands - prints all known commands");
		System.out.println("exit     - exits the program with exporting");
		System.out.println("add      - add an event to current .ics file");

	}
}
