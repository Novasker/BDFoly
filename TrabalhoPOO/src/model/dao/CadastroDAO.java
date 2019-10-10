/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import controller.MenuController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cadastro;

/**
 *
 * @author lefoly
 */
public class CadastroDAO implements InterfaceDAO {

    private Connection conn;
    private PreparedStatement ps;
    private String sql;
    private ResultSet rs;

    @Override
    public Connection conectar() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cadastro", "root", "root");
        return conn;
    }

    @Override
    public void incluir(Object o) throws Exception {
        conn = conectar();
        Cadastro c = (Cadastro) o;
        sql = "INSERT INTO registro VALUES(?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, "0");
        ps.setString(2, c.getNome());
        ps.setString(3, c.getCaixa());
        ps.setString(4, c.getQuantidade());
        ps.setString(5, c.getPreco());
        ps.execute();
    }

    @Override
    public void editar(Object o) throws Exception {
        conn = conectar();
        Cadastro c = (Cadastro) o;
        sql = "UPDATE registro SET nome=?, caixa=?, quantidade=?, preco=? WHERE idCadastro=?";
        ps = conn.prepareStatement(sql);
        ps.setString(2, c.getNome());
        ps.setString(3, c.getCaixa());
        ps.setString(4, c.getQuantidade());
        ps.setString(5, c.getPreco());
        ps.execute();
    }

    @Override
    public void excluir(Object o) throws Exception {
        conn = conectar();
        Cadastro c = (Cadastro) o;
        sql = "DELETE FROM registro WHERE id=?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, c.getIdCadastro());
        ps.execute();
    }

    @Override
    public Object pesquisar(int id) throws Exception {
        conn = conectar();
        sql = "SELECT * FROM registro WHERE id = " + id;
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        Cadastro c = null;
        if (rs.next()) {
            c = new Cadastro();
            c.setIdCadastro(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setCaixa(rs.getString("caixa"));
            c.setQuantidade(rs.getString("quantidade"));
            c.setPreco(rs.getString("preco"));
        }        
        return c;
    }

    @Override
    public List<Object> listar() throws Exception {
        conn = conectar();
        sql = "SELECT * FROM registro";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        List<Object> lista = new ArrayList();

        while (rs.next()) {
            Cadastro c = new Cadastro();
           c.setIdCadastro(rs.getInt("idCadastro"));
            c.setNome(rs.getString("nome"));
            c.setCaixa(rs.getString("caixa"));
            c.setQuantidade(rs.getString("quantidade"));
            c.setPreco(rs.getString("preco"));
            lista.add(c);
        }
        return lista;
    }
}
