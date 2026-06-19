package chess.ui.componentui;

import chess.pieces.ChessField;
import chess.ui.GamePanel;

import java.util.ArrayList;

public class ComponentsGamePanel extends GamePanel {

    private ArrayList<PieceLabel> labels;

    public ComponentsGamePanel(int fieldSize) {

        super(fieldSize);

        labels = new ArrayList<>();

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
    }

    @Override
    public void updateGUI() {

    }
}