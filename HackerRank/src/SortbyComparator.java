import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
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
}

class StudentComparision implements Comparator <Student>{
	public int compare(Student s1, Student s2) {
		int out =0;
		int outinner =0;
		if(s2.getCgpa()-s1.getCgpa()>0)
			out =1;
		else if(s2.getCgpa()-s1.getCgpa()<0)
			out=-1;
		else if (s2.getCgpa()-s1.getCgpa()==0)
		{
			outinner = s1.getFname().compareTo(s2.getFname());
			out =outinner;
			if(outinner==0)
			{
				if(s1.getId()-s1.getId()>0)
					out =1;
				else if(s1.getId()-s1.getId()<0)
					out=-1;
			}
				
		}
		return out;
	}

}

public class SortbyComparator
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
		StudentComparision student_comparator = new StudentComparision();
		Collections.sort(studentList, student_comparator);
      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
      	in.close();
	}
}
