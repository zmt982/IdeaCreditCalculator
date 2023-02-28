package com.Anatolii.CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		float sum = sc.nextFloat();
		float monthPayment = sc.nextFloat();
		float rate = sc.nextFloat();
		String clientType = sc.nextLine().trim().toLowerCase();
		sc.close();
		
		Credit input = new Credit(sum, monthPayment, rate, clientType);
		float output = input.calculate(СlientType.valueOf(clientType));
		System.out.println(output);
		
	}

}