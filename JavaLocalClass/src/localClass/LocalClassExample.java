package localClass;

public class LocalClassExample {
	
	static String regularExpression = "[^0-9]";
	
	public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {
		// A variable whose value is never changed after initialization, is effectively final.
		int numberLength = 10;
		
		/** 
		 * Local class : PhoneNumber ( Declared in a method ),  enclosing class : LocalClassExample
		 * Local classes are non-static so they can't contain most static declarations.
		 */
		class PhoneNumber {
			String formattedPhoneNumber = null;
			
			public PhoneNumber(String phoneNumber) {
				/**
				 * Local class has access to the members of its enclosing class : LocalClassExample.regularExpression
				 * Since PhoneNumber is declared in a static method, it can only access to static members of its enclosing class
				 */ 
				String currentNumber = phoneNumber.replaceAll(regularExpression, "");
				
				/**
				 *  Local class has also access to local variables when they're final or effectively final
				 *  Changing numberLength value will make it inaccessible from PhoneNumber since its no longer effectively final  
				 */
				if (currentNumber.length() == numberLength) {
					formattedPhoneNumber = currentNumber;
				}
				else {
					formattedPhoneNumber = null;
				}
			}
			
			public String getFormattedNumber() {
				return formattedPhoneNumber;
			}
			
			// When declared in a method, class has access to the method's parameters : phoneNumber1, phoneNumber2
			public void getOriginalNumbers() {
				System.out.println("Original numbers are : " + phoneNumber1 + ", "+ phoneNumber2);
			}
		}
		
		PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
		PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);
		
		myNumber1.getOriginalNumbers();
		
		if(myNumber1.getFormattedNumber() == null)
			System.out.println("First number is invalid");
		else
			System.out.println("Formatted number of first number is " + myNumber1.getFormattedNumber());
		if(myNumber2.getFormattedNumber() == null)
			System.out.println("Second number is invalid");
		else
			System.out.println("Formatted number of second number is " + myNumber2.getFormattedNumber());
	}
	
	public static void main(String[] args) {
		validatePhoneNumber("123-456-7890", "456-7890");
	}
}
