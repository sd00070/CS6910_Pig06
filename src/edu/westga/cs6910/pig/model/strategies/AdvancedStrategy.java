package edu.westga.cs6910.pig.model.strategies;

/**
 * This pig game-play strategy causes the player that uses it to roll if: the
 * game has just begun, the player's opponent is within 7 points of winning, it
 * requires more rolls than its opponent to win, or it has the same number of
 * rolls remaining as its opponent and the number of rolls is less than or equal
 * to 7. It holds if either player has reached the goal or it needs fewer rolls
 * that its opponent to win (the "opponent within 7 points" rule overrides the
 * "fewer rolls" rule).
 * 
 * (it always rolls at least once on it's turn as long as the game is not over)
 * 
 * @author Spencer Dent
 * @version 2021-07-10
 */
public class AdvancedStrategy implements PigStrategy {

	/**
	 * Using the parameters passed in, decides whether the player should roll again.
	 * 
	 * @param numberOfRollsSoFar   - the number of rolls made this turn
	 * @param pointsSoFarThisTurn  - the number of points currently scored by the
	 *                             player this round
	 * @param pointsToGoal         - how many more points the player needs until
	 *                             they have reached the goal for the game
	 * @param opponentPointsToGoal - how close the other player is to reaching the
	 *                             goal
	 */
	@Override
	public boolean rollAgain(int numberOfRollsSoFar, int pointsSoFarThisTurn, int pointsToGoal,
			int opponentPointsToGoal) {

		if (pointsToGoal == 0) {
			return false;
		}

		if (pointsToGoal < 0) {
			return false;
		}

		if (opponentPointsToGoal == 0) {
			return false;
		}

		if (opponentPointsToGoal < 0) {
			return false;
		}

		if (numberOfRollsSoFar == 0) {
			return true;
		}

		final int AVERAGE_ROLL = 7;

		if (((pointsToGoal + 6) / AVERAGE_ROLL) < ((opponentPointsToGoal + 6) / AVERAGE_ROLL)) {
			return false;
		}

		if ((((pointsToGoal + 6) / AVERAGE_ROLL) == ((opponentPointsToGoal + 6) / AVERAGE_ROLL))
				&& (((pointsToGoal + 6) / AVERAGE_ROLL) > 7)) {
			return false;
		}

		return true;
	}

}
