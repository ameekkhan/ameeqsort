# ameeqsort
Ameeq Sort a new sorting algorithm.

Time Complexity : O(N*logN)

Space Complexity : O(N)

It is a variant of merge sort with different merge strategy.

Algorithm:
---------------

This algorithm is consist on two major functions:

a) quadrupleSort()

b) merge()

The first function quadrupleSort() will sort the group of 4 elements. The second function merge() will merge all the sorted chunks/groups by using the same fashion like we do in merge sort.

1) IF N = 2^n where N is the input size of array. Then I make the chunks of input array and the chunk size is 4 then I sort theses chunks by using fixed five number of comparisons.   

2) Once the every chunk bieng sorted by using that five comparisons technique then I merge all the sorted chunks like in classical merge sort.

3) If N is not equal to 2^n then first I sort the remaider elements [1-3] and if N > 4 then I will be left with the number of elements which will be divisible by 4.

Let's take an example:

N = 19

K(number of quadruples) = N/4 

K=3

Remainder elements = N - 4(K) = 15 - 4*3 = 3

So my input array will divide into below pattern:


3

4

4

4

4

Merging:
![Image of Merging](https://github.com/ameekkhan/ameeqsort/blob/master/Capture.PNG)
















First, seperately sort the remainder elements its size is 3. And then sort all the quadruple's by using the quadrupleSort() function. Once the every quadruple's and remainder elements are sorted then pass this partially sorted input array to merge() function to merge all the quadruples and remainder elements.

I hope you like my *sort*
