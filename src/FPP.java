import java.sql.Array;
import java.util.*;

// class containing methods of the FPP test
public class FPP {

/*Question 1
An array with an odd number of elements is said to be centered
if all elements (except the middle one) are strictly greater than the value
of the middle element. Note that only arrays with an odd number of elements
have a middle element. Write a function that accepts an integer array and
returns 1 if it is a centered array, otherwise it returns 0.
Examples:
 -----------------------|-----------------------------------------------------------------------
| if the input array is | return                                                                |
|-----------------------|-----------------------------------------------------------------------|
| {1,2,3,4,5}           | 0 (the middle element 3 is not strictly less than all other elements) |
|-----------------------|-----------------------------------------------------------------------|
| {3,2,1,4,5}           | 1 (the middle element 1 is strictly less than all other elements)     |
|-----------------------|-----------------------------------------------------------------------|
| {3,2,1,4,1}           | 0 (the middle element 1 is not strictly less than all other elements) |
|-----------------------|-----------------------------------------------------------------------|
| {1,2,3,4}             | 0 (no middle element)                                                 |
|-----------------------|-----------------------------------------------------------------------|
| {}                    | 0 (no middle element)                                                 |
|-----------------------|-----------------------------------------------------------------------|
| {10}                  | 1 (the middle element 10 is strictly less than all other elements)    |
 -----------------------------------------------------------------------------------------------
*/
    public static int isCentered(int[] arr){
        if(arr.length % 2 == 0){
            return 0;
        }

        int middleNum = arr[(arr.length / 2)];

        for(int i = 0; i < arr.length; i++){
            if(i != arr.length/2 && arr[i] <= middleNum){
                return 0;
            }
        }

        return 1;
    }


    /*
Write a function that takes an array of integers as an argument and returns a
value based on the sums of the even and odd numbers in the array. Let X = the sum of the odd
numbers in the array and let Y = the sum of the even numbers. The function should return X - Y
The signature of the function is:
int f(int[] a)
Examples:
 -----------------------|-----------------------------------------------------------------------
| if input array is     | return                                                                |
|-----------------------|-----------------------------------------------------------------------|
| {1}                   | 1                                                                     |
|-----------------------|-----------------------------------------------------------------------|
| {1,2}                 | -1                                                                    |
|-----------------------|-----------------------------------------------------------------------|
| {1,2,3}               | 2                                                                     |
|-----------------------|-----------------------------------------------------------------------|
| {1,2,3,4}             | -2                                                                    |
|-----------------------|-----------------------------------------------------------------------|
| {3,3,4,4}             | -2                                                                    |
|-----------------------|-----------------------------------------------------------------------|
| {}                    | 0                                                                     |
 -----------------------------------------------------------------------------------------------
 */

    public static int f(int[] a){
        int Y = 0;
        int X = 0;

        for(int num : a){
            if(num % 2 == 0 ){
                Y += num;
            }else{
                X += num;
            }
        }

        return X - Y;

    }

