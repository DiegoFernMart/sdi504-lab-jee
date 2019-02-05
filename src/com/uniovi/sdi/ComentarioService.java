package com.uniovi.sdi;

import java.util.LinkedList;
import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class ComentarioService {
	
	public List<Comentario> getComentarios() {
		
		List<Comentario> productos = new LinkedList<Comentario>();
		ObjectContainer db = null;
		try {
			db = Db4oEmbedded.openFile("bdComentarios");
			List<Comentario> respuesta = db.queryByExample(Comentario.class);
			productos.addAll(respuesta);

		} finally {
			db.close();
		}
		return productos;
	}

	public void setNuevoProducto(Comentario nuevoComentario) {
		ObjectContainer db = null;
		try {
			db = Db4oEmbedded.openFile("bdComentarios");
			db.store(nuevoComentario);
		} finally {
			db.close();
		}
	}

}
