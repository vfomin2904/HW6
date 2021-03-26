import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ArrayTest2 {

    public static ArrayChanger arrayChanger;

    @BeforeClass
    public static void init(){
        arrayChanger = new ArrayChanger();
    }


    @Test
    public void task2Test1(){
        Assert.assertTrue(arrayChanger.task2(new Integer[]{ 1,1,1,4,4,1,4,4}));
    }
    @Test
    public void task2Test2(){
        Assert.assertFalse(arrayChanger.task2(new Integer[]{ 1,1,1,1,1,1}));
    }

    @Test
    public void task2Test3(){
        Assert.assertFalse(arrayChanger.task2(new Integer[]{ 4,4,4,4,4}));
    }

    @Test
    public void task2Test4(){
        Assert.assertFalse(arrayChanger.task2(new Integer[]{ 1,4,4,1,1,4,3}));
    }
}
