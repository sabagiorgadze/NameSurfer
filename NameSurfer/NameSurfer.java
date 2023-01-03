/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class NameSurfer extends Program implements NameSurferConstants {
	private NameSurferDataBase db = new NameSurferDataBase(NAMES_DATA_FILE);
	private NameSurferGraph graph;
	
	
	public NameSurfer(){
		graph = new NameSurferGraph();
		add(graph);
	}

/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	
	
	
/*
 * I make this variables global, because I needed to use them in drawInteractos method as well
 * as in actionPerformed method.
 */
	private JLabel name;
	private JTextField nameWriter;
	private JButton butt1;
	private JButton butt2;
	
	
	public void init() {
		drawInteractors();
	}
	
	
/*
 * This method is responsible for drawing the text Field and two buttons(graph button and
 * clear button) on the canvas.
 */
	private void drawInteractors() {
		name = new JLabel("Name");
		add(name,SOUTH);
		
		nameWriter = new JTextField(20);
		add(nameWriter,SOUTH);
		
		butt1 = new JButton("Graph");
		add(butt1,SOUTH);
		
		butt2 = new JButton("Clear");
		add(butt2,SOUTH);
		addActionListeners();
	}

/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		String lastAction = e.getActionCommand();
		String name = nameWriter.getText();
		if(lastAction.equals("Graph")){
			NameSurferEntry entry = db.findEntry(name);
			graph.addEntry(entry);
			graph.update();
		}else if(e.getSource() == butt2){
			println("Clear");
			graph.clear();
			graph.update();
		}
	}
}