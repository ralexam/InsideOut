import java.util.Random;

public class Dice {
	Random random = new Random();
	DiceParser diceParser = new DiceParser();
	private int minimumValue = 0;

	public int roll(String dice) {
		int numberOfDice = diceParser.numberOfDice(dice);
		int numberOfSides = diceParser.numberOfSides(dice);
		int modifier = diceParser.modifier(dice);
		int total = 0;
		for (int i = 0; i < numberOfDice; i++) {
			total += randomNumber(numberOfSides);
		}
		int sum = total + modifier;
		return sum > minimumValue ? sum : minimumValue;
	}

	private int randomNumber(int numberOfSides) {
		return random.nextInt(numberOfSides) + 1;
	}

}
