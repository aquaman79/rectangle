package rectangle1.strategie.implementation;

import rectangle1.NiRectangle;

import java.awt.*;

public class EmplacementHorizentalHaut implements EmplacementStrategie  {
    public EmplacementHorizentalHaut() {
    }
    public void changeEmplacement(NiRectangle niRectangle) {
        niRectangle.setSize(new Dimension(900,100));
        niRectangle.setLocation(0,200);
    }


}