    /*Question 3
Write a function that accepts a character array, a zero-based start position and
a length. It should return a character array containing lengthCharacters starting with
the startCharacter of the input array. The function should do error checking on the start
position and the length and return null if the either value is not legal.

The function signature is:
char[] f(char[] a, int start, int len)

 --------------------------------|--------------------------------------------------------------
| if the input parameters are is | return                                                       |
|--------------------------------|--------------------------------------------------------------|
| {'a','b','c'}, 0, 4            | null                                                         |
|--------------------------------|--------------------------------------------------------------|
| {'a','b','c'}, 0, 3            | {'a','b','c'}                                                |
|--------------------------------|--------------------------------------------------------------|
| {'a','b','c'}, 0, 2            | {'a','b'}                                                    |
|--------------------------------|--------------------------------------------------------------|
| {'a','b','c'}, 0, 1            | {'a'}                                                        |
|--------------------------------|--------------------------------------------------------------|
| {'a','b','c'}, 1, 3            | null                                                         |
|--------------------------------|--------------------------------------------------------------|
| {'a','b','c'}, 1, 2            | {'b','c'}                                                    |
|--------------------------------|--------------------------------------------------------------|
| {'a','b','c'}, 1, 1            | {'b'}                                                        |
|--------------------------------|--------------------------------------------------------------|
| {'a','b','c'}, 2, 2            | null                                                         |
|--------------------------------|--------------------------------------------------------------|
| {'a','b','c'}, 2, 1            | {'c'}                                                        |
|--------------------------------|--------------------------------------------------------------|
| {'a','b','c'}, 3, 1            | null                                                         |
|--------------------------------|--------------------------------------------------------------|
| {'a','b','c'}, 1, 0            | {}                                                           |
|--------------------------------|--------------------------------------------------------------|
| {'a','b','c'}, -1, 2           | null                                                         |
|--------------------------------|--------------------------------------------------------------|
| {'a','b','c'}, -1, -2          | null                                                         |
|--------------------------------|--------------------------------------------------------------|
| {}, 0, 1                       | null                                                         |
 -----------------------------------------------------------------------------------------------
 */

    public static String charArrayBasedStartLength(char[] a, int start, int len){
        if(len < 0 || start < 0 || start + len - 1 >= a.length){
            return null;
        }

        char[] ans = new char[len];

        for(int i = start, j = 0; j < len; i++, j++){
            ans[j] = a[i];
        }

        return Arrays.toString(ans);

    }

    /*
* Question 4
Write a function to reverse an integer using numeric operators and without
using any arrays or other data structures.

The signature of the function is:
int f(int n)
Examples

 --------------------------------|--------------------------------------------------------------
| if the input integer is        | return                                                       |
|--------------------------------|--------------------------------------------------------------|
| 1234                           | 4321                                                         |
|--------------------------------|--------------------------------------------------------------|
| 12005                          | 50021                                                        |
|--------------------------------|--------------------------------------------------------------|
| 1                              | 1                                                            |
|--------------------------------|--------------------------------------------------------------|
| 1000                           | 1                                                            |
|--------------------------------|--------------------------------------------------------------|
| 0                              | 0                                                            |
|--------------------------------|--------------------------------------------------------------|
| -12345                         | -54321                                                       |
 --------------------------------|--------------------------------------------------------------
 */

    public static int reverseInteger(int num){
        int reverse = 0;
        int symbol = num < 0 ? -1 : 1;
        num = num < 0 ? num * -1 : num;

        while(num > 0){
            int rem = num % 10;
            reverse = 10 * reverse + rem;
            num /= 10;
        }

        return reverse * symbol;
    }

    /*
    Question 5
Write a function to return an array containing all elements common to two
given arrays containing distinct positive integers. You should not use any inbuilt
methods. You are allowed to use any number of arrays.

The signature of the function is:
int[] f(int[] first, int[] second)

Examples:
 --------------------------------|--------------------------------------------------------------
| if the input parameters are    | return                                                       |
|--------------------------------|--------------------------------------------------------------|
| {1,8,3,2},{4,2,6,1}            | {1,2}                                                        |
|--------------------------------|--------------------------------------------------------------|
| {1,8,3,2,6},{2,6,1}            | {2,6,1}                                                      |
|--------------------------------|--------------------------------------------------------------|
| {1,3,7,9},{7,1,9,3}            | {1,3,7,9}                                                    |
|--------------------------------|--------------------------------------------------------------|
| {1,2}, {3,4}                   | {}                                                           |
|--------------------------------|--------------------------------------------------------------|
| {}, {1,2,3}                    | {}                                                           |
|--------------------------------|--------------------------------------------------------------|
| {1,2}, {}                      | {}                                                           |
|--------------------------------|--------------------------------------------------------------|
| {1,2}, null                    | null                                                         |
|--------------------------------|--------------------------------------------------------------|
| null, {}                       | null                                                         |
|--------------------------------|--------------------------------------------------------------|
| null, null                     | null                                                         |
 --------------------------------|--------------------------------------------------------------
*/

