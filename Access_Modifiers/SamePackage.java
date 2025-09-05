package Access_Modifiers;


public class SamePackage {
    public int pub = 1;
    protected int pro = 2;
    int def = 3;         // Could be accessed within same package 
    // private int pri = 4; 
    //won't work In Dif Package neither class nor subclass
}
