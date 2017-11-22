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
public class neurosensiDAO {
    private final ConexaoJDBC con;
    
     public neurosensiDAO() throws SQLException, ClassNotFoundException{
        this.con = new ConexaoPostgresJDBC();
    }
    
 //anunciante,valor,destaque,imagem_url
        public void insert(List<Neurosensi> list) throws SQLException, ClassNotFoundException{
            Long id = null;           
            for(Neurosensi n: list ){
                  
                String sqlQuery = "INSERT INTO neurosensi(nervonome,latencia,amplitude,pacienteid,nervolado)"
                + " VALUES(?,?,?,?,?)";
                PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);
                stmt.setString(1, n.getNervonome());
                stmt.setString(2, n.getLatencia());
                stmt.setString(3, n.getAmplitude());
                stmt.setInt(4, n.getPacienteid());
                stmt.setString(5, n.getNervolado());

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
    
        
    public Neurosensi select(long id) throws SQLException, ClassNotFoundException{
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
    
    
    private Neurosensi parser(ResultSet resultSet) throws SQLException{
                Neurosensi n = new Neurosensi();
                n.setAmplitude(resultSet.getString("amplitude"));
                n.setLatencia(resultSet.getString("latencia"));
                n.setNervolado(resultSet.getString("nervolado"));
                n.setNervonome(resultSet.getString("nervonome"));
                n.setPacienteid(resultSet.getInt("pacienteid"));
                n.setNeurosensid(resultSet.getInt("neurosensid"));
                
                
                return n;                             
                                
                        }
    
    public List<Neurosensi> listAllNeurosensi(long id) throws SQLException, ClassNotFoundException{
        String sqlQuery = "SELECT * FROM neurosensi WHERE pacienteid = ?";
        
        try{
            PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);     
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            List<Neurosensi> lista = new ArrayList<>();
            
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
    public List<Neurosensi> listAll() throws SQLException, ClassNotFoundException{
        String sqlQuery = "SELECT * FROM neurosensi";
        
        try{
            PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);    
            
            ResultSet rs = stmt.executeQuery();
            List<Neurosensi> lista = new ArrayList<>();
            
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
            
