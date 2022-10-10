package be.personal.GUI;

import java.io.IOException;

import be.personal.board.chess;
import be.personal.pieces.color;
import be.personal.pieces.piece;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.fxml.*;
import javafx.geometry.HPos;
import javafx.geometry.VPos;

public class chessGUI extends Application{
    @FXML
    private Button resetButton;
    @FXML
    private GridPane grid;
    @FXML
    private Label turnLabel;
    private static chess game;
    private static Scene scene;
    private static int[] selected;

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFXML("chessBase"), 1000, 800);
        stage.setTitle("Chess game");
        stage.setScene(scene);
        stage.show();
    }

    // TODO: bind pictures to each piece
    public Button pieceButton(piece p){
        Button but = new Button();
        but.setText(p.toString());
        return but;
    }

    @SuppressWarnings("static-access")
    private void initBoard(){
        updateTurnLabel();
        piece[][] bord = game.getBoard();
        String style;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                style = "-fx-text-fill: #00FFFF;";
                Button but = pieceButton(bord[j][i]);
                but.setMaxSize(400, 400);
                if((i + j) % 2 == 0){
                    style += "-fx-background-color: Black;";
                } else {
                    style += "-fx-background-color: White;";
                }
                but.setStyle(style);
                but.setOnAction(event -> {
                    Button src = (Button) event.getSource();
                    int[] pos = new int[]{grid.getRowIndex(src), grid.getColumnIndex(src)};
                    if(selected[0] == -1 || selected[1] == -1){
                        selected = pos;
                        src.setStyle("-fx-text-fill: #00FFFF; -fx-background-color: Gray;");
                    } else {
                        game.move(selected, pos);
                        initBoard();
                        selected = new int[]{-1, -1};
                    }
                    if(game.isGameOver()){
                        endOfGame();
                    }
                });
                grid.add(but, i, j);
                grid.setHalignment(but, HPos.CENTER);
                grid.setHgrow(but, Priority.ALWAYS);
                grid.setValignment(but, VPos.CENTER);
                grid.setVgrow(but, Priority.ALWAYS);
            } 
        }
    }

    private void updateTurnLabel() {
        turnLabel.setText(game.getTurn());
    }

    public void initialize(){
        resetButton.setOnAction(event -> {
            game.newGame();
            initBoard();
        });
        initBoard();
    }

    private void endOfGame() {
        grid.getChildren().clear();
        if(chess.turn == color.WHITE){
            turnLabel.setText("Black has won!");
        } else {
            turnLabel.setText("White has won!");
        }
    }

    private Parent loadFXML(String name) throws IOException{
        FXMLLoader loader = new FXMLLoader(chessGUI.class.getClassLoader().getResource(name + ".fxml"));
        return loader.load();
    }
    
    public static void main(String[] args) {
        game = new chess();
        selected = new int[]{-1, -1};
        launch();
    }
}
