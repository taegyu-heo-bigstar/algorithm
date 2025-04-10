insertion sort
==============

### feature
1. stable
2. if data is sorted, comparison O(n), swap O(1)
3. if data is reverse sorted, comparison and swap O(n^2)
4. in-place

### algorithm
increase the index from 0.
compare current index's value and previous index's value.
if current greater than previous, swap the values.

### pseudo code
    n = array.length
    int i, j    //(0 <= i, j <= n - 1)
      
    loop i from 0 to n - 1
    {
        loop j from i to j > 0 or array[j] bigger than array[j-1])
        {
          swap(array, j, j-1)    //swap array's index j and j-1
        }
    }
            
