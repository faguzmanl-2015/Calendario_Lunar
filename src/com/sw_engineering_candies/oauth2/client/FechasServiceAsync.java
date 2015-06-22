package com.sw_engineering_candies.oauth2.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sw_engineering_candies.oauth2.shared.FechaLunar;

public interface FechasServiceAsync {

	public void guardarFecha(FechaLunar dateLunar,AsyncCallback<Boolean> callback);
	
	public void listarFechas(String fase, AsyncCallback<List<FechaLunar>> callback);
	
	void borrarFecha(FechaLunar fecha,
			AsyncCallback<Boolean> callback);
}
