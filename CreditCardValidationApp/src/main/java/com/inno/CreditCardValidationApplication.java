package com.inno;

import java.util.Arrays;

import org.apache.commons.validator.routines.checkdigit.LuhnCheckDigit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreditCardValidationApplication {

	public static void main(String[] args) {

		// String cardNumber="79927398713";
		String cardNumber = "6070936102604235";
		boolean validCreditCardNumber = isValidCreditCardNumberLuhn(cardNumber);
		// boolean validCreditCardNumber = isValidCreditCardNumber(cardNumber);
		if (validCreditCardNumber) {
			System.out.println(cardNumber + " Valid Card Number");
		} else {
			System.out.println(cardNumber + " Not Valid Card Number");
		}
		SpringApplication.run(CreditCardValidationApplication.class, args);
	}

	// by using Apache provided Algorithm
	private static boolean isValidCreditCardNumberLuhn(String cardNumber) {

		return LuhnCheckDigit.LUHN_CHECK_DIGIT.isValid(cardNumber);
	}

	// by using custom algorithm
	private static boolean isValidCreditCardNumber(String cardNumber) {

		int cardIntArray[] = new int[cardNumber.length()];
		for (int i = 0; i < cardNumber.length(); i++) {
			char ch = cardNumber.charAt(i);
			cardIntArray[i] = Integer.parseInt("" + ch);

		}
		for (int i = cardIntArray.length - 2; i >= 0; i = i - 2) {
			int num = cardIntArray[i];
			num = num * 2;
			if (num > 9) {
				num = num % 10 + num / 10;
			}
			cardIntArray[i] = num;
		}
		int sumDigit = sumDigit(cardIntArray);
		System.out.println(sumDigit);
		if (sumDigit % 10 == 0) {
			return true;
		}
		return false;
	}

	public static int sumDigit(int intArray[]) {
		return Arrays.stream(intArray).sum();
	}

}
