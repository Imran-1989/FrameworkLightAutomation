import org.testng.annotations.*;

public class BasicAnnotationsInTestNG {


     @BeforeSuite //•	@BeforeSuite: It will run only once, before all tests in the suite are executed
    public void test1(){

    }
    @BeforeTest //•	@BeforeTest: This will be executed before the first @Test annotated method.
                    // It can be executed multiple times before the test case.
    public void test2(){

    }
    @BeforeClass  //•	@BeforeClass: This will be executed before first @Test method execution.
                                   // It will be executed one only time throughout the test case.
    public void test3(){

    }
    @BeforeMethod  //•	@BeforeMethod: This will be executed before every @test annotated method.
    public void test4(){

    }
    @Test
    public void test5(){

    }
    @AfterSuite //•	@AfterSuite: A method with this annotation will run once
               // after the execution of all tests in the suite is complete
    public void test6(){

    }
    @AfterTest //•	@AfterTest: A method with this annotation will be executed when all @Test annotated methods
                  // complete the execution of those classes inside the <test> tag in the TestNG.xml file.
    public void test7(){

    }
    @AfterClass  //@AfterClass: This will be executed after all test methods
                               // in the current class have been run
    public void test8(){

    }
    @AfterMethod  //•	@AfterMethod: This will be executed after every @test annotated method.
    public void test9(){

    }

}
