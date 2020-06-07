package tetris;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import tetris.tetromino.Tetromino;
import tetris.tetromino.TetrominoHandler;

public class PlayFieldView {

    private final AnchorPane pane;
    private final TetrominoHandler tetrominoHandler;

    public PlayFieldView(TetrominoHandler tetrominoHandler) {
        pane = new AnchorPane();
        pane.requestFocus();
        pane.setMaxHeight(800);
        pane.setMinWidth(400);

        pane.setStyle("-fx-border-color: blue");
        this.tetrominoHandler = tetrominoHandler;
    }

    public AnchorPane getView() {
        return pane;
    }

    public void update() {
        for (Tetromino tetromino: tetrominoHandler.getTetrominoes()) {
            if (tetromino != null && this.pane != null) {
                ObservableList<Node> paneChildren = this.pane.getChildren();
                Group squares = tetromino.getSquares();
                if (!paneChildren.contains(squares)) {
                    paneChildren.add(tetromino.getSquares());
                }

                tetromino.moveDown();
            }
        }
    }


}
