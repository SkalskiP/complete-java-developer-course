/*
 *  ==========================================================
 *  Author 	      :      AFGHAN (Piotr Skalski)
 *  Website       :      https://github.com/SkalskiP
 *  Date          :      24.02.18 23:29
 *  Project       :      DebuggerDemo
 *  ==========================================================
 */

package com.company;

public class Main {

    public static void main(String[] args) {
        StringUtilities utils =  new StringUtilities();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 10) {
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);
    }
}
