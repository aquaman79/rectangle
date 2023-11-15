package rectangle1;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;

public class PlaceChild2 {
	public static void main(String[] args) {
		NiSpace space = new NiSpace("A white rectangle with a blue child on right", new Dimension(1000, 400));
		
		NiRectangle whiteRectangle = new NiRectangle();
		whiteRectangle.setBackground(Color.white);
		whiteRectangle.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		whiteRectangle.setSize(new Dimension(900,300));
		whiteRectangle.setLocation(50, 50);

		NiRectangle blueChild = new NiRectangle();
		blueChild.setBackground(Color.blue);
		blueChild.setSize(new Dimension(whiteRectangle.getWidth()/2, whiteRectangle.getHeight()));
		whiteRectangle.add(blueChild);
		
		
		space.add(whiteRectangle);
		
		space.openInWindow();
	}	
}
