package com.mycompany.tp_id;

import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

public class ModeloXML {

    public static Document adicionaPais(Pais elem, Document doc) {
        Element raiz;
        if (doc == null) {
            raiz = new Element("paises");
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        }
        // Verifica se o país já existe
        for (Element pais : raiz.getChildren("pais")) {
            if (pais.getAttributeValue("CodigoISO").equals(elem.getISO())) {
                System.out.println("Pais já existe - não será adicionado novamente");
                return doc;
            }
        }

        Element pai = new Element("pais").setAttribute("CodigoISO", elem.getISO());

        Element nome = new Element("nome").addContent(elem.getNomePais());
        pai.addContent(nome);

        Element continente = new Element("continente").addContent(elem.getContinente());
        pai.addContent(continente);

        Element presidente = new Element("presidente").addContent(elem.getChefeEstado());
        pai.addContent(presidente);

        Element bandeira = new Element("bandeira").addContent(elem.getBandeira());
        pai.addContent(bandeira);

        raiz.addContent(pai);
        return doc;
    }

    public static Document adicionaFactos(Factos elem, Document doc) {
        Element raiz;
        if (doc == null) {
            raiz = new Element("factos");
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        }

        Element factos = new Element("pais").setAttribute("CodigoISO", elem.getCodigoISO());;

        Element nome = new Element("nome").addContent(elem.getNomePais());
        factos.addContent(nome);

        Element continente = new Element("continente").addContent(elem.getContinente());
        factos.addContent(continente);

        Element capital = new Element("capital").addContent(elem.getCapital());
        factos.addContent(capital);

        Element moeda = new Element("moeda").addContent(elem.getMoeda());
        factos.addContent(moeda);

        Element populacao = new Element("populacao").addContent((elem.getPopulacao()));
        factos.addContent(populacao);

        Element area = new Element("area").addContent(String.valueOf(elem.getArea()));
        factos.addContent(area);

        Element crescimentoPopulacional = new Element("crescimentoPopulacional").addContent(String.valueOf(elem.getCrescimentoPopulacional()));
        factos.addContent(crescimentoPopulacional);

        Element cidades = new Element("cidades_mais_populosas");
        for (String cidade : elem.getCidades()) {
            Element cidadeElement = new Element("cidade").addContent(cidade);
            cidades.addContent(cidadeElement);
        }
        factos.addContent(cidades);

        Element dominioInternet = new Element("dominioInternet").addContent(elem.getDominioInternet());
        factos.addContent(dominioInternet);

        Element idiomas = new Element("idiomas");
        for (String idioma : elem.getIdiomas()) {
            Element idiomaElement = new Element("idioma").addContent(idioma);
            idiomas.addContent(idiomaElement);
        }
        factos.addContent(idiomas);

        Element paisesVizinhos = new Element("paises_vizinhos");
        for (String paisVizinho : elem.getPaisesVizinhos()) {
            Element paisesVizinhosElement = new Element("pais_vizinho").addContent(paisVizinho);
            paisesVizinhos.addContent(paisesVizinhosElement);
        }
        factos.addContent(paisesVizinhos);

        raiz.addContent(factos);
        return doc;
    }

    public static Document adicionaFactosPorPais(String pais, Factos elem, Document doc) {
        Element raiz;
        if (doc == null) {
            raiz = new Element("factos");
            doc = new Document(raiz);
        } else {
            raiz = doc.getRootElement();
        }

        // Procura o país no documento
        for (Element paisElement : raiz.getChildren("pais")) {
            if (paisElement.getAttributeValue("CodigoISO").equals(pais)) {
                // Adiciona os factos ao país encontrado
                Element factos = new Element("pais").setAttribute("CodigoISO", elem.getCodigoISO());

                Element nome = new Element("nome").addContent(elem.getNomePais());
                factos.addContent(nome);

                Element continente = new Element("continente").addContent(elem.getContinente());
                factos.addContent(continente);

                Element capital = new Element("capital").addContent(elem.getCapital());
                factos.addContent(capital);

                Element moeda = new Element("moeda").addContent(elem.getMoeda());
                factos.addContent(moeda);

                Element populacao = new Element("populacao").addContent((elem.getPopulacao()));
                factos.addContent(populacao);

                Element area = new Element("area").addContent(String.valueOf(elem.getArea()));
                factos.addContent(area);

                Element crescimentoPopulacional = new Element("crescimentoPopulacional").addContent(String.valueOf(elem.getCrescimentoPopulacional()));
                factos.addContent(crescimentoPopulacional);

                Element cidades = new Element("cidades_mais_populosas");
                for (String cidade : elem.getCidades()) {
                    Element cidadeElement = new Element("cidade").addContent(cidade);
                    cidades.addContent(cidadeElement);
                }
                factos.addContent(cidades);

                Element dominioInternet = new Element("dominioInternet").addContent(elem.getDominioInternet());
                factos.addContent(dominioInternet);

                Element idiomas = new Element("idiomas");
                for (String idioma : elem.getIdiomas()) {
                    Element idiomaElement = new Element("idioma").addContent(idioma);
                    idiomas.addContent(idiomaElement);
                }
                factos.addContent(idiomas);

                Element paisesVizinhos = new Element("paises_vizinhos");
                for (String paisVizinho : elem.getPaisesVizinhos()) {
                    Element paisesVizinhosElement = new Element("pais_vizinho").addContent(paisVizinho);
                    paisesVizinhos.addContent(paisesVizinhosElement);
                }
                factos.addContent(paisesVizinhos);

                paisElement.addContent(factos);
                return doc;
            }
        }

        System.out.println("Pais " + pais + " não foi encontrado");
        return doc;
    }

