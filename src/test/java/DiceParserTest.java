import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class DiceParserTest {

	private DiceParser underTest;
	
	@Before
	public void setup() {
		underTest = new DiceParser();
	}
	
	@Test
	public void shouldParseNumberOfSides() {
		assertThat(underTest.numberOfSides("d42"), is(42));
	}
	
	@Test
	public void shouldParseNumberOfDice() {
		assertThat(underTest.numberOfDice("2d42"), is(2));
	}
	
	@Test
	public void shouldParsePositiveModifier() {
		assertThat(underTest.modifier("2d42+4"), is(4));
	}

	@Test
	public void shouldParseNegativeModifier() {
		assertThat(underTest.modifier("2d42-3"), is(-3));
	}
}
