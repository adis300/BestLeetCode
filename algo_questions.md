1. **Queue with two stacks.** Implement a queue with two stacks so that each queue operations takes a constant amortized number of stack operations.
*Hint: If you push elements onto a stack and then pop them all, they appear in reverse order. If you
repeat this process, they're now back in order.*

2. **Stack with max.** Create a data structure that efficiently supports the stack operations (push and pop) and also a return-the-maximum operation. Assume the elements are reals numbers so that you can compare them.
*Hint: Use two stacks, one to store all of the items and a second stack to store the maximums.*

3. **Java generics.** Explain why Java prohibits generic array creation.
*Hint: to start, you need to understand that Java arrays are covariant but Java generics are not: that is, String[] is a subtype of Object[], but Stack`<String>` is not a subtype of Stack`<Object>`*.

4. **Social network connectivity.** Given a social network containing n members and a log file containing m timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be mlog⁡n or better and use extra space proportional to n.
*Hint: union−find.*

5. **Union-find with specific canonical element.** Add a method find() to the union-find data type so that find(i) returns the largest element in the connected component containing i. The operations, union(), connected(), and find() should all take logarithmic time or better.n For example, if one of the connected components is {1,2,6,9}, then the find() method should return 9 for each of the four elements in the connected components.
*Hint: maintain an extra array to the weighted quick-union data structure that stores for each root i the large element
in the connected component containing i.*

6. **Successor with delete.** Given a set of N integers S={0,1,...,N−1} and a sequence of requests of the following form:

    - Remove x from S
    - Find the successor of x: the smallest y in S such that y≥x. Design a data type so that all operations (except construction) should take logarithmic time or better.

7. **3-SUM in quadratic time.** Design an algorithm for the 3-SUM problem that takes time proportional to n2 in the worst case. You may assume that you can sort the n integers in time proportional to n2 or better.
*Hint: given an integer x and a sorted array a[] of n distinct integers, design a linear-time algorithm to determine if there
exists two distinct indices i and j such that a[i]+a[j]==x.*

8. **Search in a bitonic array.** An array is bitonic if it is comprised of an increasing sequence of integers followed immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of n distinct integer values, determines whether a given integer is in the array.
    - Standard version: Use ∼3lg⁡n compares in the worst case.
    - Signing bonus: Use ∼2lg⁡n compares in the worst case (and prove that no algorithm can guarantee to perform fewer than ∼2lg⁡n compares in the worst case).
    
    *Hints: Standard version. First, find the maximum integer using ∼1lg⁡n compares—this divides the array into the increasing and decreasing pieces. Signing bonus. Do it without finding the maximum integer.*
    
9. **Egg drop.** Suppose that you have an n-story building (with floors 1 through n) and plenty of eggs. An egg breaks if it is dropped from floor T or higher and does not break otherwise. Your goal is to devise a strategy to determine the value of T given the following limitations on the number of eggs and tosses:
    - Version 0: 1 egg, ≤T tosses.
    - Version 1: ∼1lg⁡n eggs and ∼1lg⁡n tosses.
    - Version 2: ∼lg⁡T eggs and ∼2lg⁡T tosses.
    - Version 3: 2 eggs and ∼2n tosses.
    - Version 4: 2 eggs and ≤cT tosses for some fixed constant c.
    
    *Hints:
    - Version 0: sequential search.
    - Version 1: binary search.
    - Version 2: find an interval containing T of size ≤2T, then do binary search.
    - Version 3: find an interval of size n, then do sequential search. Note: can be improved to ∼2n tosses.
    - Version 4: 1+2+3+…+t∼12t2. Aim for c=22.*
    
10. **Intersection of two sets.** Given two arrays a[] and b[], each containing n distinct 2D points in the plane, design a subquadratic algorithm to count the number of points that are contained both in array a[] and array b[].
*Hint: shellsort (or any other subquadratic sort).*

11. **Permutation.** Given two integer arrays of size n, design a subquadratic algorithm to determine whether one is a permutation of the other. That is, do they contain exactly the same entries but, possibly, in a different order.
*Hint: sort both arrays.*

12. **Dutch national flag.** Given an array of n buckets, each containing a red, white, or blue pebble, sort them by color. The allowed operations are:
    - swap(i,j): swap the pebble in bucket i with the pebble in bucket j.
    - color(i): color of pebble in bucket i.
    
    The performance requirements are as follows:

    - At most n calls to color().
    - At most n calls to swap().
    - Constant extra space.
   
13.  A string s is a circular rotation of a string t if it matches when the characters are circularly shifted by any number of positions; e.g., ACTGACG is a circular shift of TGACGAC, and vice versa. Detecting this condition is important in the study of genomic sequences. Write a program that checks whether two given strings s and t are circular shifts of one another. 
*Solution: (s.length() == t.length()) && (s.concat(s).indexOf(t) >= 0)*

14. What does the following recursive function return?

    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N/2);
        String b = s.substring(N/2, N);
        return mystery(b) + mystery(a);
    }
*Solution : Reverse of string*  

15. Write a stack client Parentheses.java that reads in sequence of left and right parentheses, braces, and brackets from standard input and uses a stack to determine whether the sequence is properly balanced. For example, your program should print true for [()]{}{[()()]()} and false for [(])
 
15. **Merging with smaller auxiliary array.** Suppose that the subarray a[0] to a[n−1] is sorted and the subarray a[n] to a[2∗n−1] is sorted. How can you merge the two subarrays so that a[0] to a[2∗n−1] is sorted using an auxiliary array of length n (instead of 2n)?
*Hint: copy only the left half into the auxiliary array.*  

16. **Counting inversions.** An inversion in an array a[] is a pair of entries a[i] and a[j] such that `i<j` but `a[i]>a[j]`. Given an array, design a linearithmic algorithm to count the number of inversions.
*Hint: count while mergesorting.*

