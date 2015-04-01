package solver;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Best_First_Search extends AbstractSolver {

	@Override
	public List<Point> solve(int[][] maze, Point start, Point goal) {
		LinkedList<Point> path_T = new LinkedList<Point>();

		LinkedList<Point> visited = new LinkedList<Point>();
		LinkedList<LinkedList<Point>> temp = new LinkedList<LinkedList<Point>>();
		LinkedList<Integer> temp_s = new LinkedList<Integer>();
		boolean found = false;

		path_T.addFirst(start);
		temp.addFirst(path_T);

		while (!found) {
			LinkedList<Point> path = new LinkedList<Point>();
			int next = 0;
			int next_h = 0;
			for (int i = 0; i < temp.size(); i++) {
				LinkedList<Point> temp_next = temp.get(i);
				int temp_next_h = get_h(temp_next.getLast(), goal);
				temp_next_h = temp_next_h + temp_next.size();
				if (next_h > temp_next_h) {
					next = i;
					next_h = temp_next_h;
					temp_s.addLast(temp_next_h);
				}

			}

			path = temp.get(next);
			temp.remove(next);

			Point current = path.getLast();
			visited.add(current);

			if (current.equals(goal)) {
				return path;
			}
			// System.out.println(current);

			for (Point neighbour : getNeighbours(current, maze)) {
				if (!path.contains(neighbour)) {
					if (!visited.contains(neighbour)) {

						LinkedList<Point> path_neighbour = new LinkedList<Point>();
						path_neighbour.addAll(path);
						path_neighbour.add(neighbour);

						temp.addLast(path_neighbour);

					}
				}
			}

		}
		return null;
	}

	private int get_h(Point temp, Point goal) {
		int x = (int) (goal.getX() - temp.getX());
		int y = (int) (goal.getY() - temp.getY());
		
//		System.out.println(x + " : " + y + " : " + (x + y));

		return (int) (x + y);

	}

}