//Inheritance = One parent class has many child class. 
//Accessed by using extends keyword
//The child class automatically inherits all the attributes(methods and variables) from parent class


public class cellPhone {
	String name;
	String OS;
	String Standard;
	int version;
	


	cellPhone(String name,String OS,String Standard,int version) {
		this.name = name;
		this.OS = OS;
		this.Standard = Standard;
		this.version = version;
	}

	void phoneOS() {
		System.out.println(name + " use " + OS);
	}

	void phoneStandard() {
		System.out.println(name + " use " + Standard);
	}
	//Method overRide = child class over rides a method from parent class 
	//it is done so the child class can have its own version of the method
	String battery() {
		return "\n" + name + " uses a battery";
	}
	
	public String toString() {
		return "cellPhone name : " + name +
				name + "\nuse " + OS +
				"\nit is a(an)" + Standard +
				"\nlatest version is " + version;
	}
}
