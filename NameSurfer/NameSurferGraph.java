import acm.graphics.*;
import acm.util.RandomGenerator;

import java.awt.event.*;
import java.util.*;
import java.awt.*;


/*
* File: NameSurferGraph.java
* —————————
* This class represents the canvas on which the graph of
* names is drawn. This class is responsible for updating
* (redrawing) the graphs whenever the list of entries changes
* or the window is resized.
*/

public class NameSurferGraph extends GCanvas
implements NameSurferConstants, ComponentListener {

/**
* Creates a new NameSurferGraph object that displays the data.
*/
	public NameSurferGraph() {
		addComponentListener(this);
		graph = new ArrayList<NameSurferEntry>();	
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		graph.clear();
		update();
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		graph.add(entry);
	
	}
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		removeAll();
		drawGraph();
		for(int i = 0; i < graph.size(); i++){
			drawNameStatistics();
		}
	}

/*
 * This method is drawing the graph about the name, which has been inputed by the user
 */
	private void drawNameStatistics() {
		for (int i = 0; i < graph.size(); i++) {
			NameSurferEntry entry = graph.get(i);
			String desiredName = entry.getName();
			int rankings = entry.getRank(0);

			String rankLabel = Integer.toString(rankings);
			double xCoordinate = 0;
			double yCoordinate = 20 +((double)rankings/(double)MAX_RANK * (getHeight() - (GRAPH_MARGIN_SIZE * 2)));
			
			
			
			for (int j = 1; j < NDECADES; j++) {
				GLabel label = new GLabel(desiredName + " " + rankLabel, xCoordinate, yCoordinate); 
				rankings = entry.getRank(j);
				
				rankLabel = Integer.toString(rankings);
				if (rankings == 0) {
					rankings = 1000;
				}
				
				double secondXCoordinate = j * getWidth() / NDECADES;
				double secondYCoordinate = 20 + ((double)rankings / (double)MAX_RANK) * (getHeight() - (GRAPH_MARGIN_SIZE * 2));
				
				for(int i1 = 0; i1 < graph.size(); i1++){
					line = new GLine(xCoordinate, yCoordinate, secondXCoordinate, secondYCoordinate);
					int number = i1 % 4;
					switch(number){
					case 0:
						line.setColor(Color.BLUE);
						break;
					case 1:
						line.setColor(Color.RED);
						break;
					case 2:
						line.setColor(Color.BLUE);
						break;
					case 3:
						line.setColor(Color.CYAN);
						break;
					}
				}
				add(line);
				add(label);
				xCoordinate = secondXCoordinate;
				yCoordinate = secondYCoordinate;
			}
		}
	}
	
	
	
/*
 * This method is drawing the graph, it draws to horizontal line at the top and bottom
 * and vertical lines as well, also it draw years.
 */
	private void drawGraph(){
		drawTwoLines();
		drawVerticalLines();
		drawYears();
	}
	
/*
 * This method is drawing the years on the bottom of the canvas, years start with 1900.
 */
	private void drawYears(){
		divider = getWidth() / NDECADES;
		for(int i = 0; i < NDECADES; i++){
			String years = Integer.toString(START_DECADE + (i * 10));
			GLabel drawYears = new GLabel(years,(i * divider) + 5,getHeight() - 5);
			add(drawYears);
		}
	}
	
	
/*
 * This method is drawing vertical lines on the canvas.
 */
	private void drawVerticalLines(){
		divider = getWidth() / 11;
		for(int i = 0; i < NDECADES; i++){
			GLine verticalLines = new GLine((i) * divider, 0, (i) * divider,getHeight());
			add(verticalLines);
		}
	}
	
/*This method is drawing two horizontal line on the canvas, one at the top of the canvas
 * and the second one is drawn on the bottom side of the canvas.
 */
	private void drawTwoLines(){
		drawFirstLine();
		drawSecondLine();
	}
	
	private void drawFirstLine() {
		GLine firstLine = new GLine(0,GRAPH_MARGIN_SIZE,getWidth(),GRAPH_MARGIN_SIZE);
		add(firstLine);
	}
	
	private void drawSecondLine() {
		GLine secondLine = new GLine(0, getHeight() - GRAPH_MARGIN_SIZE, getWidth(),getHeight() - GRAPH_MARGIN_SIZE);
		add(secondLine);
	}

	

	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	
	
//This "divider" instance variable is responsible to divide the lines on the canvas
//in order lines not to merge with each other
	private int divider;
	private ArrayList<NameSurferEntry> graph;
	private GLine line;
}
