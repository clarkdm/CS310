//	David Clark
//	201240042
package ai;

import java.util.ArrayList;
import java.util.List;

import model.AbstractState.MOVE;
import model.State;
import eval.Evaluator;


public class DavidClark2048 extends AbstractPlayer {

	private final Evaluator eval = new DavidClarkScoreEvaluator();


	@Override
	public MOVE getMove(State game) {

		pause();

		List<MOVE> bestMoves = new ArrayList<MOVE>();

		double bestScore = Double.NEGATIVE_INFINITY;

		for (MOVE move1 : game.getMoves()) {
			game.move(move1);
			for (MOVE move2 : game.getMoves()) {
				game.move(move2);
				for (MOVE move3 : game.getMoves()) {
					game.move(move3);
					for (MOVE move4 : game.getMoves()) {
						game.move(move4);
						for (MOVE move5 : game.getMoves()) {
							game.move(move5);
							

							double score = eval.evaluate(game);
							game.undo();
							if (score > bestScore) {
								bestMoves.clear();
								bestMoves.add(move1);
								bestScore = score;
							} else if (score == bestScore) {
								bestMoves.add(move1);
							}
						}
						game.undo();
					}
					game.undo();
				}
				game.undo();
			}
			game.undo();
		}
		
		if (bestMoves.size() == 0) {
			return game.getMoves().get(0);
		}else if (bestMoves.toString().contains("UP") && bestMoves.toString().contains("DOWN")) {
			return MOVE.DOWN;
		}else if (bestMoves.toString().contains("RIGHT") && bestMoves.toString().contains("LEFT")) {
			return MOVE.LEFT;
		}

		
		return bestMoves.get(0);
	}

	@Override
	public int studentID() {
		return 201240042;
	}