    public static String intersection(int[] first, int[] second){
        List<Integer> arr = new ArrayList<>();
        int index = 0;

        for(int i:first){
            for(int j:second){
                if(i == j){
                    arr.add(i);
                }
            }
        }

        return Arrays.toString(arr.toArray());
    }


    /*
    * Question 6
Consider an array A with n of positive integers. An integer idx is called
a POE (point of equilibrium) of A, if A[0]+A[1]+...+A[idx-1] is equal to A[idx+1]+A[idx+2]+...+A[n-1].
Write a function to return POE of an array, if it exists and -1 otherwise.

The signature of the function is:
int f(int[] a)

Examples
 -------------------------|--------------------------------------------------------------
| if the input arrays are | return                                                       |
|-------------------------|--------------------------------------------------------------|
| {1,8,3,7,10,2}          | 3 Reason: a[0]+a[1]+a[2] is equal to a[4]+a[5]               |
|-------------------------|--------------------------------------------------------------|
| {1,5,3,1,1,1,1,1,1}     | 2 Reason: a[0]+a[1] is equal to a[3]+a[4]+a[5]+a[6]+a[7]+a[8]|
|-------------------------|--------------------------------------------------------------|
| {2,1,1,1,2,1,7}         | 5 Reason: a[0]+a[1]+a[2]+a[3]+a[4] is equal to a[6]          |
|-------------------------|--------------------------------------------------------------|
| {1,2,3}                 | -1 Reason: No POE                                            |
|-------------------------|--------------------------------------------------------------|
| {3,4,5,10}              | -1 Reason: No POE                                            |
|-------------------------|--------------------------------------------------------------|
| {1,2,10,3,4}            | -1 Reason: No POE                                            |
 -------------------------|--------------------------------------------------------------*

     */

    public static int POE(int[] arr){
        int frontSum = arr[0];
        int frontIdx = 1;

        int backSum = arr[arr.length - 1];
        int backIdx = arr.length - 2;

        for (int i = 0 ; i<arr.length - 1; i++){
            if(frontSum > backSum){
                backSum += arr[backIdx];
                backIdx--;
            }else{
                frontSum += arr[frontIdx];
                frontIdx++;
            }
        }

        if(frontSum == backSum){
            return frontIdx - 1;
        }
        return -1;
    }

    /*
    Question 7
Write a function nextPerfectSquare that returns the first perfect square that is greater than
it's integer argument. A perfect square is an integer that is equal to some integer squared.

For example 16 is a perfect square because 16 = 4*4. However 15 is not a perfect square because
there is no integer n such that 15 = n*n.

The signature of the function is
int isPerfectSquare(int n)
Examples
 -------------------------|--------------------------------------------------------------
| n                       | next perfect square                                          |
|-------------------------|--------------------------------------------------------------|
| 6                       | 9                                                            |
|-------------------------|--------------------------------------------------------------|
| 36                      | 49                                                           |
|-------------------------|--------------------------------------------------------------|
| 0                       | 1                                                            |
|-------------------------|--------------------------------------------------------------|
| -5                      | 0                                                            |
 -------------------------|--------------------------------------------------------------*/

    public static int isPerfectSquare(int n){
        int nextPerfectSquare = 0;

        if (n >= 0) {
            double sqrtResult = Math.sqrt(n);
            int baseNumber = (int) sqrtResult;
            int nextNumber = baseNumber + 1;
            nextPerfectSquare = (int) Math.pow(nextNumber, 2);
        }

        return nextPerfectSquare;
    }


