package com.sw_engineering_candies.oauth2.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.sw_engineering_candies.oauth2.shared.FechaLunar;

public interface FechasService extends RemoteService {

	public boolean guardarFecha(FechaLunar dateLunar);

	List<FechaLunar> listarFechas(String fase);

	public boolean borrarFecha(FechaLunar fecha);

}
