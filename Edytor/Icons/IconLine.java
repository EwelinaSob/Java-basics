package Edytor.Icons;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;


public class IconLine implements Icon {

	private Color color;

	public IconLine(Color c) {
		color = c;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.drawLine(5, 6, 100, 6);
	}

	@Override
	public int getIconWidth() {
		return 0;
	}

	@Override
	public int getIconHeight() {
		return 0;
	}

}
