package MIU;

import java.util.ArrayList;
import java.util.List;

public class search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		search test = new search();
		//System.out.println(test.breadth_first("miiii"));
		//System.out.println(test.breadth_first("mii"));
		//System.out.println(test.breadth_first("miiiiiiii"));
		
		
		System.out.println(test.depthLimited("miiiiiiii", 3));
	}

	private MIU miu = new MIU();

	public List<String> breadth_first(String target) {

		String start = "mi";
		boolean find = false;
		List<List<String>> temp = extendPath(start);

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
				
			} else {
				find = true;
				return temp.get(0);
//				System.out.println(temp.get(0));
			}

		}
		return null;
//		System.out.println(temp.size());

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
	
	
	
	public List<String> depthLimited(String target, int d) {
		int comps = 0;
		d=d+2;
		String start = "mi";
		miu = new MIU();
		boolean find = false;
		boolean not_find = true;
		List<List<String>> temp = extendPath(start);

		System.out.println("target  =  " + target);
		if (start.equals(target)) {
			find = true;
			System.out.println(start);
		}
		comps++;

		while (!find) {
			// System.out.println(temp.toString());
			if (temp == null) {
				find = true;

			} else {
				if (!(temp.size() == 0)) {

					if (temp.get(0).size() < d) {
						comps++;
						if (!temp.get(0).get(temp.get(0).size() - 1)
								.equals(target)) {
							List<String> x = temp.get(0);
							temp.remove(0);
							temp.addAll(0, extendPath(x));

						} else {
							find = true;
							not_find = false;
							return temp.get(0);
							//System.out.println(temp.get(0) + "   comps : "
								//	+ comps);
						}
					} else {
						temp.remove(0);
					}
				} else {
					find = true;
				}
			}
		}
		if (!not_find) {
			System.out.println(temp.get(0).size());
		}
		return null;

	}


	
	
	

}