package marakanaFundamental;

import static org.junit.Assert.*;

import java.util.Stack;

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
		Calculator calc=new Calculator();
		boolean result =calc.handleNumber("5");
		assertTrue(result);
		assertEquals(1, calc.stack.size());
		assertEquals(5, (int) calc.stack.peek());
	}

	@Test
	public void handleNumberMustNotHandleGarbage() {
		Calculator calc=new Calculator();
		boolean result = calc.handleNumber("a");
		assertFalse(result);
		assertTrue(calc.stack.isEmpty());
	}

	@Test
	public void handleOperatorMustHandleAddition() {
		Calculator calc=new Calculator();		
		calc.stack.push(5);
		calc.stack.push(10);
		boolean result = calc.handleOperator("+");
		assertTrue(result);
		assertEquals(1, calc.stack.size());
		assertEquals(15, (int) calc.stack.peek());
	}

	@Test
	public void handleOperatorMustNotHandleGarbage() {
		Calculator calc=new Calculator();
		calc.stack.push(5);
		calc.stack.push(10);
		boolean result = calc.handleOperator("a");
		assertFalse(result);
		assertEquals(2, calc.stack.size());
	}

	@Test
	public void onePlusOneMustEqualTwo() {
		// int result=Calculator.calculate("1 1 +");
		Calculator calc=new Calculator();
		assertEquals(2, calc.calculate("1 1 +"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void calculatorMustNotAcceptGarbage(){
		Calculator calc=new Calculator();
		calc.calculate("1 1 1 2 + - + k ");
	}

}
