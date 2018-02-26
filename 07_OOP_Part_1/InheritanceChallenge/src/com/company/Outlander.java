/*
 *  ==========================================================
 *  Author 	      :      AFGHAN (Piotr Skalski)
 *  Website       :      https://github.com/SkalskiP
 *  Date          :      26.02.18 22:27
 *  Project       :      InheritanceChallenge
 *  ==========================================================
 */

package com.company;

public class Outlander extends Car{
    private int roadServiceMonths;

    public Outlander(int roadServiceMonths) {
        super("Outlander", "4WD", 5, 5, 6, false);
        this.roadServiceMonths = roadServiceMonths;
    }
}
