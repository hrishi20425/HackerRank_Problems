import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class String_Practice {

	public static void compareStrings(String first, String second) {
		if (first.length() > 0 && second.length() > 0) {
			System.out.println(first.length() + second.length());
		}

		if (first.compareTo(second) < 0) {
			System.out.println("No");
		} else if (first.compareTo(second) > 0) {
			System.out.println("Yes");
		}

		else if ((first.compareTo(second) == 0)) {
			System.out.println("Equal");
		}
		String newfirst = first.replace(first.charAt(0),
				Character.toUpperCase(first.charAt(0)));
		String newsecond = second.replace(second.charAt(0),
				Character.toUpperCase(second.charAt(0)));
		System.out.println(newfirst + " " + newsecond);
	}

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";
		ArrayList<String> a = new ArrayList<String>();
		for (int i = 0; i < s.length() - k + 1; i++) {
			String sub = s.substring(i, k + i);
			a.add(sub);
		}
		Collections.sort(a);
		smallest = a.get(0);
		largest = a.get(a.size() - 1);
		return smallest + "\n" + largest;
	}

	public static void palindrome(String A) {
		char[] ch = new char[A.length()];
		int counter = 0;
		for (int i = A.length() - 1; i >= 0; i--) {
			ch[counter] = A.charAt(i);
			counter++;
		}

		String B = new String(ch);
		if (A.equalsIgnoreCase(B))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	public static void isAnagram(String A, String B) {
		HashMap<Character, Integer> a_hash = new HashMap<Character, Integer>();
		for (int i = 0; i < A.length(); i++) {
			char ch = Character.toLowerCase(A.charAt(i));
			if (a_hash.containsKey(ch)) {
				a_hash.put(ch, a_hash.get(ch) + 1);
			} else
				a_hash.put(ch, 1);
		}
		HashMap<Character, Integer> b_hash = new HashMap<Character, Integer>();
		for (int j = 0; j < B.length(); j++) {
			char ch_b = Character.toLowerCase(B.charAt(j));
			if (b_hash.containsKey(ch_b)) {
				b_hash.put(ch_b, b_hash.get(ch_b) + 1);
			} else
				b_hash.put(ch_b, 1);
		}
		if (a_hash.equals(b_hash))
			System.out.println("Anagrams");
		else
			System.out.println("Not Anagrams");
	}

	public static void getToken() {
		String A = "Raj a boy, he and @";
		char[] ch = A.toCharArray();
		StringBuffer s = new StringBuffer("");

		ArrayList<String> out = new ArrayList<String>();
		for (int i = 0; i < ch.length; i++) {
			if (Character.isLetterOrDigit(ch[i])) {
				s.append(ch[i]);
			} else {
				String out_s = new String(s.toString());
				out.add(out_s);
				s.delete(0, s.length());
			}
		}
		int counter = 0;
		String LastString = s.toString();
		for (String sb : out) {
			if (!sb.isEmpty())
				counter++;
		}
		if (!LastString.isEmpty())
			counter++;
		System.out.println(counter);
		for (String sb : out) {
			if (!sb.isEmpty())
				System.out.println(sb);
		}
		if (!LastString.isEmpty())
			System.out.println(LastString);

	}

	public static void checkUserName(String username) {
		char[] ch = username.toCharArray();
		if (username.length() < 8 || username.length() > 30)
			System.out.println("Invalid");
		else if (ch[0] == '_')
			System.out.println("Invalid");
		else {
			int counter = 0;
			for (int i = 0; i < ch.length; i++) {
				if (Character.isLetterOrDigit(ch[i]) || ch[i] == '_')
					counter++;
				else
					break;
			}
			if (counter == ch.length)
				System.out.println("Valid");
			else
				System.out.println("Invalid");
		}

	}

	public static void prime(String ipnumber) {
		boolean flag = true;
		BigInteger number = new BigInteger(ipnumber);
		if (number.intValue() == 1 || number.intValue() == 0) {
			flag = false;
		} 
		else 
		{
			flag = number.isProbablePrime(1);

		}
		if (flag)
			System.out.println("prime");
		else
			System.out.println("not prime");
		
	}

	public static void main(String[] args) throws ParseException {
		Scanner in = new Scanner(System.in);
		//prime(in.next());
		
		SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
		Date departure = sd.parse("09/16/2020");
		System.out.println(sd.format(departure));
		Date today = Calendar.getInstance().getTime();
		System.out.println(sd.format(today).equals(sd.format(departure)));
		SimpleDateFormat formatNowDay = new SimpleDateFormat("dd");
	    SimpleDateFormat formatNowMonth = new SimpleDateFormat("MMMM");
	    SimpleDateFormat formatNowYear = new SimpleDateFormat("YYYY");

	    String currentDay = formatNowDay.format(departure);
	    String currentMonth = formatNowMonth.format(departure);
	    String currentYear = formatNowYear.format(departure);

		System.out.println(currentDay + currentMonth + currentYear);
		
		// palindrome(input);
		/*
		 * Scanner in = new Scanner(System.in); int testCases = *
		 * Integer.parseInt(in.nextLine()); while (testCases > 0) { String line
		 * = in.nextLine(); char[] line_ch = line.toCharArray();
		 * Stack<StringBuffer> s = new Stack<StringBuffer>(); StringBuffer sb_c
		 * = new StringBuffer(""); StringBuffer sb_first = new StringBuffer("");
		 * StringBuffer sb_second = new StringBuffer(""); int i = 0; if
		 * (line_ch[i] == '<' && line_ch[i + 1] != '/') { i++; while (line_ch[i]
		 * != '>') { sb_first.append(line_ch[i]); i++; } s.add(sb_first); i++;
		 * while (line_ch[i] != '<') { sb_c.append(line_ch[i]); i++;
		 * 
		 * } }
		 * 
		 * if (line_ch[i] == '<' && line_ch[i + 1] == '/') { i++; i++; while
		 * (line_ch[i] != '>') { sb_second.append(line_ch[i]); i++; } if
		 * (sb_first.toString().equals(sb_second.toString())) {
		 * System.out.println(sb_c); break; } else { System.out.println("None");
		 * break; }
		 * 
		 * }
		 * 
		 * }
		 */

	}
}
