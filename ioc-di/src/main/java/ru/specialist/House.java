package ru.specialist;

import java.io.Closeable;
import java.io.IOException;

public class House implements Closeable{
	private Window window;
	
	public House(Window wnd) {
		this.window = wnd;
		System.out.println("Create house");
	}

	public Window getWindow() {
		return window;
	}
	public void setWindow(Window window) {
		this.window = window;
	}
	
	public void ventilate() {
		getWindow().open();
	}

	@Override
	public void close() {
		System.out.print("Destroy house");
		
	}

}
