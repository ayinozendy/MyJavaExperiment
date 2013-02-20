package com.gamalinda.java;

public class MainApp {

	private static MainApp mainAppInstace = new MainApp();

	private MainApp() {

	}
	
	public static void main(String[] args) {
		getInstance().run();
	}

	public static MainApp getInstance() {
		return mainAppInstace;
	}

	public void run() {
		System.out.println("Hello World");
	}
}