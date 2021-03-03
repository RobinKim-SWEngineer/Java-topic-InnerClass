package javaConcurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class DataReader implements Callable<String> {

	public String call() throws Exception {
		System.out.println("Reading data..");
		TimeUnit.SECONDS.sleep(3);
		
		return "Date reading finished";
	}	
}
