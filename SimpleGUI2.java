import javax.swing.*;
import java.awt.*;

public class SimpleGUI2
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

        MyDrawPanel myPanel = new MyDrawPanel();

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.getContentPane().add(myPanel);

        myFrame.setSize(644, 446); // Image is 640 x 442

        myFrame.setLocationRelativeTo(null);

        myFrame.setVisible(true);
    }
}

class MyDrawPanel extends JPanel
{
    public void paintComponent (Graphics g)
    {
        g.setColor(Color.orange);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        Image image = new ImageIcon("images/640px-Cat_March_2010-1.jpg").getImage();
        g.drawImage(image, 2, 2,
                this.getWidth()-4, this.getHeight()-4,this);
    }
}