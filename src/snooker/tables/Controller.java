package snooker.tables;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private GridPane stolovi;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Parent root = null;
        try {
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 2; j++){
                    TableController ctrl = new TableController(j * 4 + i + 1);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/table1.fxml"));
                    loader.setController(ctrl);
                    root = loader.load();
                    if ((i + j) % 2 == 0)
                        root.setStyle("-fx-background-color: #C19A6B");
                    else
                        root.setStyle("-fx-background-color: #5D7EA7");
                    GridPane.setFillHeight(root, true);
                    stolovi.setAlignment(Pos.CENTER);
                    GridPane.setHalignment(root, HPos.CENTER);
                    GridPane.setValignment(root, VPos.CENTER);
                    stolovi.add(root, i, j);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
* ResourceBundle bundle = ResourceBundle.getBundle("Translation");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/glavna.fxml"), bundle);
        GeografijaDAO model = GeografijaDAO.getInstance();
        GlavnaController ctrl = new GlavnaController(model);
        ctrl.setJezikS("bs");
        loader.setController(ctrl);
        Parent root = loader.load();
        Locale.setDefault(new Locale("bs", "BA"));
        primaryStage.setTitle(bundle.getString("glavniTitle"));
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
* */