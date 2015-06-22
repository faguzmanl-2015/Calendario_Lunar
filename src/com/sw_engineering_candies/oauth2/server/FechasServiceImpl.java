package com.sw_engineering_candies.oauth2.server;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.sw_engineering_candies.oauth2.client.FechasService;
import com.sw_engineering_candies.oauth2.shared.FechaLunar;

public class FechasServiceImpl extends RemoteServiceServlet implements
		FechasService {

	private static final long serialVersionUID = 3952664437504853905L;
	private Objectify ofy;
	
	@Override
	public void init(ServletConfig sc) {
		try {
			super.init(sc);

			ObjectifyService.register(FechaLunar.class);
			ofy = ObjectifyService.factory().begin();
			
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<FechaLunar> listarFechas(String fase)
			throws IllegalArgumentException {
		List<FechaLunar> listaFechas = ofy.load().type(FechaLunar.class).list();
		
		int i = 0;
		for (FechaLunar luna : listaFechas) {
			if (luna.equals(listaFechas.get(i).getFacelunar()))
				listaFechas.add(luna);
				i++;
		}
		return listaFechas;
	}

	@Override
	public boolean guardarFecha(FechaLunar dateLunar)
			throws IllegalArgumentException {
		List<FechaLunar> listalunas = ofy.load().type(FechaLunar.class).list();
		dateLunar.setId(listalunas.size() + 1);
		Window.alert("guardar 1");
		for (FechaLunar lunasAntiguas : listalunas) {
			if (dateLunar.equals(lunasAntiguas))
				return false;
		}
		try {
			Window.alert("guardar 2");
			ofy.save().entity(dateLunar).now();
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean borrarFecha(FechaLunar fecha)
			throws IllegalArgumentException {
		try {
			ofy.delete().type(FechaLunar.class).id(fecha.getId());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
