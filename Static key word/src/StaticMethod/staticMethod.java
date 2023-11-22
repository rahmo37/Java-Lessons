package StaticMethod;

public class staticMethod {

	int x;
	
	void method1() {
		//x = 10; (non-static variable can be accessed in non-static method)
		//method2(""); //(a static method can be accessed in a non-static method)
		
		System.out.println("i am non-static method");
	}

	static void method2(String s) {
		//x = 10; (but a non-static method can't be accessed in a static method)
		//method1(); (but cannot access non static method in a static method
		
		System.out.println("i am static method " + s);
	}

}
