package com.codility.FibonacciNumbers;

/*  The Fibonacci sequence is defined using the following recursive formula:

        F(0) = 0
        F(1) = 1
        F(M) = F(M - 1) + F(M - 2) if M >= 2
        A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.

        The leaves on the river are represented in a zero-indexed array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:

        0 represents a position without a leaf;
        1 represents a position containing a leaf.
        The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.

        For example, consider array A such that:

        A[0] = 0
        A[1] = 0
        A[2] = 0
        A[3] = 1
        A[4] = 1
        A[5] = 0
        A[6] = 1
        A[7] = 0
        A[8] = 0
        A[9] = 0
        A[10] = 0
        The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.

        Write a function:

        int solution(int A[], int N);
        that, given a zero-indexed array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.

        For example, given:

        A[0] = 0
        A[1] = 0
        A[2] = 0
        A[3] = 1
        A[4] = 1
        A[5] = 0
        A[6] = 1
        A[7] = 0
        A[8] = 0
        A[9] = 0
        A[10] = 0
        the function should return 3, as explained above.

        Assume that:

        N is an integer within the range [0..100,000];
        each element of array A is an integer that can have one of the following values: 0, 1.
        Complexity:

        expected worst-case time complexity is O(N*log(N));
        expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
        Elements of input arrays can be modified.*/


import org.junit.Test;
import java.util.*;

public class FibFrog {
    public int fib(int n){
        if(n<=1 && n>=0)
            return n;
        else{
            return fib(n-1) + fib(n-2);
        }
    }

    public int solution(int[] A){
        return 0;
    }


    @Test
    public void test(){
//        int[] F = new int[10];
//        for(int i=0; i<10; i++){
//            F[i] = fib(i);
//            System.out.println("F["+i+"]:"+F[i]);
//        }

        int[] A = {0,0,0,1,1,0,1,0,0,0,0};
        System.out.println(solution1(A));
    }

    public int solution1(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        int[] fib = new int[N + 4];
        boolean[] visit = new boolean[N];
        fib[0] = 0;
        fib[1] = 1;
        int m = 1;
        do {
            m++;
            fib[m] = fib[m-1] + fib[m-2];
        } while (fib[m] <= N + 1);
        ArrayList<Status> statusQueue = new ArrayList<Status>();
        // use a queue to save the position and the moves of every possible jump
        statusQueue.add(new Status(-1, 0));
        int nextTry = 0;
        // use the breadth first search to get the result
        while (true) {
            if (nextTry == statusQueue.size())
                return -1;
            Status currStatus = statusQueue.get(nextTry);
            nextTry++;
            int currPosition = currStatus.position;
            int currMoves = currStatus.moves;
            for (int i = m-1; i > 0; i--) {
                if (currPosition + fib[i] == N)
                    return currMoves + 1;
                else if (currPosition + fib[i] > N ||
                        A[currPosition + fib[i]] == 0 ||
                        visit[currPosition + fib[i]])
                    continue;
                statusQueue.add(new Status(currPosition + fib[i], currMoves + 1));
                visit[currPosition + fib[i]] = true;
            }
        }
    }
}

class Status {
    public int position;
    public int moves;

    public Status(int p, int m) {
        position = p;
        moves = m;
    }
}
