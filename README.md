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

1) IF N = 2^n where N is the input size of array. Then I make the chunks of input array and the chunk size is 4. And then I sort theses chunks by using fixed five number of comparisons.   

2) Once the every chunk is sorted by using that five comparisons technique then I merge all the sorted chunks like in classical merge sort.

3) If N is not equal to 2^n then first I sort the remaider elements [1-3] using basic comparisons. And if N > 4 then I will be left with the number of elements which will be divisible by 4.

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
















First, seperately sort the remainder elements in this above case its size is 3. And then sort all the quadruple's by using the quadrupleSort() function. Once the every quadruple's and remainder elements are sorted then pass this partially sorted input array to merge() function to merge all the quadruples and remainder elements.

Example if N=2^n

N = 16

K = N / 4 => 16/4 => 4 (number of quadruples)

Remainder elements = N - 4(K) => 16 - 16 = 0

So, in this case the number of remainder elements is 0 now the pattern of splitting will look like:

4

4

4

4


First, every quadruple will be get sorted using quadrupleSort()

Then Merging of all quadruples using merge()


![Image of Merging](https://github.com/ameekkhan/ameeqsort/blob/master/Capture1.PNG)




How  quadrupleSort() works?
----------------------------

To easily understand or remember the 5 comparisons technique that I am using in quadrupleSort() function. 

Let’s say N=8; N is the size of input;

K=N/4; where K is the number of quadruples. So in this case K=2.

a[8] = [4,3,2,1,11,10,9,7]

I imagine every quadruple in matrix form of 2 by 2:

Quadruple#1:

a[0]  *4*      a[1]  *3*

a[2]  *2*      a[3]  *1*


Quaruple#2:

a[4]  *11*   a[5]  *10*	

a[6]  *9*    a[7]  *7*







is similar to **Sorting network**  of 4 wires and 5 comparators. 



I hope you like my *sort*
