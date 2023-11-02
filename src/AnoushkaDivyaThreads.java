import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.awt.image.*;
import java.util.concurrent.atomic.AtomicInteger;
import javax.imageio.ImageIO;


public class AnoushkaDivyaThreads implements Runnable{
    public static double times;
    //public long count=0;
    public int counter=1;

    public AtomicInteger count = new AtomicInteger(0);
    public static long startTime;
    public static long endTime;

    public static void main(String args[])
    {
        // create an object of Runnable target

        AnoushkaDivyaThreads aa = new AnoushkaDivyaThreads();
        //int count = 0;


        startTime = System.currentTimeMillis();

       // timeBest.start();

        for(int i = 1; i <= 100; i++)
        {

            // pass the runnable reference to Thread
            Thread t = new Thread(aa, "Thread "+i);

            // start the thread
            t.start();

            // get the name of the thread
            //System.out.println(t.getName());

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
                count.addAndGet(1);
            }
            NumberFormat num = NumberFormat.getInstance();
            System.out.println(Thread.currentThread().getName()+":"+ num.format(count));
            writer.close();
            endTime= System.currentTimeMillis();
            counter++;
            if(counter == 100)
            {
                System.out.println("Time Taken is "+(endTime - startTime)/1000+" secs.");
            }

        } catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}