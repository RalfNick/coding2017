package com.ralf.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircleQueueTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		CircleQueue<Integer> queue = new CircleQueue<>();
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		Assert.assertEquals(10, queue.size());
		for (int i = 0; i < 5; i++) {
			Assert.assertEquals(i, queue.deQueue().intValue());
		}
		Assert.assertEquals(5, queue.size());
		//queue.enQueue(0);
		
		for (int i = 0; i < 5; i++) {
			queue.enQueue(i);
		}
		Assert.assertEquals(10, queue.size());
		for (int i = 0; i < 5; i++) {
			Assert.assertEquals(i+5, queue.deQueue().intValue());
		}
		for (int i = 0; i < 5; i++) {
			Assert.assertEquals(i, queue.deQueue().intValue());
		}
		
	}

}
