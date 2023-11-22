package CollectionAndLists;

import java.util.LinkedList;

public class Experiment {

	// static int i = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0; i < 5; i++) {
			list.add(i + 10);
		}
		System.out.println(list.get(10));

		// listTraverse(list);
	}

//	private static void listTraverse(LinkedList<Integer> list) {
//
//		while (i < 5) {
//			System.out.println(list.get(i));
//			i++;
//			listTraverse(list);
//
//		}
//	}

	// why do the lits's methods uses index??

}
