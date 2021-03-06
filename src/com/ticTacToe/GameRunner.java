package com.ticTacToe;

import java.util.Scanner;

public class GameRunner {
    Board board;
    private Game game;

    public GameRunner(Board board) {
        this.board = board;
        this.game = new Game(board);
    }

    public void startGame() {
        game.init();
        Scanner scanner = new Scanner(System.in);
        gamePlay(scanner);
        displayResult();
    }

    private void displayResult() {
        System.out.println(board.stringRepresentationOfBoard());
        declareResult();
    }

    private void declareResult() {
        if(board.areAllCellsFilled(game.getPlays()))
            declareGameDraw();
        else
            declareWinner();
    }

    private void declareGameDraw() {
        System.out.println("Game Over - Draw.");
    }

    private void declareWinner() {
        System.out.println("Game Over - Player "+game.getCurrentPlayer()+" Wins.");
    }

    private void gamePlay(Scanner scanner) {
        while(!game.winning() && game.getPlays()<9){
            System.out.println(board.stringRepresentationOfBoard());
            int input = getPick(scanner);
            board.addMarker(input, game.getCurrentPlayer());
            if(!game.winning())
                game.switchPlayers();
        }
    }

    private int getPick(Scanner scanner) {
        boolean isValid = false;
        int input = 0;
        while(!isValid){
            System.out.println("It is player "+game.getCurrentPlayer()+"'s chance. Enter Your Choice: ");
            try {
                input = scanner.nextInt();
                isValid = board.isValidPick(input);
            }catch (Exception e){
                scanner.next();
            }
            declareInvalidPick(isValid);
        }
        return input;
    }

    private void declareInvalidPick(boolean isValid) {
        if(!isValid)
            System.out.println("Invalid Pick!");
    }

}