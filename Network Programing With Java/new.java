class A extends Thread {
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 1; i <= 3; i++) {
            System.out.println(name);
        }
    }

    public void stopThread() {
        interrupt(); // Interrupt the thread
    }

    public static void main(String[] args) throws InterruptedException {
        A t1 = new A();
        A t2 = new A();
        A t3 = new A();
        t1.setName("Raj");
        t2.setName("Gill");
        t3.setName("Sen");
        t1.start();
        t2.start();
        t2.suspend(); // Suspending thread t2
        t3.start();
        t2.resume(); // Resuming thread t2
    }
}
