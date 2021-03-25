import java.util.Scanner;

public class MastermindTextView {

	public MastermindTextView() {
		
	}
	
	public void play() {
		// This class represents the view, it should be how uses play the game
			System.out.println("Welcome to Mastermind!");
			// while the user wants to play:
			while(1==1) {
				Scanner myObj = new Scanner(System.in);  // Create a Scanner object
			    System.out.println("Would you like to play?(yes/no)");
			    String wantToPlay = myObj.nextLine();
				boolean won = false;
				if(!wantToPlay.equals("yes")) {
					myObj.close();
					return;
				}
				// Construct the model (whose constructor builds the secret answer)
				MastermindModel model = new MastermindModel("rgbp");
				// Construct the controller, passing in the model
				MastermindController controller = new MastermindController(model);
				// Read up to ten user inputs
				int i = 1;
				while(i<=10 && won == false) {
					Scanner inputs = new Scanner(System.in);  // Create a Scanner object
				    System.out.print("Enter guess number ");
				    System.out.print(i);
				    System.out.print(": ");
				    String input = inputs.nextLine();
				    // check whether input is 4 characters long and contains legal colors
				    do{
			            try
			            {
			            	if(input.length()!=4)
			            		throw new MastermindIllegalLengthException(input);
			            	else if(!model.isLegal(input))
			            		throw new MastermindIllegalColorException(input);
			            	
			            }	 
			            	// catching illegal length exception and asking for another try
			                catch(MastermindIllegalLengthException e)
			            	{
			                    System.out.println("Enter a string 4 chars long");
			                    input = inputs.nextLine();
			             	}
			            	// catching illegal color exception and asking for another try
			                catch(MastermindIllegalColorException e)
			            	{
			                    System.out.println("Enter a string with only ['r','o','y','g','b','p'] characters");
			                    input = inputs.nextLine();
			            	}
			        } while(input.length()!=4 || model.isLegal(input)==false);
				    
					 	// Check whether or not the input is correct (by asking the controller)
					    try {
							if(controller.isCorrect(input)) {
								won = true;
							// If not, display the relevant statistics  (by asking the controller)
							} else {
								int RP = controller.getRightColorRightPlace(input);
								int WP = controller.getRightColorWrongPlace(input);
								System.out.print("Colors in the correct place: ");
								System.out.println(RP);
								System.out.print("Colors correct but in wrong position: ");
								System.out.println(WP);
							}
						} catch (MastermindIllegalColorException e) {
							e.printStackTrace();
						} catch (MastermindIllegalLengthException e) {
							e.printStackTrace();
						}
				    i++;
				}
				// Determine win or loss
				if(won == true) {
					won = false;
					System.out.println("Congrats! You Won!");
				}
				// if chances are finished 
				if(i>10)
					System.out.println("Sorry! Try Again.");
			}
	}
}
