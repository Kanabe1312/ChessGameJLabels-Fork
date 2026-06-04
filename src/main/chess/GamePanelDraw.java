package chess;

import chess.pieces.ChessPiece;

import javax.swing.*;
import java.awt.*;

public class GamePanelDraw extends JPanel {
    private ChessBoard board;
    private int fieldSize = 60;

    public GamePanelDraw() {
        board = new ChessBoard();
        setPreferredSize(new Dimension(fieldSize*8, fieldSize*8));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.RED);
        g.fillRect(0, 0, fieldSize*8, fieldSize*8);
        for(ChessPiece p : board.getPieces()) {
            g.drawImage(p.getCurrentIcon().getImage(), p.getBoardX()*fieldSize, p.getBoardY()*fieldSize, null);
        }
    }
}
