import java.util.Scanner; 

public class Interface 
{
	public static void main(String [] args)
	{
		String userInput = "";
		Scanner userInputScanner = new Scanner(System.in);
		boolean exitProgram = false;

		//get user input
		while(!exitProgram)
		{
			//take user input and convert to lower case
			System.out.println("Please enter a command!\nFor a list of commands, type \"commands\"");
       		userInput = userInputScanner.nextLine();
       		userInput = userInput.toLowerCase();

       		if(userInput.equals("commands"))
       		{
       			System.out.println("You have entered the \"Commands\" button!");
       			exitProgram = true;
       		}
       		else
       		{
       			System.out.println("I am not sure what you mean, perhaps type \"Commands\"?");
       		}
		}
	}

	/*
		Returns all possible commands that a user could enter
	*/
	private void printAllCommands()
	{
		System.out.println("-------COMMANDS--------");

	}
}
