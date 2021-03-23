package anonymousClass;

public class AnonymousClassExample {
	
	interface HelloWorld {
		public void greet();
		public void greetSomeone(String someone);
	}
	
	public void SayHello() {
		
		class EnglishGreeting implements HelloWorld {

			public void greet() {
				greetSomeone("world");
			}

			public void greetSomeone(String someone) {
				System.out.println("Hello " + someone);
			}
		}
		HelloWorld englishGreeting = new EnglishGreeting();
		
		HelloWorld frenchGreeting = new HelloWorld() {

			public void greet() {
				greetSomeone("tout le monde");
			}
			
			public void greetSomeone(String someone) {
				System.out.println("Sault " + someone);
			}
		};
		
		HelloWorld spanishGreeting = new HelloWorld() {

			public void greet() {
				greetSomeone("mundo");
			}

			public void greetSomeone(String someone) {
				System.out.println("Hola " + someone);
			}
		};
		
		englishGreeting.greet();
		frenchGreeting.greet();
		spanishGreeting.greet();
	}

	public static void main(String[] args) {
		AnonymousClassExample anonymousClassExample = new AnonymousClassExample();
		anonymousClassExample.SayHello();
	}
	
	/**
	 * Additional Example : javafx.scene.control, Class Button
	 *  
	 *  public final void setOnAction(EventHandler<ActionEvent> value)
	 *  
	 *  Button btn = new Button();
	 *  btn.setOnAction(new EventHandler<ActionEvent> {
	 *  	
	 *  	@override
	 *  	public void handle(ActionEvent event) {
	 *  		System.out.println("Hello World!");
	 *  	}
	 *  });
	 *  
	 *  -- Method above requires an object of type EventHandler<ActionEvent> interface, which has handle method.
	 *  Instead of implementing the handle() with a new class, it uses an anonymous class expression. Anonymous
	 *  classes are actually ideal for implementing an interface that contains more than two methods.
	 */
}
