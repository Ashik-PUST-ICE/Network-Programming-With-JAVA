class A extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i == 1) {
                Thread. yield();
            }
            System.out.println("\t From thread A: i = " + i);
        }
        System.out.println("Exit from Thread A.");
    }
}

class B extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("\t From thread B: i = " + i);
        }
        System.out.println("Exit from Thread B.");
    }
}

class C extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("\t From thread C: i = " + i);
            if (i == 1) {
                try {
                    sleep(1000); // Sleep for 1 second (1000 milliseconds)
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
        System.out.println("Exit from Thread C.");
    }
}

public class Thread_Methods {
    public static void main(String[] args) {
        A threadA = new A();
        B threadB = new B();
        C threadC = new C();

        System.out.println("Thread A Started :");
        threadA.start();

        System.out.println("Thread B Started :");
        threadB.start();

        System.out.println("Thread C Started :");
        threadC.start();

        System.out.println("End Of Main Thread");
    }
}
