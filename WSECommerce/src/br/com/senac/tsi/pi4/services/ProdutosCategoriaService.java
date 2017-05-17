package br.com.senac.tsi.pi4.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.tsi.pi4.Database;
import br.com.senac.tsi.pi4.ProdutosCategoria;



@Path ("/ProdutosCategoria")
public class ProdutosCategoriaService {
	//Método que retorna produtos por categroia
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduto(@PathParam("param") String categoriaId) {
		
		String id = categoriaId;
		ProdutosCategoria produto = null;
		
		List<ProdutosCategoria> produtos = new ArrayList<ProdutosCategoria>();
		
		try {	
			Connection conn = Database.get().conn();
			PreparedStatement ps = conn.prepareStatement("select * from produto where idCategoria = ?");
			ps.setInt(1, Integer.parseInt(id));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {    
				
				produto = new ProdutosCategoria();
				produto.setNomeProduto(rs.getString("nomeProduto"));
				produto.setDescProduto(rs.getString("descProduto"));
				produto.setIdProduto(rs.getInt("idProduto"));
				produto.setPrecProduto(rs.getFloat("precProduto"));
				produto.setDescontoPromocao(rs.getFloat("descontoPromocao"));
				produto.setPrecProduto(rs.getFloat("precProduto"));
				produto.setIdCategoria(rs.getInt("idCategoria"));
				produto.setAtivoProduto(rs.getBoolean("ativoProduto"));
				produto.setQtdMinEstoque(rs.getInt("qtdMinEstoque"));
				produtos.add(produto);
			}
		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		if (produtos.size()==0)
			return Response.status(404).entity(produtos).build();
		else
			return Response.status(200).entity(produtos).build();
	}
}
