
public class Account {
	  
	int acc_no;  
	String acc_name;  
	float balance;  
	
	void insert(int anum,String aname,float bal){  
		acc_no=anum;  
		acc_name=aname;  
		balance=bal;  
	}  
	void deposit(float amt){  
		balance=balance+amt;  
	System.out.println(amt+" deposited");  
	}  
	
	void withdraw(float amt){  
	if(balance<amt){  
	System.out.println("Insufficient Balance");  
	}else{  
		balance=balance-amt;  
	System.out.println(amt+" withdrawn");  
	}  
	}  
	
	void checkBalance(){
		System.out.println("Balance is: "+balance);
		} 
	
	void display(){
		System.out.println(acc_no+" "+acc_name+" "+balance);
		}  
	  
}
