package chess.pieces;

public abstract class ChessPiece extends ChessSprite {

    private ChessSprite.Color color;
    private ChessBoard board;

    public ChessPiece(ChessBoard board, String imagefile, String mouseOverImageFile,
                      int x, int y, ChessSprite.Color color) {

        super(imagefile, mouseOverImageFile, x, y);

        this.board = board;
        this.color = color;
    }

    public ChessSprite.Color getColor() {
        return color;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public abstract boolean canMoveTo(int x, int y);
}