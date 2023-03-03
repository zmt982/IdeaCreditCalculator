package com.Anatolii.CreditCalculator;

import java.util.Scanner;

/*
 * The application  CreditCalculator receives data on the loan parameters
 * from the console (amount of money borrowed, monthly payment, interest rate,
 * type of client) and outputs the calculated overpayment on the loan to the console.
 * @version 1.0 03 Mar 2023
 * @author A K
 */

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