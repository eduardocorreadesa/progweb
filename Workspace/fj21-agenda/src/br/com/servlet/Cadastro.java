package br.com.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastrox")
public class Cadastro extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
					throws IOException, ServletException {

		String nome = request.getParameter("nome");
		String dataEmTexto = request.getParameter("dataNascimento");
		String sexo = request.getParameter("sexo");
		String ensino = request.getParameter("ensino");
		String[] interesses = request.getParameterValues("interesses");
		String interesse = Arrays.toString(interesses);

		System.out.println(nome);
		System.out.println(dataEmTexto);
		System.out.println(sexo);
		System.out.println(ensino);
		System.out.println(interesse);

		request.getRequestDispatcher("pessoaCadastrada.jsp").forward(request, response);

	}

}
