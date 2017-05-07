package com.ralf.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StackWithTwoQueuesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		StackWithTwoQueues<Integer> stack = new StackWithTwoQueues<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		Assert.assertEquals(4, stack.size());
		
		Assert.assertEquals(4, stack.pop().intValue());
		Assert.assertEquals(3, stack.pop().intValue());
		stack.push(5);
		
		Assert.assertEquals(3, stack.size());
		
		Assert.assertEquals(5, stack.pop().intValue());
		Assert.assertEquals(2, stack.pop().intValue());
		Assert.assertEquals(1, stack.pop().intValue());
		
		
	}

}
