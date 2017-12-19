package com;

import org.junit.Assert;
import org.junit.Test;

public class AdditionTest {
	
	@Test
	public void testAddition() {
		Long a = (long) 5;
		Long b = (long) 7;
		Addition additionner = new Addition();
		Long result = additionner.calculer(a,b);
		Long checksum = a+b;
		Assert.assertEquals(result,checksum);
		
	}
}
