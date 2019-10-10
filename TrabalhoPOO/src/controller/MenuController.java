/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
public class MenuController implements Initializable {

    @FXML
    private MenuItem menuItemInserir;
    @FXML
    private MenuItem menuItemEditar;
    @FXML
    private MenuItem menuItemExcluir;
    @FXML
    private MenuItem menuItemCriarD;
    @FXML
    private MenuItem menuItemExcluirD;
    @FXML
    private MenuItem menuItemEstatistica;
    @FXML
    private MenuItem menuItemSobre;
    @FXML
    private TableColumn<Cadastro, Integer> tableColumnId;
    @FXML
    private TableColumn<Cadastro, String> tableColumnNome;
    @FXML
    private TableColumn<Cadastro, String> tableColumnCaixa;
    @FXML
    private TableColumn<Cadastro, String> tableColumnRaridade;
    @FXML
    private TableColumn<Cadastro, String> tableColumnPreco;
    @FXML
    private TableColumn<Cadastro, Integer> tableColumnQuantidade;
    @FXML
    public static TextField txtFiltro;
    @FXML
    private Button btnProcurar;
    @FXML
    private Button btnCancelar;
    
    private List<Object> listCadastro;
    private ObservableList<Object> observableListCadastro;
    private Cadastro cadastro;
    @FXML
    private TableView<Object> tableViewCadastro;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableViewCadastro();
    } 
    @FXML
    private void incluir(ActionEvent event) {
       new Util().chamarTela("/view/Incluir.fxml");
       
       carregarTableViewCadastro();
    }
    @FXML
     void carregarTableViewCadastro() {
        try {
            tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idCadastro"));
            tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
            tableColumnCaixa.setCellValueFactory(new PropertyValueFactory<>("Caixa"));
            tableColumnQuantidade.setCellValueFactory(new PropertyValueFactory<>("Quantidade"));
            tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>("Preco"));

            InterfaceDAO dao = new CadastroDAO();
            listCadastro = dao.listar();

            observableListCadastro = FXCollections.observableArrayList(listCadastro);
            tableViewCadastro.setItems(observableListCadastro);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
     private void btnEditarClick(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Inclusao.fxml"));
            Parent root = (Parent) loader.load();
            IncluirController incluirController = loader.getController();
            Cadastro c = (Cadastro) tableViewCadastro.selectionModelProperty()
                    .getValue().getSelectedItem();
            incluirController.setCadastro(c);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            carregarTableViewCadastro();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
 
}
