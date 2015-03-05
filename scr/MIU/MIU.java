package MIU;

public class MIU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MIU test = new MIU();
		//test.rule_1("miiui");
		//test.rule_2("miii");
		test.rule_3("muiii");
	}

	
	public void next_states() {
		
	}
	 
	
	public String rule_1(String start) {
		StringBuilder next = new StringBuilder(start);
		System.out.println(start);
		if (next.charAt(next.length()-1)=='i') {
			next = next.append("u");
		}
		
		System.out.println(next.toString());
		
		return next.toString();
		
	}
	public String rule_2(String start) {
		StringBuilder next = new StringBuilder(start);
		System.out.println(start);
		next.deleteCharAt(0);
		next = next.append(next);
		next = next.insert(0, 'm');
		System.out.println(next.toString());
		
		return next.toString();
		
	}
	
	public String[] rule_3(String start) {
		
		System.out.println(start);
		
		
		String str = "iii";
		System.out.println(start.indexOf(str));
		StringBuilder loop = new StringBuilder(start);
		
		
		if (start.contains(str)) {
			
		
		while (loop.indexOf(str)>0) {
			StringBuilder next = new StringBuilder(start);
			int x = start.indexOf(str);
			next.replace(x, x+3, "u");
			System.out.println(next.toString());
			loop.replace(x, x+3, "aii");
			
		}
		}
		return null;
		
	}
	
	

	public String rule_4(String start) {
		return null;
		
	}
	
}
