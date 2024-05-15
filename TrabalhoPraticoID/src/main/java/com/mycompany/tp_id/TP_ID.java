/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tp_id;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import net.sf.saxon.s9api.SaxonApiException;
import net.sf.saxon.s9api.XdmValue;
import org.jdom2.Document;
import org.jdom2.Element;

public class TP_ID{

    /*   public static void main(String[] args) throws IOException { //para 1 pais
        String Pais = "Portugal";
        Pais p = criaPais(Pais);
        p.imprime();
        Document docPaises;
        File filePaises = new File("paises.xml");
        if (filePaises.exists()) {
            docPaises = XMLJDomFunctions.lerDocumentoXML("paises.xml");
        } else {
            docPaises = new Document(new Element("lista"));
        }
        docPaises = ModeloXML.adicionaPais(p, docPaises);
        XMLJDomFunctions.escreverDocumentoParaFicheiro(docPaises, "paises.xml");

        Factos f = criaFactos(Pais);
        Document docFactos;
        File fileFactos = new File("factos.xml");
        if (fileFactos.exists()) {
            docFactos = XMLJDomFunctions.lerDocumentoXML("factos.xml");
        } else {
            docFactos = new Document(new Element("lista"));
        }
        docFactos = ModeloXML.adicionaFactos(f, docFactos);
        XMLJDomFunctions.escreverDocumentoParaFicheiro(docFactos, "factos.xml");
    }*/
    public static void main(String[] args) throws IOException { //para todos os paises da lista 
        Frame app = new Frame();
        app.setVisible(true);
    }
    public static void reset() throws IOException {
        ArrayList<String> listaPaises = listaPaises();
    
        File filePaises = new File("paises.xml");
        if (filePaises.exists()) {
            filePaises.delete();
        }
    
        File fileFactos = new File("factos.xml");
        if (fileFactos.exists()) {
            fileFactos.delete();
        }
    
        Document docPaises = new Document(new Element("paises"));
        Document docFactos = new Document(new Element("factos"));
    
        for (String Pais : listaPaises) {
            Pais p = criaPais(Pais);
            docPaises = ModeloXML.adicionaPais(p, docPaises);
            XMLJDomFunctions.escreverDocumentoParaFicheiro(docPaises, "paises.xml");
    
            Factos f = criaFactos(Pais);
            f.imprime();
            docFactos = ModeloXML.adicionaFactos(f, docFactos);
            XMLJDomFunctions.escreverDocumentoParaFicheiro(docFactos, "factos.xml");
        }
    }

    private static void processaPaises() throws IOException {
        for (String pais : listaPaises()) {
            String ISO = Wrappers.ISO(pais);
            String NomePais = Wrappers.NomePais(pais);
            String Continente = Wrappers.Continente(pais);
            String Bandeira = Wrappers.bandeira(pais);
            String Capital = Wrappers.Capital(pais);
            String Moeda = Wrappers.moeda(pais);
            String chefeEstado = Wrappers.chefeEstado(pais);
            String populacao = Wrappers.populacao(pais);
            String taxaCrescimento = Wrappers.taxaCrescimento(pais);
            String area = Wrappers.area(pais);
            String dominio = Wrappers.dominio(pais);
            ArrayList<String> cidadesMaisPopulosas = Wrappers.cidadesMaisPopulosas(pais);
            ArrayList<String> idiomas = Wrappers.idiomas(pais);

            System.out.println("Nome do País: " + NomePais);
            System.out.println("ISO: " + ISO);
            System.out.println("Continente: " + Continente);
            System.out.println("Capital: " + Capital);
            System.out.println("Bandeira: " + Bandeira);
            System.out.println("Moeda: " + Moeda);
            System.out.println("Chefe de Estado: " + chefeEstado);
            System.out.println("População: " + populacao);
            System.out.println("Taxa de Crescimento: " + taxaCrescimento);
            System.out.println("Área (km²): " + area);
            System.out.println("Domínio da Internet: " + dominio);
            System.out.println("Cidades mais Populosas: " + cidadesMaisPopulosas);
            System.out.println("Idiomas: " + idiomas);
            System.out.println("-------------------------------------------------");
        }
    }

    private static ArrayList<String> listaPaises() {
        ArrayList<String> paises = new ArrayList<>();
        paises.add("Portugal");
        paises.add("Spain");
        paises.add("Germany");
        paises.add("United States");
        paises.add("Sweden");
        paises.add("Venezuela");
        paises.add("Brazil");
        paises.add("Angola");
        paises.add("Rwanda");
        paises.add("Russia");
        paises.add("France");
        paises.add("Italy");
        paises.add("United Kingdom");
        paises.add("Argentina");
        paises.add("Chile");
        paises.add("China");
        paises.add("Colombia");
        paises.add("Denmark");
        return paises;
    }

