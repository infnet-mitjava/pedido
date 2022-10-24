package br.edu.infnet.pedido.model.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.pedido.model.entidade.Cliente;

public class ClienteDAO extends JdbcDAO<Cliente>  {

	public ClienteDAO() {
	}
	

	@Override
	public Boolean salvar(Cliente cliente) {
		String sql = "insert into cliente(nome, codigo) values (?,null)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, cliente.getNome()); //sql injection
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean atualizar(Cliente cliente) {
		String sql = "update cliente values (?) where codigo = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, cliente.getCodigo()); 
			pstm.setString(2, cliente.getNome());
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deletar(Cliente cliente) {
		String sql = "delete from cliente  where codigo = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, cliente.getCodigo()); //sql injection
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cliente> listarTodos() {
		String sql = "select * from cliente";
		List<Cliente> clientes = new ArrayList<>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				String nome = rs.getString("nome");
				Long codigo = rs.getLong("codigo");
				Cliente cliente = new Cliente(nome, codigo);
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Cliente obter(Long codigo) {
		String sql = "select * from cliente where codigo = ? ";
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			if(rs.next()) {
				return new Cliente(rs.getString("nome"), rs.getLong("codigo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
