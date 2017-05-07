package com.ralf.queue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JosephusTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		
		Assert.assertEquals("[1, 3, 5, 0, 4, 2, 6]", Josephus.execute(7, 2).toString());
	}

}
