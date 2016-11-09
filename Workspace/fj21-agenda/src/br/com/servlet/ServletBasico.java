package br.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teste")
public class ServletBasico extends HttpServlet{
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException {
		
		request.setAttribute("nome", "dudu");
		String  nome = (String) request.getAttribute("nome");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Nome:"+nome);
		out.println("</body>");
		out.println("</html>");
		
		request.getRequestDispatcher("teste.jsp").forward(request, response);
		
	}

}
