package edu.westga.cs6910.pig.model.strategies;

/**
 * This pig game-play strategy causes the player that uses it to roll if: the
 * game has just begun, the player's opponent is within 7 points of winning, it
 * requires more rolls than its opponent to win, or it has the same number of
 * whole rolls remaining as its opponent and the players' current turn roll
 * average is less than 7. It holds if either player has reached the goal, it
 * needs fewer rolls that its opponent to win (the "opponent within 7 points"
 * rule overrides the "fewer rolls" rule), or the tied current-turn, whole-roll
 * average is greater than or equal to 7.
 * 
 * (it always rolls at least once on it's turn as long as the game is not over)
 * 
 * @author Spencer Dent
 * @version 2021-07-10
 */
public class AdvancedStrategy implements PigStrategy {

	/**
	 * Returns whether either player has reached or passed the goal score.
	 * 
	 * @param pointsToGoal         - how many more points the player needs until
	 *                             they have reach the goal of the game
	 * @param opponentPointsToGoal - how close the other player is to reaching the
	 *                             goal
	 * @return whether or not either player has won the game
	 */
	private boolean eitherPlayerHasWon(int pointsToGoal, int opponentPointsToGoal) {
		return pointsToGoal <= 0 || opponentPointsToGoal <= 0;
	}

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

		if (this.eitherPlayerHasWon(pointsToGoal, opponentPointsToGoal)) {
			return false;
		}

		if (numberOfRollsSoFar == 0) {
			return true;
		}

		final double TYPICAL_DICE_ROLL = 7.0;

		final int WHOLE_ROLLS_LEFT = (int) Math.ceil(((double) pointsToGoal) / TYPICAL_DICE_ROLL);
		final int OPPONENT_WHOLE_ROLLS_LEFT = (int) Math.ceil(((double) opponentPointsToGoal) / TYPICAL_DICE_ROLL);

		if (WHOLE_ROLLS_LEFT < OPPONENT_WHOLE_ROLLS_LEFT) {
			return false;
		}

		final double CURRENT_TURN_AVERAGE = (double) pointsSoFarThisTurn / (double) numberOfRollsSoFar;

		if (WHOLE_ROLLS_LEFT == OPPONENT_WHOLE_ROLLS_LEFT && CURRENT_TURN_AVERAGE >= 7.0) {
			return false;
		}

		return true;
	}

}
