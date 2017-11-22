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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @ kmx
 */
public class pacienteDAO {
    private final ConexaoJDBC con;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    
     public pacienteDAO() throws SQLException, ClassNotFoundException{
        this.con = new ConexaoPostgresJDBC();
    }
    
 //anunciante,valor,destaque,imagem_url
    public Long insert(Paciente oferta) throws SQLException, ClassNotFoundException, ParseException{
        
        Long id = null;
        String sqlQuery = "INSERT INTO paciente(pacientenome,pacientesexo,pacientedatanasc,pacientetipoexame,medicosolicitante,especmedica,hda,telmedico,pacienteconvenio,pacientedataexame)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?) RETURNING pacienteid";
        Date dataExame = formatter.parse(oferta.getPacientedataexame());
        java.sql.Date sqlDate = new java.sql.Date(dataExame.getTime());
        try{
            PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);
            stmt.setString(1,oferta.getPacientenome());
            stmt.setString(2,oferta.getPacientesexo());
            stmt.setString(3,oferta.getPacientedatanasc());
            stmt.setString(4,oferta.getPacientetipoexame());
            stmt.setString(5, oferta.getMedicosolicitante());
            stmt.setString(8, oferta.getTelmedico());
            stmt.setString(6,oferta.getSpecmedica());
            stmt.setString(7,oferta.getHda());
            stmt.setString(9,oferta.getPacienteconvenio());
            stmt.setDate(10, sqlDate);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                id = rs.getLong("pacienteid");
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
        String sqlQuery = "DELETE FROM paciente WHERE pacienteid = ?";
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
    
        
    public Paciente select(long id) throws SQLException, ClassNotFoundException{
        String sqlQuery = "SELECT * FROM paciente WHERE pacienteid = ?";
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
    
    
    private Paciente parser(ResultSet resultSet) throws SQLException{
                Paciente of = new Paciente();
                
                of.setMedicosolicitante(resultSet.getString("medicosolicitante"));
                of.setId(resultSet.getInt("pacienteid"));
                of.setPacientedatanasc(resultSet.getString("pacientedatanasc"));
                of.setHda(resultSet.getString("hda"));
                of.setPacientenome(resultSet.getString("pacientenome"));
                of.setPacientesexo(resultSet.getString("pacientesexo"));
                of.setPacientetipoexame(resultSet.getString("pacientetipoexame"));
                of.setSpecmedica(resultSet.getString("especmedica"));
                of.setTelmedico(resultSet.getString("telmedico"));     
                of.setPacienteconvenio(resultSet.getString("pacienteconvenio"));
                of.setPacientedataexame(resultSet.getString("pacientedataexame"));
                
                return of;                             
                                
                        }
    
    public List<Paciente> listAll() throws SQLException, ClassNotFoundException{
        String sqlQuery = "SELECT * FROM paciente ORDER BY pacienteid";
        
        try{
            PreparedStatement stmt = this.con.getConnection().prepareStatement(sqlQuery);            
            ResultSet rs = stmt.executeQuery();
            List<Paciente> lista = new ArrayList<>();
            
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
            
