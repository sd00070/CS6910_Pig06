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

	/**
	 * Test for when computer rolls after human scores no points at game start
	 */
	@Test
	public void testShouldReturnTrueAtStartOfGameAfterHumanPlayerHasGoneWithNoPoints() {
		boolean result = this.theStrategy.rollAgain(0, 0, 100, 100);
		assertEquals(true, result);
	}

	/**
	 * Test for when computer rolls after human scores some points at game start
	 */
	@Test
	public void testShouldReturnTrueAtStartOfGameAfterHumanPlayerHasGoneWithSomePoints() {
		boolean result = this.theStrategy.rollAgain(0, 0, 100, 93);
		assertEquals(true, result);
	}

	/**
	 * Test for when computer has exactly the goal score
	 */
	@Test
	public void testShouldReturnFalseWhenComputerPlayerHasExactlyTheGoalScore() {
		boolean result = this.theStrategy.rollAgain(0, 0, 0, 100);
		assertEquals(false, result);
	}

	/**
	 * Test for when the computer has more that the goal score
	 */
	@Test
	public void testShouldReturnFalseWhenComputerPlayerHasMoreThanTheGoalScore() {
		boolean result = this.theStrategy.rollAgain(0, 0, -4, 100);
		assertEquals(false, result);
	}

	/**
	 * Test for when the human has exactly the goal score
	 */
	@Test
	public void testShouldReturnFalseWhenHumanPlayerHasExactlyTheGoalScore() {
		boolean result = this.theStrategy.rollAgain(0, 0, 100, 0);
		assertEquals(false, result);
	}

	/**
	 * Test for when the human has more that the goal score
	 */
	@Test
	public void testShouldReturnFalseWhenHumanPlayerHasMoreThanTheGoalScore() {
		boolean result = this.theStrategy.rollAgain(0, 0, 100, -4);
		assertEquals(false, result);
	}

	/**
	 * Test for when the human is exactly 7 points away from the goal
	 */
	@Test
	public void testShouldReturnTrueWhenHumanPlayerIsExactly7PointsAwayFromTheGoal() {
		boolean result = this.theStrategy.rollAgain(0, 0, 100, 7);
		assertEquals(true, result);
	}

	/**
	 * Test for when the human is less the 7 points away from the goal
	 */
	@Test
	public void testShouldReturnTrueWhenHumanPlayerIsLessThan7PoinstAwayFromTheGoal() {
		boolean result = this.theStrategy.rollAgain(0, 0, 100, 3);
		assertEquals(true, result);
	}

	/**
	 * Test for when the computer needs to make fewer rolls than the human to win
	 */
	@Test
	public void testShouldReturnFalseWhenComputerPlayerNeedsFewerNumberOfRollsToWin() {
		boolean result = this.theStrategy.rollAgain(0, 0, 92, 100);
		assertEquals(false, result);
	}
}
