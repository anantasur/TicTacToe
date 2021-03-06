package com.ticTacToe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    Board board;
    @Before
    public void setUp() throws Exception {
        this.board = new Board(3);
        board.createBoard();
    }

    @Test
    public void testCreateBoardInitialisesTheGameBoard() {
        assertEquals('1', board.getCellValue(0, 0));
        assertEquals('2', board.getCellValue(0, 1));
        assertEquals('3', board.getCellValue(0, 2));
        assertEquals('4', board.getCellValue(1, 0));
    }

    @Test
    public void testDrawBoardDraws3By3Board(){
        String expected = "Game board:"+System.lineSeparator()
                +" [1] [2] [3]"+System.lineSeparator()
                +" [4] [5] [6]"+System.lineSeparator()
                +" [7] [8] [9]"+System.lineSeparator();
        assertEquals(expected,board.stringRepresentationOfBoard());
    }

    @Test
    public void testAddMarkerAddsTheMarkOnTheBoard(){
        assertTrue(board.addMarker(1,1));
        assertEquals('x', board.getCellValue(0, 0));
    }
}