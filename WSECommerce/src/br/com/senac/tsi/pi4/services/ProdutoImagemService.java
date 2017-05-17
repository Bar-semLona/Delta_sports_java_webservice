package br.com.senac.tsi.pi4.services;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.com.senac.tsi.pi4.Database;
import br.com.senac.tsi.pi4.ProdutoImagem;

@Path ("/imagem")
public class ProdutoImagemService {
		
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getImagem(@PathParam("param") String imagemId) {
		
		String id = imagemId;
		ProdutoImagem imagem = null;
		
		try {
			Connection conn = Database.get().conn();
			PreparedStatement ps = conn.prepareStatement("select imagem from produto where idProduto = ?");
			ps.setInt(1, Integer.parseInt(id));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				imagem = new ProdutoImagem();
				byte[] imagemBytes = rs.getBytes("imagem");
				String imagemString = java.util.Base64.getEncoder().encodeToString(imagemBytes);
				imagem.setImagem(imagemString);
			}
		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}
		if (imagem == null)
			return Response.status(404).entity(imagem).build();
		else
			return Response.status(200).entity(imagem).build();
	}
	
}