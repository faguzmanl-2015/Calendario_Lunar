/* Copyright (C) 2012-2013, Markus Sprunck
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the following
 * conditions are met:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * - Redistributions in binary form must reproduce the above
 *   copyright notice, this list of conditions and the following
 *   disclaimer in the documentation and/or other materials provided
 *   with the distribution.
 *
 * - The name of its contributor may be used to endorse or promote
 *   products derived from this software without specific prior
 *   written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 */

package com.sw_engineering_candies.oauth2.client;

import com.google.api.gwt.oauth2.client.Auth;
import com.google.api.gwt.oauth2.client.AuthRequest;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.sw_engineering_candies.oauth2.shared.FechaLunar;
import com.sw_engineering_candies.oauth2.shared.FieldVerifier;
import com.sw_engineering_candies.oauth2.shared.LoginInfo;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class OAuthAppEngineSample implements EntryPoint {

	// TODO #05: add constants for OAuth2 (don't forget to update GOOGLE_CLIENT_ID)
	private static final Auth AUTH = Auth.get();
	private static final String GOOGLE_AUTH_URL = "https://accounts.google.com/o/oauth2/auth";
	private static final String GOOGLE_CLIENT_ID = "1095823490702-92ekunpmripppn51uvj9pu6cg6auhl9i.apps.googleusercontent.com";
	private static final String PLUS_ME_SCOPE = "https://www.googleapis.com/auth/userinfo.profile";
	// TODO #05:> end

	// TODO #06: define controls for login
	private final HorizontalPanel loginPanel = new HorizontalPanel();
	private final Anchor signInLink = new Anchor("");
	private final Image loginImage = new Image();
	private final TextBox nameField = new TextBox();
	// TODO #06:> end

	//Variable del panel a cambiar
	final static HorizontalPanel panelPrincipal = new HorizontalPanel();
	private final TextBox faseField = new TextBox();
	private final TextBox fechaField = new TextBox();
	private final TextBox horaField = new TextBox();
	
	
	/**
	 * The message displayed to the user when the server cannot be reached or returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
	private final FechasServiceAsync fechasService = GWT.create(FechasService.class);

	protected void registrar() {
		String fase = faseField.getText();
		String fecha = fechaField.getText();
		String hora = horaField.getText();
		FechaLunar f1 = new FechaLunar();
		f1.setFacelunar(fase);
		f1.setFecha(fecha);
		f1.setHora(hora);
		f1.setId(0);

		Window.alert("fuera.");
		if (true) {
			Window.alert("entro 1.");
						fechasService.guardarFecha(f1, new AsyncCallback<Boolean>() {
							
				public void onSuccess(Boolean result) {
					Window.alert("entro 2.");
					if (result)
						Window.alert("Fecha lunar guardada.");
					else
						Window.alert("la fecha ya existe.");
					Window.alert("entro 2.");
				}
				public void onFailure(Throwable caught) {
					Window.alert(caught.getMessage());
				}
				
			});
						Window.alert("kkkkkkk.");

		}
	}
	
	//Funcion que cambia el contenido
	public static void CambiaContenido(int Variable)
	{
		switch (Variable)
		{
			case 0:
				ContenidoGeneral();
				break;
			case 1:
				Lista1();
				break;
			case 2:
				Lista2();
				break;
			case 3:
				Lista3();
				break;
			case 4:
				Lista4();
				break;
		}
	}
	//Funcion que cambia el contenido
	public static void ContenidoGeneral()
	{
		panelPrincipal.setSize("100%", "100%");
		panelPrincipal.setHorizontalAlignment(panelPrincipal.ALIGN_CENTER);
		panelPrincipal.clear();
		RootPanel.get("divContenido").clear();
		panelPrincipal.add(new HTML("<br>Seleccione una opcion y filtre para ver resultados.<br>"));
	    RootPanel.get("divContenido").add(panelPrincipal);
	}
	//Funcion que crea la tabla con el contenido
	public static void Lista1()
	{
		 // Make a new list box, adding a few items to it.
	    
		FlexTable myTable = new FlexTable();
		myTable.setCellPadding(10);
		myTable.setCellSpacing(10);
		Label label = new Label("Fase de la luna");
		label.setStylePrimaryName("TextoGrande");
		myTable.setWidget(0,0,label);
		label = new Label("Fecha");
		label.setStylePrimaryName("TextoGrande");
		myTable.setWidget(0,1,label);
		label = new Label("Hora");
		label.setStylePrimaryName("TextoGrande");
		myTable.setWidget(0,2,label);
		
		//linea con la primera luna llena
		label = new Label("Moon llena");
		label.setStylePrimaryName("Texto");
		myTable.setWidget(1,0,label);
		label = new Label("5 enero 2015");
		label.setStylePrimaryName("Texto");
		myTable.setWidget(1,1,label);
		label = new Label("05:54:08");
		label.setStylePrimaryName("Texto");
		myTable.setWidget(1,2,label);
		
		

		panelPrincipal.setSize("100%", "100%");
		panelPrincipal.setHorizontalAlignment(panelPrincipal.ALIGN_CENTER);
		panelPrincipal.clear();
		RootPanel.get("divContenido").clear();
		panelPrincipal.add(myTable);
	    RootPanel.get("divContenido").add(panelPrincipal);
	}
	public static void Lista2()
	{
		 // Make a new list box, adding a few items to it.
	    
		FlexTable myTable = new FlexTable();
		myTable.setCellPadding(10);
		myTable.setCellSpacing(10);
		Label label = new Label("Fase de la luna");
		label.setStylePrimaryName("TextoGrande");
		myTable.setWidget(0,0,label);
		label = new Label("Fecha");
		label.setStylePrimaryName("TextoGrande");
		myTable.setWidget(0,1,label);
		label = new Label("Hora");
		label.setStylePrimaryName("TextoGrande");
		myTable.setWidget(0,2,label);
		
		//linea con la primera luna nueva
		label = new Label("Moon nueva");
		label.setStylePrimaryName("Texto");
		myTable.setWidget(1,0,label);
		label = new Label("5 enero 2015");
		label.setStylePrimaryName("Texto");
		myTable.setWidget(1,1,label);
		label = new Label("05:54:08");
		label.setStylePrimaryName("Texto");
		myTable.setWidget(1,2,label);
		
		

		panelPrincipal.setSize("100%", "100%");
		panelPrincipal.setHorizontalAlignment(panelPrincipal.ALIGN_CENTER);
		panelPrincipal.clear();
		RootPanel.get("divContenido").clear();
		panelPrincipal.add(myTable);
	    RootPanel.get("divContenido").add(panelPrincipal);
	}
	public static void Lista3()
	{
		 // Make a new list box, adding a few items to it.
	    
		FlexTable myTable = new FlexTable();
		myTable.setCellPadding(10);
		myTable.setCellSpacing(10);
		Label label = new Label("Fase de la luna");
		label.setStylePrimaryName("TextoGrande");
		myTable.setWidget(0,0,label);
		label = new Label("Fecha");
		label.setStylePrimaryName("TextoGrande");
		myTable.setWidget(0,1,label);
		label = new Label("Hora");
		label.setStylePrimaryName("TextoGrande");
		myTable.setWidget(0,2,label);
		
		//linea con la primera luna llena
		label = new Label("Moon creciente");
		label.setStylePrimaryName("Texto");
		myTable.setWidget(1,0,label);
		label = new Label("5 enero 2015");
		label.setStylePrimaryName("Texto");
		myTable.setWidget(1,1,label);
		label = new Label("05:54:08");
		label.setStylePrimaryName("Texto");
		myTable.setWidget(1,2,label);
		
		

		panelPrincipal.setSize("100%", "100%");
		panelPrincipal.setHorizontalAlignment(panelPrincipal.ALIGN_CENTER);
		panelPrincipal.clear();
		RootPanel.get("divContenido").clear();
		panelPrincipal.add(myTable);
	    RootPanel.get("divContenido").add(panelPrincipal);
	}
	public static void Lista4()
	{
		 // Make a new list box, adding a few items to it.
	    
		FlexTable myTable = new FlexTable();
		myTable.setCellPadding(10);
		myTable.setCellSpacing(10);
		Label label = new Label("Fase de la luna");
		label.setStylePrimaryName("TextoGrande");
		myTable.setWidget(0,0,label);
		label = new Label("Fecha");
		label.setStylePrimaryName("TextoGrande");
		myTable.setWidget(0,1,label);
		label = new Label("Hora");
		label.setStylePrimaryName("TextoGrande");
		myTable.setWidget(0,2,label);
		
		//linea con la primera luna llena
		label = new Label("Moon menguante");
		label.setStylePrimaryName("Texto");
		myTable.setWidget(1,0,label);
		label = new Label("5 enero 2015");
		label.setStylePrimaryName("Texto");
		myTable.setWidget(1,1,label);
		label = new Label("05:54:08");
		label.setStylePrimaryName("Texto");
		myTable.setWidget(1,2,label);
		
		

		panelPrincipal.setSize("100%", "100%");
		panelPrincipal.setHorizontalAlignment(panelPrincipal.ALIGN_CENTER);
		panelPrincipal.clear();
		RootPanel.get("divContenido").clear();
		panelPrincipal.add(myTable);
	    RootPanel.get("divContenido").add(panelPrincipal);
	}
	// TODO #07: add helper methods for Login, Logout and AuthRequest

	private void loadLogin(final LoginInfo loginInfo) {
		signInLink.setHref(loginInfo.getLoginUrl());
		signInLink.setText("Please, sign in with your Google Account");
		signInLink.setTitle("Sign in");
	}

	private void loadLogout(final LoginInfo loginInfo) {
		signInLink.setHref(loginInfo.getLogoutUrl());
		signInLink.setText(loginInfo.getName());
		signInLink.setTitle("Sign out");
	}

	private void addGoogleAuthHelper() {
		final AuthRequest req = new AuthRequest(GOOGLE_AUTH_URL, GOOGLE_CLIENT_ID)
				.withScopes(PLUS_ME_SCOPE);
		AUTH.login(req, new Callback<String, Throwable>() {
			@Override
			public void onSuccess(final String token) {

				if (!token.isEmpty()) {
					greetingService.loginDetails(token, new AsyncCallback<LoginInfo>() {
						@Override
						public void onFailure(final Throwable caught) {
							GWT.log("loginDetails -> onFailure");
						}

						@Override
						public void onSuccess(final LoginInfo loginInfo) {
							signInLink.setText(loginInfo.getName());
							nameField.setText(loginInfo.getName());
							signInLink.setStyleName("login-area");
							loginImage.setUrl(loginInfo.getPictureUrl());
							loginImage.setVisible(false);
							loginPanel.add(loginImage);
							loginImage.addLoadHandler(new LoadHandler() {
								@Override
								public void onLoad(final LoadEvent event) {
									final int newWidth = 24;
									final com.google.gwt.dom.client.Element element = event
											.getRelativeElement();
									if (element.equals(loginImage.getElement())) {
										final int originalHeight = loginImage.getOffsetHeight();
										final int originalWidth = loginImage.getOffsetWidth();
										if (originalHeight > originalWidth) {
											loginImage.setHeight(newWidth + "px");
										} else {
											loginImage.setWidth(newWidth + "px");
										}
										loginImage.setVisible(true);
									}
								}
							});
						}
					});
				}
			}

			@Override
			public void onFailure(final Throwable caught) {
				GWT.log("Error -> loginDetails\n" + caught.getMessage());
			}
		});
	}

	// TODO #07:> end

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {

	
		final Button sendButton = new Button("Send");
		final Button crearButton = new Button("Crear");
		final Label errorLabel = new Label();
		
		final Button botonFiltro = new Button("Filtrar");
		final ListBox lb = new ListBox();
			lb.addItem(" ");
		    lb.addItem("Luna llena");
		    lb.addItem("Luna nueva");
		    lb.addItem("Cuarto creciente");
		    lb.addItem("Cuarto menguante");
		final    HorizontalPanel unPanel = new HorizontalPanel();
			unPanel.add(lb);
			unPanel.add(botonFiltro);    
		// We can add style names to widgets
		sendButton.addStyleName("sendButton");
		crearButton.addStyleName("crearButton");
		
	
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);
		RootPanel.get("faseFieldContainer").add(faseField);
		RootPanel.get("fechaFieldContainer").add(fechaField);
		RootPanel.get("horaFieldContainer").add(horaField);
		RootPanel.get("crearButtonContainer").add(crearButton);
		
		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
		 
		// Add a handler to close the DialogBox
		
		crearButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				registrar();
			}
		});
		closeButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});
		botonFiltro.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				CambiaContenido(lb.getSelectedIndex());
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			@Override
			public void onClick(ClickEvent event) {
				registrar();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			@Override
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					registrar();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			
			private void sendText() {
				// First, we validate the input.
				errorLabel.setText("");
				String textFase = faseField.getText();
				if (!FieldVerifier.isValidName(textFase)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}
				String textFecha = fechaField.getText();
				if (!FieldVerifier.isValidName(textFecha)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}
				String textHora = horaField.getText();
				if (!FieldVerifier.isValidName(textHora)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}
			}
			
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer, new AsyncCallback<String>() {
					@Override
					public void onFailure(Throwable caught) {
						// Show the RPC error message to the user
						dialogBox.setText("Remote Procedure Call - Failure");
						serverResponseLabel.addStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(SERVER_ERROR);
						dialogBox.center();
						closeButton.setFocus(true);
					}

					@Override
					public void onSuccess(String result) {
						dialogBox.setText("Remote Procedure Call");
						serverResponseLabel.removeStyleName("serverResponseLabelError");
						serverResponseLabel.setHTML(result);
						dialogBox.center();
						closeButton.setFocus(true);
					}
				});
			}
		}
		

		signInLink.getElement().setClassName("login-area");
		signInLink.setTitle("sign out");
		loginImage.getElement().setClassName("login-area");
		loginPanel.add(signInLink);
		RootPanel.get("loginPanelContainer").add(loginPanel);
		
		
		final StringBuilder userEmail = new StringBuilder();
		greetingService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
			@Override
			public void onFailure(final Throwable caught) {
				GWT.log("login -> onFailure");
				RootPanel.get("divFiltro").clear();
			}
			
			@Override
			public void onSuccess(final LoginInfo result) {
				//LOGEO EXITOSOS
				if (result.getName() != null && !result.getName().isEmpty()) {
					addGoogleAuthHelper();
					loadLogout(result);
					//Pongo el contenido en el panel
					ContenidoGeneral();
					RootPanel.get("divFlitro").add(unPanel);
				} else {
					loadLogin(result);
					RootPanel.get("divFiltro").clear();
				}
				userEmail.append(result.getEmailAddress());
				
			}
		});
		// TODO #08:> end

		

	}
}
