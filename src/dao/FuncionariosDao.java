package dao;

// Imports
import beans.Funcionarios;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionariosDao {

    // Atributo pra conexão
    private Conexao conexao = new Conexao();

    // Método para cadastrar funcionários
    public void cadastroFuncionarios(Funcionarios funcionario) {

        String sql = "INSERT INTO funcionarios (nome, cpf, email, celular, cep, endereco, numero, bairro, cidade, complemento, unidade, tipo, cargo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = conexao.connectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getEmail());
            ps.setString(4, funcionario.getCelular());
            ps.setString(5, funcionario.getCep());
            ps.setString(6, funcionario.getEndereco());
            ps.setString(7, funcionario.getNumero());
            ps.setString(8, funcionario.getBairro());
            ps.setString(9, funcionario.getCidade());
            ps.setString(10, funcionario.getComplemento());
            ps.setString(11, funcionario.getUnidade());
            ps.setString(12, funcionario.getTipo());
            ps.setString(13, funcionario.getCargo());

            ps.executeUpdate();

            System.out.println("Funcionário cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
        }
    }

    // Método para buscar os funcionários pelo nome e posteriormente exibí-los nos jTextFields
    public Funcionarios buscarNomeFuncionario(String nome) {

        String sql = "SELECT * FROM funcionarios WHERE nome LIKE ?";

        try (Connection conn = conexao.connectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nome + "%");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Funcionarios funcionario = new Funcionarios();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setCelular(rs.getString("celular"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setComplemento(rs.getString("complemento"));
                funcionario.setUnidade(rs.getString("unidade"));
                funcionario.setTipo(rs.getString("tipo"));
                funcionario.setCargo(rs.getString("cargo"));

                return funcionario;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar funcionário: " + e.getMessage());
        }
        return null;
    }

    // Método para atualizar os funcionários
    public void atualizarFuncionarios(Funcionarios funcionario) {

        String sql = "UPDATE funcionarios SET nome = ?, cpf = ?, email = ?, celular = ?, cep = ?, endereco = ?, "
                + "numero = ?, bairro = ?, cidade = ?, complemento = ?, unidade = ?, tipo = ?, cargo = ? WHERE id = ?";

        try (Connection conn = conexao.connectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getEmail());
            ps.setString(4, funcionario.getCelular());
            ps.setString(5, funcionario.getCep());
            ps.setString(6, funcionario.getEndereco());
            ps.setString(7, funcionario.getNumero());
            ps.setString(8, funcionario.getBairro());
            ps.setString(9, funcionario.getCidade());
            ps.setString(10, funcionario.getComplemento());
            ps.setString(11, funcionario.getUnidade());
            ps.setString(12, funcionario.getTipo());
            ps.setString(13, funcionario.getCargo());
            ps.setInt(14, funcionario.getId());

            ps.executeUpdate();

            System.out.println("Funcionário atualizado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar funcionário: " + e.getMessage());
        }
    }

    // Método para excluir funcionários
    public void excluirFuncionarios(Funcionarios funcionario) {

        String sql = "DELETE FROM funcionarios WHERE id = ?";

        try (Connection conn = conexao.connectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, funcionario.getId());
            ps.executeUpdate();

            System.out.println("Funcionário excluído com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir funcionário: " + e.getMessage());
        }
    }

    // Método para listar todos os funcionários
    public ArrayList<Funcionarios> listarFuncionarios() {

        ArrayList<Funcionarios> listagem = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios";

        try (Connection conn = conexao.connectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Funcionarios funcionario = new Funcionarios();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setCelular(rs.getString("celular"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setComplemento(rs.getString("complemento"));
                funcionario.setUnidade(rs.getString("unidade"));
                funcionario.setTipo(rs.getString("tipo"));
                funcionario.setCargo(rs.getString("cargo"));

                listagem.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        }

        return listagem;
    }

    // Método para listar os funcionários filtrando pelo nome
    public ArrayList<Funcionarios> listarFuncionariosPorNome(String nome) {
        ArrayList<Funcionarios> listagem = new ArrayList<>();
        String sql = "SELECT * FROM funcionarios WHERE nome LIKE ?";

        try (Connection conn = conexao.connectDB(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nome + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Funcionarios funcionario = new Funcionarios();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setCelular(rs.getString("celular"));
                funcionario.setCep(rs.getString("cep"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setComplemento(rs.getString("complemento"));
                funcionario.setUnidade(rs.getString("unidade"));
                funcionario.setTipo(rs.getString("tipo"));
                funcionario.setCargo(rs.getString("cargo"));

                listagem.add(funcionario);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar funcionários por nome: " + e.getMessage());
        }

        return listagem;
    }
}
