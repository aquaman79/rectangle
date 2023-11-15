package rectangle1;

import rectangle1.strategie.EmplacementImpl;
import rectangle1.strategie.implementation.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PlaceChild1 {

	public static void main(String[] args) throws InterruptedException {

		NiSpace space = new NiSpace("A white rectangle with a blue child", new Dimension(1000, 400));

		NiRectangle whiteRectangle = new NiRectangle();
		whiteRectangle.setBackground(Color.blue);
		whiteRectangle.setBorder(BorderFactory.createLineBorder(Color.black, 2));
		whiteRectangle.setSize(new Dimension(900, 300));
		whiteRectangle.setLocation(50, 50);

		NiRectangle blueChild = new NiRectangle();
		blueChild.setBackground(Color.red);
		 EmplacementStrategie emplacementStrategie = new EmplacementVerticalSource();
		emplacementStrategie.changeEmplacement(blueChild);



		EmplacementImpl emplacement = new EmplacementImpl();
		//emplacement.changeEmplacement(100,300,0,0,blueChild);


		whiteRectangle.add(blueChild);
		space.add(whiteRectangle);
		space.openInWindow();


		Timer timer = new Timer(1000, new ActionListener() {
			int count = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				EmplacementStrategie emplacementStrategie = new EmplacementHorizentalHaut();
				if (count % 4 == 0) {

						emplacementStrategie = new EmplacementHorizentalHaut();
						emplacementStrategie.changeEmplacement(blueChild);


				} else if (count % 4 == 1) {
						emplacementStrategie = new EmplacementVerticalExtreme();
						emplacementStrategie.changeEmplacement(blueChild);

				} else if (count % 4 == 2) {
						emplacementStrategie = new EmplacementHorizentalBas();
						emplacementStrategie.changeEmplacement(blueChild);

				} else {
						emplacementStrategie = new EmplacementVerticalSource();
						emplacementStrategie.changeEmplacement(blueChild);
				}
				count++;
			}
		});

		timer.start();

	}
}