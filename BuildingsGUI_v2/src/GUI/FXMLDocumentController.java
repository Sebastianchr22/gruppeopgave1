/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import acq.IBuilding;
import acq.ISensor;
import acq.IUI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sebas
 */
public class FXMLDocumentController implements Initializable {

    private IUI ui;

    private Label label;
    @FXML
    private Rectangle SettingsBackdrop;
    private GridPane SensorsGrid;
    @FXML
    private GridPane CreateMenu;
    private ImageView SettingsIcon;
    private Rectangle BuildingBackdrop;
    private GridPane BuildingSensors;
    private Rectangle BuildingSensorGrid;
    private Rectangle BuildingBackdrop1;
    @FXML
    private TextField NameField;
    @FXML
    private TextField AddrField;
    @FXML
    private ListView<acq.ISensor> SensorsList;
    @FXML
    private ListView<acq.IBuilding> BuildingsList;

    private IBuilding building;
    private ISensor sensor;
    @FXML
    private LineChart<ISensor, ISensor> SensorChart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CreateMenu.setOpacity(0);
        CreateMenu.setDisable(true);

        ui = GUIFacade.getInstance();

        BuildingsList.setItems(ui.getBuildings());

        BuildingsList.getSelectionModel().selectedItemProperty().addListener(evt -> {
            building = BuildingsList.getSelectionModel().getSelectedItem();
            if (building != null) {
                SensorsList.setItems(building.getSonsors());
            } else {
                SensorsList.setItems(null);
            }
        });

        NumberAxis xaxis = new NumberAxis("Measurements", 0.0, SensorsList.getItems().size(), 100);
        NumberAxis yaxis = new NumberAxis("Measured", 0, 50, 10);

        XYChart.Series series = new XYChart.Series();
        series.setName("Measurements");
        int count = 0;
        for (ISensor sensor : SensorsList.getItems()) {
            series.getData().add(new XYChart.Data(sensor.getMeasurement(), count));
            count++;
        }

        SensorChart.getData().add(series);
    }

    @FXML
    private void CreateNewBuilding(MouseEvent event) {
        ChangeCreateMenu(1, false);
        if (CreateMenu.isDisable() != true) {
            SensorChart.setOpacity(0);
            SensorChart.setDisable(true);
        }
        if (CreateMenu.isDisable() == true) {
            SensorChart.setOpacity(1);
            SensorChart.setDisable(false);
        }
    }

    @FXML
    private void CreateBuilding(MouseEvent event) {
        ui.createNewBuilding(NameField.getText(), AddrField.getText());
    }

    private void ChangeCreateMenu(int i, boolean bool) {
        CreateMenu.setOpacity(i);
        CreateMenu.setDisable(bool);
    }

    @FXML
    private void CloseCreate(MouseEvent event) {
        ChangeCreateMenu(0, true);
        NameField.clear();
        AddrField.clear();

    }

    @FXML
    private void RemoveSensor(ActionEvent event) {
        sensor = SensorsList.getSelectionModel().getSelectedItem();
        if (sensor == null) {
            ui.removeBuilding(building);
        } else {
            building.removeSensor(sensor);
        }
    }

    @FXML
    private void NewCO2(ActionEvent event) {
        building.addCo2Sensor(120);
    }

    @FXML
    private void NewTemp(ActionEvent event) {
        building.addTempSensor(20);
    }

    @FXML
    private void SimulateSensor(ActionEvent event) {
        ui.SimulateSensor();
        SensorsList.refresh();
        NumberAxis xaxis = new NumberAxis("Measurements", 0.0, SensorsList.getItems().size(), 100);
        NumberAxis yaxis = new NumberAxis("Measured", 0, 50, 10);

        XYChart.Series series = new XYChart.Series();
        series.setName("Measurements");
        int count = 0;
        for (ISensor sensor : SensorsList.getItems()) {

            series.getData().add(new XYChart.Data(sensor.getMeasurements().get(count),count));
            count++;

        }

        SensorChart.getData().add(series);
    }

}
