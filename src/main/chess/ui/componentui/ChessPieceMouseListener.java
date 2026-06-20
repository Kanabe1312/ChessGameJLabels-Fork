package chess.ui.componentui;

import chess.pieces.ChessPiece;
import chess.pieces.ChessSprite;
import chess.ui.GamePanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessPieceMouseListener implements MouseListener {

    private GamePanel panel;

    public ChessPieceMouseListener(GamePanel panel) {
        this.panel = panel;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        Component c = e.getComponent();

        if (c instanceof PieceLabel label) {

            ChessSprite sprite = label.getSprite();

            if (sprite instanceof ChessPiece piece) {

                piece.setHighlighted(true);

                for (int x = 0; x < 8; x++) {

                    for (int y = 0; y < 8; y++) {

                        if (piece.canMoveTo(x, y)) {
                            panel.getBoard().highlight(x, y);
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

        if (c instanceof PieceLabel label) {

            ChessSprite sprite = label.getSprite();

            if (sprite instanceof ChessPiece piece) {

                piece.setHighlighted(false);

                panel.getBoard().unhighlightAll();

                panel.updateGUI();
            }
        }
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


}