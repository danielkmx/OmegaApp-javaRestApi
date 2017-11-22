/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dggodoi.aprendendo.java.backend.controllers;



import io.github.dggodoi.aprendendo.java.data.Eletroneuro;
import io.github.dggodoi.aprendendo.java.data.Neuromotora;
import io.github.dggodoi.aprendendo.java.data.Neurosensi;
import io.github.dggodoi.aprendendo.java.data.Oferta;
import io.github.dggodoi.aprendendo.java.data.Paciente;
import io.github.dggodoi.aprendendo.java.data.Status;
import io.github.dggodoi.aprendendo.java.data.eletroneuroDAO;
import io.github.dggodoi.aprendendo.java.data.neuromotoraDAO;
import io.github.dggodoi.aprendendo.java.data.neurosensiDAO;
import io.github.dggodoi.aprendendo.java.data.ofertaDAO;
import io.github.dggodoi.aprendendo.java.data.pacienteDAO;
import io.github.dggodoi.aprendendo.java.data.pacientesdbDAO;
import java.net.URI;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import static javax.ws.rs.client.Entity.entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @ kmx
 */

@Path("chamados")
public class ChamadoController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response listChamados(){
        List<Paciente> pacientes = new ArrayList<>();
        try{
            pacienteDAO dao = new pacienteDAO();
            pacientes = dao.listAll();
        }
        catch(SQLException | ClassNotFoundException ex){
           // Logger.getLogger(ChamadoController.class).log(Level.SEVERE, null,ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);            
        }                  
        
       
        
         return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(pacientes)
            .build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/fichasdia/")
    public Response listFichasDia(){
        List<Paciente> pacientes = new ArrayList<>();
        try{
            pacienteDAO dao = new pacienteDAO();
            pacientes = dao.listAll();
        }
        catch(SQLException | ClassNotFoundException ex){
           // Logger.getLogger(ChamadoController.class).log(Level.SEVERE, null,ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);            
        }                  
        
       
        
         return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(pacientes)
            .build();
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Response getChamado(@PathParam("id") long id) throws SQLException, ClassNotFoundException{
            Paciente paciente = new Paciente();
            pacienteDAO dao = new pacienteDAO();
           
           paciente = dao.select(id);
           
        
           return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(paciente)
            .build();
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/fichasdia/{id}/")
    public Response getFichaDiaById(@PathParam("id") long id) throws SQLException, ClassNotFoundException{
            Paciente paciente = new Paciente();
            pacienteDAO dao = new pacienteDAO();
           
           paciente = dao.select(id);
           
        
           return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(paciente)
            .build();
        
    }
    
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Paciente p) throws SQLException, ClassNotFoundException, ParseException{
        pacienteDAO dao = new pacienteDAO();
           
        dao.insert(p);
        
        return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(p)
            .build();
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/pacientesdb")
    public Response transferToPacientesdb(Paciente p) throws SQLException, ClassNotFoundException, ParseException{
        pacientesdbDAO dao = new pacientesdbDAO();
           
        dao.insert(p);
        
        return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(p)
            .build();
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/neuromotora/")
    public Response createNeuromotora(List<Neuromotora> n) throws SQLException, ClassNotFoundException{
        neuromotoraDAO dao = new neuromotoraDAO();
           
        dao.insert(n);
        
        return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(n)
            .build();
        
    }
    
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/neuromotora/{id}/")
    public Response listNeuromotora(@PathParam("id")long id){
        List<Neuromotora> tabelas = new ArrayList<>();
        try{
            neuromotoraDAO dao = new neuromotoraDAO();
            tabelas = dao.listAllNeuromotora(id);
        }
        catch(SQLException | ClassNotFoundException ex){
           // Logger.getLogger(ChamadoController.class).log(Level.SEVERE, null,ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);            
        }                  
        
       
        
         return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(tabelas)
            .build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/neurosensi/")
    public Response createNeurosensi(List<Neurosensi> n) throws SQLException, ClassNotFoundException{
        neurosensiDAO dao = new neurosensiDAO();
           
        dao.insert(n);
        
        return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(n)
            .build();
        
    }
    
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/neurosensi/{id}/")
    public Response listNeurosensi(@PathParam("id")long id){
        List<Neurosensi> tabelas = new ArrayList<>();
        try{
            neurosensiDAO dao = new neurosensiDAO();
            tabelas = dao.listAllNeurosensi(id);
        }
        catch(SQLException | ClassNotFoundException ex){
           // Logger.getLogger(ChamadoController.class).log(Level.SEVERE, null,ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);            
        }                  
        
       
        
         return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(tabelas)
            .build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/eletroneuro/")
    public Response createEletroneuro(List<Eletroneuro> n) throws SQLException, ClassNotFoundException{
       eletroneuroDAO dao = new eletroneuroDAO();
           
        dao.insert(n);
        
        return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(n)
            .build();
        
    }
      @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/eletroneuro/{id}/")
    public Response listEletroneuro(@PathParam("id")long id){
        List<Eletroneuro> tabelas = new ArrayList<>();
        try{
            eletroneuroDAO dao = new eletroneuroDAO();
            tabelas = dao.listAllEletroneuro(id);
        }
        catch(SQLException | ClassNotFoundException ex){
           // Logger.getLogger(ChamadoController.class).log(Level.SEVERE, null,ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);            
        }                  
        
       
        
         return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(tabelas)
            .build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)    
    @Path("/fichasdia/{id}/")   
    public Response delete(@PathParam("id") long id) throws SQLException, ClassNotFoundException{
        pacienteDAO dao = new pacienteDAO();
        dao.delete(id);
        
        return Response.status(200).entity(id).build();
        
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pacientesdb/{data}/")
    public Response getPacientesdb(@PathParam("data") String data) throws SQLException, ClassNotFoundException, ParseException{
            List<Paciente> pacientes = new ArrayList<>();
        
            pacientesdbDAO dao = new pacientesdbDAO();
           
           pacientes = dao.listAll(data);
           
        
           return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(pacientes)
            .build();
        
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/eletroneuroall/")
    public Response listEletroneuro(){
        List<Eletroneuro> eletro = new ArrayList<>();
        try{
            eletroneuroDAO dao = new eletroneuroDAO();
            eletro = dao.listAll();
        }
        catch(SQLException | ClassNotFoundException ex){
           // Logger.getLogger(ChamadoController.class).log(Level.SEVERE, null,ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);            
        }                  
        
       
        
         return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(eletro)
            .build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/neurosensiall/")
    public Response listNeurosensi(){
        List<Neurosensi> eletro = new ArrayList<>();
        try{
            neurosensiDAO dao = new neurosensiDAO();
            eletro = dao.listAll();
        }
        catch(SQLException | ClassNotFoundException ex){
           // Logger.getLogger(ChamadoController.class).log(Level.SEVERE, null,ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);            
        }                  
        
       
        
         return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(eletro)
            .build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/neuromotoraall/")
    public Response listNeuromotora(){
        List<Neuromotora> eletro = new ArrayList<>();
        try{
            neuromotoraDAO dao = new neuromotoraDAO();
            eletro = dao.listAll();
        }
        catch(SQLException | ClassNotFoundException ex){
           // Logger.getLogger(ChamadoController.class).log(Level.SEVERE, null,ex);
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);            
        }                  
        
       
        
         return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(eletro)
            .build();
    }
    
    
    /*
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/update/")
    public Response update(Oferta oferta) throws SQLException, ClassNotFoundException{
         ofertaDAO dao = new ofertaDAO();       
         dao.alter(oferta);
         return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, ization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209600")
            .entity(oferta)
            .build();
        
    }
    
    
    

  */

}
