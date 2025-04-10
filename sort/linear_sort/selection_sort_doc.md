selection sort
==============

### feature
    1. stable
    2. data state does't affect execution time
    3. use a small memory

### algorithm
Move an index from a current index to a last index and find minimum value.
Swap the minimum value index with the current value index after traversing to the last index.

### pseudo code
"""
n = array.length
int i, j, minimum_value_of_index    //(0 <= i, j <= n - 1)
    
loop i from 0 to n - 1
{
    minimum_value_of_index = i
    loop j from i to n - 1
    {
        if (array[j] < array[minimum_value_or_index)
            minimum_value_of_index = j
    }
    swap(array, i, minimum_value_of_index)    //swap array's index i and minimum_value_or_index
}
"""
            
