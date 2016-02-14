package marakanaFundamental;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import marakanaFundamental.expressions.Expression;
import marakanaFundamental.expressions.NumberExpression;
import marakanaFundamental.expressions.OperationExpression;

public class Calculator {
	Stack<Expression> stack;
	private static final Map<String, Operator> operators;
	
	static {
		operators=new HashMap<>();
		operators.put("+",Operator.ADD);
		operators.put("-",Operator.SUBTRACT);
		operators.put("*",Operator.MULTIPLY);
		operators.put("/",Operator.DIVIDE);

	}

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
		return parse(expression).getValue();
		
	}
	
	public Expression parse(String expression) {
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
			stack.push(new NumberExpression(number));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}

	public boolean handleOperator(String token) {

		Expression lhs, rhs;
		Operator op=operators.get(token);
		if(op == null)
			return false;

			rhs = stack.pop();
			lhs = stack.pop();
			stack.push(new OperationExpression(lhs, rhs, op));
//			stack.push(operators.get(token).operate(lhs.getValue(), rhs.getValue()));
			System.out.println(stack.peek());
			return true;
		
	
	}
}
