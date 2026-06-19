package chess.pieces;

public class ChessBoard {

    private ChessField[][] fields;

    public ChessBoard() {

        fields = new ChessField[8][8];

        for (int x = 0; x < 8; x++) {

            for (int y = 0; y < 8; y++) {

                ChessSprite.Color color;

                if ((x + y) % 2 == 0) {
                    color = ChessSprite.Color.WHITE;
                } else {
                    color = ChessSprite.Color.BLACK;
                }

                fields[x][y] = new ChessField(x, y, color);
            }
        }
    }

    public ChessField[][] getFields() {
        return fields;
    }
}