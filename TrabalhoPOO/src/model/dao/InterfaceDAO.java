/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author lefoly
 */
public interface InterfaceDAO {
    
    public abstract Connection conectar() throws Exception;
    
    public abstract void incluir(Object o) throws Exception;

    public abstract void editar(Object o) throws Exception;

    public abstract void excluir(Object o) throws Exception;

    public abstract Object pesquisar(int id) throws Exception;

    public abstract List<Object> listar() throws Exception;
    

}