17. **Shuffling a linked list.** Given a singly-linked list containing n items, rearrange the items uniformly at random. Your algorithm should consume a logarithmic (or constant) amount of extra memory and run in time proportional to nlog⁡n in the worst case. 
*Hint: design a linear-time subroutine that can take two uniformly shuffled linked lists of sizes n1 and n2 and combined them into a uniformly shuffled linked lists of size n1+n2.*
 
18. http://stackoverflow.com/questions/40173020/sort-list-of-tuples-based-on-second-element-while-alternating-over-third-element  

19. **Nuts and bolts.** A disorganized carpenter has a mixed pile of n nuts and n bolts. The goal is to find the corresponding pairs of nuts and bolts. Each nut fits exactly one bolt and each bolt fits exactly one nut. By fitting a nut and a bolt together, the carpenter can see which one is bigger (but the carpenter cannot compare two nuts or two bolts directly). Design an algorithm for the problem that uses nlog⁡n compares (probabilistically).
*Hint: modify the quicksort partitioning part of quicksort.*  

20. **Selection in two sorted arrays.** Given two sorted arrays a[] and b[], of sizes n1 and n2, respectively, design an algorithm to find the kth largest key. The order of growth of the worst case running time of your algorithm should be log⁡n, where n=n1+n2.

    - Version 1: n1=n2 and k=n/2
    - Version 2: k=n/2
    - Version 3: no restrictions
    
    *Hint: there are two basic approaches.

    Approach A: Compute the median in a[] and the median in b[]. Recur in a subproblem of roughly half the size.
    Approach B: Design a constant-time algorithm to determine whether a[i] is the kth largest key. Use this subroutine and binary search.Dealing with corner cases can be tricky.*  
    
21. **Decimal dominants.** Given an array with n keys, design an algorithm to find all values that occur more than n/10 times. The expected running time of your algorithm should be linear.
*Hint: determine the (n/10)th largest key using quickselect and check if it occurs more than n/10 times.
Alternate solution hint: use 9 counters.*

22. **Dynamic median.** Design a data type that supports insert in logarithmic time, find-the-median in constant time, and remove-the-median in logarithmic time.
*Hint: maintain two binary heaps, one that is max-oriented and one that is min-oriented.*

23. **Randomized priority queue.** Describe how to add the methods sample() and delRandom() to our binary heap implementation. The two methods return a key that is chosen uniformly at random among the remaining keys, with the latter method also removing that key. The sample() method should take constant time; the delRandom() method should take logarithmic time. Do not worry about resizing the underlying array.

24. **Taxicab numbers.** A taxicab number is an integer that can be expressed as the sum of two cubes of integers in two different ways: a3+b3=c3+d3. For example, 1729=93+103=13+123. Design an algorithm to find all taxicab numbers with a, b, c, and d less than n.

    Version 1: Use time proportional to n2log⁡n and space proportional to n2.
    Version 2: Use time proportional to n2log⁡n and space proportional to n. 
*Hints:

    Version 1: Form the sums a3+b3 and sort.
    Version 2: Use a min-oriented priority queue with n items.*
    
25. **Check if a binary tree is a BST.** Given a binary tree where each Node contains a key, determine whether it is a binary search tree. Use extra space proportional to the height of the tree.
*Hint: design a recursive function isBST(Nodex,Keymin,Keymax) that determines whether x is the root of a binary search tree with all keys between min and max.*

26. **Inorder traversal with constant extra space.** Design an algorithm to perform an inorder traversal of a binary search tree using only a constant amount of extra space.
*Hint: you may modify the BST during the traversal provided you restore it upon completion.*

27. **Web tracking.** Suppose that you are tracking n web sites and m users and you want to support the following API:

    User visits a website.
    How many times has a given user visited a given site? 
    What data structure or data structures would you use?
*Hint: maintain a symbol table of symbol tables.*

28. **Red–black BST with no extra memory.** Describe how to save the memory for storing the color information when implementing a red–black BST. 
*Hint: modify the structure of the BST to encode the color information.*

29. **Document search.** Design an algorithm that takes a sequence of n document words and a sequence of m query words and find the shortest interval in which the m query words appear in the document in the order given. The length of an interval is the number of words in that interval.
*Hint: for each word, maintain a sorted list of the indices in the document in which that word appears. Scan through the sorted lists of the query words in a judicious manner.*

30. **Generalized queue.** Design a generalized queue data type that supports all of the following operations in logarithmic time (or better) in the worst case.

    - Create an empty data structure.
    - Append an item to the end of the queue.
    - Remove an item from the front of the queue.
    - Return the ith item in the queue.
    - Remove the ith item from the queue.  
  
  *Hint: create a red–black BST where the keys are integers and the values are the items such that the ith largest integer key in the red–black BST corresponds to the ith item in the queue.*  
31. **4-SUM.** Given an array a[] of n integers, the 4-SUM problem is to determine if there exist distinct indices i, j, k, and l such that a[i]+a[j]=a[k]+a[l]. Design an algorithm for the 4-SUM problem that takes time proportional to n2 (under suitable technical assumptions).  
*Hint: create a hash table with n2 key-value pairs.*  
32. **Hashing with wrong hashCode() or equals().** Suppose that you implement a data type OlympicAthlete for use in a java.util.HashMap.

    - Describe what happens if you override hashCode() but not equals().
    - Describe what happens if you override equals() but not hashCode().
    - Describe what happens if you override hashCode() but implement public boolean equals(OlympicAthlete that) instead of public boolean equals(Object that).   
33. **What indexing technique would you use to store Prime numbers?** If by int itself lot of sparse distribution. Can we mod it by some number and use linear probing ?  
    