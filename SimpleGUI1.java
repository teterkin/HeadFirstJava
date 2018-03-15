import javax.swing.*;

public class SimpleGUI1
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

        JButton myButton = new JButton("Click me!");

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.getContentPane().add(myButton);

        myFrame.setSize(300, 300);

        myFrame.setVisible(true);
    }
}
