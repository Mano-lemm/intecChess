package be.personal.GUIRedesign;

import java.io.IOException;

import be.personal.board.chess;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class ChessGUIRemake extends Application{
    @FXML
    private Button resetButton;
    @FXML
    private GridPane grid;
    @FXML
    private Label turnLabel;
    private static boolean anySelected;
    private static ChessButton selectedButton;
    private static Scene scene;
    private static ChessButton[][] board;
    private static chess game;

    @Override
    public void start(Stage stage) throws Exception {
        game = new chess();
        scene = new Scene(loadFXML("chessBase"), 1000, 800);
        stage.setTitle("Chess game");
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(){
        grid.setStyle("height = 900.0");
        game = new chess();
        board = new ChessButton[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                final ChessButton but = new ChessButton(game.getBoard()[7 - i][j], 7 - i, j);
                but.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent arg0) {
                        if(but.isSelected()){
                            but.deSelect();
                            anySelected = false;
                            selectedButton = null;
                        } else if(!anySelected){
                            but.select();
                            anySelected = true;
                            selectedButton = but;
                        } else {
                            selectedButton.deSelect();
                            if(game.move(new int[]{selectedButton.x, selectedButton.y}, new int[]{but.x, but.y})){
                                selectedButton.update(game.getBoard()[selectedButton.x][selectedButton.y]);
                                but.update(game.getBoard()[but.x][but.y]);
                            }
                            anySelected = false;
                            selectedButton = null;
                        }
                    }
                });
                board[7 - i][j] = but;
            }
            grid.addRow(i, board[7 - i]);
        }
        
        for (int i = 0; i < 8; i++) {
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setVgrow(Priority.ALWAYS);
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setHgrow(Priority.ALWAYS);
            grid.getRowConstraints().add(rc);
            grid.getColumnConstraints().add(cc);
        }
    }

    private Parent loadFXML(String name) throws IOException{
        FXMLLoader loader = new FXMLLoader(ChessGUIRemake.class.getClassLoader().getResource(name + ".fxml"));
        return loader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
