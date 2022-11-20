package src.tests.testng;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestNGHooksTest {
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
        String actualResult="sth";
        String expectedResult="sth_";
        Assert.assertEquals(actualResult,expectedResult);
        Assert.assertTrue(true,"true");
        Assert.assertFalse(false, "false");
        Assert.fail("Err fail");

        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(actualResult,expectedResult);
        System.out.println("The test is done");
        softAssert.assertAll();
    }
    @Test
    public void testB(){
        System.out.println("\t\t\t\ttestB");
    }
}
