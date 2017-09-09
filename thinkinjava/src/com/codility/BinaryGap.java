package com.codility;

import org.junit.Test;

import java.util.Arrays;

public class BinaryGap {

    public int smallPositiveInt(int[] A) {
        Arrays.sort(A);
        int b = 0;
        for(int i=0;i<A.length;i++){
            if(A[i]>0){
                if(b-A[i]+1==0)
                    b++;
            }

        }
        return (b == 0)? 1 : b+1;

    }

    @Test
    public void test() {
        int[] A = new int[]{1,4,2,6,2,8,1,4,5,6,7,34,53,89,234234,34234,3,4,23,4,5,23,42,34,5,2,34,2,34,5,234,};
        int a = smallPositiveInt(A);
        System.out.println(a);

    }
}
