/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_id;

import java.util.ArrayList;

/**
 *
 * @author anabela
 */
public class Pais {

    private String nomePais;
    private String ISO;
    private String bandeira;
    private String moeda;
    private String continente;
    private String capital;
    private String chefeEstado;
    private String populacao;
    private String taxaCrescimento;
    private String area;
    private String dominio;
    private ArrayList<String> cidadesMaisPopulosas;
    private ArrayList<String> idiomas;

    public Pais(String ISO, String bandeira, String nomePais, String moeda, String continente, String capital, String chefeEstado, String populacao, String taxaCrescimento, String area, String dominio, ArrayList<String> cidadesMaisPopulosas, ArrayList<String> idiomas) {
        this.ISO = ISO;
        this.bandeira = bandeira;
        this.nomePais = nomePais;
        this.moeda = moeda;
        this.continente = continente;
        this.capital = capital;
        this.chefeEstado = chefeEstado;
        this.populacao = populacao;
        this.taxaCrescimento = taxaCrescimento;
        this.area = area;
        this.dominio = dominio;
        this.cidadesMaisPopulosas = cidadesMaisPopulosas;
        this.idiomas = idiomas;
    }

    public String getISO() {
        return ISO;
    }

    public void setISO(String ISO) {
        this.ISO = ISO;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getChefeEstado() {
        return chefeEstado;
    }

    public void setChefeEstado(String chefeEstado) {
        this.chefeEstado = chefeEstado;
    }

    public String getPopulacao() {
        return populacao;
    }

    public void setPopulacao(String populacao) {
        this.populacao = populacao;
    }

    public String getTaxaCrescimento() {
        return taxaCrescimento;
    }

    public void setTaxaCrescimento(String taxaCrescimento) {
        this.taxaCrescimento = taxaCrescimento;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public ArrayList<String> getCidadesMaisPopulosas() {
        return cidadesMaisPopulosas;
    }

    public void setCidadesMaisPopulosas(ArrayList<String> cidadesMaisPopulosas) {
        this.cidadesMaisPopulosas = cidadesMaisPopulosas;
    }

    public ArrayList<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(ArrayList<String> idiomas) {
        this.idiomas = idiomas;
    }

    public void imprime() {
        System.out.println("\nNome do país: " + this.nomePais);
        System.out.println("ISO: " + this.ISO);
        System.out.println("Bandeira: " + this.bandeira);
        System.out.println("Moeda: " + this.moeda);
        System.out.println("Continente: " + this.continente);
        System.out.println("Capital: " + this.capital);
        System.out.println("Chefe de Estado: " + this.chefeEstado);
        System.out.println("População: " + this.populacao);
        System.out.println("Taxa de Crescimento: " + this.taxaCrescimento);
        System.out.println("Área: " + this.area);
        System.out.println("Domínio: " + this.dominio);
        System.out.println("Cidades Mais Populosas: " + this.cidadesMaisPopulosas);
        System.out.println("Idiomas: " + this.idiomas);

    }
}
