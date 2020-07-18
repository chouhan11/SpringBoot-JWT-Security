package com.inno;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailValidationApplication {

	//Email Regex in Java
	// private static final String regex = "^(.+)@(.+)$";
	
	//Adding restrictions to local part and domain part
	// private static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	
	//Checking for all valid characters in the local part
	//private static final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	
	//Adding restrictions to the domain name part
	//private static final String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
	
	//Checking for consecutive, trailing, or leading dots
	//private static final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+↵\n" + ")*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
	
	//Using OWASP validation regex
	private static final String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	
	public static void main(String args[]) {
		List<String> emails = new ArrayList<String>();
		// valid email addresses
		emails.add("alice@example.com");
		emails.add("alice.bob@example.co.in");
		emails.add("alice#@example.me.org");
		// invalid email addresses
		emails.add("alice.example.com");
		emails.add("alice#example.com");
		emails.add("@example.me.org");

		// initialize the Pattern object
		Pattern pattern = Pattern.compile(regex);

		// searching for occurrences of regex
		for (String value : emails) {
			Matcher matcher = pattern.matcher(value);

			System.out.println("The Email address " + value + " is " + (matcher.matches() ? "valid" : "invalid"));
		}
	}

}
