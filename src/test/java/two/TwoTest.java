package two;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TwoTest {

	@BeforeSuite
	void beforeSuite() {
		System.out.println("Two BeforeSuite");
	}

	@BeforeTest
	void beforeTest() {
		System.out.println("Two BeforeTest");
	}

	@BeforeClass
	void beforeClass() {
		System.out.println("Two BeforeClass");
	}

	@Test
	void method2() {
		System.out.println("Two Test");
	}

	@AfterSuite
	void afterSuite() {
		System.out.println("Two AfterSuite");
	}

	@AfterTest
	void afterTest() {
		System.out.println("Two AfterTest");
	}

	@AfterClass
	void afterClass() {
		System.out.println("Two AfterClass");
	}

}
