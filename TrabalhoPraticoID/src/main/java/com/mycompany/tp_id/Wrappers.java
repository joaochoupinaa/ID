package com.mycompany.tp_id;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;

public class Wrappers {

    private static final String WIKI_LINK = "https://en.wikipedia.org/wiki/";
    private static final String FILE_NAME = "paises.html";

    public static String ISO(String pais) throws IOException {
        String er1 = "ISO 3166-2";
        String er2 = "\">([A-Z]{2})</a></td>";
        String resultado = pesquisa(pais, WIKI_LINK, er1, er2, 0);
        if (resultado == null) {
            return "Não definido";
        }
        return resultado;
    }

    public static String bandeira(String pais) throws IOException {
        String er1 = "image\" content=\"([^\"]+)\">";
        String resultado = pesquisa(pais, WIKI_LINK, er1, er1, 0);
        if (resultado == null) {
            return "Não definido";
        }
        return resultado;
    }

    public static String NomePais(String pais) throws IOException {
        String er1 = "<meta property=\"og:title\" content=\"(.*?) - Wikipedia\"";
        String resultado = pesquisa(pais, WIKI_LINK, er1, er1, 0);
        if (resultado == null) {
            return "Não definido";
        }
        return resultado;
    }

    public static String moeda(String pais) throws IOException {
        String er1 = "is the capital of";
        String er2 = "([A-Z a-z , \s]+)";
        String resultado = pesquisaCR(pais, er1, er2, 23);
        if (resultado == null) {
            return "Não definido";
        }
        return resultado;
    }

    public static String Continente(String pais) throws IOException {
        String er1 = "Location";
        String er2 = "([A-Z]{1}[a-z]+),";
        String resultado = pesquisaCR(pais, er1, er2, 2);
        if (resultado == null) {
            return "Não definido";
        }
        return resultado;
    }

    public static String chefeEstado(String pais) throws IOException {
        String er1 = "[C c]hief of [S s]tate:\\s+([A-Z][a-zA-Z\\s]+)";
        String resultado = pesquisaCR(pais, er1, er1, 0);
        if (resultado == null) {
            return "Não definido";
        }
        return resultado;
    }

    public static String Capital(String pais) throws IOException {
        String er1 = "is the capital of";
        String er2 = "([A-Z a-z , \s]+)";
        String resultado = pesquisaCR(pais, er1, er2, 7);
        if (resultado == null) {
            return "Não definido";
        }
        return resultado;
    }

    public static String populacao(String pais) throws IOException {
        String er1 = "Population\t\t\t\t\t</td>";
        String er2 = "([0-9 ,]+)";
        String resultado = pesquisaCR(pais, er1, er2, 2);
        if (resultado == null) {
            return "Não definido";
        }
        resultado = resultado.replaceAll(",", "");
        return resultado;
    }

    public static String taxaCrescimento(String pais) throws IOException {
        String er1 = "Population Growth Rate";
        String er2 = "([0-9\\.]+%)";
        String resultado = pesquisaCR(pais, er1, er2, 2);
        if (resultado == null) {
            return "Não definido";
        }
        return resultado;
    }

    public static String area(String pais) throws IOException {
        String er1 = "Total Area";
        String er2 = "([0-9, ]+) Square Kilometers";
        String resultado = pesquisaCR(pais, er1, er2, 2);
        if (resultado == null) {
            return "Não definido";
        }
        return resultado;
    }

    public static String dominio(String pais) throws IOException {
        String er1 = "Internet TLD";
        String er2 = "href=\"/wiki/([^\"]+)\" title=\"\\.[^\"]+\">\\.[^\"]+</a>";
        String resultado = pesquisa(pais, WIKI_LINK, er1, er2, 0);
        if (resultado == null) {
            return "Não definido";
        }
        return resultado;
    }

    public static ArrayList<String> cidadesMaisPopulosas(String pais) throws IOException {
        String er1 = "Population in Major Urban Areas";
        String er2 = "([A-Z][A-Z a-z]+)";
        ArrayList<String> resultado = pesquisaCRLista(pais, er1, er2, 2);
        
        if (resultado.isEmpty() || resultado == null) {
            resultado.clear();
            resultado.add("Nao definido");
        }
        return resultado;
    }

    public static ArrayList<String> paisesVizinhos(String pais) throws IOException {
        String er1 = "Border Countries: ";
        String er2 = "([A-Z][a-zA-Z\\s]+)\\s[0-9,.]+ km";
        ArrayList<String> resultado = pesquisaCRLista(pais, er1, er2, 0);
        if (resultado.isEmpty() || resultado == null) {
            resultado.clear();
            resultado.add("Nao definido");
        }
        return resultado;
    }

