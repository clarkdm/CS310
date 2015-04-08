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
		
		boolean found = false;

		path_T.addFirst(start);
		temp.addFirst(path_T);

		while (!found) {
			LinkedList<Point> path = new LinkedList<Point>();
			LinkedList<Integer> path_h = new LinkedList<Integer>();
			int next = 0;
			int next_h = 0;
			for (int i = 0; i < path_h.size(); i++) {
				Integer next_path_h = path_h.get(i);
				if (next_h > next_path_h) {
					next = i;
					next_h = next_path_h;

				}

			}

			path = temp.get(next);
			temp.remove(next);

			Point current = path.getLast();
			visited.add(current);

			if (current.equals(goal)) {
				return path;
			}
			

			for (Point neighbour : getNeighbours(current, maze)) {
				if (!path.contains(neighbour) && !visited.contains(neighbour)) {
					

						LinkedList<Point> path_neighbour = new LinkedList<Point>();
						path_neighbour.addAll(path);
						path_neighbour.add(neighbour);
						
						path_h.addLast(((get_h(neighbour, goal))+( path_neighbour.size())));
						temp.addLast(path_neighbour);

					
				}
			}

		}
		return null;
	}

	private int get_h(Point temp, Point goal) {
		int x = (int) (goal.getX() - temp.getX());
		int y = (int) (goal.getY() - temp.getY());
		
//		

		return (int) (x + y);

	}

}
