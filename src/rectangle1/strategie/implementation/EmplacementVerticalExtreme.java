package rectangle1.strategie.implementation;

import rectangle1.NiRectangle;

import java.awt.*;

public class EmplacementVerticalExtreme implements EmplacementStrategie {
    public EmplacementVerticalExtreme() {
    }

    public void changeEmplacement(NiRectangle niRectangle) {
        niRectangle.setSize(new Dimension(100, 300));
        niRectangle.setLocation(800, 0);
    }

}
