import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import java.util.Random;

public class Dice {
	Random rand = new Random();

	public int roll(String dice) {
		int numberOfDie = numberOfDice(dice);
		int upperBound = upperBound(dice);
		if(numberOfDie == 1) {
			return getRandomNumber(upperBound);
		}
		else {
			return getRandomNumber(upperBound) + roll(oneLessDie(numberOfDie, upperBound));
		}
		
	}

	private int getRandomNumber(int upperBound) {
		return rand.nextInt(upperBound) + 1;
	}

	private String oneLessDie(int numberOfDie, int upperBound) {
		return valueOf(numberOfDie - 1) + "d" + valueOf(upperBound);
	}

	private int upperBound(String dice) {
		int max = parseInt(dice.split("d")[1]);
		return max;
	}

	private int numberOfDice(String dice) {
		int numberOfDie = dice.split("d")[0].length() == 0 ? 1 : parseInt(dice.split("d")[0]);
		return numberOfDie;
	}

}
