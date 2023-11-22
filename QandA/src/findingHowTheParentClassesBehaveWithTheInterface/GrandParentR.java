package findingHowTheParentClassesBehaveWithTheInterface;

public class GrandParentR implements Test{
	// since the this class is not abstract it must implement all the methods inside the Test interface
	public void test1() {
		System.out.println("I am test1");
	}
	
	public void test2() {
		System.out.println("I am test2");
	}

}
