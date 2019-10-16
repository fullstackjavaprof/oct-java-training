
public class Student {
	int sno;
	String sname;
	static String cname;
	
	static {
		System.out.println("This is in static block");
	}
	
    Student(int stno,String stname)
    {
    	sno=stno;
    	sname=stname;
    	
    }
    
    static void insertCname() {
    	cname="CBIT";
    }
    
 
   	void display(){
		
		System.out.println("Student no : "+sno);
		System.out.println("Student name : "+sname);
		System.out.println("Student college name: "+cname);
	}
	

}
