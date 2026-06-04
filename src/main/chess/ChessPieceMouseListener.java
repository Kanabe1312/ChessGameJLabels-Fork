package chess;

import chess.labelui.PieceLabel;
import chess.pieces.ChessPiece;
import chess.pieces.ChessSprite;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessPieceMouseListener implements MouseListener {
    private GamePanel panel;

    public ChessPieceMouseListener(GamePanel panel) {
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Component c = e.getComponent();
        if(c instanceof PieceLabel) {
            PieceLabel l = (PieceLabel) c;
            if (l.getSprite() instanceof ChessPiece) {
                ChessPiece p = (ChessPiece) l.getSprite();
                p.setHighlighted(true);
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (p.canMoveTo(i, j)) {
                            panel.getBoard().highlight(i, j);
                        }
                    }
                }
                panel.updateGUI();
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component c = e.getComponent();
        if(c instanceof PieceLabel) {
            PieceLabel l = (PieceLabel) c;
            if(l.getSprite() instanceof ChessPiece) {
                ChessPiece p = (ChessPiece) l.getSprite();
                l.setHighlighted(false);
                panel.getBoard().unhighlightAll();
            }
            panel.updateGUI();
        }
    }
}
