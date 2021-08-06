package ua.com.alevel.level1.khightMove;

public abstract class Piece extends ChessBoardSquare {

    public Piece(String color, String typeOfObjectOnTheSquare) {
        super(typeOfObjectOnTheSquare);
        this.color = color;
    }
}
