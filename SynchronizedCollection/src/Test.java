/**
 * This file is a part of SynchronizedCollection project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
public class Test {
    public static void main(String[] args) {

        DynamicStringsArray dynamicStringsArray = new DynamicStringsArray ();
        Task task1 = new Task (dynamicStringsArray);
        Task task2 = new Task (dynamicStringsArray);

        Thread thread1 = new Thread (task1);
        // Thread thread2 = new Thread (task2);
        thread1.start ();
        // thread2.start ();
    }
}