    // Remove duplicações de uma lista de strings
    public static ArrayList<String> removeDuplicacoes(List<String> lista) {
        Set<String> palavrasUnicas = new LinkedHashSet<>();

        for (String idioma : lista) {
            String[] palavras = idioma.split("\\s+");
            for (String palavra : palavras) {
                palavrasUnicas.add(palavra.trim());
            }
        }
        
        return new ArrayList<>(palavrasUnicas);
    }
    public static ArrayList<String> idiomas(String pais) throws IOException { 
                    
        String er1 = "Predominant Language";
        String er2 = "\\b(?!Standard\\b)([A-Z][a-z]+(?: [A-Z][a-z]+)*)(?:(?:\\s*\\([^\\)]+\\))?,?)";  //para retirar o standar do chines
        ArrayList<String> resultado = pesquisaCRLista(pais, er1, er2, 2);
        if (resultado.isEmpty() || resultado == null) {
            resultado.clear();
            resultado.add("Nao definido");
        }
        return removeDuplicacoes(resultado);
    }

    public static ArrayList<String> pesquisaLista(String pais, String link, String er1, String er2, int readNextLines)
            throws IOException {
        if (link.equals("https://en.wikipedia.org/wiki/Europe")) {
            HttpRequestFunctions.httpRequest1(link, "", FILE_NAME);
        } else {
            HttpRequestFunctions.httpRequest1(link, pais, FILE_NAME);
        }
        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);
        Scanner ler = new Scanner(new FileInputStream(FILE_NAME));
        ArrayList<String> resultados = new ArrayList<>();
        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            Matcher m1 = p1.matcher(linha);
            if (m1.find()) {
                for (int i = 0; i < readNextLines && ler.hasNextLine(); i++) {
                    linha = ler.nextLine();
                }
                Matcher m2 = p2.matcher(linha);
                while (m2.find()) {
                    resultados.add(m2.group(1));
                }
                ler.close();
                return resultados;
            }
        }
        ler.close();
        return null;
    }

    public static String pesquisa(String pais, String link, String er1, String er2, int readNextLines)
            throws IOException {
        if (link.equals("https://en.wikipedia.org/wiki/Europe")) {
            HttpRequestFunctions.httpRequest1(link, "", FILE_NAME);
        } else {
            HttpRequestFunctions.httpRequest1(link, pais, FILE_NAME);
        }

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Scanner ler = new Scanner(new FileInputStream(FILE_NAME));

        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            Matcher m1 = p1.matcher(linha);
            if (m1.find()) {
                for (int i = 0; i < readNextLines && ler.hasNextLine(); i++) {
                    linha = ler.nextLine();
                }
                Matcher m2 = p2.matcher(linha);
                if (m2.find()) {
                    ler.close();
                    return m2.group(1);
                }
            }
        }
        ler.close();
        return null;
    }

    public static String pesquisaCR(String pais, String er1, String er2, int readNextLines)
            throws IOException {
        String nomeFicheiro = "";
        if ("United States".equals(pais)) {
            nomeFicheiro = "countryUSA.html";
        } else if ("United Kingdom".equals(pais)) {
            nomeFicheiro = "countryUK.html";
        } else {
            nomeFicheiro = "country" + pais + ".html";
        }

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Scanner ler = new Scanner(new FileInputStream(nomeFicheiro));

        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            Matcher m1 = p1.matcher(linha);
            if (m1.find()) {
                for (int i = 0; i < readNextLines && ler.hasNextLine(); i++) {
                    linha = ler.nextLine();
                }
                Matcher m2 = p2.matcher(linha);
                if (m2.find()) {
                    ler.close();
                    return m2.group(1);
                }
            }
        }
        ler.close();
        return null;
    }

    public static ArrayList<String> pesquisaCRLista(String pais, String er1, String er2, int readNextLines)
            throws IOException {
        String nomeFicheiro = "";
        if ("United States".equals(pais)) {
            nomeFicheiro = "countryUSA.html";
        } else if ("United Kingdom".equals(pais)) {
            nomeFicheiro = "countryUK.html";
        } else {
            nomeFicheiro = "country" + pais + ".html";
        }

        Pattern p1 = Pattern.compile(er1);
        Pattern p2 = Pattern.compile(er2);

        Scanner ler = new Scanner(new FileInputStream(nomeFicheiro));
        ArrayList<String> resultados = new ArrayList<>();

        while (ler.hasNextLine()) {
            String linha = ler.nextLine();
            Matcher m1 = p1.matcher(linha);
            if (m1.find()) {
                for (int i = 0; i < readNextLines && ler.hasNextLine(); i++) {
                    linha = ler.nextLine();
                }
                Matcher m2 = p2.matcher(linha);
                while (m2.find()) {
                    resultados.add(m2.group(1));
                }
            }
        }
        ler.close();
        return resultados;
    }

}
