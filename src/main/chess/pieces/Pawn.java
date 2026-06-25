package chess.pieces;

public class Pawn extends ChessPiece {

    public Pawn(ChessBoard board, int x, int y, ChessSprite.Color color) {

        super(board, color == ChessSprite.Color.WHITE ? "resources/Chess_plt60.png" : "resources/Chess_pdt60.png",
                "resources/Chess_pat60.png", x, y, color);
    }

    @Override
    public boolean canMoveTo(int x, int y) {

        if (x != getBoardX()) {
            return false;
        }

        if (getColor() == ChessSprite.Color.WHITE) {

            return y == getBoardY() - 1 || y == getBoardY() - 2;
        }

        return y == getBoardY() + 1 || y == getBoardY() + 2;
    }
}