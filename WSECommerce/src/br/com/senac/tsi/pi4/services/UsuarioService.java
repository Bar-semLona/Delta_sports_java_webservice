package br.com.senac.tsi.pi4.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.senac.tsi.pi4.Database;
import br.com.senac.tsi.pi4.Usuario;

import com.google.gson.Gson;



@Path ("/usuarios")
public class UsuarioService {
	
	//Método que retorna um usuário existente na base de dados
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getUsuario(Usuario usuario) {
		
		String emailCliente = usuario.getEmailCliente();
		String senhaCliente = usuario.getSenhaCliente();
		
		try {
			
			Connection conn = Database.get().conn();
			PreparedStatement ps = conn.prepareStatement("select * from cliente where emailCliente = ? AND senhaCliente = ?");
			ps.setString(1, emailCliente);
			ps.setString(2, senhaCliente);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
			}
			
		} catch (Exception e) {
			return Response.status(500).entity(null).build();
		}		
		
		Gson gson = new Gson ();
		String jsonUsuario = gson.toJson(usuario);
		System.out.println("retornando usuário "+jsonUsuario);
		return Response.status(200).entity("").build();
	}
	
}
