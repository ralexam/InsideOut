import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.String.valueOf;

import java.util.Random;

public class Dice {
	private static final String NEGATIVE_SIGN = "-";
	private static final String POSITIVE_SIGN = "+";
	Random rand = new Random();

	public int roll(String dice) {
		int numberOfDie = numberOfDice(dice);
		int upperBound = upperBound(dice);
		int modifier = modifer(dice);
		if (numberOfDie == 1) {
			return randomNumber(upperBound) + modifier;
		} else {
			return randomNumber(upperBound)
					+ roll(oneLessDie(numberOfDie, upperBound, modifier));
		}
	}

	private int randomNumber(int upperBound) {
		return rand.nextInt(upperBound) + 1;
	}

	private String oneLessDie(int numberOfDie, int upperBound, int modifier) {
		if (modifier > 0) {
			return withModifier(numberOfDie, upperBound, modifier, POSITIVE_SIGN);
		} else if (modifier < 0) {
			return withModifier(numberOfDie, upperBound, modifier, NEGATIVE_SIGN);
		}
		return valueOf(numberOfDie - 1) + "d" + valueOf(upperBound);
	}

	private String withModifier(int numberOfDie, int upperBound, int modifier,
			String sign) {
		return valueOf(numberOfDie - 1) + "d" + valueOf(upperBound) + sign
				+ valueOf(abs(modifier));
	}

	private int numberOfDice(String dice) {
		int numberOfDie = dice.split("d")[0].length() == 0 ? 1 : parseInt(dice
				.split("d")[0]);
		return numberOfDie;
	}
	
	private int upperBound(String dice) {
		int upperBoundPosition = 0;
		return determineValueOf(upperBoundPosition, dice);
	}
	
	private int modifer(String dice) {
		int modifierPosition = 1;
		return determineValueOf(modifierPosition, dice);
	}

	private int determineValueOf(int position, String dice) {
		String secondPart = dice.split("d")[1];
		if (secondPart.contains(POSITIVE_SIGN)) {
			return parseInt(secondPart.split("\\+")[position]);
		} else if (secondPart.contains(NEGATIVE_SIGN)) {
			int result = parseInt(secondPart.split("\\-")[position]);
			return position == 0 ? result : -result;
		}
		return position == 0 ? parseInt(secondPart) : 0;
	}
}
