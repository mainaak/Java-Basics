package javaIntermediate;

public class ImplementingThread implements Runnable {

    private String threadName;
    private Integer threadSleepTime;

    public ImplementingThread(){

    }

    public ImplementingThread(String threadName,Integer threadSleepTime){
        this.threadName = threadName;
        this.threadSleepTime = threadSleepTime;
    }

    public void run() {
        System.out.printf("Thread Name: %s\tSleeping For: %d\n", this.threadName, this.threadSleepTime);
        try {
            Thread.sleep(threadSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread Name: " + threadName + " has woken up after " + threadSleepTime / 1000 + " seconds");
    }

    public void execute(){
        String[] threadName = {"threadOne", "threadTwo", "threadThree", "threadFour"};
        Integer[] threadSleepTime = {10000, 5000, 15000, 1000};
        Integer counter = 0;
        Thread[] threads = new Thread[threadName.length];

        for (String value : threadName) {
            threads[counter] = new Thread(new ImplementingThread(value, threadSleepTime[counter++]));
        }

        for (Thread thread : threads){
            thread.start();
        }
    }
}
