import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import java.util.*;


/**
 * This class will display the trucks and warehouses on a map using JFrame.
 * 
 * @author Kizuki Koyasu 
 * @version Ver.1
 */
// HistogramComponent extends the functionality of a JComponent
// in order to draw a histogram.
public class DynamicMap extends JComponent {
    ArrayList<Render> items;
    public DynamicMap() {
        items = new ArrayList<Render>();
    }

    public void add(Render item) {
        items.add(item);
    }
    // Paints a histogram with three bins
    @Override
    public void paintComponent(Graphics g) {
        for(Render i : items) {
            i.draw(g);
        }
    } 
}