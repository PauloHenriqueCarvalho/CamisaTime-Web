/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Clube;

/**
 *
 * @author paulo
 */
public class ClubeDAO {
    public void create(Clube c){
        try {
            Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;
            String query = "insert into clube(nome) values (?)";
            
            stmt = conexao.prepareStatement(query);
            stmt.setString(1, c.getNome());
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
                   
        }
    }
    
    public List<Clube> create(){
        List<Clube> clubes = new ArrayList<>();
        try {
            Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;
            String query = "select * from clube";
            
            stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Clube c = new Clube();
                c.setIdClube(rs.getInt("idClube"));
                c.setNome(rs.getString("nome"));
                
                clubes.add(c);
            }
            
            
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
                   
        }
        return clubes;
    }
    
    public void delete(int id){
        try {
            Connection conexao = Conexao.getConn();
            PreparedStatement stmt = null;
            String query = "delete from clube where id = ?";
            
            stmt = conexao.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            conexao.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
                   
        }
    }
}
