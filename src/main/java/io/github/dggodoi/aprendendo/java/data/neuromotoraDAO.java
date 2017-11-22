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
public class neuromotoraDAO {
    private final ConexaoJDBC con;
    
     public neuromotoraDAO() throws SQLException, ClassNotFoundException{
        this.con = new ConexaoPostgresJDBC();
    }
    
 //anunciante,valor,destaque,imagem_url
        public void insert(List<Neuromotora> list) throws SQLException, ClassNotFoundException{
            Long id = null;           
            for(Neuromotora n: list ){
                  
                String sqlQuery = "INSERT INTO neuromotora(nervonome,latencia,amplitudedistal,amplitudeprox,velocidade,ondaf,pacienteid,ladonervo)"
                + " VALUES(?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);
                stmt.setString(1,n.getNervonome());
                stmt.setString(2,n.getLatencia());
                stmt.setString(3,n.getAmplitudedistal());
                stmt.setString(4,n.getAmplitudeprox());
                stmt.setString(5,n.getVelocidade());
                  stmt.setString(6,n.getOndaf());
                stmt.setInt(7,n.getPacienteid());
                stmt.setString(8,n.getLadonervo());


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
    
        
    public Neuromotora select(long id) throws SQLException, ClassNotFoundException{
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
    
    
    private Neuromotora parser(ResultSet resultSet) throws SQLException{
                Neuromotora n = new Neuromotora();
                n.setAmplitudedistal(resultSet.getString("amplitudedistal"));
                n.setAmplitudeprox(resultSet.getString("amplitudeprox"));
                n.setLadonervo(resultSet.getString("ladonervo"));
                n.setLatencia(resultSet.getString("latencia"));
                n.setNervonome(resultSet.getString("nervonome"));
                n.setNeuromotoraid(resultSet.getInt("neuromotoraid"));
                n.setOndaf(resultSet.getString("ondaf"));
                n.setVelocidade(resultSet.getString("amplitudedistal"));
                n.setPacienteid(resultSet.getInt("pacienteid"));
                
                
                return n;                             
                                
                        }
    
    public List<Neuromotora> listAllNeuromotora(long id) throws SQLException, ClassNotFoundException{
        String sqlQuery = "SELECT * FROM neuromotora WHERE pacienteid = ?";
        
        try{
            PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);     
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            List<Neuromotora> lista = new ArrayList<>();
            
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
      public List<Neuromotora> listAll() throws SQLException, ClassNotFoundException{
        String sqlQuery = "SELECT * FROM neuromotora";
        
        try{
            PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);     
            
            ResultSet rs = stmt.executeQuery();
            List<Neuromotora> lista = new ArrayList<>();
            
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
            
