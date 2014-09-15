package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FloodFill extends JPanel implements MouseListener{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("A simple graphics program");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new FloodFill(50,50);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
	}
	public FloodFill(int rows, int cols) {
		grid = new int[rows][cols];
		this.rows = rows;
		this.cols = cols;
		this.Randomize();
		addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent e) { 
	        	  	int i = e.getX()/10;
	      			int j = e.getY()/10;
	      			SeedFill(i,j);
	      			repaint();
	          } 
	        }); 
	}
	public void paintComponent(Graphics g) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					g.fillRect(i * 10, j * 10, 10, 10);
				} else {
					g.drawRect(i * 10, j * 10, 10, 10);
				}
			}
		}
	}

	public void SeedFill(int i, int j) {
		
	}

	public void Randomize(){
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++)
			{
				Random r = new Random();
				grid[i][j] = r.nextInt(2);
			}
		}
	}

	private int[][] grid;
	private int rows;
	private int cols;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int i = e.getX()/10;
		int j = e.getY()/10;
		System.out.println(i+"    "+j);
		grid[i][j] = 1;
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
