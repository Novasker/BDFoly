/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author lefoly
 */
public class Util {

    public void chamarTela(String arquivo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(arquivo));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.show();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
    }

    public void fecharTela(Button button) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
}
