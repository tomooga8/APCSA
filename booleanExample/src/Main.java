public class Main {
    public static boolean myTest(){

        boolean test = 3 < 5;
        if (test){
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean otherTest(){
        boolean test = 3 < 5;
        return test;
    }
    public static void main(String[] args){
        System.out.println(myTest());
        System.out.println(otherTest());
    }
}
