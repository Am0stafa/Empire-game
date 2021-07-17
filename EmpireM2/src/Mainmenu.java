
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.City;
import engine.Game;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;


public class Mainmenu extends JFrame implements ActionListener {
	private	 gameMenu a ;
	private	 JLabel label;
	private JLabel label2;

	private JTextField text1;
	private JTextField text2;
	private JLabel img;
	private JLabel img1;
	private JLabel img2;
	private JLabel img3;
	private JFrame playername;
	private JFrame chosecity;
	private JFrame chosearmyframe;
	private JButton nextbutton1,nextbutton2;
	
	private JButton startbutton ;
	private Mainmenu Father;

	private ButtonGroup checkBoxGroup;
	   private JCheckBox jcb1, jcb2, jcb3,jcb4, jcb5, jcb6;
	    private JLabel chosearmy;
	   private String cityName;
	   private  String playerName;
	   private  String armychosen;


	   
	   private Game gg;
	

	

	

	public Mainmenu() {
		
		
		

	
		
		
		
		//------3rd frame-------//
		
		
		
		
		chosearmyframe = new JFrame();
	     
		chosearmyframe.setTitle("Clash of Emprire");
		chosearmyframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
			chosearmyframe.setLayout(null);
			chosearmyframe.setSize(1050,700);
			chosearmyframe.setResizable(false);
			
		startbutton = new JButton();
		startbutton.setText("Start Game");
		startbutton.setBounds(400,600,150,30);
		chosearmyframe.getContentPane().add(startbutton);
		startbutton.addActionListener(this);
		
	    
	      chosearmy = new JLabel();
	      chosearmy.setText("Chose an army");
	      chosearmy.setBounds(15,15,150,30);
	      chosearmyframe.getContentPane().add(chosearmy);
	          jcb4 = new JCheckBox("Archer", true);
		      jcb5 = new JCheckBox("Cavalry", false);
		      jcb6 = new JCheckBox("Infantry", false);
		      checkBoxGroup = new ButtonGroup();
		      //add CheckBoxes to ButtonGroup
		      checkBoxGroup.add(jcb4);
		      checkBoxGroup.add(jcb5);
		      checkBoxGroup.add(jcb6);
	
		      chosearmyframe.getContentPane().add(jcb4);
		      chosearmyframe.getContentPane().add(jcb5);
		      chosearmyframe.getContentPane().add(jcb6);
		      jcb4.setBounds(100,0, 100,100);
		      jcb5.setBounds(400,0, 100,100);
		      jcb6.setBounds(700,0, 100,100);
		      chosearmyframe.setVisible(false);
		      
		     
		      //-----first frame--------//
		      playername = new JFrame();
		      img = new JLabel(new ImageIcon("voguish-world-map-blue.jpg"));
		      img.setLayout(null);
		      img.setBounds(540,0,400,400);
		      playername.getContentPane().add(img);

		      label = new JLabel();
			 label.setText("Player Name");
			
				label.setBounds(15,15,150,30);
				playername.getContentPane().add(label);
				playername.setTitle("Clash of Emprire");
				playername.setDefaultCloseOperation(EXIT_ON_CLOSE);
				playername.setLayout(null);
				playername.setSize(1050,700);
				playername.setResizable(false);
				nextbutton1 = new JButton();
				nextbutton1.setText("next");
				nextbutton1.setBounds(400,600,150,30);
				playername.getContentPane().add(nextbutton1);
				nextbutton1.addActionListener(this);
				text1 = new JTextField();
				text1.setBounds(110,15,150,30);
				text1.setFont(new Font("consola",Font.ITALIC,15));
				playername.getContentPane().add(text1);
	    
				playername.setVisible(true);


		//-----second frame-------/
				
				chosecity =new JFrame();
				chosecity.setTitle("Clash of Emprire");
				chosecity.setDefaultCloseOperation(EXIT_ON_CLOSE);
				chosecity.setLayout(null);
				chosecity.setSize(1050,700);
				chosecity.setResizable(false);
				
				  img1 = new JLabel(new ImageIcon("250x250_uploads2015082655dd6ca023db1.jpg"));
			      img1.setLayout(null);
			      img1.setBounds(25,100, 300,300);
			      chosecity.getContentPane().add(img1);
			      
			      img2 = new JLabel(new ImageIcon("rome.jpg"));
			      img2.setLayout(null);
			      img2.setBounds(330,100, 300,300);
			      chosecity.getContentPane().add(img2);
			      
			      img3 = new JLabel(new ImageIcon("090119-16-History-Ancient-Sparta-Greek-Greece-250x250.jpeg"));
			      img3.setLayout(null);
			      img3.setBounds(635,100, 300,300);
			      chosecity.getContentPane().add(img3);
				
				
				  jcb1 = new JCheckBox("Cairo", true);
			      jcb2 = new JCheckBox("Rome", false);
			      jcb3 = new JCheckBox("Sparta", false);
			      checkBoxGroup = new ButtonGroup();
			      //add CheckBoxes to ButtonGroup
			      checkBoxGroup.add(jcb1);
			      checkBoxGroup.add(jcb2);
			      checkBoxGroup.add(jcb3);
			      
			      chosecity.getContentPane().add(jcb1);
			      chosecity.getContentPane().add(jcb2);
			      chosecity.getContentPane().add(jcb3);
			      jcb1.setBounds(100,0, 100,100);
			      jcb2.setBounds(400,0, 100,100);
			      jcb3.setBounds(700,0, 100,100);
			      nextbutton2 = new JButton();
					nextbutton2.setText("next");
					nextbutton2.setBounds(400,600,150,30);
					chosecity.getContentPane().add(nextbutton2);
					nextbutton2.addActionListener(this);
					
					
				
		
					chosecity.setVisible(false);
	

         // this.setVisible(true);
  		
}
	
