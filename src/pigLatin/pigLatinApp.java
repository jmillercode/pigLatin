package pigLatin;

import java.util.Scanner;

public class pigLatinApp {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String userWord;
		String userWord2;
		char userContinue = 'y';
		
		while (userContinue == 'y') {
		
		System.out.println("Enter a Word:");
		userWord = scnr.next();
		
		userWord2 = pigLatin(userWord);
		
		System.out.println(userWord + " in pig latin is " +  userWord2 + "!");
		
		System.out.println("Would you like to continue?(y/n)");
		userContinue = scnr.next().charAt(0);
		}
	}
	
	public static String pigLatin(String word) {
		char check;
		boolean checkReturn;
		char checkY;
		boolean checkYReturn;
		String subWord;
		String first;
		String last;
		int x;
		
		
		check = word.charAt(0);
		
		//y check
		if (check == 'y') {
			checkY = word.charAt(1);
			checkYReturn = isVowel(checkY);
			if (checkYReturn == true) {
				subWord = word.substring(1);
				subWord = subWord + check + "ay";
				return subWord;
			}
			else {
				subWord = word + "way";
				return subWord;	
			}
		}
		//end y check
		
		//first char check
		check = word.charAt(0);
		checkReturn = isVowel(check);
		if (checkReturn == true) {
			word = word + "way";
			return word;
		}
		
		checkReturn = false;
		//find vowel loop
		for (x = 0; checkReturn == false; ++x) {
			check = word.charAt(x);
			checkReturn = isVowel(check);
		}
		first = word.substring( 0 , x - 1 );
		last = word.substring(x-1);
		subWord = last + first + "ay";
		return subWord;
		
		
	}
	
	public static boolean isVowel(char letter){
		if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'y') { 
			return true;
		}
		else {
			return false;
		}
	}
}
