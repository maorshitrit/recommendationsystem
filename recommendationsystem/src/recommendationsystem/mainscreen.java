package recommendationsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class mainscreen extends JFrame {

 private JLabel label,background,genersname;
  private JCheckBox comedy,action,drama,horror,romance,adventure,crime,documentary;
  private ArrayList<JComboBox> combo;
  
  private static final int DEFAULT_WIDTH = 300;
  private static final int DEFAULT_HEIGHT = 200;
  private static final int FONTSIZE = 24;
  int pricecount=0;
  int count = 0;
  int count2=0;
  int x =0;
  int price;
  private JPanel buttonPanel,textpanel;
  private ButtonGroup group;
  private ArrayList<String> movies;
  private static final int DEFAULT_SIZE = 36;
  private static CsvReaderWriter c = new CsvReaderWriter();
  private ArrayList<String> movienames;
  public static ArrayList<String> geners = new ArrayList<String>();
public mainscreen()
  {    		
	combo = new ArrayList<JComboBox>();
	 movies = new ArrayList<String>();
	 movienames = new ArrayList<String>();
	 String arr[] = new  String [5];
	 int ar2r[] = new  int [5];
  movie m;
  label = new JLabel("Select your favorite movies");
  label.setFont(new Font("Ariel", Font.PLAIN, 20));
  getContentPane().add(label);
     ActionListener listener = new ActionListener()
        {
           public void actionPerformed(ActionEvent event)
           {
             
              if (event.getSource() == comedy)  
              if(comedy.isSelected())
              {
              count++;
              geners.add("Comedy");
              }
              else
              {
              count --;
              geners.remove("Comedy");
              }
              else if (event.getSource() == action)  
              if(action.isSelected())
              {
              count++;
              geners.add("Action");
              }
              else
              {
              count --;
              geners.remove("Action");
              }
              else  if (event.getSource() == drama)  
              if(drama.isSelected())
              {
              count++;
              geners.add("Drama");
              }
              else
              {
              count --;
              geners.remove("Drama");
              }
              else  if (event.getSource() == horror)  
              if(horror.isSelected())
              {
              count++;
              geners.add("Horror");
              }
              else
              {
              count --;
              geners.remove("Horror");
              }
              else  if (event.getSource() == romance)  
                  if(romance.isSelected())
                  {
                  count++;
                  geners.add("Romance");
                  }
                  else
                  {
                  count --;
                  geners.remove("Romance");
                  }
              else  if (event.getSource() == adventure)  
              if(adventure.isSelected())
              {
              count++;
              geners.add("Adventure");
              }
              else {
              count --;
              geners.remove("Adventure");
              }
              else  if (event.getSource() == crime)  
                  if(crime.isSelected())
                  {
                  count++;
                  geners.add("Crime");
                  }
                  else {
                  count --;
                  geners.remove("Crime");
                  }
              else  if (event.getSource() == documentary)  
                  if(documentary.isSelected())
                  {
                  count++;
                  geners.add("Documentary");
                  }
                  else
                  {
                  count --;
                  geners.remove("Documentary");
                  }
           }
        };
       
        buttonPanel = new JPanel();
        group = new ButtonGroup();
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        pack();
        movies = c.Checkifthemovieexist1("files//ratedmoviesfull.csv");

     // add the check boxes
        JPanel buttonPanel = new JPanel();
        JPanel test = new JPanel();
        for(int i=0;i<5;i++)
		{  // add the labels & the combobox
			combo.add(combo_setup(x,70,400,400,movies));
			x+=70;
		}
  
        	
        JLabel genersnam = new JLabel("Select geners");   
     comedy = new JCheckBox("Comedy");
     comedy.addActionListener(listener);
     buttonPanel.add(comedy);
     
     action = new JCheckBox("Action");
     action.addActionListener(listener);
     buttonPanel.add(action);
     
     drama = new JCheckBox("Drama");
     drama.addActionListener(listener);
     buttonPanel.add(drama);
     
     horror = new JCheckBox("Horror");
     horror.addActionListener(listener);
     buttonPanel.add(horror);
     
     romance = new JCheckBox("Romance");
     romance.addActionListener(listener);
     buttonPanel.add(romance);
     
     adventure = new JCheckBox("adventure");
     adventure.addActionListener(listener);
     buttonPanel.add(adventure);
     crime = new JCheckBox("crime");
     crime.addActionListener(listener);
     buttonPanel.add(crime);
     documentary = new JCheckBox("documentary");
     documentary.addActionListener(listener);
     buttonPanel.add(documentary);
     
     getContentPane().add(test,BorderLayout.CENTER);
     test.add(genersnam);
     genersnam.setFont(new Font("Ariel", Font.BOLD, 20));
         
     

     getContentPane().add(buttonPanel, BorderLayout.CENTER);
     pack();
     
     
     
     setSize(380, 106);

     JButton b = new JButton("Continue");
     
     textpanel = new JPanel();
     textpanel.add(b);
     
     // add panel to frame

     getContentPane().add(buttonPanel);
     getContentPane().add(textpanel);
     buttonPanel.setPreferredSize(new Dimension(350,80));
     buttonPanel.setBackground(Color.LIGHT_GRAY);
     
     JLabel lbl = new JLabel("");       
     lbl.setIcon(new ImageIcon("pic\\backgroundjava.png"));       
     lbl.setHorizontalTextPosition(SwingConstants.CENTER);       
     lbl.setHorizontalAlignment(SwingConstants.CENTER);        
     lbl.setBounds(0, 0, 994, 549);        
     this.getContentPane().add(lbl);
     int id1,id2,id3,id4,id5;

     
     
 
     b.addActionListener(new ActionListener(){  
           public void actionPerformed(ActionEvent e){
        	   if(count!=0)
        	   {  for(int j=0;j<combo.size();j++)
	       		{
	       			arr[j]=((String)combo.get(j).getSelectedItem().toString());
	       			ar2r[j] = c.Checkifthemovieexist("files//ratedmoviesfull.csv",arr[j]);
	       			System.out.println(arr[j]);
	       			System.out.println(ar2r[j]);
	       		}
        		  c.AddUser(geners,ar2r[0],ar2r[1],ar2r[2],ar2r[3],ar2r[4]);
        		   Secondpage sec = new Secondpage();
        		   sec.setVisible(true);
        		   dispose();
        	   }
        	   else
             	   JOptionPane.showMessageDialog(null, "You have to fill all the fields");

                     
       }  
   });
  }
private  JComboBox combo_setup(int x, int y, int width, int height, ArrayList<String> movies) {
    // function gets label's settings
    // function creates the label with the given settings and returns it
    String [] messageStrings = new String[movies.size()];
    Collections.sort(movies, new sortbyname());
    movies.toArray(messageStrings);
	JComboBox cmbox = new JComboBox(messageStrings);
	cmbox.setVisible(true);
	cmbox.setBounds(x, y, width, height);
    getContentPane().add(cmbox);
    return cmbox;
}

 
}