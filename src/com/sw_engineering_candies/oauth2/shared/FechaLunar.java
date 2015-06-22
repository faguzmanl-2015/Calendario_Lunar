package com.sw_engineering_candies.oauth2.shared;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class FechaLunar implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id Long id;
	    public String facelunar;
		public String fecha;
		public String hora;	
	
	public FechaLunar() {
			super();
		}
	public FechaLunar(String facelunar, String fecha, String hora) {
			super();
			this.facelunar = facelunar;
			this.fecha = fecha;
			this.hora = hora;
		}
	public String getFecha() {
			return fecha;
		}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public void setFacelunar(String facelunar) {
		this.facelunar = facelunar;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getFacelunar() {
		return facelunar;
	}
	public boolean equals(FechaLunar luna)
    {
    	return this.facelunar == luna.facelunar;
    }
	@Override
	public String toString() {
		return facelunar + ":  " + fecha+"  "+hora;
	}
	public Long getId() {
		return id;
	}
	public void setId(int i) {
		this.id = (long) i;
	}
	
}
