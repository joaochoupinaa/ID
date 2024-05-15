/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp_id;

import java.util.ArrayList;

public class Factos {

    private String codigoISO;
    private String nomePais;
    private String capital;
    private String moeda;
    private String populacao;
    private String area;
    private String crescimentoPopulacional;
    private String continente;
    private ArrayList<String> cidades;
    private String dominioInternet;
    private ArrayList<String> idiomas;
    private ArrayList<String> paisesVizinhos;

    public Factos(String codigoISO, String nomePais, String capital,String continente , String moeda, String populacao, String area, String crescimentoPopulacional, ArrayList<String> cidades, String dominioInternet, ArrayList<String> idiomas, ArrayList<String> paisesVizinhos) {
        this.codigoISO = codigoISO;
        this.nomePais = nomePais;
        this.capital = capital;
        this.continente = continente;
        this.moeda = moeda;
        this.populacao = populacao;
        this.area = area;
        this.crescimentoPopulacional = crescimentoPopulacional;
        this.cidades = cidades;
        this.dominioInternet = dominioInternet;
        this.idiomas = idiomas;
        this.paisesVizinhos = paisesVizinhos;
    }

    // getters
    public String getCodigoISO() {
        return codigoISO;
    }

    public String getNomePais() {
        return nomePais;
    }

    public String getCapital() {
        return capital;
    }

    public String getContinente() {
        return continente;
    }

    public String getMoeda() {
        return moeda;
    }

    public String getPopulacao() {
        return populacao;
    }

    public String getArea() {
        return area;
    }

    public String getCrescimentoPopulacional() {
        return crescimentoPopulacional;
    }

    public ArrayList<String> getCidades() {
        return cidades;
    }

    public String getDominioInternet() {
        return dominioInternet;
    }

    public ArrayList<String> getIdiomas() {
        return idiomas;
    }

    public ArrayList<String> getPaisesVizinhos() {
        return paisesVizinhos;
    }

    public void imprime() {
        System.out.println("\n\nCódigo ISO: " + codigoISO);
        System.out.println("Nome do país: " + nomePais);
        System.out.println("Capital: " + capital);
        System.out.println("Continente: " + continente);
        System.out.println("Moeda: " + moeda);
        System.out.println("População: " + populacao);
        System.out.println("Área: " + area);
        System.out.println("Crescimento populacional: " + crescimentoPopulacional);
        System.out.println("Cidades: " + cidades);
        System.out.println("Domínio da Internet: " + dominioInternet);
        System.out.println("Idiomas: " + idiomas);
        System.out.println("Países vizinhos: " + paisesVizinhos);

    }
}
