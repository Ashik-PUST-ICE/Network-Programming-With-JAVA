
class threadclassQ5 extends Thread 
{ 
	public void run() 
	{ 
		System.out.print("Welcome to our ICE dept."); 
		for(int i=0 ; i<=5;i++)
		{
			System.out.println("The Number = "+i);
		}
	} 
	public static void main(String[] args) 
	{ 
		threadclassQ5 g = new threadclassQ5(); // creating thread 
		g.start(); // starting thread 
	} 
}
