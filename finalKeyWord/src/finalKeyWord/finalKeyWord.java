package finalKeyWord;

public class finalKeyWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Java final keyword is a non-access specifier that is used to restrict a
		 * class, variable, and method. If we initialize a variable with the final
		 * keyword, then we cannot modify its value.
		 * 
		 * If we declare a method as final, then it cannot be overridden by any
		 * subclasses. And, if we declare a class as final, we restrict the other
		 * classes to inherit or extend it.
		 * 
		 * In other words, the final classes can not be inherited by other classes
		 */
		final double PI = 3.1415;

		// PI = 54.23;(Not allowed to change);

		System.out.println(PI);

	}

}
