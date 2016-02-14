package marakanaFundamental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import marakanaFundamental.expressions.Expression;
import marakanaFundamental.expressions.NumberExpression;
import marakanaFundamental.expressions.OperationExpression;

import org.junit.Test;

public class CalculatorTest {

	/*
	 * TODO
	 * 
	 * White-box Testing..!!
	 * 
	 * handleNumber should handle number number:push number and return true
	 * should not handle non-number:do nothing and return false
	 * 
	 * handleOperator should handle operator:pop,op, push and return true should
	 * not handle non-operator:no nothing and return false
	 * 
	 * calculate integration test:result is calculated correctly if you pass
	 * garbage , it should throw an exception
	 */

	/*
	 * Setup
	 * 
	 * do it(perform the operation to test)
	 * 
	 * check that it worked
	 */

	@Test
	public void handleNumberMustHandleNumbers() {
		System.out.println("In handleNumberMustHandleNumbers");
		Calculator calc=new Calculator();
		boolean result =calc.handleNumber("5");
		assertTrue(result);
		assertEquals(1, calc.stack.size());
		assertEquals(new NumberExpression(5),calc.stack.peek());
	}

	@Test
	public void handleNumberMustNotHandleGarbage() {
		System.out.println("In handleNumberMustNotHandleGarbage");

		Calculator calc=new Calculator();
		boolean result = calc.handleNumber("a");
		assertFalse(result);
		assertTrue(calc.stack.isEmpty());
	}

	@Test
	public void handleOperatorMustHandleAddition() {
System.out.println("in handleOperatorMustHandleAddition");
		Calculator calc=new Calculator();		
		calc.stack.push(new NumberExpression(5));
		calc.stack.push(new NumberExpression(10));
		boolean result = calc.handleOperator("+");
		assertTrue(result);
		assertEquals(1, calc.stack.size());
		assertEquals(new OperationExpression(new NumberExpression(5), new NumberExpression(10), Operator.ADD), calc.stack.peek());
	}

	@Test
	public void handleOperatorMustNotHandleGarbage() {
		System.out.println("handleOperatorMustNotHandleGarbage");
		Calculator calc=new Calculator();
		calc.stack.push(new NumberExpression(5));
		calc.stack.push(new NumberExpression(10));
		boolean result = calc.handleOperator("a");
		assertFalse(result);
		assertEquals(2, calc.stack.size());
	}

	@Test
	public void onePlusOneMustEqualTwo() {
		System.out.println("onePlusOneMustEqualTwo");
		// int result=Calculator.calculate("1 1 +");
		Calculator calc=new Calculator();
		assertEquals(2, calc.calculate("1 1 +"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculatorMustNotAcceptGarbage(){
		System.out.println("calculatorMustNotAcceptGarbage");
		Calculator calc=new Calculator();
		calc.calculate("1 1 1 2 + - + k ");
	}
	
	@Test
	public void toStringMustConvertExpressionToInfix(){
		Expression e=new Calculator().parse("1 2 3 + -");
		assertEquals("( 1 - ( 2 + 3 ) )",e.toString());
	}

}
