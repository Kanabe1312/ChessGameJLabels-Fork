package chess.pieces;

import javax.swing.*;

public abstract class ChessSprite {
    protected int boardX;
    protected int boardY;

    private ImageIcon normalIcon;
    private ImageIcon highlightedIcon;
    private boolean highlighted = false;

    public ChessSprite(String imagefile, String highlightedImageFile, int x, int y) {
        normalIcon = new ImageIcon(imagefile);
        highlightedIcon = new ImageIcon(highlightedImageFile);
        this.boardX = x;
        this.boardY = y;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

    public boolean isHighlighted() {
        return highlighted;
    }

    public int getBoardX() {
        return boardX;
    }

    public void setBoardX(int boardX) {
        this.boardX = boardX;
    }

    public int getBoardY() {
        return boardY;
    }

    public void setBoardY(int boardY) {
        this.boardY = boardY;
    }

    public ImageIcon getCurrentIcon() {
        if(isHighlighted()) {
            return highlightedIcon;
        }
        return normalIcon;
    }
}