	public static void main(String [] args)  {
		Mainmenu game = new Mainmenu();
	
		
	}
	


	    

	    


    
    

    
		
		

	
	
	
		
		
	

	@Override
	public void actionPerformed(ActionEvent Action) {
		if(Action.getSource()== startbutton) {
			
				
			
			
				
				 playerName = text1.getText().toLowerCase();
				
				 
				 
				
				if(jcb1.isSelected()) {
					 cityName = jcb1.getText().toLowerCase();
				}
				else if(jcb2.isSelected()) {
					
					cityName = jcb2.getText().toLowerCase();
				}
				else if(jcb3.isSelected()){
					
					cityName = jcb3.getText().toLowerCase();
				}
				
				
				
				
				
				if(jcb4.isSelected()) {
					armychosen = jcb4.getText().toLowerCase();
				}
				else if(jcb5.isSelected()) {
					
					armychosen = jcb5.getText().toLowerCase();
				}
				else if(jcb6.isSelected()){
					
					armychosen = jcb6.getText().toLowerCase();
				}
				
			
		        
				
					
					try {
						a = new gameMenu(playerName,cityName,armychosen);
						a.refreshGenInfo();
					
					
				} catch (IOException e) {
					
					e.printStackTrace();
				} catch (BuildingInCoolDownException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MaxRecruitedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotEnoughGoldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
					chosearmyframe.setVisible(false);
			//this.dispose();
	        a.setVisible(true);
				
			
			
				
				
				
			}
		
		else if(Action.getSource()== nextbutton1) {
              if(text1.getText().equalsIgnoreCase("")) {
				
				JOptionPane.showMessageDialog(this, "No Name Entered", "Error", JOptionPane.ERROR_MESSAGE);
				
				
				}
              else {
            	  playername.setVisible(false);
            	  chosecity.setVisible(true);
              }
		}
		else if(Action.getSource()== nextbutton2) {
			chosecity.setVisible(false);
			chosearmyframe.setVisible(true);
			
		}
		
		
	}
	 
	

	
	
}
