import java.util.Scanner;

public class Interface 
{
	public static void main(String [] args)
	{
		String userInput = "";
		Scanner userInputScanner = new Scanner(System.in);
		boolean exitProgram = false;
		Calendar calendar;

		//if user enters a command argument
		if (args.length == 1)
		{
			//if user enters a valid .ics file
			if (isIcsFile(args[0]))
			{
				System.out.println("importing .ics file into calendar object...");
				//calendar = new Calendar(args[0]);
			}
			//if the user enters a non valid .ics file
			else
			{
				System.out.println("The entered file is not a valid .ics file!");
				return;
			}
		}
		//no command arguments
		else if (args.length == 0)
		{
			System.out.println("No import calendar, creating a new .ics file...");
			calendar = new Calendar();
		}
		//if user enters more than 1 argument
		else if (args.length > 1)
		{
			System.out.println("Too many arguments!");
			return;
		}

		//get user input
		while(!exitProgram)
		{
			//take user input and convert to lower case
			System.out.print("Command: ");
       		userInput = userInputScanner.nextLine();
       		userInput = userInput.toLowerCase();

       		//list all commands
       		if(userInput.equals("commands"))
       		{
       			printAllCommands();
       		}
       		//add event to calendar
       		else if(userInput.equals("add"))
       		{
       			System.out.println("calendar.add(); here");
       		}
       		//exit application
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

	/*
		Returns true if input is .ics file, false if otherwise
		 modified from http://stackoverflow.com/questions/3571223/how-do-i-get-the-file-extension-of-a-file-in-java
	*/
	private static boolean isIcsFile(String fileName)
	{
		String extension = "";
		int i = fileName.lastIndexOf('.');
		boolean myReturn;

		if (i > 0) 
		{
		    extension = fileName.substring(i+1);
		}

		extension = extension.toLowerCase();

		if (extension.equals("ics"))
		{
			myReturn = true;
		}
		else
		{
			myReturn = false;
		}

		return myReturn;
	}
}
