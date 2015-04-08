package eval;

import model.State;

public class ScoreEvaluator_2 implements Evaluator {

	@Override
	public double evaluate(State state) {
		int score = 12;
		// System.out.println(state.getValue(0, 0) + " " + state.getValue(1, 0)
		// + " " + state.getValue(2, 0) + " " + state.getValue(3, 0));
		// System.out.println(state.getValue(0, 1) + " " + state.getValue(1, 1)
		// + " " + state.getValue(2, 1) + " " + state.getValue(3, 1));
		// System.out.println(state.getValue(0, 2) + " " + state.getValue(1, 2)
		// + " " + state.getValue(2, 2) + " " + state.getValue(3, 2));
		// System.out.println(state.getValue(0, 3) + " " + state.getValue(1, 3)
		// + " " + state.getValue(2, 3) + " " + state.getValue(3, 3));
//		 System.out.println(state.toString());
		int x = 3;
		int y = 3;
		for (int xi = 0; xi < x; xi++) {
			for (int yi = 0; yi < y; yi++) {

				int val = 0;
				if (val != 0) {

					if (x > 0) {
						if (state.getValue(x - 1, y) == 2) {
							score = score + 1;
						}
					}
					if (y > 0) {
						if (state.getValue(x, y - 1) == 2) {
							score = score + 1;
						}
					}
					if (x < 3) {
						if (state.getValue(x + 1, y) == 2) {
							score = score + 1;
						}
					}
					if (y < 3) {
						if (state.getValue(x, y + 1) == 2) {
							score = score + 1;

						}

					}

				}

//				if (x > 0) {
//					if (state.getValue(x - 1, y) == val) {
//						score = score-1 + val*2;
//					}
//				}
//				if (y > 0) {
//					if (state.getValue(x, y - 1) == val) {
//						score = score-1 + val*2;
//					}
//				}
//				if (x < 3) {
//					if (state.getValue(x + 1, y) == val) {
//						score = score-1 + val*2;
//					}
//				}
//				if (y < 3) {
//					if (state.getValue(x, y + 1) == val) {
//						score = score-1 + val*2;
//
//					}
//				}

				
				score--;
				
			}
		}
		 System.out.println(score);
		return score;
	}
}
