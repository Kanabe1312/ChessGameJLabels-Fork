package chess.ui.componentui;

import chess.pieces.ChessField;
import chess.pieces.ChessPiece;
import chess.ui.GamePanel;

import java.util.ArrayList;

public class ComponentsGamePanel extends GamePanel {

    private ArrayList<PieceLabel> labels;

    public ComponentsGamePanel(int fieldSize) {

        super(fieldSize);

      //  System.out.println("Pieces = " + getBoard().getPieces().size());

        labels = new ArrayList<>();

        ChessPieceMouseListener listener = new ChessPieceMouseListener(this);

        setLayout(null);

        ChessField[][] fields = getBoard().getFields();

        for (int x = 0; x < 8; x++) {

            for (int y = 0; y < 8; y++) {

                PieceLabel label = new PieceLabel(fields[x][y]);
                label.setBounds(x * getFieldSize(), y * getFieldSize(), getFieldSize(), getFieldSize());

                labels.add(label);
                add(label);
            }
        }
        for (ChessPiece piece : getBoard().getPieces()) {

          //  System.out.println(piece.getBoardX() + " " + piece.getBoardY());

            PieceLabel label = new PieceLabel(piece);
            label.addMouseListener(listener);

            label.setBounds(
                    piece.getBoardX() * getFieldSize(),
                    piece.getBoardY() * getFieldSize(),
                    getFieldSize(),
                    getFieldSize()
            );

            labels.add(label);
            add(label,0);


        }
    }

    @Override
    public void updateGUI() {

        for (PieceLabel l : labels) {
            l.updateIcon();
        }

        repaint();
    }
}