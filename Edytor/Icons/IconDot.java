package Edytor.Icons;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;


public class IconDot implements Icon {
	
	  private Color color;
	 
	  public IconDot(Color c) {
		    color = c;  }


	  public void paintIcon(Component c, Graphics g, int x, int y) {
		    g.setColor(color);
		    g.fillOval(5, 5, 10, 10);

		    }

	@Override
	public int getIconWidth() {
		return 10;
	}

	@Override
	public int getIconHeight() {
		return 10;
	}
	

}
