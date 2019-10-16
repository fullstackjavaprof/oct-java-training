
public class TestAccount {
	public static void main(String[] args){  
		Account acc1=new Account();  
		acc1.insert(888888,"Ramu",2000);  
		acc1.display();  
		acc1.checkBalance();  
		acc1.deposit(50000);  
		acc1.checkBalance();  
		acc1.withdraw(15000);  
		acc1.checkBalance();  
		}
}
