
package beans;

import java.time.LocalDate;

public class Sorvetes {
    // Variáveis
    private int id;
    private String saborSorvete, descricao, categoria, unidade;
    private int quantidade;
    private double preco;
    private Fornecedores fornecedor;
    private LocalDate dataEntrada, dataValidade;

    public Sorvetes() {
    }

    public Sorvetes(int id, String saborSorvete, String descricao, String categoria, String unidade, int quantidade, double preco, Fornecedores fornecedor, LocalDate dataEntrada, LocalDate dataValidade) {
        this.id = id;
        this.saborSorvete = saborSorvete;
        this.descricao = descricao;
        this.categoria = categoria;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.preco = preco;
        this.fornecedor = fornecedor;
        this.dataEntrada = dataEntrada;
        this.dataValidade = dataValidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaborSorvete() {
        return saborSorvete;
    }

    public void setSaborSorvete(String saborSorvete) {
        this.saborSorvete = saborSorvete;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Fornecedores getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedores fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Sorvetes{" + "id=" + id + ", saborSorvete=" + saborSorvete + ", descricao=" + descricao + ", categoria=" + categoria + ", unidade=" + unidade + ", quantidade=" + quantidade + ", preco=" + preco + ", fornecedor=" + fornecedor + ", dataEntrada=" + dataEntrada + ", dataValidade=" + dataValidade + '}';
    }
}
