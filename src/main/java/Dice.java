import java.util.Random;

public class Dice {
	Random random = new Random();
	DiceParser diceParser = new DiceParser();
	
	public int roll(String dice) {
		int numberOfDice = diceParser.numberOfDice(dice);
		int numberOfSides = diceParser.numberOfSides(dice);
		int modifier = diceParser.modifier(dice);
		if(numberOfDice > 1) {
			int total = 0;
			for(int i = 0; i < numberOfDice; i++) {
				total += (randomNumber(numberOfSides) + modifier);
			}
			return total;
		}
		return randomNumber(numberOfSides) + modifier;
	}

	private int randomNumber(int numberOfSides) {
		return random.nextInt(numberOfSides) + 1;
	}

}
