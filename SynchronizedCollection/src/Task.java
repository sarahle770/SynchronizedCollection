import java.util.Arrays;

/**
 * This file is a part of SynchronizedCollection project.
 *
 * @author Sarah Cynamon
 * @version 1.0.0
 */
public class Task implements Runnable {
    private DynamicStringsArray dynamicStringsArray;

    public Task(DynamicStringsArray dynamicStringsArray) {
        this.dynamicStringsArray = dynamicStringsArray;
    }

    @Override
    public void run() {
        Runnable target;
        String[] dynamicStringsArrays = { "January", "February", "March", "April" };
        System.out.println (Arrays.toString (dynamicStringsArrays));
        String[] copy;
        System.out.println (Arrays.toString (dynamicStringsArrays));
dynamicStringsArrays.size
        try {
            System.out.println (dynamicStringsArrays[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println ("An Error occurred " + e.getMessage ());
        }
        try {
           add.  ("May");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println ("An Error occurred " + e.getMessage ());
        }
        }


    }
