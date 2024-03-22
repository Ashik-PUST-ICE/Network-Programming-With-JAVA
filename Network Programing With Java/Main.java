class MyThread extends Thread {
    private volatile boolean suspended = false;

    public void run() {
        System.out.println(Thread.currentThread().getName() + " started.");

        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                Thread.sleep(1000); // Sleep for 1 second

                // Check if the thread is suspended
                while (suspended) {
                    Thread.sleep(100); // Sleep for a short duration
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }

        System.out.println(Thread.currentThread().getName() + " exiting.");
    }

    // Method to suspend the thread
    public synchronized void suspendThread() {
        suspended = true;
    }

    // Method to resume the thread
    public synchronized void resumeThread() {
        suspended = false;
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        // Suspend the thread after 3 seconds
        try {
            Thread.sleep(3000); // Wait for 3 seconds
            System.out.println("Suspending the thread...");
            thread.suspendThread();

            // Resume the thread after 3 seconds
            Thread.sleep(3000); // Wait for 3 seconds
            System.out.println("Resuming the thread...");
            thread.resumeThread();

            // Stop the thread after 3 seconds
            Thread.sleep(3000); // Wait for 3 seconds
            System.out.println("Stopping the thread...");
            thread.interrupt(); // Interrupt the thread to stop it
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }
}
