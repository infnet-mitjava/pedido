package br.edu.infnet.pedido.model.persistencia;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PedidoDAOTest {

	private IDAO pedidoDAO = new PedidoDAO();
	
	@Test
	public void testListaClientes() {
		pedidoDAO = new PedidoDAO();
		List<PedidoDAO> lista = pedidoDAO.listarTodos();
		System.out.println(lista);
		Assert.assertTrue(lista.size() > 0);
	}
	


}
