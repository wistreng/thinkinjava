package com.codility;
/*AND is a standard operation on bits. If X and Y are two bits (1s or 0s),
then X AND Y equals 1 when X = Y = 1. Otherwise X AND Y = 0.
1 AND 1 = 1
0 AND 0 = 0 AND 1 = 1 AND 0 = 0
The AND operation can be extended to non-negative integers. Let K
and L be two such integers, and A and B their binary representations.
(For the sake of simplicity, if one of them is shorter, let us add some
leading zeros, so that A and B are of the same length.) The bitwise
AND of K and L (denoted as K bitand L) is defined in the following
way: We build a sequence of bits C by taking the AND of bits from A
and B at the same positions. C is a binary representation of K bitand
L.
For example, for K = 12 and L = 21 we obtain:
A = 01100
B = 10101
C = 00100
and C is a binary representation of K bitand L = 4.
Now we can define the bitwise AND product. If M and N are two nonnegative
integers, such that M ≤ N, then their bitwise AND product is
the bitwise AND of all integers from M to N:
M bitand (M+1) bitand ... bitand (N−1) bitand N
Note that the bitwise AND is associative; that is, the order in which this
operation is performed does not matter.
For example, the bitwise AND product of M = 5 and N = 7 is 4,
because:
5 bitand 6 bitand 7 =
4 bitand 7 = 4
Write a function:
class Solution { public int solution(int M, int N);
}
that, given two non-negative integers M and N, returns their bitwise
AND product.
For example, given M = 5 and N = 7, the function should return 4, as
explained in the example above.
Assume that:
M and N are integers within the range
[0..2,147,483,647];
M ≤ N.
Complexity:
expected worst-case time complexity is O(log(N));
expected worst-case space complexity is O(1).*/

import org.junit.Test;

import java.util.*;

public class BinaryProduct {

    public int solution1(int M, int N) {
        int product = 0;
        while(N >= M) {
            product = N & (N-1);
            if(product <= M) {
                return product;
            }
            N--;
        }
        return product;
    }

    public int solution2(int M, int N) {
        while(N > M) {
            N = N & N -1;
        }
        return M & N;
    }

    @Test
    public void test() {
        int m = 10;
        int n = 15;
        int res1 = solution1(m,n);
        int res2 = solution2(m,n);
        System.out.println("res1 = " + res1);
        System.out.println("res2 = " + res2);
    }
}