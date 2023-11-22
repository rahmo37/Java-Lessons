package OwnDynamicArray;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicArray dynamicArray = new DynamicArray(5);

		dynamicArray.add("A");
		dynamicArray.add("B");
		dynamicArray.add("C");
		dynamicArray.add("D");
		dynamicArray.add("E");
		dynamicArray.add("F");
		
		dynamicArray.delete("A");
		dynamicArray.delete("B");
		dynamicArray.delete("C");
		
		

		dynamicArray.insert(0, "X");
		
		//dynamicArray.delete("B");
		
		System.out.println("The searched character is at index : " + dynamicArray.search("C"));
		
		

		System.out.println(dynamicArray);
		System.out.println("Array size : " + dynamicArray.size);
		System.out.println("Array capacity : " + dynamicArray.capacity);
		System.out.println("Array Empty : " + dynamicArray.isEmpty());
	}

}
