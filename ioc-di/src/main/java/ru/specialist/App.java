package ru.specialist;

public class App {

	public static void main(String[] args) {
		//WoodFrameWindow woodWnd = new WoodFrameWindow ();
		//House house = new House(woodWnd);
		//PlasticWindow wnd = new PlasticWindow();
		
		//house.setWindow(wnd);
		//house.setWindow( woodWnd );
		try (Container builder = new Container()){
			House house = builder.getWoodHouse();
			house.ventilate();
		}
		

	}

}
