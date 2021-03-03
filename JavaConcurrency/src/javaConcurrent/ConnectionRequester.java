package javaConcurrent;

import java.util.concurrent.*;

public class ConnectionRequester implements Callable<String> {

	public String call() throws Exception {
		System.out.println("Requesting connection..");
		TimeUnit.SECONDS.sleep(3);
		
		return "Connection is made";
	}

}
