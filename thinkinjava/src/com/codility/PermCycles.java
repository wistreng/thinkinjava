package com.codility;

/*A zero-indexed array A consisting of N different integers is given. The
array contains all integers in the range [0..N−1]. Sets S[K] for 0 ≤ K <
N are defined as follows:
S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.
Sets S[K] are finite for each K.
Write a function:
class Solution { public int solution(int[] A); }
that, given an array A consisting of N integers, returns the size of the
largest set S[K] for this array. The function should return 0 if the array
is empty.
For example, given array A such that:
A[0] = 5 A[1] = 4 A[2] = 0
A[3] = 3 A[4] = 1 A[5] = 6
A[6] = 2
the function should return 4, because set S[2] equals { 0, 5, 6, 2 } and
has four elements. No other set S[K] has more than four elements.
Assume that:
N is an integer within the range [0..1,000,000];
the elements of A are all distinct;
each element of array A is an integer within the range
[0..N−1].
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond
input storage (not counting the storage required for
input arguments).
Elements of input arrays can be modified.*/

import org.junit.Test;

import java.util.*;

public class PermCycles {
    // while
    // Complexity O(N**2)

    /*public int solution1(int[] A ) {
        int ArraySize = A.length;
        int MaxSize = 0;
        // A length is 0
        if(ArraySize == 0){
            return 0;
        }

        for(int i=0; i < ArraySize; i++){
            int count = 0;
            int currentIndex = i;
            boolean[] visited = new boolean[ArraySize]();

            //Counts until a loop is detected!
            while(!visited[currentIndex]) {
                visited[currentIndex] = true;
                currentIndex = A[currentIndex];
                count++;
            }
            //There won't be any set bigger than A
            if(count >= ArraySize){
                return count;
            }

            MaxSize = Math.max(count, MaxSize);
        }
        return MaxSize;
    }*/

    private int count = 0;
    // recursiveSolution
    // 时间复杂度有改善
    public int solution2(int[] A) {

        int MaxSize = 0;

        for (int i = 0; i < A.length; i++) {
            recursive(A, i, A[i], true);
            MaxSize = (MaxSize < count) ? count : MaxSize;
            count = 0;
        }
        return MaxSize;
    }

    public void recursive(int[] A, int index, int firstValue, boolean isFirst) {
        //A[n] = n is exception OR A[n] = A[Index] is the loop
        if(!isFirst && (A[index] == index || A[index] == firstValue)){
            return;
        }
        count++;
        recursive(A,A[index],firstValue,false);
    }

    @Test
    public void test() {
        int[] A = {5,4,0,3,1,6,2};//{0,3,2,5,1,6,4};
        int result = solution2(A);
        System.out.println(result);
    }

}
