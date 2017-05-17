package br.com.senac.tsi.pi4.services;

import java.sql.Connection;
import java.sql.Date;
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


@Path ("/cadastro-cliente")
public class cadastroCliente {
	
	//Método cadastro de clientes
		@POST	
		@Consumes(MediaType.APPLICATION_JSON)
		public Response setUsuario(Usuario usuario) {
			
		String nomeCliente = usuario.getNomeCompletoCliente();
		String emailCliente = usuario.getEmailCliente();
		String senhaCliente = usuario.getSenhaCliente();
		String cpfCliente = usuario.getcpfCliente();
		String celularCliente = usuario.getCelularCliente();
		String telComercialCliente = usuario.getTelComercialCliente();
		String telResidencialCliente = usuario.getTelResidencialCliente();
		String dtNascCliente = usuario.getDtNascCliente();
		boolean recebeNewsLetter = usuario.isRecebeNewsLetter();
		
		try {
			
			Connection conn = Database.get().conn();
			PreparedStatement ps = conn.prepareStatement("insert into cliente (nomeCompletoCliente, emailCliente, senhaCliente, cpfCliente, celularCliente, telComercialCliente, telResidencialCliente, dtNascCliente, recebeNewsLetter) VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, nomeCliente);
			ps.setString(2, emailCliente);
			ps.setString(3, senhaCliente);
			ps.setString(4, cpfCliente);
			ps.setString(5, celularCliente);
			ps.setString(6, telComercialCliente);
			ps.setString(7, telResidencialCliente);
			Date x;
			ps.setString(8, dtNascCliente);
			ps.setBoolean(9, recebeNewsLetter);
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
