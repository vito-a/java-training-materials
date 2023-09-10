# Binary Search Implementations Comparison

This project compares the performance of two binary search implementations: RecursiveBinarySearchImpl and IterativeBinarySearchImpl. It includes unit tests and benchmarks to evaluate their effectiveness in different scenarios.

## Unit Tests

Unit tests have been created to verify the correctness of both implementations. The tests ensure that the algorithms return the correct index of the searched element.

## Benchmarks

Benchmarks have been conducted using the Java Microbenchmarking Harness (JMH) to measure the performance of both implementations. The benchmarks provide insights into the time taken by each implementation to search for an element in a large list.

### Benchmark Results

The benchmark results indicate that:

- RecursiveBinarySearchImpl tends to have slightly longer execution times compared to IterativeBinarySearchImpl.
- In scenarios where the list size is small, the performance difference may not be significant.
- In scenarios where the list size is large, IterativeBinarySearchImpl demonstrates better performance.

## When to Use Each Implementation

- **RecursiveBinarySearchImpl**:
  - Suitable for small-sized lists where the difference in execution time is negligible.
  - Offers a more straightforward and intuitive implementation.
  - Works well when the list size is moderate and the simplicity of the code is a priority.

- **IterativeBinarySearchImpl**:
  - Recommended for large-sized lists where performance is critical.
  - More efficient for very large lists due to its iterative nature.
  - Provides better scalability when searching through extensive datasets.

Consider the size of your dataset and your performance requirements when choosing between these implementations.
