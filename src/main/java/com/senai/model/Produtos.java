package com.senai.model;

public class Produtos {

    private String nome;
    private Double preco;
    private int estoqueAtual;
    private int tempoRepo;
    private int loteRepo;
    private int estoqueMin;
    private int estoqueMax;
    private double vendaMedia;
    private boolean decisao;
    private int[] meses = new int[3];
    private String mensagemDeCompra;




    public Produtos() {

    }





    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }


    public int getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(int estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public int getTempoRepo() {
        return tempoRepo;
    }

    public void setTempoRepo(int tempoRepo) {
        this.tempoRepo = tempoRepo;
    }

    public int getLoteRepo() {
        return loteRepo;
    }

    public void setLoteRepo(int loteRepo) {
        this.loteRepo = loteRepo;
    }

    public int getEstoqueMin() {
        return estoqueMin;
    }

    public void calcEstoqueMin() {
        this.estoqueMin= (int)(getVendaMedia()*getTempoRepo());
    }

    public int getEstoqueMax() {
        return estoqueMax;
    }

    public void calcEstoqueMax() {
        this.estoqueMax= (int)(getEstoqueMin()*getVendaMedia());
    }

    public void calcVendaMedia(){
        double soma = (meses[0]+meses[1]+meses[2]);
        this.vendaMedia = (int)(soma/3.0)/25.0;
    }

    public double getVendaMedia() {
        return vendaMedia;
    }

    public void decisao(int estoqueMin, int estoqueMax, int estoqueAtual) {
        if (getEstoqueAtual() < getEstoqueMin()) {
            boolean verify= true;
            setMensagemCompra("! COMPRAR !");
            setDecisao(verify);
        }
        else {
            boolean verify= false;
            setMensagemCompra("! NÃO COMPRAR !");
            setDecisao(verify);
        }
    }

    public boolean getDecisao(){
        return decisao;
    }


    public int[] getMeses() {
        return meses;
    }

    public void setMeses(int indice, int mes123) {
        if (meses == null) {
            meses = new int[3];
        }
        if (indice >= 0 && indice < meses.length) {
            meses[indice] = mes123;
        } else {
            System.out.println("Índice inválido: " + indice);
        }
    }

    public String getMensagemCompra() {
        return mensagemDeCompra;
    }

    public void setMensagemCompra(String mensagemCompra) {
        this.mensagemDeCompra = mensagemCompra;
    }

    public void setDecisao(boolean verify) {
        this.decisao = verify;
    }
}