    public static Document removePais(String procura, Document doc) {

        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro nao existe - nao dá para remover informação");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List todos = raiz.getChildren("pais");
        boolean found = false;
        for (int i = 0; i < todos.size(); i++) {
            Element pais = (Element) todos.get(i); //obtem pais i da Lista 
            if (pais.getChildText("nome").equals(procura)) { // Use equals instead of contains
                pais.getParent().removeContent(pais);
                System.out.println("Pais removido com sucesso!");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Pais " + procura + " não foi encontrado");
            return doc;
        }
        return doc;
    }

    public static Document adicionaElemento(String pais, String elemento, String valor, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro nao existe - nao dá para adicionar informação");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List<Element> todos = raiz.getChildren("pais");
        boolean found = false;
        for (Element p : todos) {
            if (p.getChildText("nome").equals(pais)) {
                Element novoElemento = new Element(elemento);
                novoElemento.setText(valor);
                p.addContent(novoElemento);
                System.out.println("Elemento adicionado com sucesso!");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Pais " + pais + " não foi encontrado");
            return null;
        }
        return doc;
    }

    public static Document adicionaElementoLista(String pais, String lista, String novoElemento, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro nao existe - nao dá para adicionar informação");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List<Element> todos = raiz.getChildren("pais");
        boolean found = false;
        for (Element p : todos) {
            if (p.getChildText("nome").equals(pais)) {
                Element listaElement = p.getChild(lista);
                if (listaElement == null) {
                    System.out.println("Lista " + lista + " não foi encontrada");
                    return null;
                }
                if (listaElement.getChildren().isEmpty()) {
                    System.out.println("Lista " + lista + " não tem elementos");
                    return null;
                }
                String nomeElemento = listaElement.getChildren().get(0).getName();
                Element novoElem = new Element(nomeElemento).setText(novoElemento);
                listaElement.addContent(novoElem);
                System.out.println("Elemento adicionado com sucesso!");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Pais " + pais + " não foi encontrado");
            return null;
        }
        return doc;
    }
    public static Document alteraElemento(String pais, String elemento, String valorAntigo, String novoValor, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro nao existe - nao dá para alterar informação");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List<Element> todos = raiz.getChildren("pais");
        boolean found = false;
        for (Element p : todos) {
            if (p.getChildText("nome").equals(pais)) {
                List<Element> children = p.getChildren();
                for (Element child : children) {
                    if (child.getName().equals(elemento) && child.getText().equals(valorAntigo)) {
                        child.setText(novoValor);
                        System.out.println("Elemento alterado com sucesso!");
                        found = true;
                        break;
                    } else {
                        List<Element> subChildren = child.getChildren();
                        for (Element subChild : subChildren) {
                            if (subChild.getName().equals(elemento) && subChild.getText().equals(valorAntigo)) {
                                subChild.setText(novoValor);
                                System.out.println("Elemento alterado com sucesso!");
                                found = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.println("Pais " + pais + " ou elemento " + elemento + " não foram encontrados");
            return null;
        }
        return doc;
    }

    public static Document removeElemento(String pais, String elemento, String textoAntigo, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro nao existe - nao dá para remover informação");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List<Element> todos = raiz.getChildren("pais");
        boolean found = false;
        for (Element p : todos) {
            if (p.getChildText("nome").equals(pais)) {
                List<Element> children = p.getChildren();
                for (Element child : children) {
                    if (child.getName().equals(elemento) && child.getText().equals(textoAntigo)) {
                        p.removeContent(child);
                        System.out.println("Elemento removido com sucesso!");
                        found = true;
                        break;
                    } else {
                        List<Element> subChildren = child.getChildren();
                        for (Element subChild : subChildren) {
                            if (subChild.getName().equals(elemento) && subChild.getText().equals(textoAntigo)) {
                                child.removeContent(subChild);
                                System.out.println("Elemento removido com sucesso!");
                                found = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (found) {
                break;
            }
        }
        if (!found) {
            System.out.println("Pais " + pais + " ou elemento " + elemento + " não foram encontrados");
            return null;
        }
        return doc;
    }

    public static Document adicionaIdioma(String pais, String novoIdioma, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro nao existe - nao dá para adicionar informação");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List<Element> todos = raiz.getChildren("pais");
        boolean found = false;
        for (Element p : todos) {
            if (p.getChildText("nome").equals(pais)) {
                Element idiomas = p.getChild("idiomas");
                if (idiomas != null) {
                    Element novoElem = new Element("idioma").setText(novoIdioma);
                    idiomas.addContent(novoElem);
                    System.out.println("Idioma adicionado com sucesso!");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Pais " + pais + " não foi encontrado");
            return null;
        }
        return doc;
    }

    public static Document adicionaVizinho(String pais, String novoVizinho, Document doc) {
        Element raiz;
        if (doc == null) {
            System.out.println("Ficheiro nao existe - nao dá para adicionar informação");
            return null;
        } else {
            raiz = doc.getRootElement();
        }
        List<Element> todos = raiz.getChildren("pais");
        boolean found = false;
        for (Element p : todos) {
            if (p.getChildText("nome").equals(pais)) {
                Element vizinhos = p.getChild("vizinhos");
                if (vizinhos == null) {
                    vizinhos = new Element("vizinhos");
                    p.addContent(vizinhos);
                }
                Element novoElem = new Element("vizinho").setText(novoVizinho);
                vizinhos.addContent(novoElem);
                System.out.println("Vizinho adicionado com sucesso!");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Pais " + pais + " não foi encontrado");
            return null;
        }
        return doc;
    }

    
}
