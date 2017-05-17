package br.com.senac.tsi.pi4.services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.senac.tsi.pi4.Database;
import br.com.senac.tsi.pi4.Categoria;
import com.google.gson.Gson;

@Path ("/categoria")
public class CategoriaService {
	//Método que retorna só uma categoria	
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduto(@PathParam("param") String categoriaId) {
		
		String id = categoriaId;
		Categoria categoria = null;
		
		try {
			
			Connection conn = Database.get().conn();
			PreparedStatement ps = conn.prepareStatement("select * from categoria where idCategoria = ?");
			ps.setInt(1, Integer.parseInt(id));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				categoria = new Categoria();
				categoria.setNomeCategoria(rs.getString("nomeCategoria"));
				categoria.setDescCategoria(rs.getString("descCategoria"));
				categoria.setIdCategoria(rs.getInt("idCategoria"));
			}
		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		if (categoria == null)
			return Response.status(404).entity(categoria).build();
		else
			return Response.status(200).entity(categoria).build();
		
	}
	
	//Método que retorna todas as categorias
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdutos() {
		
		Categoria categoria = null;
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {
			
			Connection conn = Database.get().conn();
			PreparedStatement ps = conn.prepareStatement("select * from categoria");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {    
				
				categoria = new Categoria();
				categoria.setNomeCategoria(rs.getString("nomeCategoria"));
				categoria.setDescCategoria(rs.getString("descCategoria"));
				categoria.setIdCategoria(rs.getInt("idCategoria"));
				categorias.add(categoria);
			}
		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		if (categorias.size()==0)
			return Response.status(404).entity(categorias).build();
		else
			return Response.status(200).entity(categorias).build();
		
	}
}