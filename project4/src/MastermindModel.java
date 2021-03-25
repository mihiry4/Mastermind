
import java.util.Random;

/**
 * 
 * @author Mihir Yadav
 * Name: Model class
 * Description: consists of constructor, getColorAt
 * Initializes data structures and creates a random char array
 * of colors
 */
public class MastermindModel {
	
	//private variable(s) to store the answer
	private char[] arr = new char[]{'r','o','y','g','b','p'};
	private StringBuilder b;
	private String s;
	
	
	/**
	 * MastermindModel constructor
	 * @param NONE
	 * @return NONE
	 */
    public MastermindModel() {
    	// creates an array of possible colors
    	b = new StringBuilder(); 
    	// creates random character array
    	for(int i =0;i<4;i++) {
    		int rnd = new Random().nextInt(arr.length);
    		b.append(arr[rnd]);
    	} 
    	s=b.toString();
    }
     

    /**
	 * MastermindModel constructor: Creates a already decided string of size 4
	 * from {'r','o','y','g','b','p'} from user input
	 * @param answer the string that will be initialized
	 * @return NONE
	 */
    public MastermindModel(String answer) {
    	s = answer;
    }

    /**
   	 * getColorAt: gets a character at an index
   	 * @param index to get the color present at given index
   	 * @return char
   	 */
    public char getColorAt(int index) {
    	return s.charAt(index);
    }
    
    /**
   	 * isLegal: checks if a string is legal
   	 * @param String the string which should have legal colors
   	 * @return boolean
   	 */
    public boolean isLegal(String s) {
    	// checking if colors are legal 
        for(int j = 0; j<4; j++) {
            boolean flag = false;
        	for(int k = 0; k<6; k++) {
        		if(s.charAt(j) == arr[k]) {
        			flag = true;
        		}
        	}
    	    if(flag == false)
    	    	return false;
        }
        return true;
    }

}
