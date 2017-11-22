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
public class Eletroneuro {
    private String musculonome;

    public String getMusculonome() {
        return musculonome;
    }

    public void setMusculonome(String musculonome) {
        this.musculonome = musculonome;
    }
    private int eletroneuroid;
    private String inser;
    private String repouso;
    private String recrut;
    private String ladomusculo;
    private int pacienteid;
    private String potencial;

    public String getPotencial() {
        return potencial;
    }

    public void setPotencial(String potencial) {
        this.potencial = potencial;
    }
    public int getEletroneuroid() {
        return eletroneuroid;
    }

    public void setEletroneuroid(int eletroneuroid) {
        this.eletroneuroid = eletroneuroid;
    }

    public String getInser() {
        return inser;
    }

    public void setInser(String inser) {
        this.inser = inser;
    }

    public String getRepouso() {
        return repouso;
    }

    public void setRepouso(String repouso) {
        this.repouso = repouso;
    }

    public String getRecrut() {
        return recrut;
    }

    public void setRecrut(String recrut) {
        this.recrut = recrut;
    }

    public String getLadomusculo() {
        return ladomusculo;
    }

    public void setLadomusculo(String ladomusculo) {
        this.ladomusculo = ladomusculo;
    }

    public int getPacienteid() {
        return pacienteid;
    }

    public void setPacienteid(int pacienteid) {
        this.pacienteid = pacienteid;
    }

    @Override
    public String toString() {
        return "Eletroneuro{" + "eletroneuroid=" + eletroneuroid + ", pacienteid=" + pacienteid + '}';
    }
    
}
