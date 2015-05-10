//	David Clark
//	201240042

package pacman.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import pacman.game.Game;
import pacman.game.Constants.DM;
import pacman.game.Constants.GHOST;
import pacman.game.Constants.MOVE;

/*
 * Allows a human player to play the game using the arrow key of the keyboard.
 */
public class DavidClark_1 extends Controller<MOVE> {

	public MOVE getMove(Game game, long dueTime) {

		int MIN_DISTANCE = 13;
		int currentNodeIndex = game.getPacmanCurrentNodeIndex();
		List<GHOST> g = new ArrayList<GHOST>();
		for (GHOST ghost : GHOST.values()) {
			if (game.getGhostEdibleTime(ghost) == 0
					&& game.getGhostLairTime(ghost) == 0) {
				if (game.getShortestPathDistance(currentNodeIndex,
						game.getGhostCurrentNodeIndex(ghost)) < MIN_DISTANCE) {
					g.add(ghost);
				}
			}
		}

		MOVE move1 = null;
		MOVE move3 = null;
		MOVE move2;
		if (!g.isEmpty()) {
			double ghostDistance = MIN_DISTANCE;
			GHOST NG = null;
			for (GHOST ghost : g) {
//				 System.out.println(game.getDistance(
//				 game.getPacmanCurrentNodeIndex(),
//				 game.getGhostCurrentNodeIndex(ghost), DM.PATH));
				if (ghostDistance > game.getDistance(
						game.getPacmanCurrentNodeIndex(),
						game.getGhostCurrentNodeIndex(ghost), DM.PATH)) {
					ghostDistance = game.getDistance(
							game.getPacmanCurrentNodeIndex(),
							game.getGhostCurrentNodeIndex(ghost), DM.PATH);
					NG = ghost;
				}

			}
			if (NG != null) {
				if (game.isGhostEdible(NG)) {
					move3 = game.getNextMoveTowardsTarget(
							game.getPacmanCurrentNodeIndex(),
							game.getGhostCurrentNodeIndex(NG), DM.PATH);
				} else {

					 move1 = game.getNextMoveTowardsTarget(
							game.getPacmanCurrentNodeIndex(),
							game.getGhostCurrentNodeIndex(NG), DM.PATH);
				}
			}
		}

		// System.out.println(currentNodeIndex);
		// get all active pills
		int[] activePills = game.getActivePillsIndices();

		// get all active power pills
		int[] activePowerPills = game.getActivePowerPillsIndices();
		// System.out.println(activePowerPills.length);

		
		if (game.getNumberOfActivePowerPills() <= 0) {

			move2 = game.getNextMoveTowardsTarget(currentNodeIndex, game
					.getClosestNodeIndexFromNodeIndex(currentNodeIndex,
							activePills, DM.PATH), DM.PATH);
		} else {

			move2 =  game.getNextMoveTowardsTarget(currentNodeIndex, game
					.getClosestNodeIndexFromNodeIndex(currentNodeIndex,
							activePowerPills, DM.PATH), DM.PATH);

		}
		MOVE[] moves_1 = new MOVE[4];
		moves_1 = game.getPossibleMoves(currentNodeIndex);
			List<MOVE>  moves = new ArrayList<MOVE>();	
		for (int i = 0; i < moves_1.length; i++) {
			moves.add(moves_1[i]);
		}
		moves.remove(moves_1);
		
		if (move2.equals(move1)) {
			moves.remove(move2);
			
			return moves.get(0);
				
			}
		
		return move2;
		
		
	}

	public int studentID() {
		return 201240042;
	}

	public String studentName() {
		return "David Clark";
	}
}