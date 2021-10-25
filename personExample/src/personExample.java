public class personExample {
    //instance variables
    private String name;
    private String email;
    private String phoneNumber;

    //static counter variable
    public static int personCounter = 0;

    public personExample(String initName, String initEmail, String initPhoneNumber){
        name = initName;
        email = initEmail;
        phoneNumber = initPhoneNumber;

        //everytime the constructor is called to create an object the personCounter will update by 1
        personCounter++;
    }

    public static void printPersonCounter(){
        System.out.println("Person counter: " + personCounter);
    }


}
