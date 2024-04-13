import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JLabel;

public class Piece {
    public static List<Piece> capturedWhitePieces = new ArrayList<>();
    public static List<Piece> capturedBlackPieces = new ArrayList<>();
    public int x;
    public int y;
    public boolean isWhite;
    public JLabel label = new JLabel();

    public Piece(int x, int y, boolean isWhite, String imgFilePath) {
        this.x = x;
        this.y = y;
        this.isWhite = isWhite;

        ImageIcon icon = new ImageIcon(imgFilePath);

        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        label.setIcon(icon);

        Square.arrayBoard[this.x][this.y].add(label);
    }

    public void move(int x, int y) {
        if (MyFrame.currentPlayerIsWhite == this.isWhite) {
            Square toSquare = Square.arrayBoard[x][y];
            if (toSquare.piece != null) {
                System.out.println(toSquare.piece.isWhite);
                if (toSquare.piece.isWhite) {
                    capturedWhitePieces.add(toSquare.piece);
                } else {
                    capturedBlackPieces.add(toSquare.piece);
                }
                toSquare.remove(toSquare.piece.label);
                toSquare.piece = null;

            }
            toSquare.piece = this;
            toSquare.add(this.label);

            Square.arrayBoard[this.x][this.y].piece = null;

            toSquare.piece.x = toSquare.x;
            toSquare.piece.y = toSquare.y;

            MyFrame.currentPlayerIsWhite = !MyFrame.currentPlayerIsWhite;
        }

    }

    public static boolean isSquareOccupied(int x, int y) {
        if (Square.arrayBoard[x][y].piece != null) {
            return true;
        }
        return false;
    }

    // Null if there is no piece at the specified index
    public static Piece getPieceByIndex(int x, int y) {
        return Square.arrayBoard[x][y].piece;

    }
}
