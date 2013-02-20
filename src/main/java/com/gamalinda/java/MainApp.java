package com.gamalinda.java;

import java.util.*;
import com.gamalinda.java.util.Log;

public class MainApp {
	private static final String TAG = MainApp.class.getSimpleName();

	private static MainApp mainAppInstace = new MainApp();
	private static boolean running = true;

	private static List<String> argsList;

	private MainApp() {}

	public static void main(String[] args) {

		argsList = Arrays.asList(args);
		getInstance().run();
	}

	public static MainApp getInstance() {
		return mainAppInstace;
	}

	private void run() {
		printHelloWorld();

		for(String arg : argsList) {
			System.out.println(arg);
		}
	}

	private void printHelloWorld() {
		System.out.println("Hello World");
	}
}