/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildingsgui_v2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Sebas
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private Rectangle SettingsBackdrop;
    @FXML
    private GridPane SensorsGrid;
    @FXML
    private GridPane CreateMenu;
    @FXML
    private ImageView SettingsIcon;
    @FXML
    private Rectangle BuildingBackdrop;
    @FXML
    private GridPane BuildingSensors;
    private Rectangle BuildingSensorGrid;
    private Rectangle BuildingBackdrop1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Started");
        CreateMenu.setOpacity(0);
        CreateMenu.setDisable(true);

        SensorsGrid.setOpacity(0);
        SensorsGrid.setDisable(true);

        SettingsBackdrop.setOpacity(0);
        SettingsBackdrop.setDisable(true);

        SettingsIcon.setOpacity(0);
        SettingsIcon.setDisable(true);

        BuildingBackdrop.setOpacity(0);
        BuildingBackdrop.setDisable(true);

        BuildingSensors.setOpacity(0);
        BuildingSensors.setDisable(true);
        

    }

    @FXML
    private void co2sensorClick(MouseEvent event) {
    }

    @FXML
    private void tempSensor(MouseEvent event) {
    }

    @FXML
    private void CreateNewBuilding(MouseEvent event) {
        ChangeCreateMenu(1,false);
    }

    @FXML
    private void CreateBuilding(MouseEvent event) {
    }

    @FXML
    private void CloseCreate(MouseEvent event) {
        ChangeCreateMenu(0,true);
    }

    @FXML
    private void ShowBuilding(MouseEvent event) {
        ChangeBuildingGrid(1,false);
    }

    @FXML
    private void RemoveBuilding(MouseEvent event) {
    }

    @FXML
    private void CloseBuilding(MouseEvent event) {
        ChangeBuildingGrid(0,true);
    }

    @FXML
    private void ShowBuildingOptions(MouseEvent event) {
        ChangeBuildingOptions(1,false);
        
    }

    @FXML
    private void CloseBuildingOptions(MouseEvent event) {
        ChangeBuildingOptions(0,true);
    }
    private void ChangeCreateMenu(int i, boolean bool){
        CreateMenu.setOpacity(i);
        CreateMenu.setDisable(bool);
    }
    private void ChangeBuildingGrid(int i, boolean bool){
        BuildingSensors.setOpacity(i);
        BuildingSensors.setDisable(bool);
        
        SettingsIcon.setOpacity(i);
        SettingsIcon.setDisable(bool);
    }
    private void ChangeBuildingOptions(int i, boolean bool){
        BuildingBackdrop.setOpacity(i);
        BuildingBackdrop.setDisable(bool);

        SensorsGrid.setOpacity(i);
        SensorsGrid.setDisable(bool);
    }
}
