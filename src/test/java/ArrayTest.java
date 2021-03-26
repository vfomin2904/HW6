import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ArrayTest {

    ArrayChanger arrayChanger;

    @Before
    public void init(){
        arrayChanger = new ArrayChanger();
    }


    @Test
    public void task1Test1(){
        Assert.assertArrayEquals(new Integer[]{5,6},arrayChanger.task1(new Integer[]{1,2,3,4,5,6}));
    }

    @Test
    public void task1Test2(){
        Assert.assertArrayEquals(new Integer[]{},arrayChanger.task1(new Integer[]{1,2,4,4}));
    }

    @Test(expected = RuntimeException.class)
    public void task1Test3(){
        arrayChanger.task1(new Integer[]{1,2,3});
    }
}
