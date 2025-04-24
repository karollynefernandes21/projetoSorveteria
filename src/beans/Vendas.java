
package beans;


import java.time.LocalDateTime;

public class Vendas {

    private int id;
    private int idSorvete;
    private double valorTotal;
    private String cpfCliente, formaPagamento;
    private int quantidadeSorvete;
    private LocalDateTime dataHoraVenda;
  
    public Vendas() {
    }

    public Vendas(int id, int idSorvete, double valorTotal, String cpfCliente, String formaPagamento, int quantidadeSorvete, LocalDateTime dataHoraVenda) {
        this.id = id;
        this.idSorvete = idSorvete;
        this.valorTotal = valorTotal;
        this.cpfCliente = cpfCliente;
        this.formaPagamento = formaPagamento;
        this.quantidadeSorvete = quantidadeSorvete;
        this.dataHoraVenda = dataHoraVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSorvete() {
        return idSorvete;
    }

    public void setIdSorvete(int idSorvete) {
        this.idSorvete = idSorvete;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getQuantidadeSorvete() {
        return quantidadeSorvete;
    }

    public void setQuantidadeSorvete(int quantidadeSorvete) {
        this.quantidadeSorvete = quantidadeSorvete;
    }

    public LocalDateTime getDataHoraVenda() {
        return dataHoraVenda;
    }

    public void setDataHoraVenda(LocalDateTime dataHoraVenda) {
        this.dataHoraVenda = dataHoraVenda;
    }

    @Override
    public String toString() {
        return "Vendas{" + "id=" + id + ", idSorvete=" + idSorvete + ", valorTotal=" + valorTotal + ", cpfCliente=" + cpfCliente + ", formaPagamento=" + formaPagamento + ", quantidadeSorvete=" + quantidadeSorvete + ", dataHoraVenda=" + dataHoraVenda + '}';
    }
}