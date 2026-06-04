package chess.labelui;

import chess.pieces.ChessPiece;
import chess.pieces.ChessSprite;

import javax.swing.*;

public class PieceLabel extends JLabel {
    private ChessSprite sprite;
    private boolean highlighted;

    public PieceLabel(ChessSprite sprite) {
        this.sprite = sprite;
        highlighted = false;
        updateIcon();
    }

    public ChessSprite getSprite() {
        return sprite;
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
        sprite.setHighlighted(highlighted);
        updateIcon();
    }

    public void updateIcon() {
        setIcon(sprite.getCurrentIcon());
    }

}
