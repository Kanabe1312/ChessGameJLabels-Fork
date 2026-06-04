package chess;

import chess.ui.componentui.ComponentsGamePanel;

import javax.swing.*;
import java.awt.*;

public class ChessGame extends JFrame {
    public ChessGame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(60*8+10, 60*8+10));
        add(new ComponentsGamePanel(60));
    }
    public static void main(String[] args) {
        new ChessGame().setVisible(true);
    }
}
