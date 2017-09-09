package com.codility;

import org.junit.Test;

public class Question {

    int count = 0;

    public int solution(String s, int k) {
        // write your code in Java SE 8
        // String s = "SMS messages are really short";
        getNextLength(k,s,0);
        int res = count;
        return res;
    }

    public void getNextLength(int k, String s, int f){
        if(s.length()<k){
            count++;
            return;
        }else{
            int first = f;
            int tmp = s.indexOf(" ");
            if(first + tmp + 1 > k){
                s = s.substring(first + 1);
                count++;
                getNextLength(k,s,0);
            }else{
                first += tmp;
                getNextLength(k,s,first);
            }
        }
    }

    @Test
    public void test() {
        String s = "SMS messages are really short dahwdu dahudwhfhfh dwhuadhuwa dwh fhuad";
        int res = solution(s,11);
        System.out.println(res);
    }
    /*public void recursive(String s, int k){
        if(s.length()<k){
            count++;
            return;
        }else{
            int first = getNextLength(k,s);

        }

    }*/
}
