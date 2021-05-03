package sorts.comparison.com;

import java.util.*;

/*
 
  Implemenatation Taken from: https://www.cs.waikato.ac.nz/~bernhard/317/source/IntroSort.java
  
  */

public class IntroSort 
{
  /*
   * Class Variables
   */
  private static int size_threshold = 16;

  /*
   * Public interface
   */
  public static void sort(int[] a)
    {
      introsort_loop(a, 0, a.length, 2*floor_lg(a.length));
    }

  public static void sort(int[] a, int begin, int end)
    {
      if (begin < end)
	  {
	    introsort_loop(a, begin, end, 2*floor_lg(end-begin));
	  }
    }

  /*
   * Quicksort algorithm modified for Introsort
   */
  private static void introsort_loop (int[] a, int lo, int hi, int depth_limit)
    {
      while (hi-lo > size_threshold)
	  {
	    if (depth_limit == 0)
		{
		  heapsort(a, lo, hi);
		  return;
		}
	    depth_limit=depth_limit-1;
	    int p=partition(a, lo, hi, medianof3(a, lo, lo+((hi-lo)/2)+1, hi-1));
	    introsort_loop(a, p, hi, depth_limit);
	    hi=p;
	  }
      insertionsort(a, lo, hi);
    }

  private static int partition(int[] a, int lo, int hi, int x)
    {
      int i=lo, j=hi;
      while (true)
	  {
	    while (a[i] < x) i++;
	    j=j-1;
	    while (x < a[j]) j=j-1;
	    if(!(i < j))
	      return i;
	    exchange(a,i,j);
	    i++;
	  }
    }

  private static int medianof3(int[] a, int lo, int mid, int hi)
    {
      if (a[mid] < a[lo])
	  {
            if (a[hi] < a[mid])
	      return a[mid];
            else
		{
		  if (a[hi] < a[lo])
		    return a[hi];
		  else
		    return a[lo];
		}
	  }
      else
	  {
            if (a[hi] < a[mid])
		{
		  if (a[hi] < a[lo])
		    return a[lo];
		  else
		    return a[hi];
		}
            else
	      return a[mid];
	  }
    }

  /*
   * Heapsort algorithm
   */
  private static void heapsort(int[] a, int lo, int hi)
    {
      int n = hi-lo;
      for (int i=n/2; i>=1; i=i-1)
	  {
	    downheap(a,i,n,lo);
	  }
      for (int i=n; i>1; i=i-1)
	  {
	    exchange(a,lo,lo+i-1);
	    downheap(a,1,i-1,lo);
	  }
    }

  private static void downheap(int[] a, int i, int n, int lo)
    {
      int d = a[lo+i-1];
      int child;
      while (i<=n/2)
	  {
	    child = 2*i;
	    if (child < n && a[lo+child-1] < a[lo+child])
		{
		  child++;
		}
	    if (d >= a[lo+child-1]) break;
	    a[lo+i-1] = a[lo+child-1];
	    i = child;
	  }
      a[lo+i-1] = d;
    }

  /*
   * Insertion sort algorithm
   */
  private static void insertionsort(int[] a, int lo, int hi)
    {
      int i,j;
      int t;
      for (i=lo; i < hi; i++)
	  {
            j=i;
	    t = a[i];
	    while(j!=lo && t < a[j-1])
		{
		  a[j] = a[j-1];
		  j--;
		}
	    a[j] = t;
	  }
    }

  /*
   * Common methods for all algorithms
   */
  private static void exchange(int[] a, int i, int j)
    {
      int t=a[i];
      a[i]=a[j];
      a[j]=t;
    }

  private static int floor_lg(int a)
    {
      return (int)(Math.floor(Math.log(a)/Math.log(2)));
    }


