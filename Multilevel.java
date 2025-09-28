class A {
    int var = 50;
    public A(){
        System.out.println("Class A constructor");
    }
    public void display() {
        System.out.println("Class A display function");
    }
    public static void show() {
        System.out.println("Class A show function");
    }
}
class B extends A {
    int var = 60;
    public B() {
        System.out.println("Class B constructor");
    }
    @Override
    public void display() {
        System.out.println("Class B display function");
    }
    public static void show() {
        System.out.println("Class B show function");
    }
}
public class Multilevel {
    public static void main(String args[]) {
        A obj = new B();
        System.out.println(obj.var);
        obj.display();
        A.show();
        B.show();
    }
}