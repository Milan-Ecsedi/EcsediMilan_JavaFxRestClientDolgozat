package com.example.ecsedimilan_javafxrestclientdolgozat;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ListTankController {

    @FXML
    private Button insertButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TableView<Tank> TankTable;
    @FXML
    private TableColumn<Tank, Integer> idCol;
    @FXML
    private TableColumn<Tank, String> nameCol;
    @FXML
    private TableColumn<Tank, String> countryCol;
    @FXML
    private TableColumn<Tank, Boolean> inserviceCol;
    @FXML
    private TableColumn<Tank,Integer> penetrationCol;



    @FXML
    private void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
        inserviceCol.setCellValueFactory(new PropertyValueFactory<>("inservice"));
        penetrationCol.setCellValueFactory(new PropertyValueFactory<>("penetration"));
        Platform.runLater(() -> {
            try {
                loadTanksFromServer();
            } catch (IOException e) {

                Platform.exit();
            }
        });
    }

    private void loadTanksFromServer() throws IOException {
        Response response = RequestHandler.get(App.BASE_URL);
        String content = response.getContent();
        Gson converter = new Gson();
        Tank[] tanks = converter.fromJson(content, Tank[].class);
        TankTable.getItems().clear();
        for (Tank tank : tanks) {
            TankTable.getItems().add(tank);
        }
    }
    @FXML
    public void insertClick(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("create-person-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            Stage stage = new Stage();
            stage.setTitle("Create tank");
            stage.setScene(scene);
            stage.setOnCloseRequest(event -> {
                try {
                    loadTanksFromServer();
                } catch (IOException e) {
                    error("Nem sikerült kapcsolódni a szerverhez");
                }
            });
            stage.show();
        } catch (IOException e) {
            error("Hiba történt az űrlap betöltése során", e.getMessage());
        }
    }

}