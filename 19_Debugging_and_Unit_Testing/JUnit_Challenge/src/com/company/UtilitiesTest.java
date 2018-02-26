/*
 *  ==========================================================
 *  Author 	      :      AFGHAN (Piotr Skalski)
 *  Website       :      https://github.com/SkalskiP
 *  Date          :      26.02.18 19:34
 *  Project       :      JUnit_Challenge
 *  ==========================================================
 */

package com.company;

import static org.junit.Assert.*;

public class UtilitiesTest {

    private Utilities utils;

    @org.junit.Before
    public void setup() {
        utils = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar() {
        char[] output = utils.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[] {'e', 'l'}, output);

        char[] output2 = utils.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @org.junit.Test
    public void removePairs() {
        assertEquals("ABCDEF", utils.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", utils.removePairs("ABCCABDEEF"));
        assertNull("Did not get null returned when argument passed was null", utils.removePairs(null));
        assertEquals("A", utils.removePairs("A"));
        assertEquals("", utils.removePairs(""));
    }

    @org.junit.Test
    public void converter() {
        assertEquals(300, utils.converter(10, 5));
    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter_2() {
        utils.converter(10, 0);
    }

    @org.junit.Test
    public void nullIfOddLength() {
        assertNotNull(utils.nullIfOddLength("Test"));
        assertNull(utils.nullIfOddLength("Piotr"));
    }
}