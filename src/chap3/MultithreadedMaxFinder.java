package chap3;
import java.util.concurrent.*;

public class MultithreadedMaxFinder {
	public static int max(int[] data, int numberOfThread) throws InterruptedException, ExecutionException {
		if (data.length == 1) {
			return data[0];
		}
		else if (data.length == 0) {
			throw new IllegalArgumentException();
		}
		if(numberOfThread == 2) {
			// split the job into 2 pieces
			FindMaxTask task1 = new FindMaxTask(data, 0, data.length/2);
			FindMaxTask task2 = new FindMaxTask(data, data.length/2, data.length);
			// spawn 2 threads
			ExecutorService service = Executors.newFixedThreadPool(2);
			Future<Integer> future1 = service.submit(task1);
			Future<Integer> future2 = service.submit(task2);
			return Math.max(future1.get(), future2.get());
		}
		else if(numberOfThread == 1) {
			FindMaxTask task1 = new FindMaxTask(data, 0, data.length);
			ExecutorService service = Executors.newFixedThreadPool(1);
			Future<Integer> future1 = service.submit(task1);
			return future1.get();
		}
		else if(numberOfThread == 4) {
			FindMaxTask task1 = new FindMaxTask(data, 0, data.length/4);
			FindMaxTask task2 = new FindMaxTask(data, data.length/4, 2*(data.length/4));
			FindMaxTask task3 = new FindMaxTask(data, 2*(data.length/4), 3*(data.length/4));
			FindMaxTask task4 = new FindMaxTask(data, 3*(data.length/4), data.length);
			
			ExecutorService service = Executors.newFixedThreadPool(4);
			Future<Integer> future1 = service.submit(task1);
			Future<Integer> future2 = service.submit(task2);
			Future<Integer> future3 = service.submit(task3);
			Future<Integer> future4 = service.submit(task4);
			return Math.max(Math.max(future1.get(), future2.get()),Math.max(future3.get(), future4.get()));
		}
		else if(numberOfThread == 8) {
			FindMaxTask task1 = new FindMaxTask(data, 0, data.length/8);
			FindMaxTask task2 = new FindMaxTask(data, data.length/8, 2*(data.length/8));
			FindMaxTask task3 = new FindMaxTask(data, 2*(data.length/8), 3*(data.length/8));
			FindMaxTask task4 = new FindMaxTask(data, 3*(data.length/8), 4*(data.length/8));
			FindMaxTask task5 = new FindMaxTask(data, 4*(data.length/8), 5*(data.length/8));
			FindMaxTask task6 = new FindMaxTask(data, 5*(data.length/8), 6*(data.length/8));
			FindMaxTask task7 = new FindMaxTask(data, 6*(data.length/8), 7*(data.length/8));
			FindMaxTask task8 = new FindMaxTask(data, 7*(data.length/8), data.length);
			
			
			ExecutorService service = Executors.newFixedThreadPool(8);
			Future<Integer> future1 = service.submit(task1);
			Future<Integer> future2 = service.submit(task2);
			Future<Integer> future3 = service.submit(task3);
			Future<Integer> future4 = service.submit(task4);
			Future<Integer> future5 = service.submit(task5);
			Future<Integer> future6 = service.submit(task6);
			Future<Integer> future7 = service.submit(task7);
			Future<Integer> future8 = service.submit(task8);
			
			return Math.max(Math.max(Math.max(future1.get(), future2.get()), Math.max(future3.get(), future4.get())),
					Math.max(Math.max(future5.get(), future6.get()), Math.max(future7.get(), future8.get())));
		}
		else if(numberOfThread == 16) {
			FindMaxTask task1 = new FindMaxTask(data, 0, data.length/8);
			FindMaxTask task2 = new FindMaxTask(data, data.length/8, 2*(data.length/16));
			FindMaxTask task3 = new FindMaxTask(data, 2*(data.length/16), 3*(data.length/16));
			FindMaxTask task4 = new FindMaxTask(data, 3*(data.length/16), 4*(data.length/16));
			FindMaxTask task5 = new FindMaxTask(data, 4*(data.length/16), 5*(data.length/16));
			FindMaxTask task6 = new FindMaxTask(data, 5*(data.length/16), 6*(data.length/16));
			FindMaxTask task7 = new FindMaxTask(data, 6*(data.length/16), 7*(data.length/16));
			FindMaxTask task8 = new FindMaxTask(data, 7*(data.length/16), 8*(data.length/16));
			FindMaxTask task9 = new FindMaxTask(data, 8*(data.length/16), 9*(data.length/16));
			FindMaxTask task10= new FindMaxTask(data, 9*(data.length/16), 10*(data.length/16));
			FindMaxTask task11= new FindMaxTask(data, 10*(data.length/16), 11*(data.length/16));
			FindMaxTask task12= new FindMaxTask(data, 11*(data.length/16), 12*(data.length/16));
			FindMaxTask task13= new FindMaxTask(data, 12*(data.length/16), 13*(data.length/16));
			FindMaxTask task14= new FindMaxTask(data, 13*(data.length/16), 14*(data.length/16));
			FindMaxTask task15= new FindMaxTask(data, 14*(data.length/16), 15*(data.length/16));
			FindMaxTask task16= new FindMaxTask(data, 15*(data.length/16), data.length);
			
			ExecutorService service = Executors.newFixedThreadPool(16);
			Future<Integer> future1 = service.submit(task1);
			Future<Integer> future2 = service.submit(task2);
			Future<Integer> future3 = service.submit(task3);
			Future<Integer> future4 = service.submit(task4);
			Future<Integer> future5 = service.submit(task5);
			Future<Integer> future6 = service.submit(task6);
			Future<Integer> future7 = service.submit(task7);
			Future<Integer> future8 = service.submit(task8);
			Future<Integer> future9 = service.submit(task9);
			Future<Integer> future10= service.submit(task10);
			Future<Integer> future11= service.submit(task11);
			Future<Integer> future12= service.submit(task12);
			Future<Integer> future13= service.submit(task13);
			Future<Integer> future14= service.submit(task14);
			Future<Integer> future15= service.submit(task15);
			Future<Integer> future16= service.submit(task16);
			Math.max(Math.max(Math.max(Math.max(future1.get(), future2.get()), Math.max(future3.get(), future4.get())),
					Math.max(Math.max(future5.get(), future6.get()), Math.max(future7.get(), future8.get()))),
					Math.max(Math.max(Math.max(future9.get(), future10.get()), Math.max(future11.get(), future12.get())),
							Math.max(Math.max(future13.get(), future14.get()), Math.max(future15.get(), future16.get()))));
			
			return Math.max(Math.max(Math.max(Math.max(future1.get(), future2.get()), Math.max(future3.get(), future4.get())),
					Math.max(Math.max(future5.get(), future6.get()), Math.max(future7.get(), future8.get()))),
					Math.max(Math.max(Math.max(future9.get(), future10.get()), Math.max(future11.get(), future12.get())),
							Math.max(Math.max(future13.get(), future14.get()), Math.max(future15.get(), future16.get()))));
		}
		else
			return 0;
	}
	
