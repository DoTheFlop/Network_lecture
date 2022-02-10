package chap2;

public class chap2_java implements Runnable 
{ 
    private int x; 
    private int y; 

    public static void main(String args[]) 
    {
    	chap2_java that = new chap2_java(); 
        (new Thread(that)).start(); 
        (new Thread(that)).start(); 
    } 
    public synchronized void run() 
    {
        for(int i = 0; i < 10; i++) 
        { 
            x++; 
            y++; 
            System.out.println("x = " + x + ", y = " + y); /* Line 17 */
        } 
    } 
} 