package com.ralf.stack;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TwoStacksInOneArrayTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		TwoStacksInOneArray<Integer> twoStack = new TwoStacksInOneArray<>();
		twoStack.push1(1);
		twoStack.push1(2);
		twoStack.push1(3);
		
		twoStack.push2(4);
		twoStack.push2(5);
		
		Assert.assertEquals(3, twoStack.peek1().intValue());
		Assert.assertEquals(5, twoStack.peek2().intValue());
		
		twoStack.push1(6);
		twoStack.push2(7);
		
		Assert.assertEquals(6, twoStack.peek1().intValue());
		Assert.assertEquals(7, twoStack.peek2().intValue());
		
		Assert.assertEquals(7, twoStack.pop2().intValue());
		Assert.assertEquals(5, twoStack.pop2().intValue());
		Assert.assertEquals(4, twoStack.pop2().intValue());
		Assert.assertEquals(6, twoStack.pop1().intValue());
		Assert.assertEquals(3, twoStack.pop1().intValue());
		Assert.assertEquals(2, twoStack.pop1().intValue());
		Assert.assertEquals(1, twoStack.pop1().intValue());

	}

}
