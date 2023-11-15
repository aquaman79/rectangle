package rectangle1.strategie.implementation;

import rectangle1.NiRectangle;

import java.awt.*;

public class EmplacementVerticalSource implements EmplacementStrategie {

    public EmplacementVerticalSource() {
    }

    public void changeEmplacement(NiRectangle niRectangle) {
        niRectangle.setSize(new Dimension(100, 300));
        niRectangle.setLocation(0,0);
    }


}
