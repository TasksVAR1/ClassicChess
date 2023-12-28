package ru.vsu.cs.vlasik_ar;


import ru.vsu.cs.vlasik_ar.chess.ChessMatch;
import ru.vsu.cs.vlasik_ar.chess.ChessPiece;
import ru.vsu.cs.vlasik_ar.chess.ChessPosition;
import ru.vsu.cs.vlasik_ar.chess.exceptions.ChessException;
import ru.vsu.cs.vlasik_ar.views.BoardView;
import ru.vsu.cs.vlasik_ar.views.utils.BoardColors;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captureChessPieces = new ArrayList<>();
        System.out.print(BoardColors.ANSI_YELLOW_BACKGROUND);
        System.out.print(BoardColors.ANSI_BLACK);
        while (!chessMatch.isCheckMate()) {
            try {
                System.out.print(BoardColors.ANSI_RESET);
                BoardView.clearScreen();
                BoardView.printMatch(chessMatch, captureChessPieces);
                System.out.println();
                System.out.print("Позиция фигуры: ");
                ChessPosition source = BoardView.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                BoardView.clearScreen();
                BoardView.printBoard(chessMatch.getPieces(), possibleMoves);
                System.out.println();
                System.out.print("Позиция хода: ");
                ChessPosition target = BoardView.readChessPosition(sc);
                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
                if (capturedPiece != null) {
                    captureChessPieces.add(capturedPiece);
                }
                if (chessMatch.getPromoted() != null) {
                    System.out.println("Выберите фигуру: (Q/H/R/B)");
                    String type = sc.nextLine();
                    chessMatch.replacepromotedPiece(type);
                }
            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

        BoardView.clearScreen();
        BoardView.printMatch(chessMatch, captureChessPieces);
    }
}