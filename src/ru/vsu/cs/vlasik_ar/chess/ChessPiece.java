package ru.vsu.cs.vlasik_ar.chess;

import ru.vsu.cs.vlasik_ar.boardgame.Board;
import ru.vsu.cs.vlasik_ar.boardgame.Piece;
import ru.vsu.cs.vlasik_ar.boardgame.Position;
import ru.vsu.cs.vlasik_ar.chess.utils.Color;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void increaseMoveCount() {
        moveCount++;
    }

    public void decreaseMoveCount() {
        moveCount--;
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }
}