	public static void main(int[] numbers) {
		
	//	int[] arr = {728, 742, 55, 586, 376, 50, 890, 4, 67, 1021, 380, 752, 281, 17, 275, 72, 828, 86, 613, 600, 536, 874, 798, 457, 737, 771, 520, 366, 729, 295, 546, 646, 604, 726, 47, 653, 37, 695, 90, 691, 171, 929, 88, 179, 471, 274, 429, 331, 1001, 231, 687, 797, 156, 56, 305, 700, 220, 562, 425, 993, 547, 482, 530, 363, 357, 151, 176, 41, 662, 1004, 155, 850, 760, 69, 507, 446, 873, 704, 811, 73, 197, 461, 499, 21, 944, 74, 794, 103, 935, 829, 945, 757, 135, 372, 112, 845, 393, 236, 936, 853, 628, 333, 617, 755, 97, 565, 979, 410, 140, 124, 161, 181, 437, 1015, 238, 921, 51, 715, 469, 529, 978, 365, 985, 456, 52, 460, 94, 876, 954, 908, 901, 895, 855, 972, 263, 917, 217, 958, 561, 677, 849, 390, 290, 618, 532, 310, 270, 769, 568, 321, 655, 136, 601, 249, 162, 787, 452, 285, 255, 610, 910, 566, 352, 578, 803, 502, 938, 201, 440, 919, 219, 166, 923, 633, 998, 505, 589, 592, 915, 669, 679, 128, 976, 330, 510, 969, 95, 42, 65, 152, 731, 7, 751, 838, 840, 53, 77, 555, 99, 122, 36, 288, 518, 747, 587, 404, 473, 168, 911, 375, 286, 637, 195, 309, 716, 454, 289, 213, 997, 373, 434, 391, 476, 475, 580, 243, 264, 183, 539, 540, 964, 671, 367, 147, 194, 150, 916, 528, 105, 860, 39, 261, 311, 990, 71, 551, 123, 492, 11, 882, 730, 900, 652, 314, 590, 594, 159, 609, 864, 645, 10, 872, 268, 337, 1020, 313, 665, 79, 165, 418, 535, 298, 670, 478, 664, 877, 577, 111, 292, 488, 975, 668, 950, 127, 118, 608, 491, 98, 1023, 801, 107, 121, 549, 378, 117, 196, 385, 312, 736, 885, 526, 48, 192, 649, 819, 271, 144, 272, 871, 846, 776, 537, 773, 142, 433, 624, 763, 346, 61, 947, 834, 132, 205, 815, 189, 705, 781, 466, 116, 369, 355, 634, 102, 541, 970, 361, 912, 149, 889, 381, 442, 630, 635, 827, 199, 377, 991, 926, 472, 823, 575, 300, 260, 206, 538, 772, 78, 857, 632, 710, 399, 137, 406, 708, 1, 448, 240, 438, 334, 753, 784, 1000, 720, 415, 598, 1007, 190, 569, 269, 1011, 878, 603, 411, 133, 788, 995, 961, 0, 660, 480, 215, 674, 543, 847, 297, 498, 207, 612, 92, 786, 46, 622, 642, 22, 865, 754, 167, 859, 960, 1009, 759, 500, 224, 636, 982, 154, 322, 925, 862, 81, 209, 597, 516, 8, 342, 519, 768, 521, 212, 766, 884, 414, 785, 49, 719, 397, 115, 241, 948, 965, 14, 246, 750, 666, 807, 905, 40, 867, 405, 495, 441, 182, 247, 417, 542, 680, 579, 350, 842, 323, 430, 818, 744, 717, 683, 681, 175, 13, 32, 869, 616, 254, 631, 57, 262, 25, 508, 685, 341, 392, 87, 344, 1003, 160, 599, 325, 174, 426, 235, 62, 487, 775, 930, 193, 368, 522, 640, 675, 534, 531, 279, 963, 725, 291, 902, 533, 332, 458, 66, 214, 43, 419, 306, 138, 574, 104, 9, 396, 647, 651, 591, 28, 403, 400, 407, 743, 265, 12, 447, 557, 707, 672, 661, 696, 185, 347, 734, 464, 711, 428, 896, 282, 371, 83, 93, 718, 783, 761, 388, 572, 256, 338, 638, 888, 879, 673, 887, 832, 858, 992, 817, 129, 762, 994, 401, 170, 329, 625, 940, 234, 554, 813, 712, 421, 524, 237, 573, 702, 114, 699, 971, 501, 85, 423, 854, 301, 267, 595, 1006, 951, 512, 108, 481, 280, 362, 382, 383, 427, 59, 444, 724, 164, 844, 914, 903, 741, 253, 607, 886, 304, 880, 697, 125, 294, 420, 841, 356, 60, 467, 34, 822, 1002, 770, 698, 489, 973, 424, 198, 738, 308, 284, 409, 924, 814, 359, 131, 89, 996, 1022, 676, 5, 701, 740, 23, 852, 250, 525, 203, 804, 883, 379, 553, 659, 571, 134, 756, 812, 232, 326, 648, 868, 605, 19, 639, 474, 732, 68, 928, 38, 439, 302, 223, 490, 157, 693, 303, 922, 146, 621, 643, 374, 721, 703, 739, 942, 789, 904, 395, 658, 29, 650, 927, 143, 517, 233, 962, 909, 100, 445, 544, 690, 694, 800, 623, 984, 777, 239, 620, 141, 387, 33, 145, 596, 75, 2, 226, 20, 559, 412, 606, 907, 315, 582, 746, 906, 358, 451, 58, 225, 84, 657, 106, 952, 949, 556, 340, 186, 27, 109, 307, 765, 509, 45, 967, 30, 764, 497, 796, 977, 810, 825, 550, 782, 805, 349, 191, 793, 327, 44, 780, 506, 54, 296, 682, 453, 479, 931, 939, 799, 173, 723, 455, 767, 287, 353, 527, 897, 1013, 188, 6, 324, 548, 463, 941, 180, 774, 959, 242, 218, 468, 343, 148, 130, 1018, 345, 576, 626, 778, 802, 619, 251, 934, 422, 435, 644, 504, 745, 398, 913, 1014, 317, 1016, 629, 364, 866, 983, 918, 126, 981, 758, 515, 656, 258, 252, 614, 593, 611, 259, 494, 588, 891, 35, 486, 113, 692, 416, 733, 248, 3, 999, 953, 943, 920, 563, 684, 545, 485, 843, 602, 244, 408, 158, 483, 470, 722, 581, 856, 266, 932, 82, 713, 881, 974, 119, 667, 792, 169, 18, 484, 230, 749, 946, 222, 893, 689, 228, 709, 503, 552, 163, 1010, 91, 615, 933, 320, 227, 988, 848, 688, 15, 389, 511, 64, 210, 384, 560, 835, 319, 348, 245, 24, 1005, 413, 820, 293, 477, 567, 892, 861, 790, 273, 229, 211, 830, 735, 714, 318, 120, 221, 875, 459, 80, 514, 641, 493, 139, 1019, 184, 806, 335, 957, 299, 370, 863, 465, 986, 1012, 432, 200, 663, 831, 966, 989, 795, 899, 894, 654, 177, 394, 276, 1008, 980, 360, 402, 277, 584, 678, 836, 564, 627, 779, 110, 16, 96, 339, 987, 816, 937, 821, 808, 791, 386, 968, 31, 837, 351, 436, 431, 558, 1017, 513, 26, 278, 204, 824, 748, 257, 63, 202, 216, 328, 178, 826, 851, 809, 187, 839, 70, 585, 443, 1024, 354, 727, 316, 870, 955, 956, 283, 833, 496, 583, 523, 686, 101, 706, 336, 898, 450, 570, 76, 172, 462, 153, 449};
	//	long startTime = System.nanoTime();
		//IntroSort.sort(numbers); 
	//	long endTime = System.nanoTime();
//		long duration = (endTime - startTime);
//		System.out.println(duration);
	//	System.out.println(arr);

}




	
	}
