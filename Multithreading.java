public class Multithreading {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]); // Number of threads
        Runnable greeter = () -> System.out.println("Hi mom!");
        
        for (int i = 0; i < n; i++) {
            new Thread(greeter).start();
        }
    }
}
