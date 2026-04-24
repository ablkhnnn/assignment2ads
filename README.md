# ads-assignment2

This assignment consists of 5 sections totaling to **25 points**.

In this assignment you are not allowed to use Java library classes like `List, ArrayList, LinkedList, Stack, Queue, PriorityQueue`.
Instead, you are to implement your own versions of the classes.

#### Defense questions will be of the following type:
1. Write and run a piece of code to test method `foo()`?
2. Explain the algorithm of method `foo()` using paper and pen?
3. What is the running time of method `foo()` and why?

### Section 1 - Resizable Array (**5 points**)

1. Implement `IntArray`, a resizable array of integers, according to the API specified in the `IntArray` class. (**3 points**)
2. In `ArrayIntersection` class, implement `intersect()` method  that accepts two integer arrays `A` and `B` as arguments and returns an array of *intersection* of `A` and `B`. 
Each item in the resultant array must be unique. The items in the resultant array may be in any order. (**2 points**)
   
### Section 2 - LinkedList (**5 points**)

1. Implement `IntList` class, a singly linked list of integers. (**3 points**)
2. Implement the `reverse()` methods that reverses the `IntList` in place, using an iterative or a recursive approach. (**2 points**)

### Section 3 - Stack (**5 points**)
1. Implement `StackArray` using `IntArray` (**2 points**)
2. Implement `StackQueue` using only two instances of `QueueList` (**3 points**)

### Section 4 - Queue (**5 points**)
1. Implement `QueueList` using `IntList` (**2 points**)
2. Implement `QueueStack` using only two instances of `StackArray` (**3 points**)

### Section 5 - Heap (**5 points**)
1. Implement `MinHeap` using `IntArray`. (**3 points**)
2. Sort any array of integers in **descending** order using the `MinHeap`. (**2 points**)
