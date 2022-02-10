package chap4;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class PooledWeblog {
	private final static int NUM_THREADS = 4;
	public static void main(String args[]) throws IOException {
		
		ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
		
		Queue<LogEntry> results = new LinkedList<LogEntry>();
		
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("access_hosts1.txt"), "UTF-8"));
		
		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("accesslog_2021_hw.txt"), "UTF-8"));)
		{
			for(String entry = in.readLine(); entry != null; entry = in.readLine()) {
				LookupTask task = new LookupTask(entry);
				Future<String> future = executor.submit(task);
				LogEntry result = new LogEntry(entry, future);
				results.add(result);
			}
		}
		for (LogEntry result : results) {
			try{
				out.write(result.future.get()+"\n");
			} catch (InterruptedException | ExecutionException ex) {
				System.out.println(result.original);
			}
		}
		executor.shutdown();
		out.close();
	}
	private static class LogEntry {
		String original;
		Future<String> future;
		
		LogEntry(String original, Future<String> future) {
			this.original = original;
			this.future = future;
		}
	}
}