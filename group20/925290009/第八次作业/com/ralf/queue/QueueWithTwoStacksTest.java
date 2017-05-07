package com.ralf.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueWithTwoStacksTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
		Assert.assertEquals(0, queue.size());
		
		for (int i = 0; i < 5; i++) {
			queue.enQueue(i);
		}
		
		Assert.assertEquals(5, queue.size());
		
		for (int i = 0; i < 3; i++) {
			Assert.assertEquals(i, queue.deQueue().intValue());
		}
		Assert.assertEquals(2, queue.size());
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);
		
		Assert.assertEquals(5, queue.size());
		
		for (int i = 3; i < 8; i++) {
			Assert.assertEquals(i, queue.deQueue().intValue());
		}
		
	}

}
