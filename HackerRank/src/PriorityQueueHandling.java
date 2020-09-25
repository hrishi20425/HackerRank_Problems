import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueHandling {
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
			
		}
		//System.out.println(events);
		List<StudentP> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (StudentP st : students) {
				System.out.println(st.getFname());
			}
		}
	}
}

class StudentP implements Comparable<StudentP>{
	private int id;
	private String fname;
	private double cgpa;

	public StudentP(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}


	@Override
	public int compareTo(StudentP s2) {
		int out =0;
		int outinner =0;
		if(s2.getCgpa()-this.getCgpa()>0)
			out =1;
		else if(s2.getCgpa()-this.getCgpa()<0)
			out=-1;
		else if (s2.getCgpa()-this.getCgpa()==0)
		{
			outinner = this.getFname().compareTo(s2.getFname());
			out =outinner;
			if(outinner==0)
			{
				if(this.getId()-this.getId()>0)
					out =1;
				else if(this.getId()-this.getId()<0)
					out=-1;
			}
				
		}
		return out;
	}

}

class Priorities {
	public List<StudentP> getStudents(List<String> events) {
		List<StudentP> student_out = new ArrayList<StudentP>();
		PriorityQueue <StudentP> student_queue= new PriorityQueue<StudentP>();
		for (int i = 0; i < events.size(); i++) {
			String[] student_details = events.get(i).split(" ");
			if (student_details[0].equalsIgnoreCase("ENTER"))
				student_queue.add(new StudentP(Integer.valueOf(student_details[3]),
						student_details[1], Double.valueOf(student_details[2])));
			if (student_details[0].equalsIgnoreCase("SERVED"))
				student_queue.poll();

		}
		Iterator<StudentP> it = student_queue.iterator();
		while(it.hasNext())
		student_out.add(student_queue.poll());
		return student_out;

	}
}

