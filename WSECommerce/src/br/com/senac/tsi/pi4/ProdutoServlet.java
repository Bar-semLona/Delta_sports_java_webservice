package br.com.senac.tsi.pi4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public ProdutoServlet() {

    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String id = req.getParameter("productId");
		
		try {
			resp.getWriter().append("doGet "+ id);
			Connection conn = Database.get().conn();
			PreparedStatement ps = conn.prepareStatement("select * from produto where idProduto = ?");
			ps.setInt(1, Integer.parseInt(id));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				resp.getWriter().append( rs.getString("nomeProduto"));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		resp.getWriter().append("doPost");
	}
    
    

}
