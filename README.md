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


Every quadruple will be get sorted using quadrupleSort()

Then Merging of all quadruples using merge()


![Image of Merging](https://github.com/ameekkhan/ameeqsort/blob/master/Capture1.PNG)




How  quadrupleSort() function works?
----------------------------

To easily understand or remember the 5 comparisons technique that I am using in quadrupleSort() function. 

Let’s say N=8; N is the size of input;

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

After the completion of column wise, Now apply the row wise comparison between index 0 and index 1 smaller value will take the position of index 0 and then apply row wise comparison between index 2 and index 3 smaller value will take the position of index 2. After applying 2 column and 2 row wise comparisons our quadruple#1: 

a[0]  *5*      a[1]  *7*

a[2]  *6*      a[3]  *8*


Last the diagonal comparison between a[1] and a[2] smaller value will take the postion of index 1. The complete sorted quadruple:

a[0]  *5*      a[1]  *6*

a[2]  *7*      a[3]  *8*

So this every quadruple will be get sorted by using this five comparisons.

After the completion of quadrupleSort():

a[8] = [5,6,7,8,7,9,10,11]

In last the above array will pass to merge() function to merge every quadruples as discussed above.


![Image of Merging](https://github.com/ameekkhan/ameeqsort/blob/master/Capture2.PNG)



This 5 comparison approach is also similar to **Sorting network**  of 4 wires and 5 comparators.


![Image of Merging](https://github.com/ameekkhan/ameeqsort/blob/master/sorting_network.PNG)



I hope you like my *sort*
