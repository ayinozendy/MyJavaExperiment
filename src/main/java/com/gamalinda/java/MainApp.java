package com.gamalinda.java;

import com.gamalinda.java.util.Log;

public class MainApp {
	private static final String TAG = MainApp.class.getSimpleName();

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
		Log.d(TAG, "Test!");
	}
}