	@Override
	public String studentName() {
		return "David Clark";
	}

}




 class DavidClarkScoreEvaluator implements Evaluator {

	@Override
	public double evaluate(State state) {
		int score = state.getScore();

		int temp = 0;
		int x = 0;
		int y = 0;

		// 1
		x = 0;
		y = 0;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}else if (temp == state.getHighestTileValue()) {
			score = score + (temp/32);              //getHighestTileValue
		}
		// down
		if (temp == state.getValue(x, y + 1)) {
			// score = score + (temp );
		}
		// right
		if (temp == state.getValue(x + 1, y)) {
			score = score + (temp);
		}
		// //up
		// if (temp == state.getValue(x, y - 1)) {
		// score = score + (temp );
		// }
		// //left
		// if (temp == state.getValue(x - 1, y)) {
		// score = score + (temp );
		// }

		// 2
		x = 1;
		y = 0;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}
		// down
		if (temp == state.getValue(x, y + 1)) {
			score = score + (temp);
		}
		// right
		if (temp == state.getValue(x + 1, y)) {
			score = score + (temp);
		}
		// //up
		// if (temp == state.getValue(x, y - 1)) {
		// score = score + (temp );
		// }
		// left
		if (temp == state.getValue(x - 1, y)) {
			score = score + (temp);
		}

		x = 2;
		y = 0;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}
		// down
		if (temp == state.getValue(x, y + 1)) {
			score = score + (temp);
		}
		// right
		if (temp == state.getValue(x + 1, y)) {
			score = score + (temp);
		}
		// //up
		// if (temp == state.getValue(x, y - 1)) {
		// score = score + (temp );
		// }
		// left
		if (temp == state.getValue(x - 1, y)) {
			score = score + (temp);
		}

		// 3
		x = 3;
		y = 0;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}else if (temp == state.getHighestTileValue()) {
			score = score + (temp/32);              //getHighestTileValue
		}
		// down
		if (temp == state.getValue(x, y + 1)) {
			score = score + (temp);
		}
		// //right
		// if (temp == state.getValue(x + 1, y)) {
		// score = score + (temp );
		// }
		// //up
		// if (temp == state.getValue(x, y - 1)) {
		// score = score + (temp );
		// }
		// left
		if (temp == state.getValue(x - 1, y)) {
			score = score + (temp);
		}

		// 4
		x = 0;
		y = 1;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}
		// down
		if (temp == state.getValue(x, y + 1)) {
			score = score + (temp);
		}
		// right
		if (temp == state.getValue(x + 1, y)) {
			score = score + (temp);
		}
		// up
		if (temp == state.getValue(x, y - 1)) {
			score = score + (temp);
		}
		// //left
		// if (temp == state.getValue(x - 1, y)) {
		// score = score + (temp );
		// }
		x = 0;
		y = 2;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}
		// down
		if (temp == state.getValue(x, y + 1)) {
			score = score + (temp);
		}
		// right
		if (temp == state.getValue(x + 1, y)) {
			score = score + (temp);
		}
		// up
		if (temp == state.getValue(x, y - 1)) {
			score = score + (temp);
		}
		// //left
		// if (temp == state.getValue(x - 1, y)) {
		// score = score + (temp );
		// }

		// 5
		x = 0;
		y = 3;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}else if (temp == state.getHighestTileValue()) {
			score = score + (temp/32);              //getHighestTileValue
		}
		// //down
		// if (temp == state.getValue(x, y + 1)) {
		// score = score + (temp );
		// }
		// right
		if (temp == state.getValue(x + 1, y)) {
			score = score + (temp);
		}
		// up
		if (temp == state.getValue(x, y - 1)) {
			score = score + (temp);
		}
		// //left
		// if (temp == state.getValue(x - 1, y)) {
		// score = score + (temp );
		// }

		// 6
		x = 1;
		y = 3;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}
		// //down
		// if (temp == state.getValue(x, y + 1)) {
		// score = score + (temp );
		// }
		// right
		if (temp == state.getValue(x + 1, y)) {
			score = score + (temp);
		}
		// up
		if (temp == state.getValue(x, y - 1)) {
			score = score + (temp);
		}
		// left
		if (temp == state.getValue(x - 1, y)) {
			score = score + (temp);
		}
		x = 2;
		y = 3;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}
		// //down
		// if (temp == state.getValue(x, y + 1)) {
		// score = score + (temp );
		// }
		// right
		if (temp == state.getValue(x + 1, y)) {
			score = score + (temp);
		}
		// up
		if (temp == state.getValue(x, y - 1)) {
			score = score + (temp);
		}
		// left
		if (temp == state.getValue(x - 1, y)) {
			score = score + (temp);
		}

		// 7
		x = 3;
		y = 3;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}else if (temp == state.getHighestTileValue()) {
			score = score + (temp/32);              //getHighestTileValue
		}
		// //down
		// if (temp == state.getValue(x, y + 1)) {
		// score = score + (temp );
		// }
		// //right
		// if (temp == state.getValue(x + 1, y)) {
		// score = score + (temp );
		// }
		// up
		if (temp == state.getValue(x, y - 1)) {
			score = score + (temp);
		}
		// left
		if (temp == state.getValue(x - 1, y)) {
			score = score + (temp);
		}

		// 8
		x = 3;
		y = 1;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}
		// down
		if (temp == state.getValue(x, y + 1)) {
			score = score + (temp);
		}
		// //right
		// if (temp == state.getValue(x + 1, y)) {
		// score = score + (temp );
		// }
		// up
		if (temp == state.getValue(x, y - 1)) {
			score = score + (temp);
		}
		// left
		if (temp == state.getValue(x - 1, y)) {
			score = score + (temp);
		}
		x = 3;
		y = 2;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}
		// down
		if (temp == state.getValue(x, y + 1)) {
			score = score + (temp);
		}
		// //right
		// if (temp == state.getValue(x + 1, y)) {
		// score = score + (temp );
		// }
		// up
		if (temp == state.getValue(x, y - 1)) {
			score = score + (temp);
		}
		// left
		if (temp == state.getValue(x - 1, y)) {
			score = score + (temp);
		}

		// 9
		x = 1;
		y = 1;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}
		// down
		if (temp == state.getValue(x, y + 1)) {
			score = score + (temp);
		}
		// right
		if (temp == state.getValue(x + 1, y)) {
			score = score + (temp);
		}
		// up
		if (temp == state.getValue(x, y - 1)) {
			score = score + (temp);
		}
		// left
		if (temp == state.getValue(x - 1, y)) {
			score = score + (temp);
		}
		x = 2;
		y = 1;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}
		// down
		if (temp == state.getValue(x, y + 1)) {
			score = score + (temp);
		}
		// right
		if (temp == state.getValue(x + 1, y)) {
			score = score + (temp);
		}
		// up
		if (temp == state.getValue(x, y - 1)) {
			score = score + (temp);
		}
		// left
		if (temp == state.getValue(x - 1, y)) {
			score = score + (temp);
		}
		x = 1;
		y = 2;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}
		// down
		if (temp == state.getValue(x, y + 1)) {
			score = score + (temp);
		}
		// right
		if (temp == state.getValue(x + 1, y)) {
			score = score + (temp);
		}
		// up
		if (temp == state.getValue(x, y - 1)) {
			score = score + (temp);
		}
		// left
		if (temp == state.getValue(x - 1, y)) {
			score = score + (temp);
		}
		x = 2;
		y = 2;
		temp = state.getValue(x, y);
		if (temp == 0) {
			score = score + 17;
			temp = 2;
		}
		// down
		if (temp == state.getValue(x, y + 1)) {
			score = score + (temp);
		}
		// right
		if (temp == state.getValue(x + 1, y)) {
			score = score + (temp);
		}
		// up
		if (temp == state.getValue(x, y - 1)) {
			score = score + (temp);
		}
		// left
		if (temp == state.getValue(x - 1, y)) {
			score = score + (temp);
		}

		return score;
	}

}
