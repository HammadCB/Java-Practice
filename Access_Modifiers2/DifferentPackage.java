package Access_Modifiers2;
import Access_Modifiers.SamePackage;

public class DifferentPackage extends SamePackage {
    void show() {
        System.out.println(pub); 
        System.out.println(pro); 
        // System.out.println(def); Won't work 
        // System.out.println(pri); 
    }
}