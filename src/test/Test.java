package test;

public class Test {

	public static void main(String[] args) {

		String first="faisal";
		String second=null;
		if(first.equals(second))
			System.out.println("Equal");
		else
			System.out.println("Not equal");
		
		if(first == second)
			System.out.println("Equal");
		else
			System.out.println("Not equal");

	}

}