    /*
    *Question 8
Define the n-upcount of an array to be the number of times the partial sum goes from less than
or equal to n to greater than n during the calculation of the sum of elements of the array.
if you are programming in Java or C#, the function signature is int nUpCount(int[] a, int n)

For example, if n=5, the 5-upcount of the array {2,3,1,-6,8,-3,-1,2} is 3.
 ------|------|--------------|---------|---------------------------------
| i    | a[i] | partial sum  | upcount | comment                         |
|------|------|--------------|---------|---------------------------------|
| 0    | 2    | 2            |         |                                 |
|------|------|--------------|---------|---------------------------------|
| 1    | 3    | 5            |         |                                 |
|------|------|--------------|---------|---------------------------------|
| 2    | 1    | 6            | 1       | partial sum goes from 5 to 6    |
|------|------|--------------|---------|---------------------------------|
| 3    | -6   | 0            |         |                                 |
|------|------|--------------|---------|---------------------------------|
| 4    | 8    | 8            | 2       | partial sum goes from 0 to 8    |
|------|------|--------------|---------|---------------------------------|
| 5    | -3   | 5            |         |                                 |
|------|------|--------------|---------|---------------------------------|
| 6    | -1   | 4            |         |                                 |
|------|------|--------------|---------|---------------------------------|
| 7    | 2    | 6            | 3       | partial sum goes from 4 to 6    |
 ------|------|--------------|---------|---------------------------------*/
    public static int nUpCount(int[] a, int n){
        int count = 0;
        int previousPartialSum = 0;
        int currentPartialSum = 0;

        for(int x: a){
            previousPartialSum = currentPartialSum;
            currentPartialSum += x;

            if(previousPartialSum <= n && currentPartialSum > n){
                count++;
            }
        }

        return count;
    }

    /*
    Write a function named primeCount with signature int primeCount(int start, int end);
The function returns the number of primes between start and end inclusive.
Recall that a prime is a positive integer greater than 1 whose only integer factors are 1 and itself.

Examples
 -------------|------------|---------|------------------------------------------------------------------
| if start is | and end is | return  | reason                                                           |
|-------------|------------|---------|------------------------------------------------------------------|
| 10          | 30         | 6       | The primes between 10 and 30 inclusive are 11,13,17,19,23 and 29 |
|-------------|------------|---------|------------------------------------------------------------------|
| 11          | 29         | 6       | The primes between 11 and 29 inclusive are 11,13,17,19,23 and 29 |
|-------------|------------|---------|------------------------------------------------------------------|
| 20          | 22         | 0       | 20,21, and 22 are all non-prime                                  |
|-------------|------------|---------|------------------------------------------------------------------|
| 1           | 1          | 0       | By definition, 1 is not a prime number                           |
|-------------|------------|---------|------------------------------------------------------------------|
| 5           | 5          | 1       | 5 is a prime number                                              |
|-------------|------------|---------|------------------------------------------------------------------|
| 6           | 2          | 0       | start must be less than or equal to end                          |
|-------------|------------|---------|------------------------------------------------------------------|
| -10         | 6          | 3       | primes are greater than 1. 2, 3 and 5 are prime                  |
 -------------|------------|---------|------------------------------------------------------------------*/

    public static int primeCount(int start, int end){
        int count = 0;

        for(int i = start; i < end + 1; i++){
            boolean isPrime = true;
            if(i > 1){
                for(int j = 2; j < i; j++){
                    if(i % j == 0){
                        isPrime = false;
                        break;
                    }
                }

                if(isPrime){
                    count++;
                }
            }
        }

        return count;
    }

    /*
    * Question 10
A fancy number is a number in the sequence 1,1,5,17,61,... Note the first two fancy numbers
are 1 and any fancy number other than the first two is sum of three times previous one and two times
the one before that. see below
1,
1,
3*1 + 2*1 = 5,
5*3 + 2*1 = 17,
17*3 + 5*2 = 61
Write a function named isFancy that returns 1, if it's integer argument is a Fancy number,
otherwise it returns 0.*/
    public static int isFancy(int num){
        int prev = 1;
        int current = 1;

        for(int i = 0; i < num; i++){
            int fancy = (3 * current) + (2 * prev);
            if(num == fancy){
                return 1;
            }
            prev = current;
            current = fancy;
        }

        return 0;
    }

