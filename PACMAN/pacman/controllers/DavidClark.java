//	David Clark
//	201240042

package pacman.controllers;



import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

/*
 * Allows a human player to play the game using the arrow key of the keyboard.
 */
public class DavidClark extends Controller<MOVE> {

	public MOVE getMove(Game game, long dueTime) {

		int MIN_DISTANCE = 13;
		int currentNodeIndex = game.getPacmanCurrentNodeIndex();
		GHOST g = null;
		for (GHOST ghost : GHOST.values()) {
			if (game.getGhostEdibleTime(ghost) == 0 && game.getGhostLairTime(ghost) == 0) {
				if (game.getShortestPathDistance(currentNodeIndex,game.getGhostCurrentNodeIndex(ghost)) < MIN_DISTANCE) {
					g = ghost;
				}
			}
		}
		if (g != null) {
			return game.getNextMoveAwayFromTarget(
					game.getPacmanCurrentNodeIndex(),
					game.getGhostCurrentNodeIndex(g), DM.PATH);
		}

		// System.out.println(currentNodeIndex);
				// get all active pills
				int[] activePills = game.getActivePillsIndices();

				// get all active power pills
				int[] activePowerPills = game.getActivePowerPillsIndices();
//				 System.out.println(activePowerPills.length);
		if (game.getNumberOfActivePowerPills() <= 0) {
		
			return game.getNextMoveTowardsTarget(currentNodeIndex, game
					.getClosestNodeIndexFromNodeIndex(currentNodeIndex,
							activePills, DM.PATH), DM.PATH);
		}else {
			
			return game.getNextMoveTowardsTarget(currentNodeIndex, game
					.getClosestNodeIndexFromNodeIndex(currentNodeIndex,
							activePowerPills, DM.PATH), DM.PATH);
		}
		
		
	}

	public int studentID() {
		return 201240042;
	}

	public String studentName() {
		return "David Clark";
	}
}