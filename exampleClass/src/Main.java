public class Main {
    public static void main(String[] args){
        Class object = new Class(25, 3);

        //nonstatic method that has access to the objects attributes and returns an int - good example of coding
        int multiply1 = object.multiplyValues();
        //static method that does not have access to instance variables and therefore uses getter methods to pass in those integers - good example of coding
        int multiply2 = Class.staticMultiplyValues(object.getInstance1(), object.getInstance2());

        //does the same thing as the method above ^^ just held in a different class
        int multiply3 = calculate.multiplyValues(object.getInstance1(), object.getInstance1());

        //nonstatic method that already has access to instance variables, however, uses nonstatic getter methods
        // anyways to access those integers again from the object that was called (your way) --> using this
        //method, you could theoretically pass random integer values and still get the same value
        int mupltiply4 = object.nonstaticMultiplyValues(object.getInstance1(), object.getInstance2());


    }
}
