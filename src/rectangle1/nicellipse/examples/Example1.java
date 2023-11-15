package rectangle1.nicellipse.examples;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import rectangle1.NiEllipse;
import rectangle1.NiImage;
import rectangle1.NiSpace;

public class Example1 {
	public static void main(String[] args) throws IOException {
		NiSpace space = new NiSpace("Space with circles", new Dimension(400, 400));
				
		NiEllipse circle = new NiEllipse();
		circle.setBounds(0, 0, 300, 300);
		space.add(circle);
		
		NiEllipse inner = new NiEllipse();
		inner.setSize(100, 100);
		inner.setCenter(circle.getCenter());
		inner.setBackground(Color.yellow);
		circle.add(inner);
		
		NiImage image = new NiImage(new File("I_love_Brest_city.jpg"));
		image.setCenter(circle.getCenter());
		circle.add(image);
		
		
		space.setBackground(Color.blue);
		space.setOpaque(false);
		space.openInWindow();
		
		circle.setCenter(space.getCenter());
	}

}
