package chap3;

import java.io.*;
import java.util.concurrent.*;

public class GZipAllFiles {
	public final static int THREAD_COUNT = 4;
	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
		
		String[] temp = {"zip_sample"};
		
		for (String filename : temp) {
			File f = new File(filename);
			if (f.exists()) {
				if (f.isDirectory()) {
					File[] files = f.listFiles();
					for (int i = 0; i < files.length; i++) {
						if (!files[i].isDirectory()) { // don't recurse directories
							Runnable task = new GZipRunnable(files[i]);
							pool.submit(task);
						}
					}
					} else {
						Runnable task = new GZipRunnable(f);
						pool.submit(task);
					}
			}
		}
		pool.shutdown();
		long elapstedTime = System.nanoTime() - startTime;
		System.out.println("elapsed time = " + elapstedTime);
	}
}