package MIU;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MIU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MIU test = new MIU();
		System.out.println(test.next_states("miii").toString());
		


		
		
	}
	public List<String> next_states(String str) {
		List<String> list = new ArrayList<String>();
		list.addAll(rule_1(str));
		list.addAll(rule_2(str));
		list.addAll(rule_3(str));
		list.addAll(rule_4(str));
		return list;
		
	}

	public List<String> rule_1(String start) {
		List<String> list = new ArrayList<String>();
		StringBuilder next = new StringBuilder(start);
		//System.out.println(start);
		if (next.charAt(next.length() - 1) == 'i') {
			next = next.append("u");
		}

		//System.out.println(next.toString());
list.add(next.toString());
		return list;

	}

	public List<String> rule_2(String start) {
		List<String> list = new ArrayList<String>();
		StringBuilder next = new StringBuilder(start);
		//System.out.println(start);
		next.deleteCharAt(0);
		next = next.append(next);
		next = next.insert(0, 'm');
	//	System.out.println(next.toString());
		list.add(next.toString());
		return list;

	}

	public List<String> rule_3(String start) {
		List<String> list = new ArrayList<String>();
		String str = "iii";
		StringBuilder start_b = new StringBuilder(start);

		if (start_b.toString().contains(str)) {
			while (start_b.toString().indexOf(str) < start_b.length() - 2

			&& start_b.toString().indexOf(str) != -1) {
				StringBuilder next = new StringBuilder(start_b);
				int x = start_b.indexOf(str);
				if (x >= 0) {
					next.replace(x, x + 3, "u");
					next.toString().replace('a', 'i');
					start_b.replace(x, x + 3, "aii");
					String temp = next.toString().replace('a', 'i');
					list.add(temp);
					// list.addAll(rule_3(temp));
				}

			}
		}

		return list;
	}

	public List<String> rule_4(String start) {
		List<String> list = new ArrayList<String>();
		String str = "uu";
		StringBuilder start_b = new StringBuilder(start);

		if (start_b.toString().contains(str)) {
			while (start_b.toString().indexOf(str) < start_b.length() - 1

			&& start_b.toString().indexOf(str) != -1) {
				StringBuilder next = new StringBuilder(start_b);
				int x = start_b.indexOf(str);
				if (x >= 0) {
					next.replace(x, x + 2, "");
					next.toString().replace('a', 'u');
					start_b.replace(x, x + 2, "au");
					String temp = next.toString().replace('a', 'u');
					list.add(temp);
					
				}

			}
		}
		List<String> list_2 = new ArrayList<String>();
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			if (!list_2.contains(string)) {
				list_2.add(string);
			}
		}
		return list_2;

	}

}
