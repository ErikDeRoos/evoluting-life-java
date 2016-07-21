package main;

import javax.swing.JFrame;

import ui.Canvas;

public class Run {

	public static void main(String[] args) {
		
		Main main = new Main();
		
		JFrame frame = new JFrame("Evoluting-life-java");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Canvas canvas = new Canvas(main.foodSupply, main.population);
	    frame.add(canvas);
	    frame.setSize(500, 500);
	    frame.setVisible(true);
	    frame.setResizable(false);
		
		
		main.addObserver(canvas);
		
		main.startMainLoop();
	}

}
