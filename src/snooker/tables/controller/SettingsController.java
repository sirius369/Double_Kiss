package snooker.tables.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import snooker.tables.data.Tarifa;
import java.util.ArrayList;

public class SettingsController {
    public TableColumn<Tarifa, String> tarifaNaziv;
    public TableColumn<Tarifa, Double> tarifaCijena;
    public TableView<Tarifa> tarifeTbl;
    public ArrayList<Tarifa> tarife = Tarifa.mockupTarife();
    @FXML
    public void initialize(){
        System.out.println("Ovamo bi trebalo da dodje");
        tarifaNaziv.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        tarifaCijena.setCellValueFactory(new PropertyValueFactory<>("cijena"));
        tarifeTbl.setItems(FXCollections.observableArrayList(tarife));
    }

    public void ukloniTarifu(ActionEvent event){
        tarife.remove(tarifeTbl.getSelectionModel().getSelectedItem());
        tarifeTbl.setItems(FXCollections.observableArrayList(tarife));
    }
}
