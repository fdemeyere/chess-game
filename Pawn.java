public class Pawn extends Piece {
    public Pawn(int x, int y, boolean isWhite, String imgFilePath) {
        super(x, y, isWhite, imgFilePath);
    }

    private boolean moveIsLegal(int x, int y) {
        if (getPieceByIndex(x, y) != null && this.isWhite == getPieceByIndex(x, y).isWhite) {
            System.out.println("Can't capture piece of same color");
            return false;
        }

        boolean captureAttempt = false;
        if (getPieceByIndex(x, y) != null) {
            captureAttempt = true;
        }
        if (captureAttempt) {
            if (this.x + 1 == x || this.x - 1 == x) {
                if (this.isWhite) {
                    if (this.y - 1 == y) {
                        return true;
                    }
                } else {
                    if (this.y + 1 == y) {
                        return true;
                    }
                }
            }

        } else {
            if (this.isWhite) {
                if (this.x == x && this.y - 1 == y && getPieceByIndex(this.x, this.y - 1) == null) {
                    return true;
                } else if (this.x == x && this.y == 6 && y == 4 && getPieceByIndex(this.x, this.y - 2) == null
                        && getPieceByIndex(this.x, y - 1) == null) {
                    return true;
                }
            } else {
                if (this.x == x && this.y + 1 == y && getPieceByIndex(this.x, this.y + 1) == null) {
                    return true;
                } else if (this.x == x && this.y == 1 && y == 3 && getPieceByIndex(this.x, this.y + 2) == null) {
                    return true;
                }
            }
        }

        return false;
    }

    public void move(int x, int y) {

        // System.out.println("x: " + this.x);
        // System.out.println("y: " + this.y);
        if (this.moveIsLegal(x, y)) {
            super.move(x, y);

        }

    }
}
