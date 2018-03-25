import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI1B implements ActionListener
{
    JButton button;
    Boolean pressed = false;


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

        SimpleGUI1B gui = new SimpleGUI1B();
        gui.go();
    }

    private void go()
    {
        JFrame myFrame = new JFrame();

        button = new JButton("Только не жмякай на меня!");

        button.setFont(new Font("Arial", Font.PLAIN, 18));

        button.addActionListener(this);

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.getContentPane().add(button);

        myFrame.setSize(300, 300);

        myFrame.setLocationRelativeTo(null);

        myFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (!pressed)
        {
            button.setText("Ну я же просил!");
            pressed = true;
        } else
        {
            button.setText("Ты что такой непонятливый!");
            pressed = false;
        }


    }
}
