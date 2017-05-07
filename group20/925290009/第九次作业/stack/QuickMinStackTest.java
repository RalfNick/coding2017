package com.ralf.stack;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class QuickMinStackTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		QuickMinStack stack = new QuickMinStack();
		stack.push(3);
		stack.push(5);
		stack.push(4);
		stack.push(1);
		stack.push(2);

		Assert.assertEquals(1, stack.findMin());
		stack.pop();
		Assert.assertEquals(1, stack.findMin());
		stack.pop();
		Assert.assertEquals(3, stack.findMin());
		
	}

}
