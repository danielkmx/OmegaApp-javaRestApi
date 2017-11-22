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
public class Neurosensi {
    private int neurosensid;
    private String nervonome;
    private String latencia;
    private String amplitude;
    private int pacienteid;
    private String nervolado;

    public String getNervolado() {
        return nervolado;
    }

    public void setNervolado(String nervolado) {
        this.nervolado = nervolado;
    }

    public int getNeurosensid() {
        return neurosensid;
    }

    @Override
    public String toString() {
        return "Neurosensi{" + "neurosensid=" + neurosensid + ", pacienteid=" + pacienteid + '}';
    }

    public void setNeurosensid(int neurosensid) {
        this.neurosensid = neurosensid;
    }

    public String getNervonome() {
        return nervonome;
    }

    public void setNervonome(String nervonome) {
        this.nervonome = nervonome;
    }

    public String getLatencia() {
        return latencia;
    }

    public void setLatencia(String latencia) {
        this.latencia = latencia;
    }

    public String getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(String amplitutde) {
        this.amplitude = amplitutde;
    }

    public int getPacienteid() {
        return pacienteid;
    }

    public void setPacienteid(int pacienteid) {
        this.pacienteid = pacienteid;
    }
    
    
}
