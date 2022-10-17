/*
 *Create the unit test shown in class that checks if squares are in the position you created 
 * 
 * */


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Point;

import org.junit.jupiter.api.Test;


public class TetrisTestExample {

	//create and complete my first unit test as shown in class 
	@Test
	void testCheckRows() {
		//create a grid 
		//fill all of the squares except for row 5 and 15 
		Grid g = new Grid();
		//loop through the rows of the grid
		for(int row = 0; row < Grid.HEIGHT; row++) {
			//loop through the columns of the grid
			for(int col = 0; col < Grid.WIDTH; col++) {
				//create a conditional statement for parts of row 5 and 15 not to be used 
				if(row != 5 && row != 15 || col == 4 || col == 5) {
					
					//set the row and column 
					g.set(row, col, Color.BLUE);
				}
				
			}
		}
		g.checkRows();
		
		
		//check if you have 4 squares at the bottom of the grid 
		for(int row = 0; row < Grid.HEIGHT; row++) {
			//loop through the columns of the grid
			for(int col = 0; col < Grid.WIDTH; col++) {
				
				if((row == Grid.HEIGHT - 1 || row == Grid.HEIGHT - 2) && (col == 4 || col == 5)) {
					assertTrue(g.isSet(row, col));
				} else {
					assertFalse(g.isSet(row, col));
				}
				
			}
		}
		
	}
	
	//create a unit test for the movement of LShape to the right
	@Test
	void testMovement() {
		
		Grid grid = new Grid();
		LShape piece = new LShape(1, Grid.WIDTH / 2 - 1, grid);
		System.out.println();
		//Move the LShape once to the left 
		piece.move(Direction.LEFT);
		//create the assertion statements for the test 
		//All four LShape squares should shift one unit to left
		
		//getLocations() returns an array of points - I'll use the first point in the array to test
		//the movement to the left
		Point[] points;
		if( !piece.getLocations()[0].equals(new Point(0, 4))) {
			assertTrue(piece.getLocations()[0].equals(new Point(0, 3))); 
		} 
		
		
		
	}
}
