class A
{
   public void methodA()
   {
     System.out.println("methodA() is called");
   }
}

class B extends A
{
   public void methodB()
   {
     System.out.println("methodB() is called");
   }
   
}

class C extends B
{
	 public void methodC()
	   {
	     System.out.println("methodC() is called");
	   }
	
	public static void main(String args[])
	   {
	     C obj = new C();
	     obj.methodA(); //calling  class A method
	     obj.methodB(); //calling class B method
	     obj.methodC(); //calling class C method
	  }
}

