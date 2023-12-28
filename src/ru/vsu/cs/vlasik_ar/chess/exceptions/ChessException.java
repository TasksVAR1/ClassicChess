package ru.vsu.cs.vlasik_ar.chess.exceptions;

import ru.vsu.cs.vlasik_ar.boardgame.exceptions.BoardException;

public class ChessException extends BoardException {
    private static final long serialVersionUID = 1L;

    public ChessException(String msg) {
        super(msg);
    }

}