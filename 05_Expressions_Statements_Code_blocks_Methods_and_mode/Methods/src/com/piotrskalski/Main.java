package com.piotrskalski;

public class Main {

    public static void main(String[] args) {

        boolean gameOver = true;
        int score = 800;
        int levelCompleated = 5;
        int bonus = 100;

        int highScore = calculateScore(gameOver,score, levelCompleated, bonus);
        System.out.println("Your final score was " + highScore + " on the high score table.");

        score = 10000;
        levelCompleated = 8;
        bonus = 200;

        highScore = calculateScore(gameOver,score, levelCompleated, bonus);
        System.out.println("Your final score was " + highScore);

        System.out.println("===========================================================");
        String playerName = "Piorek";
        int playerScore = 900;
        int position = calculateHighScorePosition(playerScore);
        displayHighScorePosition(playerName, position);

    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleated, int bonus) {

        if (gameOver) {
            int finalScore = score + (levelCompleated * bonus);
            finalScore += 2000;
            return finalScore;
        }
        return -1;
    }

    public static int calculateHighScorePosition(int playerScore) {
        if (playerScore >= 1000) {
            return 1;
        } else if (playerScore >= 500 && playerScore < 1000) {
            return 2;
        } else if (playerScore >= 100 && playerScore < 500) {
            return 3;
        } else {
            return  4;
        }
    }

    public static void displayHighScorePosition(String playersName, int playersPosition) {
        System.out.println(playersName + " managed to get position " + playersPosition);
    }
}
