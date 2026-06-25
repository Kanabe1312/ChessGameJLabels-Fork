package chess.pieces;

import javax.swing.ImageIcon;

public abstract class ChessSprite {

    public enum Color {
        WHITE,
        BLACK
    }

    protected int boardX;
    protected int boardY;
    private ImageIcon normalIcon;
    private ImageIcon highlightedIcon;

    private boolean highlighted;



    public ChessSprite(String imagefile, String highlightedImageFile,
                       int boardX, int boardY) {

        this.boardX = boardX;
        this.boardY = boardY;

        normalIcon = new ImageIcon(imagefile);
        highlightedIcon = new ImageIcon(highlightedImageFile);
        System.out.println(imagefile + " width=" + normalIcon.getIconWidth());
        highlighted = false;
    }

    public void setBoardY(int boardY) {
        this.boardY = boardY;
    }
    public boolean isHighlighted() {
        return highlighted;
    }
    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }
    public void setBoardX(int boardX) {
        this.boardX = boardX;
    }

    public int getBoardX() {
        return boardX;
    }
    public int getBoardY() {
        return boardY;
    }
    public ImageIcon getNormalIcon() {
        return normalIcon;
    }
    public ImageIcon getHighlightedIcon() {
        return highlightedIcon;
    }
    public ImageIcon getCurrentIcon() {
        if (highlighted) {
            return highlightedIcon;
        }

        return normalIcon;
    }
}