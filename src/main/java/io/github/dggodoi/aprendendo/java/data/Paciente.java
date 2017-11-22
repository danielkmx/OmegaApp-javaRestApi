/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dggodoi.aprendendo.java.data;

/**
 *
 * @ kmx
 */
public class Paciente {
    private int id;
    private String pacientenome;
    private String pacientesexo;
    private String pacientedatanasc;
    private String pacienteconvenio;
    private String pacientedataexame;

    public String getPacientedataexame() {
        return pacientedataexame;
    }

    public void setPacientedataexame(String pacientedataexame) {
        this.pacientedataexame = pacientedataexame;
    }

    public String getPacienteconvenio() {
        return pacienteconvenio;
    }

    public void setPacienteconvenio(String pacienteconvenio) {
        this.pacienteconvenio = pacienteconvenio;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + '}';
    }
    private String pacientetipoexame;
    private String telmedico;

    public String getTelmedico() {
        return telmedico;
    }

    public void setTelmedico(String telmedico) {
        this.telmedico = telmedico;
    }
    private String medicosolicitante;
    private String specmedica;
    private String hda;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPacientenome() {
        return pacientenome;
    }

    public void setPacientenome(String pacientenome) {
        this.pacientenome = pacientenome;
    }

    public String getPacientesexo() {
        return pacientesexo;
    }

    public void setPacientesexo(String pacientesexo) {
        this.pacientesexo = pacientesexo;
    }

    public String getPacientedatanasc() {
        return pacientedatanasc;
    }

    public void setPacientedatanasc(String pacientedatanasc) {
        this.pacientedatanasc = pacientedatanasc;
    }

    public String getPacientetipoexame() {
        return pacientetipoexame;
    }

    public void setPacientetipoexame(String pacientetipoexame) {
        this.pacientetipoexame = pacientetipoexame;
    }

    public String getMedicosolicitante() {
        return medicosolicitante;
    }

    public void setMedicosolicitante(String medicosolicitante) {
        this.medicosolicitante = medicosolicitante;
    }

    public String getSpecmedica() {
        return specmedica;
    }

    public void setSpecmedica(String specmedica) {
        this.specmedica = specmedica;
    }

    public String getHda() {
        return hda;
    }

    public void setHda(String hda) {
        this.hda = hda;
    }
    
}
