import javax.swing.JPanel;

import java.awt.Color;

public class Square extends JPanel {
    public static Square[][] arrayBoard = new Square[8][8];

    public Piece piece;
    public Color color = new Color(250, 250, 250);

    public int x;
    public int y;

    public Square(int x, int y, boolean isGreen) {
        arrayBoard[x][y] = this;
        this.x = x;
        this.y = y;

        if (isGreen) {
            color = new Color(22, 130, 51);
            this.setBackground(color);
        }
        this.setBounds(x * 100, y * 100, 100, 100);

    }

}
