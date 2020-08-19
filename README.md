# ameeqsort
Ameeq Sort a new sorting algorithm (N*logN)

It is a variant of merge sort with different merge strategy.

Algorithm Steps:

1) IF N = 2^n where N is the input size of array. Then I make the chunks of input array the chunk size is 4 and then I sort theses chunks by using five fixed number of comparisons.
For Example :
  
                IF N= 16 then the Number of chunks will be 4 because,
                K(number of chunks) = N/4 => 16/4 => 4
                
2) Once the every chunk bieng sorted then I merge all the sorted chunks by using merge sort technique.
