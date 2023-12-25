package com.piotrholda.algorithms;

/*
    Source: https://www.hackerrank.com/challenges/kangaroo/problem
 */
public class NumberLineJumps {

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 == v2) {
            return x1 == x2 ? "YES" : "NO";
        }
        double n = ((double) x2 - x1) / (v1 - v2);
        return n > 0 && n == (int) n ? "YES" : "NO";
    }
}
