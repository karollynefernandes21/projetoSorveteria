package dao;

// Imports
import beans.Clientes;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientesDao {

    // Atributo para conexão
    private Conexao conexao = new Conexao();

    // Método para cadastrar clientes
    public void cadastroClientes(Clientes cliente) {

        String sql = "INSERT INTO clientes (nome, cpf, email, celular, cep, endereco, numero, bairro, cidade, complemento, unidade) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexao.connectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getCelular());
            ps.setString(5, cliente.getCep());
            ps.setString(6, cliente.getEndereco());
            ps.setString(7, cliente.getNumero());
            ps.setString(8, cliente.getBairro());
            ps.setString(9, cliente.getCidade());
            ps.setString(10, cliente.getComplemento());
            ps.setString(11, cliente.getUnidade());

            ps.executeUpdate();

            System.out.println("Cliente cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    // Método para buscar os clientes por nome para posteriormente exibí-los nos jTextFields
    public Clientes buscarNomeCliente(String nome) {

        String sql = "SELECT * FROM clientes WHERE nome LIKE ?";

        try (Connection conn = conexao.connectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Clientes cliente = new Clientes();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setUnidade(rs.getString("unidade"));
                return cliente;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar cliente: " + e.getMessage());
        }
        return null;
    }

    // Método para atualizar os clientes
    public void atualizarClientes(Clientes cliente) {

        String sql = "UPDATE clientes SET nome = ?, cpf = ?, email = ?, celular = ?, cep = ?, endereco = ?, "
                + "numero = ?, bairro = ?, cidade = ?, complemento = ?, unidade = ? WHERE id = ?";

        try (Connection conn = conexao.connectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getCelular());
            ps.setString(5, cliente.getCep());
            ps.setString(6, cliente.getEndereco());
            ps.setString(7, cliente.getNumero());
            ps.setString(8, cliente.getBairro());
            ps.setString(9, cliente.getCidade());
            ps.setString(10, cliente.getComplemento());
            ps.setString(11, cliente.getUnidade());
            ps.setInt(12, cliente.getId());

            ps.executeUpdate();

            System.out.println("Cliente atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    // Método para excluir os clientes
    public void excluirClientes(Clientes cliente) {

        String sql = "DELETE FROM clientes WHERE id = ?";

        try (Connection conn = conexao.connectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cliente.getId());
            ps.executeUpdate();

            System.out.println("Cliente excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir cliente: " + e.getMessage());
        }
    }

    // Método para listar todos os clientes
    public ArrayList<Clientes> listarClientes() {

        ArrayList<Clientes> listagem = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        try (Connection conn = conexao.connectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clientes cliente = new Clientes();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setUnidade(rs.getString("unidade"));

                listagem.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar cliente: " + e.getMessage());
        }
        return listagem;
    }

    // Método para listar os clientes filtrando pelo nome
    public ArrayList<Clientes> listarClientesPorNome(String nome) {
        ArrayList<Clientes> listagem = new ArrayList<>();
        String sql = "SELECT * FROM clientes WHERE nome LIKE ?";

        try (Connection conn = conexao.connectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nome + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clientes cliente = new Clientes();

                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setCep(rs.getString("cep"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setUnidade(rs.getString("unidade"));

                listagem.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar clientes por nome: " + e.getMessage());
        }

        return listagem;
    }
}
