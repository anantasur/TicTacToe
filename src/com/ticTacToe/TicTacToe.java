package com.ticTacToe;

public class TicTacToe {

    public static void main(String[] args) {
        new GameRunner(new Board(3)).startGame();
    }
}