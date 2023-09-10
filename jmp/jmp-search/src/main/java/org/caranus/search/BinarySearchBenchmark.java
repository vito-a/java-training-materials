package org.caranus.search;

import org.caranus.search.binary.IterativeBinarySearchImpl;
import org.caranus.search.binary.RecursiveBinarySearchImpl;
import org.caranus.search.generic.GenericSearchImpl;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BinarySearchBenchmark {

	@State(Scope.Thread)
	public static class SearchState {
		List<Element<Integer>> elementList;
		Element<Integer> elementToFind = new Element<>(42);

		@Setup(Level.Trial)
		public void setup() {
			elementList = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				elementList.add(new Element<>(i));
			}
		}
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void testRecursiveBinarySearch(SearchState state) {
		RecursiveBinarySearchImpl<Element<Integer>, Integer> search =
			  new RecursiveBinarySearchImpl<>(GenericSearchImpl.ElementToGet.ANY);
		search.searchElement(state.elementToFind, state.elementList, 0, state.elementList.size());
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	public void testIterativeBinarySearch(SearchState state) {
		IterativeBinarySearchImpl<Element<Integer>, Integer> search =
			  new IterativeBinarySearchImpl<>(GenericSearchImpl.ElementToGet.ANY);
		search.searchElement(state.elementToFind, state.elementList, 0, state.elementList.size());
	}

	public static void main(String[] args) throws RunnerException {
		Options options = new OptionsBuilder()
			  .include(BinarySearchBenchmark.class.getSimpleName())
			  .forks(1)
			  .build();

		new Runner(options).run();
	}
}
