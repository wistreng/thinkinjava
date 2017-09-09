package com.codility.EuclideanAlgorithm;

import org.junit.Test;

public class ChocolatesByNumbers {
    //数值越界
    public int solution(int n, int m) {
        int point = m;
        int count = 1;
        while(point % n != 0){
            point += m;
            count++;
        }
        return count;
    }


    public int solution1(int a, int b) {
        int gcd = 0;
        int n = a;
        int m = b;
        while (n % m != 0){
            gcd = m;
            m = n % gcd;
            n = gcd;
        }
        gcd = m;
        return a/gcd;
    }

    @Test
    public void test1() {
        int res = solution(1234123896,23458);
        int res1 = solution1(1234123896,23458);
        System.out.println("res="+res); //wrong
        System.out.println("res1="+res1);
    }
}
