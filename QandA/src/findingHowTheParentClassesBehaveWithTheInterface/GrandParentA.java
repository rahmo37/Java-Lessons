package findingHowTheParentClassesBehaveWithTheInterface;

public abstract class GrandParentA implements Test {
	//when an abstract parent class implements an interface, it is the immidiate subclasse's responsibility to do the implementation of that method
	//because the abstract methods in the test interface works as if the it is in the abstract parent class
}
