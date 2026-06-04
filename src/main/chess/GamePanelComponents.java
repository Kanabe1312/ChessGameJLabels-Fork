package chess;

import chess.labelui.PieceLabel;
import chess.pieces.ChessField;
import chess.pieces.ChessPiece;
import chess.pieces.ChessSprite;

import java.util.ArrayList;

public class GamePanelComponents extends GamePanel {
    private ArrayList<PieceLabel> labels = new ArrayList<>();

    public GamePanelComponents(int fieldSize) {
        super(fieldSize);
        ChessPieceMouseListener listener = new ChessPieceMouseListener(this);
        setLayout(null);
        for(ChessPiece p : getBoard().getPieces()) {
            PieceLabel pieceLabel = new PieceLabel(p);
            pieceLabel.setBounds(p.getBoardX()*fieldSize, p.getBoardY()*fieldSize,
                    fieldSize, fieldSize);
            pieceLabel.addMouseListener(listener);
            labels.add(pieceLabel);
            add(pieceLabel);
        }
        for(ChessField[] row : getBoard().getFields()) {
            for(ChessField f : row) {
                PieceLabel l = new PieceLabel(f);
                l.setBounds(f.getBoardX()*fieldSize, f.getBoardY()*fieldSize,
                        fieldSize, fieldSize);
                add(l);
                labels.add(l);
            }
        }
    }

    @Override
    public void updateGUI() {
       for(PieceLabel l : labels) {
           l.updateIcon();
       }
       repaint();
    }

}
