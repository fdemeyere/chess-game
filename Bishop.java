public class Bishop extends Piece {
    public Bishop(int x, int y, boolean isWhite, String imgFilePath) {
        super(x, y, isWhite, imgFilePath);
    }

    private boolean moveIsLegal(int x, int y) {
        if (getPieceByIndex(x, y) != null && this.isWhite == getPieceByIndex(x,
                y).isWhite) {
            System.out.println("Can't capture piece of same color");
            return false;
        }

        if (Math.abs(x - this.x) == Math.abs(y - this.y)) {
            if (this.x > x && this.y > y) {
                for (int i = this.x - 1, j = this.y - 1; i > x; i--, j--) {
                    if (getPieceByIndex(i, j) != null) {
                        System.out.println("Piece is blocking the desired direction");
                        return false;
                    }
                }
                return true;
            } else if (this.x > x && this.y < y) {
                for (int i = this.x - 1, j = this.y + 1; i > x; i--, j++) {
                    if (getPieceByIndex(i, j) != null) {
                        System.out.println("Piece is blocking the desired direction");
                        return false;
                    }
                }
                return true;
            } else if (this.x < x && this.y > y) {
                for (int i = this.x + 1, j = this.y - 1; i < x; i++, j--) {
                    if (getPieceByIndex(i, j) != null) {
                        System.out.println("Piece is blocking the desired direction");
                        return false;
                    }
                }
                return true;

            } else if (this.x < x && this.y < y) {
                for (int i = this.x + 1, j = this.y + 1; i < x; i++, j++) {
                    if (getPieceByIndex(i, j) != null) {
                        System.out.println("Piece is blocking the desired direction");
                        return false;
                    }
                }
                return true;

            }

        }
        return false;
    }

    public void move(int x, int y) {
        if (this.moveIsLegal(x, y)) {
            super.move(x, y);

        }
    }
}
