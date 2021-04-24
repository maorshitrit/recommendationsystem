package recommendationsystem;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class main {

public static void main(String[] args) throws Exception {

// TODO Auto-generated method stub
    EventQueue.invokeLater(new Runnable()
        {
           public void run()
           {
              JFrame frame = new mainscreen();
              frame.setTitle("Movierateings");
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.getContentPane().setLayout(new FlowLayout());
              frame.pack();
              frame.setVisible(true);
              frame.setResizable(false);
              frame.setBounds(300,0,980,815);
              frame.setSize(980,815);
           }
        });
        


}

}
