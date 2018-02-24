/*
 *  ==========================================================
 *  Author 	      :      AFGHAN (Piotr Skalski)
 *  Website       :      https://github.com/SkalskiP
 *  Date          :      24.02.18 23:30
 *  Project       :      DebuggerDemo
 *  ==========================================================
 */

package com.company;

public class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charAdded = 0;

    public void addChar(StringBuilder sBuilder, char c) {
        this.sBuilder.append(c);
        charAdded ++;
    }
}
