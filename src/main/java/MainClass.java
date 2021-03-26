public class MainClass {
    public static void main(String[] args) {
        ArrayChanger arrayChanger =  new ArrayChanger();
        Integer[] mas = arrayChanger.task1(new Integer[]{1,2,3,4,5,6});
        for(Integer item : mas){
            System.out.println(item);
        }
    }
}
