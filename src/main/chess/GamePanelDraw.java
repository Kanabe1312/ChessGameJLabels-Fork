package chess;

import chess.ui.GamePanel;
import chess.pieces.ChessBoard;
import chess.pieces.ChessPiece;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GamePanelDraw extends GamePanel implements MouseMotionListener {
    private Color highlightColor = new Color(125, 125, 255);
    private Color darkColor = Color.LIGHT_GRAY;
    private Color lightColor = Color.WHITE;
    private ChessBoard board;
    private int fieldSize = 60;

    public GamePanelDraw(int fieldSize) {
        super(fieldSize);
        board = new ChessBoard();
        setPreferredSize(new Dimension(fieldSize*8, fieldSize*8));
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        paintBoard(g2d);
        for(ChessPiece p : board.getPieces()) {
            g.drawImage(p.getCurrentIcon().getImage(), p.getBoardX()*fieldSize, p.getBoardY()*fieldSize, null);
        }
    }

    public void paintBoard(Graphics2D g2d) {
        g2d.setColor(Color.black);
        for(int i=0; i<=8; i++) {
            g2d.drawLine(i*fieldSize, 0, i*fieldSize, fieldSize*8);
            g2d.drawLine(0, i*fieldSize, 8*fieldSize, i*fieldSize);
        }
        for(int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board.getFields()[i][j].isHighlighted()) {
                    g2d.setColor(highlightColor);
                } else if((i+j)%2==0) {
                    g2d.setColor(darkColor);
                } else {
                    g2d.setColor(lightColor);
                }
                g2d.fillRect(i*fieldSize+1, j*fieldSize+1, fieldSize-1, fieldSize-1);
            }
        }
    }

    @Override
    public void updateGUI() {
        repaint();
    }

    private boolean overPiece(Point point, ChessPiece piece) {
        if(
                point.x > piece.getBoardX()*fieldSize
                && point.x < (piece.getBoardX()+1)*fieldSize
                && point.y > piece.getBoardY()*fieldSize
                && point.y < (piece.getBoardY()+1)*fieldSize
        )
            return true;
        return false;
    }

    private void highlightMovableFields(ChessPiece p) {
        for(int i=0; i<8; i++) {
            for (int j = 0; j < 8; j++) {
                if(p.canMoveTo(i, j)) {
                    board.highlight(i, j);
                }
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        boolean mustRepaint = false;
        board.unhighlightAll();
        for(ChessPiece p : board.getPieces()) {
            if(overPiece(e.getPoint(), p)) {
                System.out.println(e.getPoint());
                if(!p.isHighlighted())
                    mustRepaint = true;
                p.setHighlighted(true);
                highlightMovableFields(p);
            }
            else {
                if(p.isHighlighted())
                    mustRepaint = true;
                p.setHighlighted(false);
            }
        }
        if(mustRepaint) {
            updateGUI();
        }
    }
}
