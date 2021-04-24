package recommendationsystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
public class Secondpage extends JFrame {
	
	
	private ArrayList<JLabel> labels; 
	private ArrayList<JPanel> panels;
	private ArrayList<JComboBox> combo;
	public ArrayList<String> st1;
	 ArrayList<movie> toshow;
	 ArrayList<String> torecommend;
	CsvReaderWriter csv= new CsvReaderWriter();
	int [] arr = new int[10];
	public Secondpage() {
		toshow = new ArrayList<movie>();
		torecommend = new ArrayList<String>();
		labels = new ArrayList<JLabel>();
		panels = new ArrayList<JPanel>();
		combo = new ArrayList<JComboBox>();
		//toshow = mainscreen.geners;
		setSize(1200,1200);
		getContentPane().setBackground(Color.lightGray);
		getContentPane().setLayout(null);
		JLabel labe = new JLabel("Rate the movies");
		labe.setBounds(400,10,217,100);
		labe.setFont(new Font("Ariel", Font.PLAIN, 20));
		//labe.setSize(100,100);
		 csv.ReadfiletoHashmapMovies("files//ratedmoviesfull.csv");
  	     csv.ReadFiletoHashmapUser("files//ratings.csv");
		//mainscreen mn = new  mainscreen();
		toshow = csv.tenmoviestoshow(mainscreen.geners);
		getContentPane().add(labe);
	//la.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\ratethemoviestext.png"));
		//la.setBounds(400,20, 300, 1680);
		//getContentPane().add(la);
		//getContentPane().setBounds(400,400,900,1920);
		int num=21;
		int x=100,y=80,width=300,height=30,z = 800;
		for(int i=0;i<10;i++)
		{  // add the labels & the combobox
			labels.add(label_setup("Ariel",x,y,width,height));
			combo.add(combo_setup(z,y,width,height));
			y+=70;
		}
		for(int f =0;f<labels.size();f++) // show to movie the names
		{//System.out.println(f);
			//System.out.println(toshow.get(f));
			labels.get(f).setText(toshow.get(f).getName());
		}
		JButton btn = new JButton("Next");
		btn.setBounds(417,873,115,43);
		getContentPane().add(btn);
		/*for(int j=0;j<combo.size();j++)
		{
			arr[j]=Integer.parseInt((String)combo.get(j).getSelectedItem());
		}*/
		btn.addActionListener(new ActionListener(){  
	           public void actionPerformed(ActionEvent e){
	        	   for(int j=0;j<combo.size();j++)
	       		{
	       			arr[j]=Integer.parseInt((String)combo.get(j).getSelectedItem());
	       			//System.out.println(arr[j]);
	       			
	       		}
	        	  
	        	   csv.addtomoviestohashmap(arr,toshow);
	        	   torecommend = csv.algorithem("files//ratings.csv", "files//ratedmoviesfull.csv", csv.userr1);	   
	        	   JOptionPane.showMessageDialog(null, "The recommendeds movies are\n"+torecommend.get(0)
	        	   +"\n"+torecommend.get(1)+"\n"+torecommend.get(2)+"\n"+torecommend.get(3)+"\n"+torecommend.get(4));
	        	   dispose();
	        	   for(int i=0;i<torecommend.size();i++)
	               {
	            	   System.out.println(torecommend.get(i));
	               }
	           }  
	   });
	}
	
	 private  JLabel label_setup(String font, int x, int y, int width, int height) {
	        // function gets label's settings
	        // function creates the label with the given settings and returns it
	        JLabel lbl = new JLabel("Movie Name");
	        lbl.setFont(new Font(font, Font.PLAIN, 15));
			lbl.setForeground(SystemColor.BLACK);
	        lbl.setBounds(x, y, width, height);
	        getContentPane().add(lbl);
	        return lbl;
	    }
	 private  JComboBox combo_setup(int x, int y, int width, int height) {
	        // function gets label's settings
	        // function creates the label with the given settings and returns it
		    String [] messageStrings = {"1","2","3","4","5","6","7","8","9","10"};
			JComboBox cmbox = new JComboBox(messageStrings);
			cmbox.setVisible(true);
			cmbox.setBounds(x, y, width, height);
	        getContentPane().add(cmbox);
	        return cmbox;
	    }
	
}
