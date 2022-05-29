
# Problem:  Find Maximum and minimum of an array using minimum number of comparisons

### Solution :


**Pair DataStructure** :

static class pair {
int max;
int min;
}

## 1. Brute force:  (Simple Linear Search) 

 1. Take two variables min & max;

 2. if array length is one then:
         min == max = arr[0]
        return first element as min and max.

 3. if array length is more than one:
        min = minimum of first two.
        max = maximum of first two.

4. Run a loop from i = 2 to n:
        if arr[i] > max:
            max = arr[i]
        //else if used intentionally here
        else if arr[i] < min: 
            min = arr[i]
            
**Complextiy** : O(n)
**Comparisons** : 1 + 2(n -2) in worst case (if all elements sorted in decreasing order) 
                        and 1 + n - 2 Comparisons in Best case
**Space** : O(1)


###################################################### Mehtod 2 #####################################################


## (Tournament Method) : Recursive Solution

1. Take two variables **max** and **min**.

2. if arraylength == 1:
    return element as both max and min

3. else if arraylength == 2:
    //one comparison to determine max and min
    return that pair

4. else:
    recursive call for max and min of left half
    recursive call for max and min of right half

    one comparison determine true max of the two candidates.
    one comparison determine true min of two candidates.

    return the pair of max and min




**Complextiy**: O(n)
**Space**: O(log n) // same as a binary tree

**Comparisons**:

Mathematical formula:

  T(n) = T(floor(n/2)) + T(ceil(n/2)) + 2  
  T(2) = 1
  T(1) = 0

If n is a power of 2, then we can write T(n) as: 

   T(n) = 2T(n/2) + 2

After solving the above recursion, we get 

  T(n)  = 3n/2 -2
  
Thus, the approach does **3n/2 -2** comparisons **if n is a power of 2**. And it does more than **3n/2 -2** comparisons** if n is not a power of 2**.



###################################################### Mehtod 3 #####################################################

## Optimal Method:

To solve in java create :

static class pair {
int max;
int min;
}

IDEA: idea is to do comparison in paris and increment loop by 2.


 1. Take two variables min & max;

 2. if array length is one then:
         min == max = arr[0]
        return first element as min and max.
 3. Take a varisble i
 
 4. if array length is even then:
        min = minimum of first two.
        max = maximum of first two.
        i = 2

 5. if array lenth is odd then:
        min = first_element
        max = first_element
        i = 1

 6. Run a while loop from i to n - 1 with increment i = i + 2:
     compare in pairs:  arr[i] and arr[i + 1] and update min and max accordingly.


     PsuedoCode:

        // compare in pairs
        `while (i < n - 1) {
            if (arr[i] < arr[i + 1]) {
                if (arr[i] < minMax.min)
                    minMax.min = arr[i];

                if (arr[i + 1] > minMax.max)
                    minMax.max = arr[i + 1];
            } else {
                if (arr[i + 1] < minMax.min)
                    minMax.min = arr[i + 1];

                if (arr[i] > minMax.max)
                    minMax.max = arr[i];
            }
            i = i + 2;
        }`



**Analysis**:

**Time Complexity**: O(n)

**Auxiliary Space**: O(1) as no extra space was needed.

**Total number of comparisons**: Different for even and odd n, see below: 

       **If n is odd** :    3(n-1)/2      (starting loop from i = 1 So n - 1 element left. There are total three comparisons (n - 1)/2 times. Divide by 2 because increment i as i = i + 2 )
       
       **If n is even** :   1 (Initial comparison for initializing min and max, and 3(n-2)/2 comparisons for rest of the elements)
                           
                            1 + 3(n-2)/2 = 3n/2 -2
                      
                      
Second and third approaches make the **equal number of comparisons** when n is a power of 2. 

In general, method 3 seems to be the best because no recursive call as recursive call stroage use stack internally.
