import java.util.ArrayList;
import java.util.Arrays;

public class ArrayChanger {
    public Integer[] task1(Integer[] mas){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(mas));
        int lastIndex = list.lastIndexOf(4);

        if(lastIndex<0){
            throw new RuntimeException();
        }

        return list.subList(lastIndex+1, list.size()).toArray(new Integer[0]);
    }

    public boolean task2(Integer[] mas){
        boolean one = false;
        boolean four = false;
        for (Integer item: mas) {
            if(item == 1){
                one = true;
            }else if(item == 4){
                four = true;
            } else{
                return false;
            }
        }
        return (one && four);
    }
}
