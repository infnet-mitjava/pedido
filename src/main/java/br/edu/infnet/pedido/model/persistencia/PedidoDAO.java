package br.edu.infnet.pedido.model.persistencia;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.infnet.pedido.model.entidade.Cliente;
import br.edu.infnet.pedido.model.entidade.Pedido;
import br.edu.infnet.pedido.model.entidade.Produto;

public class PedidoDAO extends JdbcDAO<Pedido> {

	@Override
	public Boolean salvar(Pedido obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean atualizar(Pedido obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deletar(Pedido obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listarTodos() {
		String sql = "select * from cliente";
		Map<Long, Pedido> pedidos = new TreeMap<Long, Pedido>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				//p.codigo, p.data, c.nome, pr.descricao, pr.preco
				Long codigo = rs.getLong("codigo");
				LocalDate data = rs.getDate("data").toLocalDate();
				String nome = rs.getString("data");
				String descricao = rs.getString("data");
				Double preco = rs.getDouble("data");
				Pedido pedido = null;
				if(pedidos.get(codigo) == null) {
					pedido = new Pedido(codigo, data, new Cliente(nome));
					pedido.setProdutos(new ArrayList<>());
					pedidos.put(codigo, pedido);
				}
				Produto produto = new Produto(descricao, preco);
				pedido = pedidos.get(codigo);
				pedido.getProdutos().add(produto);
			}
			return new ArrayList<>(pedidos.values());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Pedido obter(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
