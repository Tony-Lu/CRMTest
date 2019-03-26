package com.crm.qa.testcases;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class retryAnalyzerTest {

	@Test			//(retryAnalyzer = hashMapTest.RetryAnalyzer.class)---> since we created a class "myTransformer"
	public void Test1() {

		Assert.assertEquals(false, true);
	}

	@Test			//(retryAnalyzer = hashMapTest.RetryAnalyzer.class)
	public void Test2() {

		Assert.assertEquals(false, true);
	}
	
	@Test			//(retryAnalyzer = hashMapTest.RetryAnalyzer.class)
	public void Test3() {

		Assert.assertEquals(true, true);
	}
	

}
