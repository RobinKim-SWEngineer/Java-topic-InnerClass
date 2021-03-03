package javaConcurrent;
import java.util.concurrent.*;

public class JavaConcurrent {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		/** 
		 *  Creating an executor with three threads.
		 *  This executor will submit call_able object that can produce a Future object
		 */
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		/**
		 *  Submitting a call_able object through an executor. 
 		 *  Executor's .submit() returns a Future object.
 		 *  Upon submission, .call() method that includes asynchronous task of the call_able object is executed.
 		 */
		Future<String> connectionRequestFuture = executorService.submit(new ConnectionRequester());
		Future<String> dataProcessorFuture = executorService.submit(new DataProcessor());
		Future<String> dataReaderFuture = executorService.submit(new DataReader());
		
		/**
		 *  Checking whether the asynchronous task is completed.
		 *  Use .isDone() as check point that guarantees the task's result was packed in the Future.
		 */
		while (!connectionRequestFuture.isDone() && !dataProcessorFuture.isDone() && !dataReaderFuture.isDone()) {
			System.out.println("Tasks still not yet finished");
			// Other stuff not depending on these three processes
			TimeUnit.SECONDS.sleep(1);
		}
		
		/**
		 *  Returns result of the asynchronous task. 
		 *  It will wait if task is not completed and block the application.
		 */
		System.out.println(connectionRequestFuture.get());
		System.out.println(dataProcessorFuture.get());
		System.out.println(dataReaderFuture.get());
	}
}