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
		printArgs();
		respondToArgs();
	}

	private void printHelloWorld() {
		System.out.println("Hello World");
		Log.i(TAG, "Hello World");
	}

	private void printArgs() {
		for (String arg : argsList) {
			System.out.println(arg);
		}
	}

	private void respondToArgs() {
		for (String arg : argsList) {

			if (arg.equals("-a")) {
				System.out.println("Responding to A");
			} else if (arg.equals("-b")) {
				System.out.println("Responding to B");
			} else if (arg.equals("-c")) {
				System.out.println("Responding to C");
			} else if (arg.equals("-d")) {
				System.out.println("Responding to D");
			} else {
				System.out.println("Responding to Default");
			}
		}
	}
}