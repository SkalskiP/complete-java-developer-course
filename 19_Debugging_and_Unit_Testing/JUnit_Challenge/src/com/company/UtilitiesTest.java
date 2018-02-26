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

    @org.junit.Test
    public void everyNthChar() {
        fail("TEST FAILED");
    }

    @org.junit.Test
    public void removePairs() {
        Utilities utils = new Utilities();
        assertEquals("ABCDEF", utils.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", utils.removePairs("ABCCABDEEF"));
    }

    @org.junit.Test
    public void converter() {
        fail("TEST FAILED");
    }

    @org.junit.Test
    public void nullIfOddLength() {
        fail("TEST FAILED");
    }
}