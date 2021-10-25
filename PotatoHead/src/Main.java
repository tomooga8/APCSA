public class Main {
    public static void main(String[] args) {
        //Create objects of the PotatoHead class datatype (like int or a double)
        //Use the "new" keyword to call constructor and initialize the object
        //The order of your attributes MUST correspond to the order of the parameters in your constructor

        PotatoHead nicholas = new PotatoHead("baseball hat", "green", 15);
        PotatoHead rocky = new PotatoHead("helmet", "brown", 17);
        PotatoHead eddie = new PotatoHead("top hat", "blue", 14);

        //overloaded constructor object creation
        PotatoHead jack = new PotatoHead("blond", 65);
        /**
         *You cannot write 2 constructors that have the same number and type of arguments for the same
         * class, because Java would not be able to tell them apart
         *
         * Doing so will cause a compile time error
         */

        //only changing Rocky's age in the print statement
        eddie.setAge(15);
        System.out.println(eddie.getAge());

        //with static methods, you must call it using the class name you created it inm if you are outside of that class
        double ageAverage = PotatoHead.averageTheirAges(nicholas.getAge(), rocky.getAge(), eddie.getAge());
        System.out.println(ageAverage);
        PotatoHead.objectFriends();
    }
}