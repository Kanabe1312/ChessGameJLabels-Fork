package chess.pieces;

import chess.ChessBoard;

public abstract class ChessPiece extends ChessSprite {
    public enum Color {WHITE, BLACK};
    private Color color;
    private ChessBoard board;

    public ChessPiece(ChessBoard board, String imagefile, String mouseOverImageFile, int x, int y, Color color) {
        super(imagefile, mouseOverImageFile, x, y);
        this.color = color;
        this.board = board;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean canMoveTo(int x, int y);
}
