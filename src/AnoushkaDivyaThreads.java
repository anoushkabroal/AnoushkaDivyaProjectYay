import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AnoushkaDivyaThreads implements Runnable{
    public static void main(String args[])
    {
        // create an object of Runnable target

        AnoushkaDivyaThreads aa = new AnoushkaDivyaThreads();
        int count = 0;

        for(int i = 1; i <= 100; i++)
        {

            // pass the runnable reference to Thread
            Thread t = new Thread(aa, "Thread "+i);

            // start the thread
            t.start();

            // get the name of the thread
            System.out.println(t.getName());

        }
    }
    @Override public void run()
    {
        //System.out.println("Inside run method for ");
        try
        {
            FileWriter writer = new FileWriter(new File("C:\\Users\\gaurav\\Desktop\\Test",Thread.currentThread().getName()+".txt"));

            for (int j = 1; j <= 1000000; j++)
            {
                writer.write(Thread.currentThread().getName()+":"+j+"\n");
                //System.out.println(Thread.currentThread().getId()+":"+j);
            }
            writer.close();
        } catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}