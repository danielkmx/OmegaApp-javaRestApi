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
public class eletroneuroDAO {
    private final ConexaoJDBC con;
    
     public eletroneuroDAO() throws SQLException, ClassNotFoundException{
        this.con = new ConexaoPostgresJDBC();
    }
    
 //anunciante,valor,destaque,imagem_url
        public void insert(List<Eletroneuro> list) throws SQLException, ClassNotFoundException{
            Long id = null;           
            for(Eletroneuro n: list ){
                  
                String sqlQuery = "INSERT INTO eletroneuro(musculonome,inser,repouso,pacienteid,ladomusculo,recrut,potencial)"
                + " VALUES(?,?,?,?,?,?,?)";
                PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);
                stmt.setString(1, n.getMusculonome());
                stmt.setString(2, n.getInser());
                stmt.setString(3, n.getRepouso());
                stmt.setInt(4, n.getPacienteid());
                stmt.setString(5, n.getLadomusculo());
                stmt.setString(6, n.getRecrut());
                stmt.setString(7, n.getPotencial());

                 stmt.executeUpdate();
              

                   
              
            }
            this.con.commit();   
         
                
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
    
        
    public Eletroneuro select(long id) throws SQLException, ClassNotFoundException{
        String sqlQuery = "SELECT * FROM neuromotora WHERE pacienteid = ?";
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
    
    
    private Eletroneuro parser(ResultSet resultSet) throws SQLException{
               Eletroneuro n = new Eletroneuro();
                n.setEletroneuroid(resultSet.getInt("eletroneuroid"));
                n.setInser(resultSet.getString("inser"));
                n.setLadomusculo(resultSet.getString("ladomusculo"));
                n.setMusculonome(resultSet.getString("musculonome"));
                n.setPotencial(resultSet.getString("potencial"));
                n.setRecrut(resultSet.getString("recrut"));
                n.setRepouso(resultSet.getString("repouso"));                
                n.setPacienteid(resultSet.getInt("pacienteid"));
                
                
                return n;                             
                                
                        }
    
    public List<Eletroneuro> listAllEletroneuro(long id) throws SQLException, ClassNotFoundException{
        String sqlQuery = "SELECT * FROM eletroneuro WHERE pacienteid = ?";
        
        try{
            PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);     
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            List<Eletroneuro> lista = new ArrayList<>();
            
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
    
    
    
    public List<Eletroneuro> listAll() throws SQLException, ClassNotFoundException{
        String sqlQuery = "SELECT * FROM eletroneuro";
        
        try{
            PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);     
           
            ResultSet rs = stmt.executeQuery();
            List<Eletroneuro> lista = new ArrayList<>();
            
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


    
          
            