    /*
    *Question 11
A Meera array is any array that contains the value 1 if and only if it contains 9.
The array {7,9,0,10,1} is a Meera array because it contains 1 and 9.
The array {6,10,8} is a Meera array because it contains no 1 and no 9.
The array {7,6,1} is not a Meera array because it contains 1 but does not contain a 9.
The array {9,10,0} is not a Meera array because it contains a 9 but does not contain 1.
It is okay if a Meera array contains more than one value 1 and more than one 9.
So the array {1,1,0,8,0,9,9,1} is a Meera array.
Write a function named isMeera that returns 1 if it's array argument is a Merra array
and returns 0 otherwise.
If you are programming in Java or C#, the function signature is int isMeera(int[] a)
*/

    public static int isMeera(int[] a){
        int oneCount = 0;
        int nineCount = 0;

        for(int x: a){
           if(x == 1){
               oneCount = oneCount == 0 ? oneCount + 1 : oneCount;
           }

           if(x == 9){
               nineCount = nineCount == 0 ? nineCount + 1 : nineCount;
           }
        }

        if(oneCount + nineCount >= 2){
            return 1;
        }

        return 0;
    }

    /*
    * Question 12
A Bean array is defined to be an integer array where for every value n in the array,
there is also an element 2n, 2n+1 or n/2 in the array.

for example {4,9,8} is a Bean array because for 4,8 is present, for 9, 4 is present, for 8, 4 is present.
Other Bean arrays include {2,2,5,11,23}, {7,7,3,6} and {0}
The array {3,8,4} is not a Bean array because of the value 3 which requires that the array contains
either the value 6, 7 or 1 and none of these values are in the array.
Write a function named isBean that returns 1 if it's array argument is a Bean array,
otherwise it returns a 0.
if you are programming in Java or C#, the function signature is int isBean(int[] a)*/

    public static int isBean(int[] a){
        for(int i = 0; i < a.length; i++){
            boolean flag = false;
            for(int j = 0; j < a.length - 1; j++){
                if(2*a[i] == a[j] || (2*a[i] + 1 == a[j] || a[i] / 2 == a[j])){
                    flag = true;
                    break;
                }
            }

            if(!flag){
                return 0;
            }
        }

        return 1;
    }

    /*
    * Consider the positive integer 50. Note that 50 = 25 + 25 = 5^2 + 5^2 and 50 = 1 + 49 = 1^2 + 7^2,
Thus 50 can be expressed as a sum of the two squares in two different ways.
Write a method whether or not a positive integer n can be expressed as a sum of two squares in
exactly two different ways.
The signature of the function is
int answerOne(int n)
*/
    public static int answerOne(int n){
        int count = 0;

        for(int i = 1; i < n; i++){
            for(int j = i; j < n; j++){
                int calc = (int)(Math.pow(i,2) + Math.pow(j, 2));
                if(calc == n){
                    System.out.println(i + " " + j);
                    count++;
                }
            }
        }
        System.out.println("count" + count);

        if(count == 2){
            return 1;
        }

        return 0;
    }

    /*
    Question 14
Write a function that will return the most occurring number in an array. If there is more than
one such number, the function may return any one of them.
If you are programming in Java or C#, the function signature is int answerTwo(int[] a)

Examples
 -------------------------|----------|------------------------------------------------------------
| a                       | return   | Explanation                                                |
|-------------------------|----------|------------------------------------------------------------|
| {6,8,1,8,2}             | 8        | 8 occurs two times. No other number occurs 3 or more times |
|-------------------------|----------|------------------------------------------------------------|
| {6,8,1,8,6}             | 8 or 6   | 8, 6. The Function may return either 8 or 6                |
 -------------------------|----------|------------------------------------------------------------*/

    public static int mostOccurring(int[] a){
        int mostOccurringIdx = 0;
        int mostOccuringIdxCount = 0;

        for(int i = 0; i < a.length; i++){
            int count = 0;
            for(int j = 0; j < a.length; j++){
                if(a[i] == a[j]){
                    count++;
                }
            }

            if(count > mostOccuringIdxCount){
                mostOccuringIdxCount = count;
                mostOccurringIdx = i;
            }
        }
        return a[mostOccurringIdx];
    }

