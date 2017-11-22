/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dggodoi.aprendendo.java.data;

import io.github.dggodoi.aprendendo.java.backend.infra.ConexaoJDBC;
import io.github.dggodoi.aprendendo.java.backend.infra.ConexaoPostgresJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ kmx
 */
public class ofertaDAO {
    private final ConexaoJDBC con;
    
    
    public ofertaDAO() throws SQLException, ClassNotFoundException{
        this.con = new ConexaoPostgresJDBC();
    }
    
    //anunciante,valor,destaque,imagem_url
    public Long insert(Oferta oferta) throws SQLException, ClassNotFoundException{
        Long id = null;
        String sqlQuery = "INSERT INTO ofertas(categoria,titulo,descricao_oferta) VALUES(?,?,?) RETURNING id";
        try{
            PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);
            stmt.setString(1,oferta.getCategoria());
            stmt.setString(2,oferta.getTitulo());
            stmt.setString(3,oferta.getDescricao_oferta());
            //stmt.setString(4,oferta.getAnunciante());
            //stmt.setDouble(5, oferta.getValor());
            //stmt.setString(6, oferta.getDestaque());
            //stmt.setString(7,oferta.getImagens());
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                id = rs.getLong("id");
            }
            
            this.con.commit();        
            }
        catch(SQLException e){
            this.con.rollback();
            throw e;
            }
            return id;
            }        
        
    
    
    public int alter(Oferta oferta)throws SQLException, ClassNotFoundException{
        String sqlQuery = "UPDATE ofertas SET categoria = ?,titulo = ? ,descricao_oferta = ? WHERE id = ?";
        int linhasAfetadas = 0;
           try{
            PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);
            stmt.setString(1,oferta.getCategoria());
            stmt.setString(2,oferta.getTitulo());
            stmt.setString(3,oferta.getDescricao_oferta());          
            stmt.setDouble(4, oferta.getId());
            
            linhasAfetadas = stmt.executeUpdate();            
            this.con.commit();        
            }
        catch(SQLException e){
            this.con.rollback();
            throw e;
            }
            return linhasAfetadas;
            }
    
    public int delete(long id) throws SQLException, ClassNotFoundException{
        int linhasAlteradas = 0;
        String sqlQuery = "DELETE FROM ofertas WHERE id = ?";
        try{
            PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);
            stmt.setLong(1,id);
            linhasAlteradas = stmt.executeUpdate();
            this.con.commit();        
            }
        catch(SQLException e){
            this.con.rollback();
            throw e;
            }
            return linhasAlteradas;
            }
    
        
    public Oferta select(long id) throws SQLException, ClassNotFoundException{
        String sqlQuery = "SELECT * FROM Ofertas WHERE id = ?";
        try{
            PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                return parser(rs);
            }
          }
        catch(SQLException e){
            this.con.rollback();
            throw e;
            }
            return null;
            }
    
    
    private Oferta parser(ResultSet resultSet) throws SQLException{
                Oferta of = new Oferta();
                of.setAnunciante(resultSet.getString("anunciante"));
                of.setCategoria(resultSet.getString("categoria"));
                of.setDescricao_oferta(resultSet.getString("descricao_oferta"));
                of.setDestaque(resultSet.getString("destaque"));
                of.setId(resultSet.getInt("id"));
                of.setImagens(resultSet.getString("imagem_url"));
                of.setTitulo(resultSet.getString("titulo"));
                of.setValor(resultSet.getInt("valor"));
                
                return of;                             
                                
                        }
    
    public List<Oferta> listAll() throws SQLException, ClassNotFoundException{
        String sqlQuery = "SELECT * FROM ofertas ORDER BY id";
        
        try{
            PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);            
            ResultSet rs = stmt.executeQuery();
            List<Oferta> lista = new ArrayList<>();
            
            while(rs.next()){
                lista.add(parser(rs));
            }
            return lista;
            }
        catch(SQLException e){
            this.con.rollback();
            throw e;
              }   
        
            }   
    
          }
            
                        
            

          
             
        
    

        
        
        
    
    
   
    
    
    
    

