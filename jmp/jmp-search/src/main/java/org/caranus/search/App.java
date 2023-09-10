package org.caranus.search;

import java.util.List;
import java.util.logging.Logger;

import org.caranus.search.binary.IterativeBinarySearchImpl;
import org.caranus.search.binary.RecursiveBinarySearchImpl;
import org.caranus.search.generic.GenericSearchImpl;


public class App
{
	protected static Logger logger = Logger.getLogger(App.class.getName());
	public static void main(String[] args)
	{
		GenericSearchImpl<Element<Integer>, Integer> genericSearchImpl =
			  new GenericSearchImpl<>(GenericSearchImpl.ElementToGet.LAST);
		RecursiveBinarySearchImpl<Element<Integer>, Integer> recursiveBinarySearchImpl =
			  new RecursiveBinarySearchImpl<>(GenericSearchImpl.ElementToGet.LAST);
		IterativeBinarySearchImpl<Element<Integer>, Integer> iterativeBinarySearchImpl =
			  new IterativeBinarySearchImpl<>(GenericSearchImpl.ElementToGet.LAST);

		List<Element<Integer>> elementList1 = List.of(
			  new Element<>(6),
			  new Element<>(7),
			  new Element<>(8),
			  new Element<>(100)
		);
		List<Element<Integer>> elementList2 = List.of(
			  new Element<>(7),
			  new Element<>(8),
			  new Element<>(8),
			  new Element<>(8),
			  new Element<>(9),
			  new Element<>(100)
		);
		System.out.println(genericSearchImpl.search(new Element<>(7), elementList1));
		System.out.println(genericSearchImpl.search(new Element<>(8), elementList2));

		System.out.println(iterativeBinarySearchImpl.search(new Element<>(7), elementList1));
		System.out.println(iterativeBinarySearchImpl.search(new Element<>(8), elementList2));

		System.out.println(recursiveBinarySearchImpl.search(new Element<>(7), elementList1));
		System.out.println(recursiveBinarySearchImpl.search(new Element<>(8), elementList2));
	}
}