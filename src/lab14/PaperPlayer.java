package lab14;

import java.util.Random;

public class PaperPlayer extends Player {

	public PaperPlayer(String name) {
		super(name);
	}
	
	@Override
	public Roshambo generateRoshambo() {		
		int random = randInt(3);
		if(random == 0) {
			return Roshambo.ROCK;
		}
		else if(random == 1) {
			return Roshambo.PAPER;
		}
		else {
			return Roshambo.SCISSORS;
		}
	}

	public static int randInt(int max) {
	    int rand = new Random().nextInt(max);
	    return rand;
	   
	}
	
	
}