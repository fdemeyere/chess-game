public class Queen extends Piece {
    public Queen(int x, int y, boolean isWhite, String imgFilePath) {
        super(x, y, isWhite, imgFilePath);
    }

    private boolean moveIsLegal(int x, int y) {
        if (getPieceByIndex(x, y) != null && this.isWhite == getPieceByIndex(x,
                y).isWhite) {
            System.out.println("Can't capture piece of same color");
            return false;
        }

        if (this.y == y) {
            if (this.x > x) {
                for (int i = x + 1; i < this.x; i++) {
                    if (getPieceByIndex(i, y) != null) {
                        System.out.println("Piece is blocking the desired direction");
                        return false;
                    }
                }
                return true;
            } else if (this.x < x) {
                for (int i = this.x + 1; i < x; i++) {
                    if (getPieceByIndex(i, y) != null) {
                        System.out.println("A piece is blocking that direction");
                        return false;
                    }
                }
                return true;
            }
        } else if (this.x == x) {
            if (this.y > y) {
                for (int i = this.y - 1; i > y; i--) {
                    if (getPieceByIndex(x, i) != null) {
                        System.out.println("Piece is blocking the desired direction");
                        return false;
                    }
                }
                return true;
            } else if (this.y < y) {
                for (int i = this.y + 1; i < y; i++) {
                    if (getPieceByIndex(x, i) != null) {
                        System.out.println("Piece is blocking the desired direction");
                        return false;
                    }
                }
                return true;
            }
        } else if (Math.abs(x - this.x) == Math.abs(y - this.y)) {
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

        // System.out.println("x: " + this.x);
        // System.out.println("y: " + this.y);
        if (this.moveIsLegal(x, y)) {
            super.move(x, y);

        }
    }

}