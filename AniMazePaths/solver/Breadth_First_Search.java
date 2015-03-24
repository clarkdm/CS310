package solver;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Breadth_First_Search extends AbstractSolver {

	@Override
	public List<Point> solve(int[][] maze, Point start, Point goal) {
		LinkedList<Point> path = new LinkedList<Point>();

		LinkedList<LinkedList<Point>> temp = new LinkedList<LinkedList<Point>>();
		boolean found = false;

		path.add(start);
		temp.add(path);

		while (!found) {
			
			path = temp.pollFirst();
			
			
			Point current = path.getLast();
			if (current.equals(goal)) {
				return path;
			}
			System.out.println(current);
//			System.out.println(getNeighbours(current, maze).size() + " 1: "
//					+ temp.size()+getNeighbours(current, maze));
//			
			for (Point neighbour : getNeighbours(current, maze)) {
				
				System.out.println(!path.contains(neighbour) + " " + neighbour);
					if (!path.contains(neighbour)) {
						LinkedList<Point> path_neighbour = path;
						path_neighbour.add(neighbour);
						System.out.println(temp.size());
						temp.addLast(path_neighbour);
						System.out.println(temp.size());
						System.out.println();
					}
				}
			
			
		}
		return null;
	}

}
