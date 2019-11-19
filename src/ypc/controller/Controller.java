package ypc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ypc.model.Downloader;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    TextField tfUrl;

    public void DownloadButton(ActionEvent actionEvent) {
        Downloader downloader = new Downloader();
        downloader.Download(tfUrl.getText());
    }

    public void StopButton(ActionEvent actionEvent) {

    }
}