    /*
   * Question 15
Write a function that will return 1 if an integer array satisfies the following conditions and returns 0 otherwise.
1. it has even numbers of elements
2. Sum of all the numbers in the first half of the array is equal to the sum of all the numbers in the second half of the array.

If you are programming in Java, the function Signature is
int answerThree(int[] a)
Examples
-------------------|--------|-----------------------------------------------------------------------
| a                 | return | Explanation                                                           |
|-------------------|--------|-----------------------------------------------------------------------|
| {5,4,3,2,3,4,6,1} | 1      | *There are 8 (even) number of elements in the array. Thus condition 1 |
|                   |        | satisfied.                                                            |
|                   |        | *The sum of all the numbers in the first half = 5+4+3+2 = 14          |
-------------------|--------|-----------------------------------------------------------------------*/
    public static int answerThree(int[] a){
        if(a.length == 0) return 0;

        int frontSum = 0;
        int backSum = 0;

        if(a.length % 2 == 0){
            for(int i = 0, j = a.length - 1; i < a.length / 2; i++){
                frontSum += a[i];
                backSum += a[j];
                j--;
            }
        }

        if(frontSum == backSum){
            return 1;
        }

        return 0;
    }

    /*
    Question 16
A Madhav array has the following property.
a[0] = a[1] + a[2] = a[3] + a[4] + a[5] = a[6] + a[7] + a[8] + a[9] = ...
The length of a Madhav array must be n*(n+1)/2 for some n.
Write a method named isMadhavArray that returns 1 if its array argument is a Madhav array,
otherwise it returns 0. If you are programming in Java or C# the function signature is
int isMadhavArray(int[] a)

Examples
 -----------------------------------|-------|---------------------------------------------------
| if a is                           | return| reason                                            |
|-----------------------------------|-------|---------------------------------------------------|
| {2,1,1}                           | 1     | 2 = 1 + 1                                         |
|-----------------------------------|-------|---------------------------------------------------|
| {2,1,1,4,-1,-1}                   | 1     | 2 = 1 + 1, 2 = 4 + -1 + -1                        |
|-----------------------------------|-------|---------------------------------------------------|
| {6,2,4,2,2,2,1,5,0,0}             | 1     | 6 = 2 + 4, 6 = 2 + 2 + 2, 6 = 1 + 5 + 0 + 0       |
|-----------------------------------|-------|---------------------------------------------------|
| {18,9,10,6,6,6}                   | 0     | 18 != 9 + 10                                      |
|-----------------------------------|-------|---------------------------------------------------|
| {-6,-3,-3,8,-5,-4}                | 0     | -6 != 8 + -5 + -4                                 |
|-----------------------------------|-------|---------------------------------------------------|
| {0,0,0,0,0,0,0,0,0,0,1,1,1,-2,-1} | 1     | 0 = 0+0, 0 = 0+0+0, 0 = 0+0+0+0, 0 = 1+1+1+-2+-1  |
|-----------------------------------|-------|---------------------------------------------------|
| {3,1,2,3,0}                       | 0     | The length of the array is 5, but 5 != n*(n+1)/2  |
 -----------------------------------|-------|---------------------------------------------------*/

//    public static int isMadhavArray(int[] a){
//        int sum = 0;
//
//       for(int i = 1; i < a.length; i++){
//
//       }
//    }


    static int smallest(int n){
        int number = 1;

        while(true){
            int count = 0;
            for(int i = 1; i <= n; i++){
                if(containsTwo(number * i)){
                    count++;
                }
            }

            if(count == n){
                break;
            }

            number++;
        }

        return number;
    }

