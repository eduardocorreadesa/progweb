package controllers;

import java.net.UnknownHostException;

import views.Home;

public class Main {

	public static void main( String[] args ) throws UnknownHostException{

		Home principal = new Home();
		principal.setVisible(true);
	}

}
