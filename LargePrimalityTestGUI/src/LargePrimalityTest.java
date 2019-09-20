/* Created by Vision Paudel on Sept. 17, 2019 
 * This is the GUI version of the Large Primality Test!
 */

import java.math.BigInteger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LargePrimalityTest extends Application{

	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Large Primality Test Console version 1.0 by Vision Paudel");
		System.out.println("https://github.com/Vision-Paudel/LargePrimalityTest");
		System.out.println("-------------------------------------------------------");
		
		BorderPane mainPane = new BorderPane();
		
		TextArea areaToWrite = new TextArea("https://github.com/Vision-Paudel/LargePrimalityTest");
		areaToWrite.setWrapText(true);		
		mainPane.setCenter(areaToWrite);
		
		BorderPane bottomPane = new BorderPane();
		Button test = new Button(" T E S T ! " );
		bottomPane.setRight(test);  
		mainPane.setBottom(bottomPane);
		
		test.setOnMouseClicked(   e -> {
			try {
				String userInput = areaToWrite.getText().trim();		
				  if (userInput.length() > 18) {				  
					  BigInteger userInputBigInteger = new BigInteger(userInput);
					  if(   userInputBigInteger.compareTo( new BigInteger(Long.MAX_VALUE + "") ) == 1 )
						  checkFactors(userInputBigInteger, areaToWrite);
					  else {
						  long userInputLong = Long.parseLong(userInput);
						  checkFactors(userInputLong, areaToWrite);
					  }					  
						  
				  }else {
					  long userInputLong = Long.parseLong(userInput);
					  checkFactors(userInputLong, areaToWrite);
				  }
			  }
			  catch(NumberFormatException ex) {
				  areaToWrite.setText("Invalid Integer...");								  
			  }
		});
		
		Scene newScene = new Scene(mainPane);
		primaryStage.setScene(newScene);
		primaryStage.setWidth(500);
		primaryStage.setHeight(300);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Large Primality Test GUI version 1.0 by Vision Paudel");
		primaryStage.show();
		
	}
	
	private static boolean checkFactors(long inputNumber, TextArea output) {
		output.setText("");
		if(inputNumber>0) {
			
			if(inputNumber == 1) {
				output.setText(" 1 is not a prime!");
				return false;
			}
			else if (inputNumber == 2) {
				output.setText(" 2 is a prime!");
				return true;
			}
			else if (inputNumber == 3) {
				output.setText(" 3 is a prime!");
				return true;
			}
			else if (inputNumber == 4) {
				output.setText(" 4 is not a prime! One factor is 2.");
				return false;
			}
			else if (inputNumber == 5) {
				output.setText(" 5 is a prime!");
				return true;
			}
			else if (inputNumber % 2 == 0) {
				output.setText(" " + inputNumber + " is not a prime! One factor is 2.");
				return false;
				
			}else {	
				
				long maxValue =  (long)Math.pow(inputNumber, 0.5); 	
				output.setText(" Floor of Square root is " + maxValue + ". \n");
				System.out.println(" Floor of Square root is " + maxValue + ". ");
				if (inputNumber % maxValue == 0) {
					output.setText(output.getText() + " " + inputNumber + " is not a prime! One factor is " + maxValue+"\n");
					System.out.println(" " + inputNumber + " is not a prime! One factor is " + maxValue);
					return false;
				}
				
				for (long i = 3; i <= Long.MAX_VALUE && i <= Math.pow(inputNumber, 0.5); i+=2) {			
					if (inputNumber % i == 0) {				
						output.setText(output.getText() + " " + inputNumber + " is not a prime! One factor is " + i + ".\n");
						System.out.println(" " + inputNumber + " is not a prime! One factor is " + i + ".");
						return false;
					}		
				}	
				output.setText(output.getText() + " " + inputNumber + " is a prime!\n");
				System.out.println(" " + inputNumber + " is a prime!");
			}
			return true; 
			
		}
		else {
			
			output.setText(" Zero or Negative Number... ");
			return false; 
			
		}
		
	}
	
	private static boolean checkFactors(BigInteger inputNumber, TextArea output) {			
			output.setText("");
			if(inputNumber.compareTo(BigInteger.ZERO) == 1 ) {
			
				if(inputNumber.compareTo(BigInteger.ONE) == 0) {
					output.setText(" 1 is not a prime!");
					return false;
				}
				else if (inputNumber.compareTo(new BigInteger(2+"")) == 0) {
					output.setText(" 2 is a prime!");
					return true;
				}
				else if (inputNumber.compareTo(new BigInteger(3+"")) == 0) {
					output.setText(" 3 is a prime!");
					return true;
				}
				else if (inputNumber.compareTo(new BigInteger(4+"")) == 0) {
					output.setText(" 4 is not a prime! One factor is 2.");
					return false;
				}
				else if (inputNumber.compareTo(new BigInteger(5+"")) == 0) {
					output.setText(" 5 is a prime!");
					return true;
				}
				else if (inputNumber.mod(new BigInteger(2+"")).compareTo(BigInteger.ZERO) == 0) {
					output.setText(" " + inputNumber + " is not a prime! One factor is 2.");
					return false;
				}else {
					BigInteger maxValue =  sqrt(inputNumber); 	
					output.setText(" Floor of Square root is " + maxValue + ". \n");
					System.out.println(" Floor of Square root is " + maxValue + ". ");
					if (inputNumber.mod(maxValue).compareTo(BigInteger.ZERO) == 0) {
						output.setText(output.getText() + " " + inputNumber + " is not a prime! One factor is " + maxValue + "\n");
						System.out.println(" " + inputNumber + " is not a prime! One factor is " + maxValue);
						return false;
					}
					
					for (BigInteger i = new BigInteger(3+""); i.compareTo(maxValue) < 1; i = i.add(new BigInteger(2+"")) ) {			
						if (inputNumber.mod(i).compareTo(BigInteger.ZERO) == 0) {				
							output.setText(output.getText() + " " + inputNumber + " is not a prime! One factor is " + i + ".\n");
							System.out.println(" " + inputNumber + " is not a prime! One factor is " + i + ".");
							return false;
						}
						else {
							int count = ((int)(Math.random()*200000000));
							if(count < 5)
								System.out.println(" Passed " + i);
						}
					}	
					output.setText(output.getText() + " " + inputNumber + " is a prime!\n");
					System.out.println(" " + inputNumber + " is a prime!");
				}
				return true;	
				
			}
			else {
				output.setText(" Zero or Negative Number... ");
				return false;	
			}
	}
	
	public static BigInteger sqrt(BigInteger val) {
	    BigInteger half = BigInteger.ZERO.setBit(val.bitLength() / 2);
	    BigInteger cur = half;

	    while (true) {
	        BigInteger tmp = half.add(val.divide(half)).shiftRight(1);

	        if (tmp.equals(half) || tmp.equals(cur))
	            return tmp;

	        cur = half;
	        half = tmp;
	    }
	}

}
