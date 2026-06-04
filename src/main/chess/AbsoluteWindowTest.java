package chess;

import chess.pieces.ChessSprite;
import chess.ui.componentui.PieceLabel;

import javax.swing.*;
import java.awt.*;

public class AbsoluteWindowTest extends JFrame {
    private class AbsolutePanel extends JPanel {
        public AbsolutePanel() {
            setLayout(null);
            setSize(new Dimension(8*60, 8*60));
            ChessSprite testSprite = new ChessSprite("resources/Chess_pdt60.png", "resources/Chess_pat60.png", 0, 0);
            PieceLabel testLabel = new PieceLabel(testSprite);
            testLabel.setBounds(10, 10, 60, 60);
            add(testLabel);
            testSprite = new ChessSprite("resources/Chess_plt60.png", "resources/Chess_pat60.png", 0, 0);
            testLabel = new PieceLabel(testSprite);
            testLabel.setBounds(80, 120, 60, 60);
            add(testLabel);
        }
    }
    public AbsoluteWindowTest() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(8*60, 8*60));
        add(new AbsolutePanel());
    }
    public static void main(String[] args) {
        new AbsoluteWindowTest().setVisible(true);
    }
}
