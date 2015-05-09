package eval;

import model.State;

public class ScoreEvaluator_2 implements Evaluator {

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
