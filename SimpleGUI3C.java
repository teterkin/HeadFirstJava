import com.sun.prism.paint.Gradient;

import javax.swing.*;
import java.awt.*;

public class SimpleGUI3C
{
    public static void main(String[] args)
    {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        JFrame myFrame = new JFrame();

        My3CDrawPanel myPanel = new My3CDrawPanel();

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.getContentPane().add(myPanel);

        myFrame.setSize(400, 400); // Image is 640 x 442

        myFrame.setLocationRelativeTo(null);

        myFrame.setVisible(true);
    }
}

class My3CDrawPanel extends JPanel
{
    public void paintComponent (Graphics g)
    {
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color startColor = new Color(red,green,blue);

        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        Color endColor = new Color(red,green,blue);

        GradientPaint gradient =
                new GradientPaint(70,70,startColor,
                        (int)this.getWidth()/2.25f,(int) this.getHeight()/2.25f,
                        endColor);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(gradient);
        g2d.fillOval(70,70,
                (int)this.getWidth()/2, (int) this.getHeight()/2);

    }
}