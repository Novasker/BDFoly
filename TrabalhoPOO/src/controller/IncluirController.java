/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import model.Cadastro;
import model.dao.CadastroDAO;
import model.dao.InterfaceDAO;
import util.Util;

/**
 * FXML Controller class
 *
 * @author Essencia
 */
public class IncluirController implements Initializable {

    @FXML
    private Button btnInserir;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCaixa;
    @FXML
    private TextField txtPreco;
    @FXML
    private TextField txtQuantidade;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
     @FXML
    private void gravar(ActionEvent event) {
        try {
            String nome = txtNome.getText();
            String caixa = txtCaixa.getText();
            String quantidade = txtQuantidade.getText();
            String preco = txtPreco.getText();
            InterfaceDAO dao = new CadastroDAO();
            dao.incluir(new Cadastro(nome, caixa, quantidade, preco));
            new Util().fecharTela(btnCancelar);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
}
