public class Class {
    private int instance1;
    private int instance2;

    public Class(int inst1, int inst2){
        instance1 = inst1;
        instance2 = inst2;
    }

    //static method that could be made outside of the class (runs when called from the class, and passes any value, could be run from another class)
    public static int staticMultiplyValues(int int1, int int2){
        return int1*int2;
    }

    //nonstatic method that has access to instances (this is object specific)
    public int multiplyValues(){
        return instance1*instance2;
    }
    //nonstatic method that has access to instances but takes parameters (this method runs when called from an object but can pass any value)
    public int nonstaticMultiplyValues(int int1, int int2){
        return int1*int2;
    }

    //getter methods

    public int getInstance1() {
        return instance1;
    }
    public int getInstance2() {
        return instance2;
    }
}