	public static void main(String args[]) {
		int [] samples = new int[100000000];
		
		int threadNumber = 1;
		for (int i = 0; i < 100000000; i++) {
			samples[i] = (int) (Math.random() * Integer.MAX_VALUE - 1);
		}
		
		int maxReturn;

		long startTime = System.nanoTime();
		try {
			maxReturn = max(samples, 1);
			System.out.println("One thread Max: = " + maxReturn);
		}
		catch(Exception e) {}
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println(threadNumber + " thread Time: " + elapsedTime);
		
		threadNumber = 2;
		startTime = System.nanoTime();
		try {
			maxReturn = max(samples, 2);
			System.out.println("Two thread Max: = " + maxReturn);
		}
		catch(Exception e){}
		elapsedTime = System.nanoTime() - startTime;
		System.out.println(threadNumber + " thread Time: " + elapsedTime);
		
		threadNumber = 4;
		startTime = System.nanoTime();
		try {
			maxReturn = max(samples, 4);
			System.out.println("Four thread Max: = " + maxReturn);
		}
		catch(Exception e){}
		elapsedTime = System.nanoTime() - startTime;
		System.out.println(threadNumber + " thread Time: " + elapsedTime);
		
		threadNumber = 8;
		startTime = System.nanoTime();
		try {
			maxReturn = max(samples, 8);
			System.out.println("Eight thread Max: = " + maxReturn);
		}
		catch(Exception e){}
		elapsedTime = System.nanoTime() - startTime;
		System.out.println(threadNumber + " thread Time: " + elapsedTime);
		
		threadNumber = 16;
		startTime = System.nanoTime();
		try {
			maxReturn = max(samples, 16);
			System.out.println("Sixteen thread Max: = " + maxReturn);
		}
		catch(Exception e){}
		elapsedTime = System.nanoTime() - startTime;
		System.out.println(threadNumber + " thread Time: " + elapsedTime);
	}
}