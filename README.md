# MergeSort++
Mergesort++ a variant of merge sort.

Time Complexity : O(N*logN)

Space Complexity : O(N)

#### Note: My algorithm is almost working in same fashion like [QuadSort](https://github.com/scandum/quadsort) but I visualize the mergesort++ in different way and the approach is slightly different.

Algorithm:
---------------

This algorithm is consist on two major functions:

a) quadrupleSort()

b) merge()

The first function quadrupleSort() will sort the group of 4 elements. The second function merge() will merge all the sorted chunks by using the same fashion like we do in merge sort.

1) IF N = 2^n where N is the input size of array. Then I make the chunks of input array and the chunk size is 4. And then I sort theses chunks by using fixed five number of comparisons.   

2) Once the every chunk is sorted by using that five comparisons technique then I merge all the sorted chunks like in classical merge sort.

3) If N is not equal to 2^n then first I sort the remaider elements [1-3] using simple comparisons.
Let's take an example if N is not equal to 2^n:

N = 19

K(number of quadruples) = N/4 

K=4

Remainder elements = N - 4(K) = 19 - 4*4 = 3

So my input array will divide into below pattern:


3

4

4

4

4

Merging:
----------


![Image of Merging](https://github.com/ameekkhan/ameeqsort/blob/master/Capture.PNG)




First, seperately sort the remainder elements in this above case its size is 3. And then sort all the quadruple's by using the quadrupleSort() function. Once the every quadruple's and remainder elements are sorted. I pass it to merge() function to merge all the quadruples and remainder elements.

Example if N=2^n

N = 16

K = N / 4 => 16/4 => 4 (number of quadruples)

Remainder elements = N - 4(K) => 16 - 16 = 0

So, in this case the number of remainder elements is 0 now the pattern of splitting will look like:

4

4

4

4


Every quadruple will be sorted using quadrupleSort()

Then Merging of all quadruples using merge()


![Image of Merging](https://github.com/ameekkhan/ameeqsort/blob/master/Capture1.PNG)




How  quadrupleSort() function works?
----------------------------

For better understanding of 5 comparisons technique in quadrupleSort() function. 

N=8;
K=N/4; where K is the number of quadruples. So in this case K=2.

a[8] = [8,5,7,6,11,10,9,7]

I imagine every quadruple in matrix form of 2 by 2:

Quadruple#1:

a[0]  *8*      a[1]  *5*

a[2]  *7*      a[3]  *6*


Quaruple#2:

a[4]  *11*   a[5]  *10*	

a[6]  *9*    a[7]  *7*


Now, let's apply 5 comparisons on every quadruple/matrix .

I will first do two *column wise* comparison and then two *row wise* comparison and finally the diagonal comparison thus five fixed number of comparisons are required to sort the 4 values.

In Column wise compare the index 0 and index 2 smaller element will take the position of index 0 then again do column wise comparison between index 1 and index 3 smaller element will swap with index 1. After applying only column wise comparisons on quadruple#1: 

a[0]  *7*      a[1]  *5*

a[2]  *8*      a[3]  *6*

After the completion of column wise, Now apply the row wise comparison between index 0 and index 1 smaller value will take the position of index 0 and then apply row wise comparison between index 2 and index 3 smaller value will take the position of index 2. After applying 2 column and 2 row wise comparisons on quadruple#1: 

a[0]  *5*      a[1]  *7*

a[2]  *6*      a[3]  *8*


Last the diagonal comparison between a[1] and a[2] smaller value will take the postion of index 1. The complete sorted quadruple#1:

a[0]  *5*      a[1]  *6*

a[2]  *7*      a[3]  *8*

So this way every quadruple will be get sorted by using this five comparisons.

After the completion of quadrupleSort():

a[8] = [5,6,7,8,7,9,10,11]

In last the above array will pass to merge() function to merge every quadruples as discussed above.


![Image of Merging](https://github.com/ameekkhan/ameeqsort/blob/master/Capture2.PNG)



This 5 comparison approach is also similar to **Sorting network**  of 4 wires and 5 comparators.


![Image of Merging](https://github.com/ameekkhan/ameeqsort/blob/master/sorting_network.PNG)




How  merge() function works?
----------------------------

After the completion of quadrupleSort() I invokes the merge() function and the merging approach is almost similar to a classical merge sort. The only difference is instead of splitting the array recursively until we get the array size 1 we will stop the splitting when the array size reach to 4 that's base condition in merge() function.


Benchmarking
--------------

All the benchmarks was on Windows 10 64 bit operating system and the source code was compiled on Java JDK 1.8

When I ran all the sorts on the 1024 random integers below are the exection time in nanoseconds with single iteration.

 - Execution Time of MergeSort++ in milli seconds: 735900
 - Execution Time of Timsort in milli seconds: 1200200
 - Execution Time of MergeSort in milli seconds: 810100
 - Execution Time of QuickSort in milli seconds: 540300
 - Execution Time of HeapSort in milli seconds: 912600
 - Execution Time of DualPivotQuickSort in milli seconds: 715200
 - Execution Time of IntroSort in milli seconds: 690200

When I ran the sort on the 1 million random integers below are the exection time in milliseconds with single iteration.

 - Execution Time of MergeSort++ in milli seconds: 115
 - Execution Time of Timsort in milli seconds: 122
 - Execution Time of MergeSort in milli seconds: 125
 - Execution Time of QuickSort in milli seconds: 109
 - Execution Time of HeapSort in milli seconds: 118
 - Execution Time of DualPivotQuickSort in milli seconds: 60
 - Execution Time of IntroSort in milli seconds: 55

There is a MainFile.java where I invoke all the sorts and compare their runtime with all other sorts.

All the sorts implementation are in Java some implementations were taken from the libraries and some of them from the well known academic websites and the link is also given in every indivisual sort code.
