import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintAnything<Integer> intPrint = new PrintAnything<>(23);
		System.out.println(intPrint.add());
		
		
		PrintAnything<Double> doublePrint = new PrintAnything<>(23.5);
		doublePrint.print();
	}
}
