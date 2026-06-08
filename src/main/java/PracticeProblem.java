/**
 * File Name: G11 ICS3U1 culminating
 * Author: Tom Leung
 * Date Created: May 29, 2026
 * Date Last Edited: June 10, 2026
 */

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;
import java.util.Queue;

public class PracticeProblem {

	public static void main(String args[]) {
		Scanner ip = new Scanner(System.in);
		Random r = new Random();

		System.out.println("Welcome to the Reverse - Cal Game!");

		System.out.print("\nPlease enter the number of rounds: ");

		// Validate integer input
		while (!(ip.hasNextInt())) {
			ip.nextLine();
			System.out.println("Invalid Input!");
			System.out.print("Please enter the number of rounds: ");
		}

		int rounds = ip.nextInt();
		ip.nextLine();

		// Ensure rounds >= 1
		while (rounds < 1) {
			System.out.println("Invalid Input!");
			System.out.print("Please enter the number of rounds: ");
			while (!(ip.hasNextInt())) {
				ip.nextLine();
				System.out.println("Invalid Input!");
				System.out.print("Please enter the number of rounds: ");
			}
			rounds = ip.nextInt();
			ip.nextLine();
		}

		System.out.println("\nPlease be awared that the following settings/input will apply to all rounds/generated questions.\n");


		System.out.print("Please enter the first number you want in the question: ");

		// Validate number input
		while (!(ip.hasNextDouble())) {
			ip.nextLine();
			System.out.println("Invalid Input!");
			System.out.print("Please enter the first number you want in the question: ");
		}

		double base = ip.nextDouble();
		ip.nextLine();
		

		System.out.print("\nPlease enter the number of numbers used in each calculation/operation: ");

		// Validate integer input
		while (!(ip.hasNextInt())) {
			ip.nextLine();
			System.out.println("Invalid Input!");
			System.out.print("Please enter the number of numbers used in each calculation/operation: ");
		}

		int total = ip.nextInt();
		ip.nextLine();

		// Ensure total >= 2
		while (total < 2) {
			System.out.println("Invalid Input!");
			System.out.print("Please enter the number of numbers used in each calculation/operation: ");
			while (!(ip.hasNextInt())) {
				ip.nextLine();
				System.out.println("Invalid Input!");
				System.out.print("Please enter the number of numbers used in each calculation/operation: ");
			}
			total = ip.nextInt();
			ip.nextLine();
		}

		System.out.println("\nPlease enter number 1 - 5 to select the type of operation: ");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("5. Mixed");

		while (!(ip.hasNextInt())) {
			ip.nextLine();
			System.out.println("Invalid Input!");
			System.out.println("Please enter number 1 - 5 to select the type of operation: ");
		    System.out.println("1. Addition");
		    System.out.println("2. Subtraction");
		    System.out.println("3. Multiplication");
		    System.out.println("4. Division");
		    System.out.println("5. Mixed");
		}
		
		int operationtype = ip.nextInt();
		ip.nextLine();

		while (operationtype < 1 || operationtype > 5) {
			System.out.println("Invalid Input!");
			System.out.println("Please enter number 1 - 5 to select the type of operation: ");
		    System.out.println("1. Addition");
		    System.out.println("2. Subtraction");
		    System.out.println("3. Multiplication");
		    System.out.println("4. Division");
		    System.out.println("5. Mixed");
			while (!(ip.hasNextInt())) {
				ip.nextLine();
				System.out.println("Invalid Input!");
				System.out.println("Invalid Input!");
			    System.out.println("Please enter number 1 - 5 to select the type of operation: ");
		        System.out.println("1. Addition");
		        System.out.println("2. Subtraction");
		        System.out.println("3. Multiplication");
		        System.out.println("4. Division");
		        System.out.println("5. Mixed");
			}
			operationtype = ip.nextInt();
			ip.nextLine();
		}

		
		for(int i = 0; i < rounds; i++){
			int mixed = 0;
			int round = i + 1;
			System.out.print("Question" + round + ": " + base);
			
			ArrayDeque<Double> numbers = new ArrayDeque<>();
			ArrayDeque<Character> operators = new ArrayDeque<>();
			numbers.push(base);

			for (int i1 = 0; i1 < total - 1; i1++){
				double randomNum = -10000 + r.nextInt(20001);
				while(randomNum > -0.5 && randomNum < 0.5){
					randomNum = -10000 + r.nextInt(20001);
				}
				double randomNum1 = Math.round(randomNum);
				numbers.push(randomNum1);
				mixed = 1 + r.nextInt(4);
				if (operationtype != 5){
					mixed = 0;
				}

				if (operationtype == 1 || mixed == 1){
					operators.push('+');
					System.out.print(" + " + randomNum1) ;
				}
				if (operationtype == 2 || mixed == 2){
					operators.push('-');
					System.out.print(" - " + randomNum1) ;
				}

				double top1 = numbers.peek();
				if (operationtype == 3 || mixed == 3){
					System.out.print(" * " + randomNum1) ;
					numbers.pop();
					double top2 = numbers.peek();
					numbers.pop();
					numbers.push(top2*top1);
				}
				if (operationtype == 4 || mixed == 4){
					System.out.print(" / " + randomNum1) ;
					numbers.pop();
					double top2 = numbers.peek();
					numbers.pop();
					numbers.push(top2/top1);
				}
			}	
			System.out.println("\n" + numbers);	
			System.out.println(operators);

			
			
			while(numbers.size()>1){
				Character operator = operators.peekLast();
				double top1 = numbers.peekLast();
				if (operator == '+'){
					numbers.removeLast();
					double top2 = numbers.peekLast();
					numbers.removeLast();
					numbers.addLast(top1 + top2);	
				}

				if (operator == '-'){
					numbers.removeLast();
					double top2 = numbers.peekLast();
					numbers.removeLast();
					numbers.addLast(top1 - top2);	
						
				}
				operators.removeLast();
			}
					
			System.out.println(numbers);	
			System.out.println(operators);
			System.out.println(" = ?");
			
			double polarity = numbers.peek() * -1;
			numbers.remove();
			numbers.add(polarity);
			
			String ans = numbers.peek() + " ";
			String reverseans = "";
			for (int i2 = ans.length()-1 ; i2 >= 0 ; i2 --){
				reverseans = reverseans + ans.charAt(i2);
			}
			System.out.println(reverseans);
		}
	}
}

	
	


