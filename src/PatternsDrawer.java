// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2024T1, Assignment 4
 * Name:
 * Username:
 * ID:
 */

 import ecs100.*;
 import java.awt.Color;
 
 /** PatternsDrawer: draws various repetitive patterns. */
 
 public class PatternsDrawer{
 
     public static final double PATTERN_LEFT = 50.0;   // Left side of the pattern
     public static final double PATTERN_TOP = 50.0;    // Top of the pattern
     public static final double PATTERN_SIZE = 300.0;  // The size of the pattern on the window
 
     /** Draw a checkered board with alternating black and white squares
      *    Asks the user for the number of squares on each side
      */
     public void drawDraughtsBoard(){
         UI.clearGraphics();
         UI.setColor(Color.black);
         int num = UI.askInt("How many rows:");
         /*# YOUR CODE HERE */

        for(int current_row = 0; current_row <= num-1; current_row+=1){
            for(int current_col = 0; current_col<= num-1; current_col +=1){
                int rect_width = (int)PATTERN_SIZE / num;
                if(current_row % 2 == 1){
                    if(current_col %2 == 1){
                        UI.setColor(Color.white);
                    }else{
                        UI.setColor(Color.black);
                    }
                }else{
                    if(current_col %2 == 1){
                        UI.setColor(Color.black);
                    }else{
                        UI.setColor(Color.white);
                    }
                }
                UI.fillRect(PATTERN_LEFT + rect_width*current_col, PATTERN_TOP + rect_width*current_row, rect_width, rect_width);
            }
        }
 
     }
 
     /** TriGrid
      * a triangular grid of squares that makes dark circles appear 
      * in the intersections when you look at it.
      */
     public void drawTriGrid(){
         UI.clearGraphics();
         UI.setColor(Color.black);
         int num = UI.askInt("How many rows:");
         /*# YOUR CODE HERE */

         int gap = 1;
         int num_of_squares = num;
         int square_width = (int)((PATTERN_SIZE - gap*(num-1))/num);

         for(int current_row = 0; current_row <= num-1; current_row+=1){
            for(int current_col = 0; current_col<= num_of_squares-1; current_col +=1){
                UI.fillRect(PATTERN_LEFT + (square_width+gap)*current_col, PATTERN_TOP + (square_width+gap)*current_row , square_width, square_width);
            }
            num_of_squares -= 1;
        }
 
     }
 
 
     /**   CHALLENGE
      * DO NOT DO THIS IF YOU HAVE NOT DONE THE PREVIOUS METHODS
      * Draw a board made of hexagonals
      *  Asks the user for the number of hexagonals on each side
      */

     //helper function for hexagonal board drawing
     public void drawhex(int x, int y,double edgeLength,boolean extra){
        UI.setColor(Color.black);
        //draws the center lines
        // draw the lines from the center upwards
        UI.drawLine(x, y, x, (int)y-edgeLength);
        // draw the lines from the center to bottom right
        UI.drawLine(x, y, x + Math.round(Math.cos(Math.PI/6)*edgeLength) , y+Math.round(Math.sin(Math.PI/6)*edgeLength));
        // draw the lines from the center to bottom left
        UI.drawLine(x, y, x - Math.round(Math.cos(Math.PI/6)*edgeLength) , y+Math.round(Math.sin(Math.PI/6)*edgeLength));

        //drwas the outline
        //draws the topright side
        UI.drawLine(x,y-edgeLength,x+Math.round(Math.cos(Math.PI/6)*edgeLength),y-Math.round(Math.sin(Math.PI/6)*edgeLength));
        //draws the topleft side
        UI.drawLine(x,y-edgeLength,x-Math.round(Math.cos(Math.PI/6)*edgeLength),y-Math.round(Math.sin(Math.PI/6)*edgeLength));
        //draws right side
        UI.drawLine(x+Math.round(Math.cos(Math.PI/6)*edgeLength),y-Math.round(Math.sin(Math.PI/6)*edgeLength),x+Math.round(Math.cos(Math.PI/6)*edgeLength),y+Math.round(Math.sin(Math.PI/6)*edgeLength));
        //draws left side
        UI.drawLine(x-Math.round(Math.cos(Math.PI/6)*edgeLength),y-Math.round(Math.sin(Math.PI/6)*edgeLength),x-Math.round(Math.cos(Math.PI/6)*edgeLength),y+Math.round(Math.sin(Math.PI/6)*edgeLength));
        //draws the bottomright side
        UI.drawLine(x,y+edgeLength,x+Math.round(Math.cos(Math.PI/6)*edgeLength),y+Math.round(Math.sin(Math.PI/6)*edgeLength));
        //draws the bottomleft side
        UI.drawLine(x,y+edgeLength,x-Math.round(Math.cos(Math.PI/6)*edgeLength),y+Math.round(Math.sin(Math.PI/6)*edgeLength));

        if(extra){
            //drwas extra lines
            //drws the up down line
            UI.drawLine(x, (int)y+edgeLength, x, (int)y+2*edgeLength);

            //draws right bottom side
            UI.drawLine(x+Math.round(Math.cos(Math.PI/6)*edgeLength),y-Math.round(Math.sin(Math.PI/6)*edgeLength)+edgeLength,x+Math.round(Math.cos(Math.PI/6)*edgeLength),y+Math.round(Math.sin(Math.PI/6)*edgeLength)+edgeLength);
            //draws left bottom side
            UI.drawLine(x-Math.round(Math.cos(Math.PI/6)*edgeLength),y-Math.round(Math.sin(Math.PI/6)*edgeLength)+edgeLength,x-Math.round(Math.cos(Math.PI/6)*edgeLength),y+Math.round(Math.sin(Math.PI/6)*edgeLength)+edgeLength);
            //draws the bottombottomright side
            UI.drawLine(x,y+2*edgeLength,x+Math.round(Math.cos(Math.PI/6)*edgeLength),y+edgeLength+Math.round(Math.sin(Math.PI/6)*edgeLength));
            //draws the bottombottomleft side
            UI.drawLine(x,y+2*edgeLength,x-Math.round(Math.cos(Math.PI/6)*edgeLength),y+edgeLength+Math.round(Math.sin(Math.PI/6)*edgeLength));
        }
        

     }

     public void drawHexagonalBoard(){
         /*# YOUR CODE HERE */
        UI.clearGraphics();
        UI.setColor(Color.black);

        double num_of_hexs = UI.askDouble("number of hexs along top?");

        double width_of_hex = PATTERN_SIZE / num_of_hexs;

        double edgeLength = ((1f/2f)*width_of_hex) / Math.cos(Math.PI/6);

        int fullrows = (int)(num_of_hexs/2f);
        int halfrows = (int)(num_of_hexs%2);
        
        for(int current_row=0; current_row < fullrows+halfrows; current_row+=1){
            for(int current_col=0;current_col < num_of_hexs; current_col+=1){
                if(current_row != fullrows){
                    drawhex((int)(PATTERN_LEFT+(1f/2f)*width_of_hex+current_col*width_of_hex),(int)(PATTERN_TOP+edgeLength+3*edgeLength*current_row),edgeLength,true);
                }else{
                    drawhex((int)(PATTERN_LEFT+(1f/2f)*width_of_hex+current_col*width_of_hex),(int)(PATTERN_TOP+edgeLength+3*edgeLength*current_row),edgeLength,false);
                }
            }
            
        }
     }
 
     /** Draw a Spiral board consisting of a square spiral path of small white squares.
      *  Asks the user for the number of squares along the top
      *
      * CHALLENGE
      */
      //helper function for drawing spiral
      public void drawsquare(int TOP, int LEFT, int num_of_squares,int square_width,boolean extra){
        UI.println("LEFT:"+ LEFT);
        UI.println("TOP:"+ TOP);
        UI.println("num_of_squares:"+ num_of_squares);
        UI.println("square_width:"+ square_width);
        
        UI.setColor(Color.black);

        int rows = num_of_squares;
        int cols = num_of_squares;

        //draws top and bottom of square
        for(int current_col=0;current_col < cols; current_col+=1){
            if(current_col != 1){
                UI.drawRect(LEFT,TOP + square_width*current_col, square_width, square_width);
            }
            UI.drawRect(LEFT + square_width*(rows-1),TOP + square_width*current_col, square_width, square_width);

        }

        //draws right and left of square
        for(int current_row=0; current_row < rows; current_row+=1){
            UI.drawRect(LEFT + square_width*current_row, TOP,square_width,square_width);
            UI.drawRect(LEFT + square_width*current_row,TOP + square_width*(rows-1), square_width, square_width);
        }

        if(extra){
            UI.drawRect(LEFT + square_width, TOP+square_width*2,square_width,square_width);

        }


      }
     public void drawSpiralBoard(){
         /*# YOUR CODE HERE */

        UI.clearGraphics();
        UI.setColor(Color.black);

        int num_of_squares = UI.askInt("number of square along top?");

        int square_width = (int)(PATTERN_SIZE / num_of_squares);

        int num_of_spirals = (int)(num_of_squares/4);
        UI.println("num_of_spirals:" + num_of_spirals);

        for(int spiral = 0; spiral <= num_of_spirals;spiral +=1){
            UI.println("looped");
            if(num_of_spirals != spiral){
                drawsquare((int)PATTERN_TOP+ 2*square_width*spiral,(int)PATTERN_LEFT+ 2*square_width*spiral,num_of_squares,square_width,true);

            }else{
                drawsquare((int)PATTERN_TOP+ 2*square_width*spiral,(int)PATTERN_LEFT+ 2*square_width*spiral,num_of_squares,square_width,false);

            }
            num_of_squares -= 4;
        }

        


 
     }
 
     public void setupGUI(){
         UI.initialise();
         UI.addButton("Clear",UI::clearPanes);
         UI.addButton("Draughts", this::drawDraughtsBoard);
         UI.addButton("TriGrid", this::drawTriGrid);
         UI.addButton("CHALLENGE: Hexagon", this::drawHexagonalBoard);
         UI.addButton("CHALLENGE Spiral", this::drawSpiralBoard);
         UI.addButton("Quit",UI::quit);
     }   
 
     public static void main(String[] arguments){
         PatternsDrawer pd = new PatternsDrawer();
         pd.setupGUI();
     }
 
 }
 