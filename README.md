About
=====

This is a minimal test case to show the (IMO buggy) TestNG behaviour where `BeforeTest` and `BeforeSuite` methods always run, even when there are no test methods in either the test or the suite.

This repo defines a single test suite with two `<test>` blocks in the `testng.xml` file. In each `<test>` block, there is one test class, and in each test class, there is one test method.

A MethodInterceptor is defined that filters out test methods depending on the value of system property `filter` which you can specifiy on the command line via

```
mvn test -Dfilter=xyz
```

Requires: Java 17, Apache Maven


Working case (no filtering)
------------

```
mvn test
```
Result (linebreaks added for clarity):

```
One BeforeSuite
Two BeforeSuite

One BeforeTest
One BeforeClass
One Test
One AfterClass
One AfterTest

Two BeforeTest
Two BeforeClass
Two Test
Two AfterClass
Two AfterTest

One AfterSuite
Two AfterSuite
```

As expected, both test methods run, with their respective `BeforeTest/BeforeClass` and `AfterClass/BeforeTest` surrounding them. Also expected is that both `BeforeSuite` and `AfterSuite` run at the very beginning and end.

Broken case (one `<test>` is filtered out)
---

```
mvn test -Dfilter=one
```

Result (linebreaks added for clarity):

```
One BeforeSuite
Two BeforeSuite

One BeforeTest
One BeforeClass
One Test
One AfterClass
One AfterTest

Two BeforeTest
Two AfterTest

One AfterSuite
Two AfterSuite
```

As expected, only `One Test` gets run because of the filter that selects package `one` only.

Unexpectedly, `BeforeTest` and `AfterTest` for `Two` are run despite no test methods inside `<test>` two being run!

I would expect this to behave more like `Before/AfterClass`, which do not run if no methods are being run.

Broken case (all tests are filtered out)
---
```
mvn test -Dfilter=none
```

Result (linebreaks added for clarity):

```
One BeforeSuite
Two BeforeSuite

One BeforeTest
One AfterTest

Two BeforeTest
Two AfterTest

One AfterSuite
Two AfterSuite
```

As expected, no tests run.

Unexpectedly, all `BeforeTest/BeforeSuite` and `AfterTest/AfterSuite` are run despite no test methods in the entire test/suite!