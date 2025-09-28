public class FizzBuzzThreads {

    public static class FizzBuzz {
        private int n;
        private int current = 1;
        private final Object lock = new Object();

        public FizzBuzz(int n) {
            this.n = n;
        }

        public void fizz(PrintRunnable printFizz) throws InterruptedException {
            synchronized (lock) {
                while (current <= n) {
                    if (current % 3 == 0 && current % 5 != 0) {
                        printFizz.run();
                        System.out.println(); // Ensure newline after output
                        current++;
                        lock.notifyAll();
                    } else {
                        lock.wait();
                    }
                }
            }
        }

        public void buzz(PrintRunnable printBuzz) throws InterruptedException {
            synchronized (lock) {
                while (current <= n) {
                    if (current % 5 == 0 && current % 3 != 0) {
                        printBuzz.run();
                        System.out.println(); // Ensure newline after output
                        current++;
                        lock.notifyAll();
                    } else {
                        lock.wait();
                    }
                }
            }
        }

        public void fizzbuzz(PrintRunnable printFizzBuzz) throws InterruptedException {
            synchronized (lock) {
                while (current <= n) {
                    if (current % 3 == 0 && current % 5 == 0) {
                        printFizzBuzz.run();
                        System.out.println(); // Ensure newline after output
                        current++;
                        lock.notifyAll();
                    } else {
                        lock.wait();
                    }
                }
            }
        }

        public void number(PrintNumberRunnable printNumber) throws InterruptedException {
            synchronized (lock) {
                while (current <= n) {
                    if (current % 3 != 0 && current % 5 != 0) {
                        printNumber.run(current); // Pass current number to print
                        System.out.println(); // Ensure newline after output
                        current++;
                        lock.notifyAll();
                    } else {
                        lock.wait();
                    }
                }
            }
        }
    }

    // Interface for printing Fizz, Buzz, and FizzBuzz
    public interface PrintRunnable {
        void run();
    }

    // Interface for printing numbers
    public interface PrintNumberRunnable {
        void run(int number);
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 15;
        FizzBuzz fizzBuzz = new FizzBuzz(n);

        Thread threadA = new Thread(new FizzTask(fizzBuzz));
        Thread threadB = new Thread(new BuzzTask(fizzBuzz));
        Thread threadC = new Thread(new FizzBuzzTask(fizzBuzz));
        Thread threadD = new Thread(new NumberTask(fizzBuzz));

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        threadA.join();
        threadB.join();
        threadC.join();
        threadD.join();

        System.out.println("End of Program");
    }

    // Runnable classes for different tasks
    static class FizzTask implements Runnable {
        private FizzBuzz fizzBuzz;

        public FizzTask(FizzBuzz fizzBuzz) {
            this.fizzBuzz = fizzBuzz;
        }

        public void run() {
            try {
                fizzBuzz.fizz(new PrintRunnable() {
                    public void run() {
                        System.out.print("Fizz");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class BuzzTask implements Runnable {
        private FizzBuzz fizzBuzz;

        public BuzzTask(FizzBuzz fizzBuzz) {
            this.fizzBuzz = fizzBuzz;
        }

        public void run() {
            try {
                fizzBuzz.buzz(new PrintRunnable() {
                    public void run() {
                        System.out.print("Buzz");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class FizzBuzzTask implements Runnable {
        private FizzBuzz fizzBuzz;

        public FizzBuzzTask(FizzBuzz fizzBuzz) {
            this.fizzBuzz = fizzBuzz;
        }

        public void run() {
            try {
                fizzBuzz.fizzbuzz(new PrintRunnable() {
                    public void run() {
                        System.out.print("FizzBuzz");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class NumberTask implements Runnable {
        private FizzBuzz fizzBuzz;

        public NumberTask(FizzBuzz fizzBuzz) {
            this.fizzBuzz = fizzBuzz;
        }

        public void run() {
            try {
                fizzBuzz.number(new PrintNumberRunnable() {
                    public void run(int number) {
                        System.out.print(number);
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}