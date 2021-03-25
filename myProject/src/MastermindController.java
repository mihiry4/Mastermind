import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Mihir Yadav
 * Name: controller class
 * Description: Contains constructor, isCorrect, getRightColorRightPlace, 
 * getRightColorWrongPlace class. Used to create a master mind object and 
 * match the outputs.
 */
public class MastermindController {
	
	private MastermindModel m;
	private int correctPlace;
	private int wrongPlace;
	
	/**
	 * MastermindController: constructor
	 * @param model 
	 * @return NONE
	 */
	public MastermindController(MastermindModel model) {
		m = model;
	}
 
	/**
	 * isCorrect: checks if string is correct
	 * @param guess 
	 * @return boolean
	 * @throws MastermindIllegalLengthException 
	 * @throws MastermindIllegalColorException 
	 */
    public boolean isCorrect(String guess) throws MastermindIllegalColorException, MastermindIllegalLengthException {
    	if(guess.length()>4|| guess.length()<4)
    		throw new MastermindIllegalLengthException(guess);
    	else if(!m.isLegal(guess))
    		throw new MastermindIllegalColorException(guess);
    	for(int i = 0;i<guess.length();i++) {
    		if(m.getColorAt(i) != guess.charAt(i))
    			return false;
    	}
    	return true;
    }

    /**
	 * getRightColorRightPlace: gets number of colors that are at correct
	 * @param guess 
	 * @return int
	 * @throws MastermindIllegalLengthException 
	 * @throws MastermindIllegalColorException 
	 */
    public int getRightColorRightPlace(String guess) throws MastermindIllegalColorException, MastermindIllegalLengthException{ 
    	if(guess.length()>4 || guess.length()<4)
    		throw new MastermindIllegalLengthException(guess);
    	else if(!m.isLegal(guess))
    		throw new MastermindIllegalColorException(guess);
    	correctPlace = 0;
    	for(int i =0;i<guess.length();i++) {
    		if(m.getColorAt(i) == guess.charAt(i))
    			correctPlace++;
    	}
    	return correctPlace;
    }


    /**
	 * getRightColorWrongPlace: gets colors that are correct but at wrong position
	 * @param guess 
	 * @return int
	 * @throws MastermindIllegalLengthException 
	 * @throws MastermindIllegalColorException 
	 */
    public int getRightColorWrongPlace(String guess) throws MastermindIllegalColorException, MastermindIllegalLengthException {
    	if(guess.length()>4 || guess.length()<4) {
    		throw new MastermindIllegalLengthException(guess);
    	} else if(!m.isLegal(guess)) {
    		throw new MastermindIllegalColorException(guess);
    	}
    	wrongPlace = 0;
    	int[] ar1 = new int[256];
    	for(int i = 0;i<4;i++) {
    		int x = m.getColorAt(i);
    		ar1[x]++; 
    	}
    	for(int i = 0;i<guess.length();i++) {
    		if(m.getColorAt(i) == guess.charAt(i) && ar1[guess.charAt(i)]>0) {
    			ar1[guess.charAt(i)]--;
    		}
    		else if(m.getColorAt(i) != guess.charAt(i) && ar1[guess.charAt(i)]>0) {
    			ar1[guess.charAt(i)]--;
    			wrongPlace++;
    		}
    	}	
    	return wrongPlace;
    }


}
