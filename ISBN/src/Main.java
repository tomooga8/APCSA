public class Main {

    public static void main(String[] args){
        System.out.println(ISBN("0205080057"));
    }
    //x10 = (1·x1 + 2·x2 + 3·x3 + 4·x4 + 5·x5 + 6·x6 + 7·x7 + 8·x8 + 9·x9) mod 11

    public static boolean ISBN(int isbn){
        int addTogether = 0;
        for (int i = 0; i <= 9; i++){
            addTogether += addTogether % 10;
            isbn /= 10;
        }
        if ((addTogether % 11) ==  )

    }
}
