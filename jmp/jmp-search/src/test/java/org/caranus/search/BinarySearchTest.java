package org.caranus.search;

import org.caranus.search.binary.IterativeBinarySearchImpl;
import org.caranus.search.binary.RecursiveBinarySearchImpl;
import org.caranus.search.generic.GenericElement;
import org.caranus.search.generic.GenericSearchImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;


public class BinarySearchTest {
    @Test
    public void testRecursiveBinarySearch() {
        RecursiveBinarySearchImpl<GenericElement<Integer>, Integer> search = new RecursiveBinarySearchImpl<>(GenericSearchImpl.ElementToGet.ANY);
        Element<Integer> elementToFind = new Element<>(42);
        List<GenericElement<Integer>> elementList = List.of(
              new Element<>(10),
              new Element<>(20),
              new Element<>(30),
              elementToFind,
              new Element<>(50)
        );

        int result = search.searchElement(elementToFind, elementList, 0, elementList.size());
        assertEquals(3, result); // Expecting index 3
    }

    @Test
    public void testIterativeBinarySearch() {
        IterativeBinarySearchImpl<GenericElement<Integer>, Integer> search = new IterativeBinarySearchImpl<>(GenericSearchImpl.ElementToGet.ANY);
        Element<Integer> elementToFind = new Element<>(42);
        List<GenericElement<Integer>> elementList = List.of(
              new Element<>(10),
              new Element<>(20),
              new Element<>(30),
              elementToFind,
              new Element<>(50)
        );

        int result = search.searchElement(elementToFind, elementList, 0, elementList.size());
        assertEquals(3, result); // Expecting index 3
    }
}
