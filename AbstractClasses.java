// // Abstract class
// abstract class Sunstar {
//     Sunstar(){
//         System.out.println("Inside sunstar constructor");
//     }
//     abstract void printInfo();
// }

// // Abstraction performed using extends
// class Employee extends Sunstar {
//     @Override
//     void printInfo()
//     {
//         String name = "avinash";
//         int age = 21;
//         float salary = 222.2f;

//         System.out.println(name);
//         System.out.println(age);
//         System.out.println(salary);
//     }
// }

// // Base class
// class AbstractClasses {
//     public static void main(String args[])
//     {
//         Sunstar s = new Employee();
//         s.printInfo();
//     }
// } 
// Java Program to implement Abstract Class
// having constructor, data member, and methods
import java.io.*;

abstract class Subject {
    Subject() { 
      System.out.println("Learning Subject"); 
    }
  
      abstract void syllabus();
  
      void Learn(){
          System.out.println("Preparing Right Now!");
    }
}

class IT extends Subject {
  void syllabus(){
    System.out.println("C , Java , C++");
  }
  void Learn(){
          System.out.println("Preparing Now!");
    }
}

public class AbstractClasses {
    public static void main(String[] args) {
        Subject x=new IT();
      
          x.syllabus();
          x.Learn();
    }
}