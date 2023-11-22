package findingHowTheParentClassesBehaveWithTheInterface;

public class ParentA extends GrandParentA {
	//since the ParentA class is the immidiate child class of an abstract parent class it must implement all the methods in the Test interface
	
	public void test1() {
		System.out.println("I am test1");
	}
	
	public void test2() {
		System.out.println("I am test2");
	}

}
