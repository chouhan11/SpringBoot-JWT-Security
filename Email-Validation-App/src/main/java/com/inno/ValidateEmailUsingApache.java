package com.inno;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.validator.routines.EmailValidator;

public class ValidateEmailUsingApache {

	// using apache commons builtin mathod
	public static boolean isValidEmail(String email) {
		// create the EmailValidator instance
		EmailValidator validator = EmailValidator.getInstance();
		// check the valid email address using is Valid method
		return validator.isValid(email);
	}

	public static void main(String[] args) {
		List<String> emails = new ArrayList<String>();
		// valid email addresses
		emails.add("alice@example.com");
		emails.add("alice.bob@example.com");
		emails.add("alice@example.me.org");

		// invalid email addresses
		emails.add("alice.example.com");
		emails.add("alice..bob@example.com");
		emails.add("alice@.example.com");

		// iterate using enhanced for loop
		for (String email : emails) {
			System.out.println(email + " Email address  is " + (isValidEmail(email) ? "valid" : "invalid"));
		}

	}

}
