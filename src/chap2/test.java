package chap2;

public class test implements Runnable {
	static final StringBuffer sb1 = new StringBuffer(); 
	static final StringBuffer sb2 = new StringBuffer();
	
	public static void main(String args[])
	{
		test that2 = new test(); 
        (new Thread(that2)).start(); 
        (new Thread(that2)).start(); 
	}
	public synchronized void run()
	{
			for(int i = 0; i < 100; i++) 
	        { 
	           sb1.append("b");
	            System.out.println(sb1); /* Line 17 */
	        }
    }
	
}