/* Created by Vision Paudel on Sept. 17, 2019 
 * This is the console version of the Large Primality Test!
 */

import java.math.BigInteger;
import java.util.Scanner;

public class LargePrimalityTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Large Primality Test Console version 1.0 by Vision Paudel");
		System.out.println("https://github.com/Vision-Paudel/LargePrimalityTest");
		System.out.println("-------------------------------------------------------");
		System.out.println("Please enter a number: ");
		  try {
			  
			  String userInput = input.nextLine().trim();		
			  if (userInput.length() > 18) {				  
				  BigInteger userInputBigInteger = new BigInteger(userInput);
				  if(   userInputBigInteger.compareTo( new BigInteger(Long.MAX_VALUE + "") ) == 1 )
					  checkFactors(userInputBigInteger);
				  else {
					  long userInputLong = Long.parseLong(userInput);
					  checkFactors(userInputLong);
				  }					  
					  
			  }else {
				  long userInputLong = Long.parseLong(userInput);
				  checkFactors(userInputLong);
			  }
		  }
		  catch(NumberFormatException ex) {
			  System.out.println("Invalid Integer... Quitting Program!");								  
		  }
		  
	}
	
	private static boolean checkFactors(long inputNumber) {
		
		if(inputNumber>0) {
			
			if(inputNumber == 1) {
				System.out.println("1 is not a prime!");
				return false;
			}
			else if (inputNumber == 2) {
				System.out.println("2 is a prime!");
				return true;
			}
			else if (inputNumber == 3) {
				System.out.println("3 is a prime!");
				return true;
			}
			else if (inputNumber == 4) {
				System.out.println("4 is not a prime! One factor is 2.");
				return false;
			}
			else if (inputNumber == 5) {
				System.out.println("5 is a prime!");
				return true;
			}
			else if (inputNumber % 2 == 0) {
				System.out.println(inputNumber + " is not a prime! One factor is 2.");
				return false;
			}else {	
				
				for (long i = 3; i <= Long.MAX_VALUE && i <= Math.pow(inputNumber, 0.5); i+=2) {			
					if (inputNumber % i == 0) {				
						System.out.println(inputNumber + " is not a prime! One factor is " + i + ".");
						return false;
					}		
				}	
				System.out.println(inputNumber + " is a prime!");
				
			}
			return true; 
			
		}
		else {
			
			System.out.println("Zero or Negative Number... Quitting Program!");
			return false; 
			
		}
		
	}
	
	private static boolean checkFactors(BigInteger inputNumber) {
		
			if(inputNumber.compareTo(BigInteger.ZERO) == 1 ) {
			
				if(inputNumber.compareTo(BigInteger.ONE) == 0) {
					System.out.println("1 is not a prime!");
					return false;
				}
				else if (inputNumber.compareTo(new BigInteger(2+"")) == 0) {
					System.out.println("2 is a prime!");
					return true;
				}
				else if (inputNumber.compareTo(new BigInteger(3+"")) == 0) {
					System.out.println("3 is a prime!");
					return true;
				}
				else if (inputNumber.compareTo(new BigInteger(4+"")) == 0) {
					System.out.println("4 is not a prime! One factor is 2.");
					return false;
				}
				else if (inputNumber.compareTo(new BigInteger(5+"")) == 0) {
					System.out.println("5 is a prime!");
					return true;
				}
				else if (inputNumber.mod(new BigInteger(2+"")).compareTo(BigInteger.ZERO) == 0) {
					System.out.println(inputNumber + " is not a prime! One factor is 2.");
					return false;
				}else {
					BigInteger maxValue =  sqrt(inputNumber); 	
					System.out.println("Square root is " + maxValue);
					if (inputNumber.mod(maxValue).compareTo(BigInteger.ZERO) == 0) {
						System.out.println(inputNumber + " is not a prime! One factor is " + maxValue);
						return false;
					}
					
					for (BigInteger i = new BigInteger(3+""); i.compareTo(maxValue) < 1; i = i.add(new BigInteger(2+"")) ) {			
						if (inputNumber.mod(i).compareTo(BigInteger.ZERO) == 0) {				
							System.out.println(inputNumber + " is not a prime! One factor is " + i + ".");
							return false;
						}
						else {
							int count = ((int)(Math.random()*200000000));
							if(count < 5)
								System.out.println("Passed " + i);
						}
					}	
					System.out.println(inputNumber + " is a prime!");
					
				}
				return true;	
				
			}
			else {
				System.out.println("Zero or Negative Number... Quitting Program!");
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
