package com.piotrholda.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManachersAlgorithmTest {

    @ParameterizedTest
    @CsvSource(value = {"babcbabcbaccba,abcbabcba",
            "abaaba,abaaba",
            "abababa,abababa",
            "abcbabcbabcba,abcbabcbabcba",
            "forgeeksskeegfor,geeksskeeg",
            "caba,aba",
            "abacdfgdcaba,aba",
            "abacdfgdcabba,abba",
            "abacdedcaba,abacdedcaba",
            "ababdedbabeab,babdedbab",
            "a,a",
            "abcde,a"})
    void shouldFindPalindrome(String input, String expected) {
        String actual = ManachersAlgorithm.longestPalindrome(input);
        assertEquals(expected, actual);
    }
}