    static boolean containsTwo(int n){
        while(n > 0){
            if(n % 10 == 2){
                return true;
            }

            n /= 10;
        }

        return false;
    }

//    cluster compression
    static int[] clusterCompression(int[] a){
        List<Integer> cluster = new ArrayList<>();

        for(int i=0; i < a.length - 1; i++){
            if(a[i] != a[i+1]){
                cluster.add(a[i]);
            }
        }

        int[] clusterArr = new int[cluster.size()];


        for(int i=0; i<cluster.size(); i++){
            clusterArr[i] = cluster.get(i);
        }

        return clusterArr;
    }

//    is railroad array

    static int isRoadTie(int[] a){
        boolean flag = false;

        for(int x:a){
            if(x > 0){
                flag = true;
                break;
            }
        }

        for(int i=1; i<a.length-1; i++){
            int prev = a[i-1];
            int next = a[i+1];
            int current = a[i];
            if(current > 0){
                if(prev > 0 && next > 0 || prev == 0 && next == 0) {
                    flag = false;
                    break;
                }
            }

            if(current == 0 && (prev <= 0 && next <= 0)){
                flag = false;
                break;
            }
        }

        if(flag){
            return 1;
        }
        return 0;
    }

//    is packed
    static int isPacked(int[] a){
       int i = 0;

       while(i < a.length){
           int value = a[i];
           int count = 0;

           if(value < 0){
               return 0;
           }

           while(i < a.length && a[i] == value){
               count++;
               i++;
           }

           if(count != value){
               return 0;
           }
       }

       return 1;
    }

//    is odd-heavy
    static int isOddHeavy(int[] a){
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j < a.length; j++){
                boolean isOdd = a[i] % 2 != 0;
                boolean isEven = a[j] % 2 == 0;
                if(isOdd && isEven && a[i] < a[j]){
                    return 0;
                }
            }
        }
        return 1;
    }

//    get exponent
    static int getExponent(int n, int p){
        if(p <= 1){
            return -1;
        }

        int i = 0;
        int ans = 0;

        while(true){
            int exponent = (int)Math.pow(p, i);

            if(n % exponent == 0){
                ans = exponent;
                i++;
            }else{
                return i - 1;
            }
        }
    }

//    is hodder
    static int isHodder(int n){
        for(int i=2; i<n; i++){
            if(n % 2 == 0){
                return 0;
            }
        }

        for(int i=0; i<n; i++){
            if(n == Math.pow(2, i) - 1){
                return 1;
            }
        }

        return 0;

    }

//    pairwise sum

    static int[] pairwiseSum(int[] a){
        if(a.length == 0 || a.length % 2 != 0){
            return null;
        }

        int[] arr = new int[a.length/2];
        int index = 0;
        int count = 0;

        while(count < a.length){
            int sum = a[count] + a[count + 1];
            arr[index] = sum;
            index++;
            count += 2;
        }

        return arr;
    }

//    is square
    static int isSquare(int n){
        for(int i=0; i < n; i++){
            if(i * i > n){
                return 0;
            }else if(i * i == n){
                return 1;
            }
        }

        return 0;
    }

//    is complete
    static int isComplete(int[] a){
        boolean hasEven = false;
        boolean hasPerfectSquare = false;
        boolean hasSum = false;

        for(int i=0; i < a.length; i++){
            int element = a[i];

            if(isSquare(a[i]) == 1){
                hasPerfectSquare = true;
            }else if(a[i] % 2 == 0){
                hasEven = true;
            }

            for(int j=i+1; j < a.length; j++){
                if(element + a[j] == 8){
                    hasSum = true;
                    break;
                }
            }

            if(hasSum && hasEven && hasPerfectSquare){
                return 1;
            }
        }

        return 0;
    }

//    loopSum
    static int loopSum(int[] a, int n){
        int count = 1;
        int index = 0;
        int sum = 0;

        while(count <= n){
            sum += a[index];

            count++;
            index++;

            if(index > a.length - 1){
                index = 0;
            }
        }

        return sum;
    }

//    all values the same
    static int allValuesTheSame(int[] a){
        for(int i = 0; i <a.length - 1; i++){
            int element = a[i];

            if(element != a[i+1]){
                return 0;
            }
        }

        return 1;
    }
}



