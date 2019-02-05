package com.uniovi.sdi;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletComentario
 */
@WebServlet("/addComentario")
public class ServletComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletComentario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Pares nombre imagen
				List<Comentario> listaComentarios = (List<Comentario>) request.getSession().getAttribute("listaComentarios");
				
				
				// No hay lista, creamos una y la insertamos en sesión
				if (listaComentarios == null) {
					listaComentarios = new LinkedList<Comentario>();
					request.getSession().setAttribute("listaComentarios", listaComentarios);
				}
				//Insertamos los comentarios en la lista
				ComentarioService cS= new ComentarioService();
				List<Comentario> lista = cS.getComentarios();
				for(Comentario c : lista){
					if (c.getAuthor() != null)
						listaComentarios.add(c);
					
				}
				
				// Retornar la vista con parámetro
				request.setAttribute("listaComentarios", listaComentarios);
				getServletContext().getRequestDispatcher("/foro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
