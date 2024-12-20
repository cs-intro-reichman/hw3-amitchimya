/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1=preProcess(str1);
		str2=preProcess(str2);
		int count1 =0;
		int count2 =0;
		int length1 = str1.length();
		int length2 = str2.length();
		if (length1==0 && length2==0) {
			return true;
		}
		char c = str1.charAt(0);
		for (int i=0; i<length1; i++) {
			c = str1.charAt(i);
			if (c== ' ') {
				i++;
				c = str1.charAt(i);
			}
			for (int j=0; j<length1; j++) {
				if (c == str1.charAt(j)) {
					count1++;
				}
			}
			for (int k=0; k<length2; k++) {
				if (c == str2.charAt(k)) {
					count2++;
				}
			}
			if (count1!=count2) {
				return false;
			}
			count1 =0;
			count2 =0;
		}
	
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newStr = "";
		if (str.length()==0) {
			return str;
		}
		char c = str.charAt(0);
		for (int i=0; i<str.length(); i++) {
			c=  str.charAt(i);
			if (c>='A' && c<='Z') {
				c= (char)(c +32);
			}
			if ((c>='a' && c<='z')||(c>='0' && c<='9') || c==' ') {
				newStr = newStr + c;
			}

		}
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {

		String newStr = "";
		while (str.length()!=0) {
			int random = (int) (Math.random()*str.length());
			newStr = newStr + str.charAt(random);
			str = str.substring(0, random) + str.substring(random +1);
		}
		return newStr;
	}
}
