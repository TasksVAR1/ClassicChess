package ru.vsu.cs.vlasik_ar.boardgame.exceptions;

public class BoardException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BoardException(String msg) {
        super(msg);
    }
}
