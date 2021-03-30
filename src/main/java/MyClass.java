import Test.AfterSuite;
import Test.BeforeSuite;
import Test.Test;


public class MyClass {

    @BeforeSuite
    public void init(){
        System.out.println("Init MyClass");
    }

    @Test(priority = 4)
    public void test1(){
        System.out.println("test1");
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("test2");
    }

    @Test(priority = 2)
    public void test3(){
        System.out.println("test3");
    }
    @Test(priority = 3)
    public void test4(){
        System.out.println("test4");
    }


    @AfterSuite
    public void end(){
        System.out.println("End test MyClass");
    }
}
