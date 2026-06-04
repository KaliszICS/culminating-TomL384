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

		// Validate integer input
		while (!(ip.hasNextInt())) {
			ip.nextLine();
			System.out.println("Invalid Input!");
			System.out.print("Please enter the first number you want in the question: ");
		}

		int base = ip.nextInt();
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
		    int ans = base;
			int round = i + 1;
			System.out.print("Question" + round + ": " + base);
			if (operationtype == 5){
				Stack<Double> numbers = new Stack<>();
				Stack<Character> operators = new Stack<>();
				for (int i1 = 0; i1 < total - 1; i1++){
					int randomNum = -10000 + r.nextInt(20001);
					numbers.push(randomNum);
					mixed = 1 + r.nextInt(4);
					if (mixed == 1){
						operators.push("+");
					}
				    if (mixed == 2){
					    operators.push("-");
				    }
				    if (mixed == 3){
					    operators.push("*");
				    }
				    if (mixed == 4){
					    operators.push("/");
				    }
				}			
			}
			else{
				for (int i1 = 0; i1 < total - 1; i1++){
					int randomNum = -10000 + r.nextInt(20001);
					if (operationtype == 1){
						ans = ans  + randomNum ;
					    System.out.print(" + " + randomNum) ;
				    }
				    if (operationtype == 2){
					    ans = ans - randomNum ;
					    System.out.print(" - " + randomNum) ;
				    }
				    if (operationtype == 3){
					    ans = ans * randomNum ;
					    System.out.print(" * " + randomNum) ;
				    }
				    if (operationtype == 4){
					    ans = ans / randomNum ;
					    System.out.print(" / " + randomNum) ;
				    }
				
			    }
			}
			System.out.println(" = ?");
		}
	}
}

	
	


