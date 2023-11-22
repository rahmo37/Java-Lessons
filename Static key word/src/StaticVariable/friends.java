package StaticVariable;

public class friends {
	String name;
	static int numberOfFriends;

	friends(String name) {
		this.name = name;
		numberOfFriends++;
	}
}
