package Utils;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LoadImage {
    
    public void loadImage(String imageString, JLabel lblImage) {
        try {
            
            URL url = new URL(imageString);
            Image image = ImageIO.read(url).getScaledInstance(lblImage.getHeight(), lblImage.getWidth(), Image.SCALE_SMOOTH);
            lblImage.setIcon(new ImageIcon(image));
        } 
        catch (IOException ex) {
            lblImage.setText("Not found");
        }
    }
}
