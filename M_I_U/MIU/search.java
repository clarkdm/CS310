package MIU;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		search test = new search();

		String target = "miiiuii";

		System.out.println("breadth First Search");
		System.out.println(test.breadthFirstSearch(target));
		System.out.println();
		System.out.println("breadth First Search Path Checking");
		System.out.println(test.breadthFirstSearch_Path_Checking(target));
		System.out.println();
		System.out.println("Depth lilited");
		System.out.println(test.depthLimitedDFS_Path_Checking(target, 10));
		System.out.println();
		System.out.println("iterative Deepening");
		System.out.println(test.iterativeDeepening(target));
		System.out.println();
		System.out.println("iterative Deepening Path Checking");
		System.out.println(test.iterativeDeepening_Path_Checking(target));

	}

	private MIU miu = new MIU();
	private int d_l_comps = 0;

	public List<String> breadthFirstSearch_Path_Checking(String target) {
		int index = 0;
		String start = "mi";
		boolean find = false;
		List<List<String>> temp = extendPath(start);
		index++;
		List<String> visited = new ArrayList<String>();
		System.out.println("target  =  " + target);
		if (start.equals(target)) {
			visited.add(start);
			find = true;
			System.out.println(start);
		}

		while (!find) {
			// System.out.println(temp.toString());
			if (visited.contains(temp.get(0).get(temp.get(0).size() - 1))) {
				temp.remove(0);
			} else {
				visited.add(temp.get(0).get(temp.get(0).size() - 1));
				if (!temp.get(0).get(temp.get(0).size() - 1).equals(target)) {
					List<String> x = temp.get(0);
					temp.remove(0);
					temp.addAll(temp.size(), extendPath(x));
					index++;
				} else {
					System.out.println("length of the path : "
							+ temp.get(0).size());
					System.out
							.println("the number of times extendPath is called : "
									+ temp.size());
					System.out.println("size of the agenda : " + index);

					find = true;
					return temp.get(0);

				}

			}
		}
		return null;

	}

	public List<String> breadthFirstSearch(String target) {
		int index = 0;
		String start = "mi";
		boolean find = false;
		List<List<String>> temp = extendPath(start);
		index++;
		System.out.println("target  =  " + target);
		if (start.equals(target)) {
			find = true;
			System.out.println(start);
		}

		while (!find) {
			// System.out.println(temp.toString());
			if (!temp.get(0).get(temp.get(0).size() - 1).equals(target)) {
				List<String> x = temp.get(0);
				temp.remove(0);
				temp.addAll(temp.size(), extendPath(x));
				index++;
			} else {
				System.out
						.println("length of the path : " + temp.get(0).size());
				System.out
						.println("the number of times extendPath is called : "
								+ temp.size());
				System.out.println("size of the agenda : " + index);

				find = true;
				return temp.get(0);

			}

		}

		return null;

	}

	public List<List<String>> extendPath(List<String> start) {
		List<List<String>> x = new ArrayList<List<String>>();

		List<String> temp = miu.next_states(start.get(start.size() - 1));
		for (String temp_string : temp) {
			List<String> start_l = new ArrayList<String>(start);
			start_l.add(temp_string);
			x.add(start_l);

		}

		return x;

	}

	public List<List<String>> extendPath(String start) {
		d_l_comps = 0;
		List<List<String>> x = new ArrayList<List<String>>();

		List<String> temp = miu.next_states(start);
		for (String temp_string : temp) {
			List<String> start_l = new ArrayList<String>();
			start_l.add(start);
			start_l.add(temp_string);
			x.add(start_l);
		}

		return x;

	}

	public List<String> depthLimitedDFS(String target, int d) {

		d = d + 2;
		String start = "mi";
		miu = new MIU();
		boolean find = false;

		List<List<String>> temp = extendPath(start);

		// System.out.println("target  =  " + target);
		if (start.equals(target)) {
			find = true;

		}
		d_l_comps++;

		while (!find) {
			// System.out.println(temp.toString());
			if (temp == null) {
				find = true;

			} else {
				if (!(temp.size() == 0)) {

					if (temp.get(0).size() < d) {

						if (!temp.get(0).get(temp.get(0).size() - 1)
								.equals(target)) {
							List<String> x = temp.get(0);
							temp.remove(0);
							temp.addAll(0, extendPath(x));
							d_l_comps++;
						} else {
							find = true;
							System.out.println("length of the path : "
									+ temp.get(0).size());
							System.out
									.println("the number of times extendPath is called : "
											+ d_l_comps);
							System.out.println("size of the agenda : "
									+ temp.size());
							return temp.get(0);

						}
					} else {
						temp.remove(0);
					}
				} else {
					find = true;
				}
			}
		}
		// System.out.println("the number of times extendPath is called : "
		// + comps);
		return null;

	}

	public List<String> iterativeDeepening(String goalString) {

		int index = 0;
		List<String> temp = null;
		while (temp == null) {

			temp = depthLimitedDFS(goalString, index);
			index++;
		}

		return temp;

	}

	public List<String> iterativeDeepening_Path_Checking(String goalString) {
		d_l_comps = 0;
		int index = 0;
		List<String> temp = null;
		while (temp == null) {

			temp = depthLimitedDFS_Path_Checking(goalString, index);
			// System.out.println(index);
			index++;
		}

		return temp;

	}

	public List<String> depthLimitedDFS_Path_Checking(String target, int d) {

		d = d + 2;
		String start = "mi";
		miu = new MIU();
		boolean find = false;

		Stack<List<String>> agenda = new Stack<List<String>>();
		List<String> visited = new ArrayList<String>();
		List<String> path = new LinkedList<String>();
		path.add(start);
		agenda.push(path);
		// System.out.println("target  =  " + target);
		if (start.equals(target)) {
			find = true;

		}
		d_l_comps++;

		while (!agenda.isEmpty()) {
			path = agenda.pop();
			String last = path.get(path.size()-1);
			visited.add(last);
			if(last.equals(target)) {
				System.out.println("length of the path : "+ path.size());
				System.out.println("the number of times extendPath is called : "+ d_l_comps);
				System.out.println("size of the agenda : "+ agenda.size());
				
				
				return path;
			} else {
				if(path.size() < d) {
					List<List<String>> e = extendPath(path);
					d_l_comps++;
					for(List<String> path2 : e) {
						String last2 = path2.get(path2.size()-1);
						if(!visited.contains(last2) && !hasDuplicate(path2, last2)) {
							agenda.push(path2);
						}
					}
				}
			}
			// System.out.println(temp.get(0).size());
			// System.out.println(temp.toString() + d);
//			if (temp == null) {
//				return null;
//
//			} else {
//				if ((temp.size() == 0)) {
//					return null;
//				} else {
//					if (temp.get(0).size() < d) {
//						String valu = temp.get(0).get(temp.get(0).size() - 1);
//						if (visited.contains(valu)) {
//
//							temp.remove(0);
//						} else {
//							// System.out.println(valu+temp.get(0).size());
//
//							visited.add(valu);
//
//							if (!valu.equals(target)) {
//
//								List<String> x = temp.remove(0);
//								temp.addAll(0, extendPath(x));
//								d_l_comps++;
//
//							} else {
//								find = true;
//								System.out.println("length of the path : "
//										+ temp.get(0).size());
//								System.out
//										.println("the number of times extendPath is called : "
//												+ d_l_comps);
//								System.out.println("size of the agenda : "
//										+ temp.size());
//								return temp.get(0);
//
//							}
//
//						}
//					} else {
//
//						temp.remove(0);
//					}
//				}
//			}

		}

		return null;

	}

	private boolean hasDuplicate(List<String> path2, String last2) {
		if (path2.indexOf(last2) < (path2.size()-1)) {
			return true;
		}
		return false;
	}

}