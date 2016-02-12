package marakanaFundamental;

import java.util.Stack;

public class Calculator {
	Stack<Integer> stack;

	public Calculator() {
		super();
		this.stack = new Stack<>();

	}

	public static void main(String args[]) {
		System.out.println("inside main");
		if (args.length != 1) {
			System.err.println("Usage: calculator <Expr>");
			return;
		}

		String expression = args[0];
		System.out.println(expression);
		int result = new Calculator().calculate(expression);

		System.out.println("Result:" + result);
	}

	public int calculate(String expression) {
		String[] tokens = expression.split(" ");

		for (String token : tokens) {
			if (!handleOperator(token) && !handleNumber(token)) {
				throw new IllegalArgumentException("garbage");
			}
		}
		return stack.pop();

	}

	public boolean handleNumber(String token) {

		try {
			int number = Integer.parseInt(token);
			stack.push(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}

	public boolean handleOperator(String token) {

		int lhs, rhs;
		Operator op;

		switch (token) {
		case "+":
			op=new Add();
			break;
		case "-":
			op=new Subtract();
			break;
		case "/":
			op=new Divide();
			break;
		case "*":
			op=new Subtract();
			break;
		default:
			return false;
		}
		rhs=stack.pop();
		lhs=stack.pop();
		stack.push(op.operate(lhs, rhs));
		System.out.println(stack.peek());
		return true;
	}
}