    public static Pais criaPais(String pais) throws IOException {
        String ISO = Wrappers.ISO(pais);
        String Bandeira = Wrappers.bandeira(pais);
        String NomePais = Wrappers.NomePais(pais);
        String Moeda = Wrappers.moeda(pais);
        String Continente = Wrappers.Continente(pais);
        String Capital = Wrappers.Capital(pais);
        String chefeEstado = Wrappers.chefeEstado(pais);
        String populacao = Wrappers.populacao(pais);
        String taxaCrescimento = Wrappers.taxaCrescimento(pais);
        String area = Wrappers.area(pais);
        String dominio = Wrappers.dominio(pais);
        ArrayList<String> cidadesMaisPopulosas = Wrappers.cidadesMaisPopulosas(pais);
        ArrayList<String> idiomas = Wrappers.idiomas(pais);
        Pais p = new Pais(ISO, Bandeira, NomePais, Moeda, Continente, Capital, chefeEstado, populacao, taxaCrescimento, area, dominio, cidadesMaisPopulosas, idiomas);
        return p;
    }

    public static Factos criaFactos(String pais) throws IOException {
        String codigoISO = Wrappers.ISO(pais);
        String nomePais = Wrappers.NomePais(pais);
        String capital = Wrappers.Capital(pais);
        String continente = Wrappers.Continente(pais);
        String moeda = Wrappers.moeda(pais);
        String populacao = Wrappers.populacao(pais);
        String area = Wrappers.area(pais);
        String crescimentoPopulacional = Wrappers.taxaCrescimento(pais);
        ArrayList<String> cidades = Wrappers.cidadesMaisPopulosas(pais);
        String dominioInternet = Wrappers.dominio(pais);
        ArrayList<String> idiomas = Wrappers.idiomas(pais);
        ArrayList<String> paisesVizinhos = Wrappers.paisesVizinhos(pais);

        Factos f = new Factos(codigoISO, nomePais, capital, continente, moeda, populacao, area, crescimentoPopulacional, cidades, dominioInternet, idiomas, paisesVizinhos);
        return f;
    }

    public static boolean paisExisteEmFicheiro(String nomePais) throws IOException {
        ArrayList<String> listaFicheiros = new ArrayList<>();
        listaFicheiros.add("paises.xml");
        listaFicheiros.add("factos.xml");
        for (String ficheiro : listaFicheiros) {
            File file = new File(ficheiro);
            if (file.exists()) {
                Document doc = XMLJDomFunctions.lerDocumentoXML(ficheiro);
                Element raiz = doc.getRootElement();
                List todos = raiz.getChildren("pais");
                for (int i = 0; i < todos.size(); i++) {
                    Element pais = (Element) todos.get(i);
                    if (pais.getChildText("nome").equals(nomePais)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    

    //remove pais em ficheiro XML

    public static void removePaisEmFicheiro(String pais) throws IOException {
        ArrayList<String> listaFicheiros = new ArrayList<>();
        listaFicheiros.add("paises.xml");
        listaFicheiros.add("factos.xml");
        for (String ficheiro : listaFicheiros) {
            File file = new File(ficheiro);
            if (file.exists()) {
                Document doc = XMLJDomFunctions.lerDocumentoXML(ficheiro);
                doc = ModeloXML.removePais(pais, doc);
                XMLJDomFunctions.escreverDocumentoParaFicheiro(doc, ficheiro);
            }
        }
       
    }

    public static void adicionaPaisEmFicheiro(String pais) throws IOException {
          //  String fileFactos = "factos.xml";
            String filePaises = "paises.xml";
            
            
        //        Document docFactos = XMLJDomFunctions.lerDocumentoXML(fileFactos);
                Document docPaises = XMLJDomFunctions.lerDocumentoXML(filePaises);

                
                    docPaises = ModeloXML.adicionaPais(criaPais(pais), docPaises);
               
      //              docFactos = ModeloXML.adicionaFactos(criaFactos(pais), docFactos);
                
                XMLJDomFunctions.escreverDocumentoParaFicheiro(docPaises, filePaises);
            }
        
    public static void adicionaFactosEmFicheiro(String pais) throws IOException {
        String fileFactos = "factos.xml";
        Document docFactos = XMLJDomFunctions.lerDocumentoXML(fileFactos);
        docFactos = ModeloXML.adicionaFactos(criaFactos(pais), docFactos);
        XMLJDomFunctions.escreverDocumentoParaFicheiro(docFactos, fileFactos);
    }
}

