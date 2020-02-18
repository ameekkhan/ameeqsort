# Ameeqsort
Ameeq Sort a new sorting algorithm (n*logn)

Algorithm:
1.	If N is the multiple of 4 make the group of 4 elements apply that 5 comparison technique.
2.	If N is not multiple of 4 then take N % 4 = REMAINDER; subtract that remainder from N. We will get the new set which will be the multiple of 4 N1=N-REMAINDER. Apply that 5 comparison technique on N1 or apply step 1. 
3.	Then sort the remainder elements to sort these elements maximum the remainder will be 3 so I am using simple IF-ELSE to sort remainder elements.
4.	Then merge all the sorted quadruples and remainder elements like we do in Merge Sort.
