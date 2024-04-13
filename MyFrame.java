
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MyFrame extends JFrame implements MouseListener {

    public int[] fromIndex;
    private boolean gameIsOn = false;
    public static boolean currentPlayerIsWhite = true;

    public MyFrame() {

        this.setTitle("Chess");
        this.setSize(850, 850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);

        // JButton b = new JButton("lol");
        // b.setBounds(130, 100, 100, 40);

        this.setLayout(null);
        // this.add(b);

        // Create checkerboard pattern
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j += 2) {
                boolean isGreen = false;
                if (i % 2 != 0) {
                    isGreen = true;
                }
                Square square = new Square(i, j, isGreen);
                square.addMouseListener(this);

                this.add(square);

            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 8; j += 2) {
                boolean isGreen = false;
                if (i % 2 == 0) {
                    isGreen = true;
                }
                Square square = new Square(i, j, isGreen);
                square.addMouseListener(this);
                this.add(square);
            }
        }

        createPieces();
        startGame();

        this.setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        return;
    }

    public void mousePressed(MouseEvent e) {
        if (gameIsOn) {
            if (e.getComponent() instanceof Square) {

                Square square = (Square) e.getComponent();
                if (fromIndex == null) {
                    if (square.piece != null) {
                        fromIndex = new int[] { square.piece.x, square.piece.y };
                        Square.arrayBoard[fromIndex[0]][fromIndex[1]].setBackground(new Color(88, 252, 43));
                    }

                } else if (fromIndex[0] == square.x && fromIndex[1] == square.y) {
                    Square fromSquare = Square.arrayBoard[fromIndex[0]][fromIndex[1]];
                    fromSquare.setBackground(fromSquare.color);
                    fromIndex = null;
                } else {

                    Square fromSquare = Square.arrayBoard[fromIndex[0]][fromIndex[1]];

                    fromSquare.setBackground(fromSquare.color);
                    fromSquare.piece.move(square.x, square.y);
                    fromIndex = null;

                }

                // square.add(fromSquare.piece.label);

                revalidate();
                repaint();
            }
        }

    }

    public void mouseReleased(MouseEvent e) {
        return;
    }

    public void mouseEntered(MouseEvent e) {
        return;
    }

    public void mouseExited(MouseEvent e) {
        return;
    }

    private void createPieces() {
        for (int i = 0; i < 8; i++) {
            Square.arrayBoard[i][6].piece = new Pawn(i, 6, true,
                    "S:\\Java\\images\\Chess_plt45.svg.png");
        }

        for (int i = 0; i < 8; i++) {
            Square.arrayBoard[i][1].piece = new Pawn(i, 1, false,
                    "S:\\Java\\images\\Chess_pdt45.svg.png");

        }

        Square.arrayBoard[3][7].piece = new Queen(3, 7, true,
                "S:\\Java\\images\\Chess_qlt45.svg.png");

        Square.arrayBoard[0][0].piece = new Rook(0, 0, false,
                "S:\\Java\\images\\Chess_rdt45.svg.png");

        Square.arrayBoard[2][0].piece = new Bishop(2, 0, false,
                "S:\\Java\\images\\Chess_bdt60.png");

        Square.arrayBoard[6][7].piece = new Knight(6, 7, true,
                "S:\\Java\\images\\Chess_nlt45.svg.png");

        Square.arrayBoard[4][7].piece = new King(4, 7, true,
                "S:\\Java\\images\\Chess_klt45.svg.png");
    }

    public void startGame() {

        gameIsOn = true;
    }

}
