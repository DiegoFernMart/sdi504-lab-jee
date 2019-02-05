package com.uniovi.sdi;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/productos")
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Pares nombre imagen
		HashMap<String, String> productosTienda = (HashMap<String, String>) request.getSession().getAttribute("productosTienda");
		//HashMap<String, String> productosTienda = new HashMap<String,String>();
		
		// No hay lista, creamos una y la insertamos en sesión
		if (productosTienda == null) {
			productosTienda = new HashMap<String, String>();
			request.getSession().setAttribute("productosTienda", productosTienda);
		}
		//Insertamos el producto en la lista
		ProductosService pS= new ProductosService();
		List<Producto> lista = pS.getProductos();
		for(Producto p : lista){
			if (productosTienda.get(p.getNombre()) == null)
				productosTienda.put(p.getNombre(), p.getImagen());
			
		}
		
		// Retornar la vista con parámetro "carrito"
		request.setAttribute("listaProductos", productosTienda);
		getServletContext().getRequestDispatcher("/vista-productos.jsp").forward(request, response);	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
