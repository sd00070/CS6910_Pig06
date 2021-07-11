package edu.westga.cs6910.pig.tests.strategies.advancedstrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs6910.pig.model.strategies.AdvancedStrategy;

/**
 * Provides unit testing to verify the expected behavior of AdvanceStrategy's
 * rollAgain method.
 * 
 * @author Spencer Dent
 * @version 2021-07-10
 */
public class AdvancedStrategyRollAgain {

	private AdvancedStrategy theStrategy;

	/**
	 * Before each test, creates a AdvancedStrategy object to run the tests on. This
	 * reduces code duplication & guarantees each test gets the same fresh model.
	 * 
	 * @throws Exception - in case something goes wrong in initializing the model
	 *                   object
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.theStrategy = new AdvancedStrategy();
	}

	/**
	 * Test for the first roll of the game by the computer
	 */
	@Test
	public void testShouldReturnTrueAtStartOfGame() {
		boolean result = this.theStrategy.rollAgain(0, 0, 100, 100);
		assertEquals(true, result);
	}

}
