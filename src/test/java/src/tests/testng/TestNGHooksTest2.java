package src.tests.testng;

import org.testng.annotations.*;

public class TestNGHooksTest2 {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuit");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("\tbeforeTest");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("\t\tbeforeClass");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\t\t\tbeforeMethod");
    }
    @Test
    public void testA(){
        System.out.println("\t\t\t\ttestA");
    }
    @Test
    public void testB(){
        System.out.println("\t\t\t\ttestB");
    }
}
