package solver;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class CopyOfCopyOfBreadth_First_Search extends AbstractSolver {

	@Override
	public List<Point> solve(int[][] maze, Point start, Point goal) {
		LinkedList<Point> path_T = new LinkedList<Point>();

		LinkedList<Point> visited = new LinkedList<Point>();
		LinkedList<LinkedList<Point>> temp = new LinkedList<LinkedList<Point>>();
		boolean found = false;

		path_T.addFirst(start);
		temp.addFirst(path_T);

		while (!found) {
			LinkedList<Point> path = new LinkedList<Point>();
			path = temp.pollFirst();
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

}
