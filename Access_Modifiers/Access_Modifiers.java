package Access_Modifiers;

class A {
    private int pri = 1;
    int def = 2;
    protected int pro = 3;
    public int pub = 4;

    public void show() {
        // inside same class, all work
        System.out.println(pri + " " + def + " " + pro + " " + pub);
    }
}
public class Access_Modifiers {
    public static void main(String[] args) {
      A a1 = new A();
      a1.show();}}