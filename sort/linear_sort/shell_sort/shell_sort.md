shell sort
==============

# feature
1. similar to insertion sort
2. insertion sort compare current index and current index minus 1
3. shell sort compare current index and current index minus h<sub>i</sub>
4. h<sub>i</sub> is the i-th element of the h-sequence
5. So, sorting efficiency depends on the h-sequence's recursive formula
6. if h<sub>i</sub> is big(start step), short array sorting
7. if h<sub>i</sub> is small(last step), total array is partially sorted.
---
<br/>
   
# algorithm   
set h-sequence start from 1.
find the largest h-sequence value not greater than the array length.
iterate h-sequence in revcerse order and perform insertion sort on elements spaced h<sub>i</sub> apart
remember. h<sub>i</sub> shell sort is same to insertion sort.
generally used h-sequence making algorithm is "h<sub>i</sub> = 3 * h<sub>i-1</sub> + 1"
---
<br/>

# pseudo code
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
            
