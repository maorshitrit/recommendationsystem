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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class mainscreen extends JFrame {

private JLabel label,background;
  private JCheckBox comedy,action,drama,horror,romance,adventure,crime,documentary;
  private TextField name, age, mail,movie1,movie2,movie3,movie4,movie5;
  private static final int DEFAULT_WIDTH = 300;
  private static final int DEFAULT_HEIGHT = 200;
  private static final int FONTSIZE = 24;
  int pricecount=0;
  int count = 0;
  int count2=0;
  int price;
  private JPanel buttonPanel,textpanel;
  private ButtonGroup group;
  private static final int DEFAULT_SIZE = 36;
  private static CsvReaderWriter c = new CsvReaderWriter();
  public static ArrayList<String> geners = new ArrayList<String>();
public mainscreen()
  {    
  movie m;
 /* background = new JLabel();
 ImageIcon imageIcon = new ImageIcon("pic//backgroundjava.png");
 Image image = imageIcon.getImage();
  image = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
  imageIcon = new ImageIcon(image);
  background.setIcon(imageIcon);*/
  Font font = new Font("", Font.BOLD, 15);
      //name = new TextField("Enter your name", 15);
    //  name.setFont(font);
    //  age = new TextField("Enter your age", 15);
     // age.setFont(font);
   // mail = new TextField("Enter your mail", 15);
    //  mail.setFont(font);
    //  getContentPane().add(name);
    //  getContentPane().add(age);
  //    getContentPane().add(mail);
   // c.ReadfiletoHashmapMovies("files//ratedmoviesfull.csv");
    //c.ReadFiletoHashmapUser("files//ratings.csv");
   //c.algorithem("files//ratings.csv","files//ratedmoviesfull.csv");
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
       

     // add the check boxes

     JPanel buttonPanel = new JPanel();
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
     
     movie1 = new TextField("enter a movie", 15);
     movie1.setFont(font);
     movie2 = new TextField("enter a movie", 15);
     movie2.setFont(font);
     movie3 = new TextField("enter a movie", 15);
     movie3.setFont(font);

     movie4 = new TextField("enter a movie", 15);
     movie4.setFont(font);
     movie5 = new TextField("enter a movie", 15);
     movie5.setFont(font);
     
     getContentPane().add(movie1,BorderLayout.CENTER);
     getContentPane().add(movie2,BorderLayout.CENTER);
     getContentPane().add(movie3,BorderLayout.CENTER);
     getContentPane().add(movie4,BorderLayout.CENTER);
     getContentPane().add(movie5,BorderLayout.CENTER);
         
     

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

     
     
 
     b.addActionListener(new ActionListener(){  
           public void actionPerformed(ActionEvent e){
        	   if(CheckIfok()==1)
        	   {
        		  // c.tenmoviestoshow(geners);
        		   Secondpage sec = new Secondpage();
        		  // sec.getusergeners(geners);
        		   sec.setVisible(true);
        		   dispose();
        	   }
        	   else
        		   if(CheckIfok()==2)
        	   {
        			   JOptionPane.showMessageDialog(null, "the movie is not exist");
        	   }
        		   else
        		   {
        			   JOptionPane.showMessageDialog(null, "You have to fill all the fields");
        		   }

        	   
         
          pricecount=0;
               
           
       }  
   });
  }
  public int CheckIfok()
  {
	  int id1,id2,id3,id4,id5;
	  CsvReaderWriter csv = null; 
	  if(movie1.getText().equals("enter a movie") ||movie2.getText().equals("enter a movie") ||movie3.getText().equals("enter a movie") ||movie4.getText().equals("enter a movie") ||movie5.getText().equals("enter a movie")||count ==0 )
		  return 0;  // בודק האם הכל נכתב בוצרה תקינה
	  else
		 if((id1 = csv.Checkifthemovieexist("files//ratedmoviesfull.csv",movie1.getText()))==-1 || (id2 = csv.Checkifthemovieexist("files//ratedmoviesfull.csv",movie2.getText()))==-1 || (id3 = csv.Checkifthemovieexist("files//ratedmoviesfull.csv",movie3.getText()))==-1 || (id4 = csv.Checkifthemovieexist("files//ratedmoviesfull.csv",movie4.getText()))==-1 || (id5 = csv.Checkifthemovieexist("files//ratedmoviesfull.csv",movie5.getText()))==-1)
		 {
			return 2;  // בודק האם הסרט קיים במאגר הסרטים
		 }
        	 c.AddUser(geners,id1,id2,id3,id4,id5); // מוסיף את המשתמש
	  return 1;

	  
  }
  
 
 
 
}