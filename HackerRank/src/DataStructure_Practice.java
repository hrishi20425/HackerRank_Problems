import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DataStructure_Practice {

	public static boolean canWin(int leap, int[] game) {
		int counter = 0;
		boolean flag = true;
		while (counter < game.length - 1) {
			// negative outcome
			if ((game[counter + 1] == 1 && counter + 1 < game.length - 1)
					&& (game[counter + leap] == 1 && counter + leap < game.length - 1)) {
				flag = false;
				break;
			}
			// positive outcome
			if ((counter + 1 >= game.length - 1)
					|| (counter + leap >= game.length - 1)) {
				flag = true;
				break;
			}
			if (game[counter + 1] == 0)
				counter++;
			if (game[counter + leap] == 0)
				counter = counter + leap;

		}
		return flag;

	}

	public static void hourglass(int[][] arr) {
		int sum = 0;
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				sum = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1]
						+ arr[i][j] + arr[i + 1][j - 1] + arr[i + 1][j]
						+ arr[i + 1][j + 1];
				a.add(sum);
				sum = 0;
			}

		}
		Collections.sort(a);
		System.out.println(a.get(a.size() - 1));
	}

	public static void listhandling() {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>();
		int list_intial_length = scan.nextInt();
		for (int i = 0; i < list_intial_length; i++) {
			int element = scan.nextInt();
			a.add(element);
		}
		int totalqueries = scan.nextInt();
		for (int j = 0; j < totalqueries; j++) {
			String query_type = scan.next();
			if (query_type.equalsIgnoreCase("Insert")) {
				a.add(scan.nextInt(), scan.nextInt());
			} else if (query_type.equalsIgnoreCase("Delete")) {
				int delete_element = scan.nextInt();
				if (delete_element < a.size())
					a.remove(delete_element);
			}
		}
		for (Integer i : a)
			System.out.print(i + " ");
		scan.close();
	}

	public static void arraylisthandling() {
		Scanner scan = new Scanner(System.in);
		int total_list = scan.nextInt();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < total_list; i++) {
			int length = scan.nextInt();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = 0; j < length; j++) {
				int element = scan.nextInt();
				temp.add(element);
			}
			list.add(temp);
		}
		int total_queries = scan.nextInt();
		for (int k = 0; k < total_queries; k++) {
			int index = scan.nextInt();
			int element = scan.nextInt();
			if (list.get(index - 1).size() >= element
					&& list.get(index - 1).size() > 0)
				System.out.println(list.get(index - 1).get(element - 1));
			else
				System.out.println("ERROR!");
		}
		scan.close();

	}

	public static void maphandling() {
		Scanner scan = new Scanner(System.in);
		int number_records = scan.nextInt();
		scan.nextLine();
		HashMap<String, Integer> phone_records = new HashMap<String, Integer>();

		for (int i = 0; i < number_records; i++) {
			String name = scan.nextLine().trim();
			int phone = scan.nextInt();
			scan.nextLine();
			phone_records.put(name, phone);
		}
		while (scan.hasNext()) {
			String search_name = scan.nextLine().trim();
			if (phone_records.containsKey(search_name))
				System.out.println(search_name + "="
						+ phone_records.get(search_name));
			else
				System.out.println("Not Found");
		}
		scan.close();
	}

	public static void hashpair() {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		String[] pair_left = new String[t];
		String[] pair_right = new String[t];
		HashSet<String> hashpair = new HashSet<String>();
		for (int i = 0; i < t; i++) {
			pair_left[i] = s.next();
			pair_right[i] = s.next();
			hashpair.add(pair_left[i] + "_" + pair_right[i]);
			System.out.println(hashpair.size());
		}
	}

	public static void maxSubarray() {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<Integer>();
		int n = in.nextInt();
		int m = in.nextInt();
		int[] list = new int[n];
		for (int i = 0; i < n; i++) {
			int num = in.nextInt();
			list[i] = num;
		}
		Set<Integer> temp = new HashSet<Integer>();
		List<Integer> max = new ArrayList<Integer>();
		for (int j = 0; j < n - m + 1; j++) {
			temp.clear();
			for (int k = j; k < j + m; k++) {
				temp.add(list[k]);
			}
			max.add(temp.size());
		}
		Collections.sort(max);
		System.out.println(max.get(max.size() - 1));
		in.close();
	}

	public static void getSetIndex(BitSet B1, BitSet B2) {
		int counter1 = 0, counter2 = 0;
		for (int i = 0; i < B1.size(); i++) {
			if (B1.get(i))
				counter1++;
		}
		for (int i = 0; i < B2.size(); i++) {
			if (B2.get(i))
				counter2++;
		}
		System.out.println(counter1 + " " + counter2);
	}
	
	public  static void manageBitSet()
	{
		BitSet B1, B2;
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int no_operations = in.nextInt();
		B1 = new BitSet(size);
		B2 = new BitSet(size);
		for (int i = 0; i < no_operations; i++) {
			String operation_type = in.next();
			int position1, position2;
			position1 = in.nextInt();
			position2 = in.nextInt();
			switch (operation_type) {
			case "AND":
				if (position1 == 1)
					for (int j = 0; j < B1.size(); j++) {
						boolean value;
						value = B1.get(j) && B2.get(j);
						B1.set(j, value);
					}
				if (position1 == 2)
					for (int j = 0; j < B2.size(); j++) {
						boolean value;
						value = B2.get(j) && B1.get(j);
						B2.set(j, value);
					}
				getSetIndex(B1, B2);
				break;
			case "OR":
				if (position1 == 1)
					for (int j = 0; j < B1.size(); j++) {
						boolean value;
						value = B1.get(j) || B2.get(j);
						B1.set(j, value);
					}
				if (position1 == 2)
					for (int j = 0; j < B2.size(); j++) {
						boolean value;
						value = B2.get(j) || B1.get(j);
						B2.set(j, value);
					}
				getSetIndex(B1, B2);
				break;
			case "XOR":
				if (position1 == 1)
					for (int j = 0; j < B1.size(); j++) {
						boolean value;
						value = B1.get(j) ^ B2.get(j);
						B1.set(j, value);
					}
				if (position1 == 2)
					for (int j = 0; j < B2.size(); j++) {
						boolean value;
						value = B2.get(j) ^ B1.get(j);
						B2.set(j, value);
					}
				getSetIndex(B1, B2);
				break;
			case "FLIP":
				if (position1 == 1) {
					if (B1.get(position1))
						B1.set(position2, false);
					else
						B1.set(position2, true);
				}
				if (position1 == 2) {
					if (B2.get(position2))
						B2.set(position2, false);
					else
						B2.set(position2, true);
				}
				getSetIndex(B1, B2);
				break;
			case "SET":
				if (position1 == 1)
					B1.set(position1, true);
				if (position1 == 2)
					B2.set(position2, true);
				getSetIndex(B1, B2);
				break;
			}
		}
		in.close();

	}

	public static void main(String[] args) {
		
	}
}
