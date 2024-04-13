public class Knight extends Piece {
    public Knight(int x, int y, boolean isWhite, String imgFilePath) {
        super(x, y, isWhite, imgFilePath);
    }

    private boolean moveIsLegal(int x, int y) {
        if (getPieceByIndex(x, y) != null && this.isWhite == getPieceByIndex(x, y).isWhite) {
            System.out.println("Can't capture piece of same color");
            return false;
        }

        if (Math.abs(x - this.x) == 2 && Math.abs(y - this.y) == 1) {
            return true;
        } else if (Math.abs(x - this.x) == 1 && Math.abs(y - this.y) == 2) {
            return true;
        }
        return false;

    }

    public void move(int x, int y) {
        if (this.moveIsLegal(x, y)) {
            super.move(x, y);

        }

    }
}
