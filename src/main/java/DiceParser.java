import static java.lang.Integer.parseInt;
import static java.util.regex.Pattern.compile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DiceParser {
	
	private static final Pattern DICE_REGEX = compile("(?<numberOfDice>\\d*)d(?<numberOfSides>\\d+)(?<modifier>[\\+-]\\d+)?");

	public int numberOfSides(String dice) {
		return parseValue(dice, "numberOfSides");
	}
	
	public int numberOfDice(String dice) {
		return parseValue(dice, "numberOfDice", 1);
	}
	
	public int modifier(String dice) {
		return parseValue(dice, "modifier");
	}
	
	private int parseValue(String dice, String groupName) {
		return parseValue(dice, groupName, 0);
	}

	private int parseValue(String dice, String groupName, int defaultValue) {
		String matched = findMatch(dice, groupName);
		boolean isEmpty = matched == null || matched.equals("");
		return isEmpty ? defaultValue : parseInt(matched);
	}

	private String findMatch(String dice, String groupName) {
		Matcher matcher = performMatch(dice);
		return matcher.group(groupName);
	}

	private Matcher performMatch(String dice) {
		Matcher matcher = DICE_REGEX.matcher(dice);
		matcher.matches();
		return matcher;
	}
}
