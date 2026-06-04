package chess.pieces;

public class ChessField extends ChessSprite {
    private Color color;

    public ChessField(int x, int y, Color color) {
        super("resources/Chess_f" + (color == Color.WHITE?"l":"d") + "t60.png", "resources/Chess_fat60.png", x, y);
    }
}
