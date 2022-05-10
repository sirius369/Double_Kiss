package snooker.tables.controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    private int redniBroj, sati = 0;
    private double cijenaPS = 2.0;
    private boolean isRunning = false;
    @FXML
    private Label stoOznaka;
    @FXML
    private Label vrijemeLabel;
    @FXML
    private Label cijenaLabel;
    @FXML
    private ChoiceBox izborCijena;
    @FXML
    private Button zauzmiBtn;
    public TableController(int redniBroj){
        this.redniBroj = redniBroj;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        stoOznaka.setText("Sto " + redniBroj);
        vrijemeLabel.setText("00:00:00");
        cijenaLabel.setText("0.0");
        izborCijena.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                if ((Integer) number2 == 0)
                    cijenaPS = 2.5;
                else
                    cijenaPS = 2.0;
                System.out.println("Nova cijena je " + cijenaPS);
            }
        });
    }

    public void pocniBrojanje(ActionEvent event){
        isRunning = true;
        System.out.println("STISNUTO");
        zauzmiBtn.setDisable(true);
        izborCijena.setDisable(true);
        new Thread(() -> {
                long startTime = System.nanoTime();
                while (isRunning){
                    try {
                        Thread.sleep(90);
                        Platform.runLater(() -> {
                            vrijemeLabel.setText(formatirajVrijeme(System.nanoTime() - startTime));
                            cijenaLabel.setText(sati * cijenaPS + "");
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Platform.runLater(() -> {
                vrijemeLabel.setText("00:00:00");
                cijenaLabel.setText("0.0");
            });
        }).start();
    }

    public void zaustavi(ActionEvent event) throws InterruptedException {
        isRunning = false;
        zauzmiBtn.setDisable(false);
        izborCijena.setDisable(false);
    }

    private String formatirajVrijeme(long miliSekunde){
        long nanoSecondsPerSecond = 1000000000;
        long nanoSecondsPerMinute = 60000000000L;
        long nanoSecondsPerHour = 3600000000000L;
        int sati = (int)(miliSekunde / nanoSecondsPerHour);
        int minute = (int)((miliSekunde - sati * nanoSecondsPerHour) / nanoSecondsPerMinute);
        int sekunde = (int)((miliSekunde - sati * nanoSecondsPerHour - minute * nanoSecondsPerMinute) / nanoSecondsPerSecond);
        String ret;
        ret = (sati < 10) ? "0"+sati + ":" : sati + ":";
        ret += (minute < 10) ? "0"+minute + ":" : minute + ":";
        ret += (sekunde < 10) ? "0"+sekunde : sekunde + "";
        this.sati = sekunde;
        return ret;
    }

}
