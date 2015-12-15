import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Random;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class DiceTest {
	@InjectMocks
	Dice underTest;
	
	@Mock
	Random rand;
	
	@Mock
	DiceParser diceParser;
	
	@Before
	public void setup() {
		initMocks(this);
		setUpDiceParserExpectation();
	}

	private void setUpDiceParserExpectation() {
		when(diceParser.numberOfDice("3d10+2")).thenReturn(3);
		when(diceParser.numberOfSides("3d10+2")).thenReturn(10);
		when(diceParser.modifier("3d10+2")).thenReturn(2);
		when(diceParser.numberOfDice("2d10-3")).thenReturn(2);
		when(diceParser.numberOfSides("2d10-3")).thenReturn(10);
		when(diceParser.modifier("2d10-3")).thenReturn(-3);
	}
	
	@Test
	public void shouldReturnADiceRollOf14() {
		int firstExpectedDieRoll = 4;
		int secondExpectedDieRoll = 6;
		int thirdExpectedDieRoll = 2;
		int modifier = 2;
		when(rand.nextInt(10)).thenReturn(firstExpectedDieRoll - 1, secondExpectedDieRoll - 1, thirdExpectedDieRoll - 1);
		int result = underTest.roll("3d10+2");
		assertThat(result, is(firstExpectedDieRoll + secondExpectedDieRoll + thirdExpectedDieRoll + (3*modifier)));
	}
	
	@Test
	public void shouldSubtractModifier3AndSum2Dice() {
		int firstExpectedDieRoll = 4;
		int secondExpectedDieRoll = 6;
		int modifier = -3;
		when(rand.nextInt(10)).thenReturn(firstExpectedDieRoll - 1, secondExpectedDieRoll - 1);
		int result = underTest.roll("2d10-3");
		assertThat(result, is(firstExpectedDieRoll + secondExpectedDieRoll + (2*modifier)));
	}
	
}
