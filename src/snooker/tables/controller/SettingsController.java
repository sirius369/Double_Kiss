package snooker.tables.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import snooker.tables.data.Tarifa;

public class SettingsController {
    public TableColumn<Tarifa, String> tarifaNaziv;
    public TableColumn<Tarifa, Double> tarifaCijena;

    @FXML
    public void initalize(){
        tarifaNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tarifaCijena.setCellValueFactory(new PropertyValueFactory<>("cijena"));
    }
}
