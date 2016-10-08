package br.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@WebServlet("/cadastro")
	public class CadastroServlet extends HttpServlet {
		protected void service(HttpServletRequest request,
				HttpServletResponse response)
						throws IOException, ServletException {

			PrintWriter out = response.getWriter();

			// pegando os parâmetros do request
			String nome = request.getParameter("nome");
			String dataEmTexto = request.getParameter("dataNascimento");
			String sexo = request.getParameter("sexo");
			String ensino = request.getParameter("ensino");
			String[] interesses = request.getParameterValues("interesses");
			String interesse = Arrays.toString(interesses);

			
			
			// imprime o nome do contato que foi adicionado
			out.println("<html>");
			out.println("<body>");
			out.println("Contato adicionado com sucesso");    
			out.println("</body>");
			out.println("</html>");

			System.out.println(nome);
			System.out.println(dataEmTexto);
			System.out.println(sexo);
			System.out.println(ensino);
			System.out.println(interesse);
		}
	
}
