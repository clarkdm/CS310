package ai;

import java.util.ArrayList;
import java.util.List;

import model.AbstractState.MOVE;
import model.State;
import eval.Evaluator;
import eval.ScoreEvaluator;
import eval.ScoreEvaluator_2;

public class CopyOfRandomAI extends AbstractPlayer {

	private final Evaluator eval = new ScoreEvaluator_2();


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
