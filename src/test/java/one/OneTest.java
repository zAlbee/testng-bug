package one;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OneTest {

	@BeforeSuite
	void beforeSuite() {
		System.out.println("One BeforeSuite");
	}

	@BeforeTest
	void beforeTest() {
		System.out.println("One BeforeTest");
	}

	@BeforeClass
	void beforeClass() {
		System.out.println("One BeforeClass");
	}

	@Test
	void method1() {
		System.out.println("One Test");
	}

	@AfterSuite
	void afterSuite() {
		System.out.println("One AfterSuite");
	}

	@AfterTest
	void afterTest() {
		System.out.println("One AfterTest");
	}

	@AfterClass
	void afterClass() {
		System.out.println("One AfterClass");
	}

}
