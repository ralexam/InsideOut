import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


public class DiceTest {

	@InjectMocks
	Dice underTest;
	
	@Mock
	Random rand;
	
	@Before
	public void setup() {
		initMocks(this);
	}
	
	@Test
	public void shouldReturnANumberBetween1And6() {
		int firstExpectedDieRoll = 4;
		when(rand.nextInt(6)).thenReturn(firstExpectedDieRoll - 1);
		int result = underTest.roll("d6");
		assertThat(result, is(firstExpectedDieRoll));
	}
	
	@Test
	public void shouldReturnANumberBetween1And3() {
		int firstExpectedDieRoll = 2;
		when(rand.nextInt(3)).thenReturn(firstExpectedDieRoll - 1);
		int result = underTest.roll("d3");
		assertThat(result, is(firstExpectedDieRoll));
	}

	@Test
	public void shouldReturnANumberBetween1And10() {
		int firstExpectedDieRoll = 8;
		when(rand.nextInt(10)).thenReturn(firstExpectedDieRoll - 1);
		int result = underTest.roll("d10");
		assertThat(result, is(firstExpectedDieRoll));
	}
	
	@Test
	public void shouldReturnASumOf2NumbersBetween1And10() {
		int firstExpectedDieRoll = 4;
		int secondExpectedDieRoll = 6;
		when(rand.nextInt(10)).thenReturn(firstExpectedDieRoll - 1, secondExpectedDieRoll - 1);
		int result = underTest.roll("2d10");
		Assert.assertThat(result, is(firstExpectedDieRoll + secondExpectedDieRoll));
		
	}
	
	@Test
	public void shouldReturnASumOf3NumbersBetween1And10() {
		int firstExpectedDieRoll = 4;
		int secondExpectedDieRoll = 6;
		int thirdExpectedDieRoll = 2;
		when(rand.nextInt(10)).thenReturn(firstExpectedDieRoll - 1, secondExpectedDieRoll - 1, thirdExpectedDieRoll - 1);
		int result = underTest.roll("3d10");
		Assert.assertThat(result, is(firstExpectedDieRoll + secondExpectedDieRoll + thirdExpectedDieRoll));
	}

}
