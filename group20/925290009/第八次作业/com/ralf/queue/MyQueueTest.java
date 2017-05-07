package com.ralf.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		MyQueue<Integer> queue = new MyQueue<>();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		
		Assert.assertEquals(4, queue.size());
		for (int i = 1; i <= 4; i++) {
			Assert.assertEquals(i, queue.deQueue().intValue());
		}
	}

}
