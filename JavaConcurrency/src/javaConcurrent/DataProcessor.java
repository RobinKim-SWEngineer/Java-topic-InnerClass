package javaConcurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class DataProcessor implements Callable<String> {

	public String call() throws Exception {
		System.out.println("Processing data...");
		TimeUnit.SECONDS.sleep(3);
		
		return "Data is processed";
	}
}
