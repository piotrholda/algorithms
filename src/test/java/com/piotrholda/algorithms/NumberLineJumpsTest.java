package com.piotrholda.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberLineJumpsTest {

    @ParameterizedTest
    @CsvSource(value = {"0,2,5,3,NO",
    "0,3,4,2,YES",
    "1,4,2,4,NO",
    "3,2,3,2,YES"})
    void shouldCalculateJumps(int x1, int v1, int x2, int v2, String expected) {
        String actual = NumberLineJumps.kangaroo(x1, v1, x2, v2);
        assertEquals(expected, actual);
    }

}