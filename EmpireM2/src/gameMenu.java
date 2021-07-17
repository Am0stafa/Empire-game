import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.Farm;
import buildings.Market;
import buildings.Stable;
import engine.City;
import engine.Game;
import engine.Player;
import exceptions.BuildingInCoolDownException;
import exceptions.FriendlyCityException;
import exceptions.FriendlyFireException;
import exceptions.MaxLevelException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import exceptions.TargetNotReachedException;
import units.Archer;
import units.Army;
import units.Cavalry;
import units.Infantry;
import units.Status;
import units.Unit;

public class gameMenu extends JFrame  implements ActionListener  {

	
	
	private Mainmenu mainmenu;
	JFrame nextpageafterchoosecontcitywindow = new JFrame();
	//JPanelss
	private JPanel geninfo = new JPanel();
	private JPanel ac = new JPanel();
	private JPanel ca = new JPanel();
	private JPanel cityviewbuttonpanel = new JPanel();
	private JPanel laysiegepann = new JPanel();
	private JPanel marcharm = new JPanel();
	private JPanel besiegingpan = new JPanel();
	private JPanel autoResolvepann = new JPanel();
	private JPanel buildingpanel = new JPanel();
	private JPanel recrutepann = new JPanel();
	private JPanel upgradepann = new JPanel();
	private JPanel buildpann = new JPanel();
	private JPanel infopann = new JPanel();		
	private JPanel backbuttonpann = new JPanel();	
	private JPanel backbuttonpann2 = new JPanel();		
	private JPanel donebuttonupgpan = new JPanel();	
	private JPanel backbuttonpann3 = new JPanel();	
	private JPanel donebuttonupgpan1 = new JPanel();	
	private JPanel backbuttonbuildpan = new JPanel();
	private JPanel buildbuttonpan = new JPanel();
	private JPanel attackpann = new JPanel();
	private JPanel relocatepann = new JPanel();
	private JPanel nextbuttonforattakpan = new JPanel();


	
	
	
	private JLabel nobulidins = new JLabel();
	private JLabel nobulidins2 = new JLabel();

	


	

	
	




	
	
	
	
	
	
	
	private JCheckBox jcb1;
	private JCheckBox jcb2;
	private JCheckBox jcb3,jcb10,jcb11,jcb12,jcb13,jcb20,jcb21,jcb22,jcb40,jcb41,jcb42,jcb43,jcb44,jcb60,jcb61,jcb62;
	private ButtonGroup checkBoxGroup;


	private JFrame recrutebuttonpress = new JFrame();	
	private JFrame attackbuttonpresd = new JFrame();		

	private JFrame buildbuttonpressed = new JFrame();
	private JFrame firstwindow = new JFrame();		
	




	JFrame choosecontcitywindow = new JFrame();
	JFrame updatebuttonpres = new JFrame();

	
	private JButton armystatus,nextbutton1,backbutton1 ,upgradebutton,recrutebutton,buildbutton,backbutton2,doneupgr,donerec,backbuttonbuild,buildbutto;
	private JButton  cityviewbutton,backattak;
	private JButton endTurn,nextattak,backofrecrutr;
	private JButton laysiege,attackbutton,relocbutton;
	private JButton autoResolve,backbutton3,donebuttonbuild;


	
	private JComboBox<String> avacities;
	
	
	
	private String name;
	private String cityname;
	private String armychosen;
	
	
	//JLabels
	private JLabel gold;
	private JLabel citynamee;
	private JLabel idlearmies;
	private JLabel food;
	 private JLabel turn;
	 private JLabel generalinfo;
	 private JLabel tempmessageformarch,choseonecont,bulidinginfolabel,infolabel,choseonetobu,chosetoupg,choseacityattak;

	
	
	//buttons
	 
	
	 private Player p;
	 private Game g;
	 private City c;
	 private Army a;
	
	
	
	public gameMenu(String playerName, String cityName,String armychosen) throws IOException, BuildingInCoolDownException, MaxRecruitedException, NotEnoughGoldException {
		
		
        this.armychosen=armychosen;
		this.name=playerName;
		this.cityname=cityName;
		   g = new Game(name,cityname);
		 p = new Player(name);
		 c = new City(cityname);
		 a= new Army(cityname);
		 
		 if(armychosen.equals("archer")) {
			 Archer AA = new Archer(1,60,0.4,0.5,0.6); 
				a.getUnits().add(AA);
		 }
		 else if(armychosen.equals("cavalry")) {
			 Cavalry CC = new Cavalry(1,50,0.5,0.6,0.7);
				a.getUnits().add(CC);
		 }
		 else if(armychosen.equals("Infantry")){
			 Infantry II =new Infantry(1, 50, 0.5, 0.6, 0.7);
			 a.getUnits().add(II);
		 }
		 
		 
		 
		 
		 
		 
		 p.getControlledArmies().add(a);
		 g.getAvailableCities().add(c);
		 p.getControlledArmies().get(0).getCurrentStatus();
		 
		
		
		
		
		
		
	
		
		
      
        
        
        
        
        
   
      
        
        
        
        //third JPanel //

		
		
		
		
		
	
	}
	
	
	
	

	public void refreshGenInfo() {
		
		firstwindow = new JFrame();
		
		


		
		
		//Fist JPanel for general info//
		geninfo.setBackground(Color.gray);
		geninfo.setLayout(new GridLayout(5,1));
      	geninfo.setBounds(650, 0, 400, 150);
		JLabel generalinfo = new JLabel();
		generalinfo.setText("general info");
		generalinfo.setForeground(Color.cyan);
		geninfo.add(generalinfo);
		JLabel playername = new JLabel();
		playername.setText("Player name : " + this.name);
		geninfo.add(playername);	
		JLabel gold = new JLabel();
		// g = new Game(this.name,this.cityname);
		gold.setText("Gold : " + g.getPlayer().getTreasury());
		geninfo.add(gold);		
		JLabel food = new JLabel();		
		food.setText("Food : " + g.getPlayer().getTreasury());
		geninfo.add(food);		
        JLabel turn = new JLabel();
        turn.setText("Turn : " + g.getCurrentTurnCount());
		geninfo.add(turn);
		JButton endTurn = new JButton();
		endTurn.setText("End Turn");
		geninfo.add(endTurn);
		endTurn.addActionListener(this);
		//Fist JPanel for general info//
		
		
		
		  //button //
        cityviewbuttonpanel.setBackground(Color.white);
        cityviewbuttonpanel.setBounds(375,25,150,50);
        cityviewbutton = new JButton();
        cityviewbutton.setText("City View");
        cityviewbutton.setPreferredSize(new Dimension (145,45));
        cityviewbutton.setForeground(Color.CYAN);;
        cityviewbutton.addActionListener(this);
        cityviewbuttonpanel.add(cityviewbutton);
        
        
        laysiegepann.setBackground(Color.white);
        laysiegepann.setBounds(850,200,150,50);
        laysiege = new JButton();
        laysiege.setText("laySiege");
        laysiege.setPreferredSize(new Dimension (145,45));
        laysiege.setForeground(Color.CYAN);;
        laysiege.addActionListener(this);
        laysiegepann.add(laysiege);
        
        
        autoResolvepann.setBackground(Color.white);
        autoResolvepann.setBounds(850,250,150,50);
        autoResolve = new JButton();
        autoResolve.setText("auto Resolve");
        autoResolve.setPreferredSize(new Dimension (145,45));
        autoResolve.setForeground(Color.CYAN);;
        autoResolve.addActionListener(this);
        autoResolvepann.add(autoResolve);
        
        
        autoResolvepann.setBackground(Color.white);
        autoResolvepann.setBounds(850,250,150,50);
        autoResolve = new JButton();
        autoResolve.setText("auto Resolve");
        autoResolve.setPreferredSize(new Dimension (145,45));
        autoResolve.setForeground(Color.CYAN);;
        autoResolve.addActionListener(this);
        autoResolvepann.add(autoResolve);
        
        
        attackpann.setBackground(Color.white);
        attackpann.setBounds(550,450,150,50);
        attackbutton = new JButton();
        attackbutton.setText("Attack a city");
        attackbutton.setPreferredSize(new Dimension (145,45));
        attackbutton.setForeground(Color.CYAN);;
        attackbutton.addActionListener(this);
        attackpann.add(attackbutton);
        
        
        relocatepann.setBackground(Color.white);
        relocatepann.setBounds(400,450,150,50);
        relocbutton = new JButton();
        relocbutton.setText("Relocate");
        relocbutton.setPreferredSize(new Dimension (145,45));
        relocbutton.setForeground(Color.CYAN);;
        relocbutton.addActionListener(this);
        relocatepann.add(relocbutton);
        
        
        //button//
		
	
			//Second JPanel for general info// 
			ac.setBackground(Color.gray);
			ac.setLayout(new GridLayout(5,1));
			ac.setBounds(0, 0, 290, 150);
			JLabel citynamee = new JLabel();
			citynamee.setText("Your available cities");
			citynamee.setBounds(0, 0, 250, 150);
			citynamee.setForeground(Color.cyan);
			ac.add(citynamee);
	        DefaultListModel model = new DefaultListModel();           
	        JList list = new JList(model);                            
	        JScrollPane listScrollPane = new JScrollPane(list);       
	            list.setBounds(0, 30, 200, 150);         
	        model.addElement(cityname);                             
	        ac.add(listScrollPane);  
				//Second JPanel for general info//
		        
			        
			      //third JPanel about Idle Armies//
			        ca.setBackground(Color.gray);
			        ca.setLayout(new GridLayout(5,1));
			        ca.setBounds(0, 170, 250, 200);
			        JLabel idlearmies = new JLabel();
			        idlearmies.setText("Your Idle Armies");
			        idlearmies.setBounds(0, 0, 200, 150);
			        idlearmies.setForeground(Color.cyan);
			        ca.add(idlearmies);
			        
			        if(a.getCurrentStatus().equals(Status.IDLE)) {
			        DefaultListModel mod = new DefaultListModel();            
			        JList list2 = new JList(mod);  
			        list2.setBounds(0, 250, 250, 150);
			        
					JScrollPane listScrollPane2 = new JScrollPane(list2);
					for(int i =0; i<p.getControlledArmies().size(); i++) {
					if(p.getControlledArmies().get(i).getUnits().get(i) instanceof Archer) {
			        mod.addElement("Archer"+" Of Level "+ p.getControlledArmies().get(i).getUnits().get(i).getLevel()+ " Current solider count "+p.getControlledArmies().get(i).getUnits().get(i).getCurrentSoldierCount() + " Max solider count " +p.getControlledArmies().get(i).getUnits().get(i).getMaxSoldierCount() );
			        ca.add(listScrollPane2);    }
					else if(p.getControlledArmies().get(i).getUnits().get(i) instanceof Cavalry) {
						 mod.addElement("Cavalry"+" Of Level "+ p.getControlledArmies().get(i).getUnits().get(i).getLevel()+ " Current solider count "+p.getControlledArmies().get(i).getUnits().get(i).getCurrentSoldierCount() + " Max solider count " +p.getControlledArmies().get(i).getUnits().get(i).getMaxSoldierCount() );
					        ca.add(listScrollPane2); 
					}
					else if(p.getControlledArmies().get(i).getUnits().get(i) instanceof Infantry) {
						 mod.addElement("Infantry"+" Of Level "+ p.getControlledArmies().get(i).getUnits().get(i).getLevel()+ " Current solider count "+p.getControlledArmies().get(i).getUnits().get(i).getCurrentSoldierCount() + " Max solider count " +p.getControlledArmies().get(i).getUnits().get(i).getMaxSoldierCount() );
					        ca.add(listScrollPane2); 
					}
					
					}
			   
			        }
			        else {
			        	
			        	JLabel tempmessageforide = new JLabel();
			        	tempmessageforide.setText("currently no idle armies");
			        	tempmessageforide.setBounds(0, 0, 200, 150);
			        	tempmessageforide.setForeground(Color.red);
			        	marcharm.add(tempmessageforide);
			        }
			       //third JPanel//
				
			
				        //4th panel about marching armies//
				        marcharm.setBackground(Color.gray);
				        marcharm.setLayout(new GridLayout(5,1));
				        marcharm.setBounds(300, 170, 250, 200);
				        JLabel marchingtext = new JLabel();
				        marchingtext.setText("Your Marching Armies");
				        marchingtext.setBounds(0, 0, 200, 150);
				        marchingtext.setForeground(Color.cyan);
				        marcharm.add(marchingtext);
				        if(a.getCurrentStatus().equals(Status.MARCHING)) {
				        	  DefaultListModel mod = new DefaultListModel();            
						        JList list3 = new JList(mod);  
						        list3.setBounds(0, 30, 200, 150);
						        
								JScrollPane listScrollPane3 = new JScrollPane(list3);
								for(int i =0; i<p.getControlledArmies().size(); i++) {
								if(p.getControlledArmies().get(i).getUnits().get(i) instanceof Archer) {
						        mod.addElement("Archer"+" Of Level "+ p.getControlledArmies().get(i).getUnits().get(i).getLevel()+ " Current solider count "+p.getControlledArmies().get(i).getUnits().get(i).getCurrentSoldierCount() + " Max solider count " +p.getControlledArmies().get(i).getUnits().get(i).getMaxSoldierCount() +" Target City " +p.getControlledArmies().get(i).getTarget()+" Distance left "+ p.getControlledArmies().get(i).getDistancetoTarget() );
						        ca.add(listScrollPane3);    }
								else if(p.getControlledArmies().get(i).getUnits().get(i) instanceof Cavalry) {
									DefaultListModel mod10 = new DefaultListModel();
									 mod.addElement("Cavalry"+" Of Level "+ p.getControlledArmies().get(i).getUnits().get(i).getLevel()+ " Current solider count "+p.getControlledArmies().get(i).getUnits().get(i).getCurrentSoldierCount() + " Max solider count " +p.getControlledArmies().get(i).getUnits().get(i).getMaxSoldierCount() +" Target City " +p.getControlledArmies().get(i).getTarget()+" Distance left "+ p.getControlledArmies().get(i).getDistancetoTarget() );
								        ca.add(listScrollPane3); 
								}
								else if(p.getControlledArmies().get(i).getUnits().get(i) instanceof Infantry) {
									 mod.addElement("Infantry"+" Of Level "+ p.getControlledArmies().get(i).getUnits().get(i).getLevel()+ " Current solider count "+p.getControlledArmies().get(i).getUnits().get(i).getCurrentSoldierCount() + " Max solider count " +p.getControlledArmies().get(i).getUnits().get(i).getMaxSoldierCount()+" Target City " +p.getControlledArmies().get(i).getTarget() +" Distance left "+ p.getControlledArmies().get(i).getDistancetoTarget() );
								        ca.add(listScrollPane3); 
								} } }
				        
				        else {
				        	
				        	JLabel tempmessageformarch = new JLabel();
				        	tempmessageformarch.setText("currently no marching armies");
				        	tempmessageformarch.setBounds(0, 0, 200, 150);
				        	tempmessageformarch.setForeground(Color.red);
				        	marcharm.add(tempmessageformarch);
				        }
				        //4th panel about marching armies//

				        
				        
						        //5th panel about besieging//
						        besiegingpan.setBackground(Color.gray);
						        besiegingpan.setLayout(new GridLayout(5,1));
						        besiegingpan.setBounds(590, 170, 250, 200);
						        JLabel besiegingtext = new JLabel();
						        besiegingtext.setText("Your Besieging Armies");
						        besiegingtext.setBounds(0, 0, 200, 150);
						        besiegingtext.setForeground(Color.cyan);
						        besiegingpan.add(besiegingtext);
						        
						        if(a.getCurrentStatus().equals(Status.BESIEGING)) {
						        	  DefaultListModel mod = new DefaultListModel();            
								        JList list4 = new JList(mod);  
								        list4.setBounds(0, 30, 200, 150);
								        
										JScrollPane listScrollPane4 = new JScrollPane(list4);
										for(int i =0; i<p.getControlledArmies().size(); i++) {
										if(p.getControlledArmies().get(i).getUnits().get(i) instanceof Archer) {
								        mod.addElement("Archer"+" Of Level "+ p.getControlledArmies().get(i).getUnits().get(i).getLevel()+ " Current solider count "+p.getControlledArmies().get(i).getUnits().get(i).getCurrentSoldierCount() + " Max solider count " +p.getControlledArmies().get(i).getUnits().get(i).getMaxSoldierCount() +" Target City " +p.getControlledArmies().get(i).getTarget()+" turns under siege "+ c.getTurnsUnderSiege() );
								        ca.add(listScrollPane4);    }
										else if(p.getControlledArmies().get(i).getUnits().get(i) instanceof Cavalry) {
											DefaultListModel mod1 = new DefaultListModel();
											 mod1.addElement("Cavalry"+" Of Level "+ p.getControlledArmies().get(i).getUnits().get(i).getLevel()+ " Current solider count "+p.getControlledArmies().get(i).getUnits().get(i).getCurrentSoldierCount() + " Max solider count " +p.getControlledArmies().get(i).getUnits().get(i).getMaxSoldierCount() +" Target City " +p.getControlledArmies().get(i).getTarget()+" turns under siege "+ c.getTurnsUnderSiege() );
											 JList list5 = new JList(mod1);  
										        list5.setBounds(0, 150, 200, 150);
												JScrollPane listScrollPane5 = new JScrollPane(list5);
												ca.add(listScrollPane5);
										}
										else if(p.getControlledArmies().get(i).getUnits().get(i) instanceof Infantry) {
											DefaultListModel mod2 = new DefaultListModel();
											 mod2.addElement("Infantry"+" Of Level "+ p.getControlledArmies().get(i).getUnits().get(i).getLevel()+ " Current solider count "+p.getControlledArmies().get(i).getUnits().get(i).getCurrentSoldierCount() + " Max solider count " +p.getControlledArmies().get(i).getUnits().get(i).getMaxSoldierCount()+" Target City " +p.getControlledArmies().get(i).getTarget() +" turns under siege "+ c.getTurnsUnderSiege() );
										        ca.add(listScrollPane4); 
										        JList list6 = new JList(mod2);  
										        list6.setBounds(0, 250, 200, 150);
												JScrollPane listScrollPane6 = new JScrollPane(list6);
												ca.add(listScrollPane6);
										} } }
						        else {
						        	
						        	JLabel tempmessageformarch = new JLabel();
						        	tempmessageformarch.setText("currently no besieging armies");
						        	tempmessageformarch.setBounds(0, 0, 200, 150);
						        	tempmessageformarch.setForeground(Color.red);
						        	besiegingpan.add(tempmessageformarch);
						        }
					
						        //5th panel about besieging//

				        
						        firstwindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
						        firstwindow.setLayout(null);
						        firstwindow.setSize(1050,700);
						        firstwindow.setResizable(false);
						        firstwindow.setVisible(true);
						        firstwindow.add(geninfo);
						        firstwindow.add(ac);
						        firstwindow.add(ca);
								firstwindow.add(cityviewbuttonpanel);
								firstwindow.add(marcharm);
								firstwindow.add(besiegingpan);
								firstwindow.add(laysiegepann);
								firstwindow.add(autoResolvepann);
								firstwindow.add(attackpann);
								firstwindow.add(relocatepann);
        
        
        
		
	
    }
	
	
	private void attackbuttonpresd() {
		attackbuttonpresd = new JFrame();
		attackbuttonpresd.setDefaultCloseOperation(EXIT_ON_CLOSE);
		attackbuttonpresd.setLayout(null);
		attackbuttonpresd.setSize(1050,700);
		attackbuttonpresd.setResizable(false);
		attackbuttonpresd.setVisible(true);
		attackbuttonpresd.add(nextbuttonforattakpan);
		
		
		choseacityattak = new JLabel();
		choseacityattak.setText("Choose a unit you will use");
		choseacityattak.setBounds(15,15,650,30);
		attackbuttonpresd.add(choseacityattak);
		
		
		for(int i =0;i<p.getControlledArmies().size();i++) {

			if(p.getControlledArmies().get(i).getUnits().get(i) instanceof Archer) {
				jcb60 = new JCheckBox("Archers", false);
				checkBoxGroup = new ButtonGroup();
				checkBoxGroup.add(jcb60);
				jcb60.setBounds(100,0, 100,100);
				attackbuttonpresd.add(jcb60);
				
	
			}
			else if(p.getControlledArmies().get(i).getUnits().get(i) instanceof Cavalry) {
				jcb61 = new JCheckBox("Cavalry", false);
				checkBoxGroup = new ButtonGroup();
				checkBoxGroup.add(jcb61);
				jcb61.setBounds(400,0, 100,100);
				attackbuttonpresd.add(jcb61);

			}
			else if(p.getControlledArmies().get(i).getUnits().get(i) instanceof Infantry) {
				jcb62 = new JCheckBox("Infantry", false);
				checkBoxGroup = new ButtonGroup();
				checkBoxGroup.add(jcb62);
				jcb62.setBounds(700,0, 100,100);
				attackbuttonpresd.add(jcb62);

			}
			
		}
		
		
	      
	      
	      

	 	 

	    
	    
		nextbuttonforattakpan.setBackground(Color.white);
		nextbuttonforattakpan.setBounds(550,580,150,50);
		nextattak = new JButton();
	 	nextattak.setText("Done");
	 	nextattak.setPreferredSize(new Dimension (145,45));
	 	nextattak.setForeground(Color.black);;
	 	nextattak.addActionListener(this);
		nextbuttonforattakpan.add(nextattak);
	 		
	 		
	 		 backattak = new JButton();
	 		backattak.setText("Back for attack button");
	 		backattak.setBounds(300,600,150,30);
	 		attackbuttonpresd.add(backattak);
	 			backattak.addActionListener(this);
		
		
		
		
		
	}
	
	
	private String selectedcity;
	public void choosecontcitywindow() {
	 choosecontcitywindow = new JFrame();
	choosecontcitywindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
	choosecontcitywindow.setLayout(null);
	choosecontcitywindow.setSize(1050,700);
	choosecontcitywindow.setResizable(false);
	choosecontcitywindow.setVisible(true);
	
	choseonecont = new JLabel();
	choseonecont.setText("Chose one of your controlled cities that you want to display information about");
	choseonecont.setBounds(15,15,650,30);
	choosecontcitywindow.add(choseonecont);
	for(int i =0; i<p.getControlledArmies().size(); i++) {
		
		if(g.getAvailableCities().get(i).getName().equalsIgnoreCase("cairo")) {
			jcb1 = new JCheckBox("Cairo", true);
			checkBoxGroup = new ButtonGroup();
		      //add CheckBoxes to ButtonGroup
		      checkBoxGroup.add(jcb1);
		      choosecontcitywindow.add(jcb1);
		      jcb1.setBounds(100,0, 100,100);
			
		}
		
		
		else if(g.getAvailableCities().get(i).getName().equalsIgnoreCase("Sparta")) {
			jcb2 = new JCheckBox("Sparta", false);
			checkBoxGroup = new ButtonGroup();
		      //add CheckBoxes to ButtonGroup
		      checkBoxGroup.add(jcb2);
		      choosecontcitywindow.add(jcb2);
		      jcb2.setBounds(400,0, 100,100);
		}
		else {
			jcb3 = new JCheckBox("Rome",false);
			checkBoxGroup = new ButtonGroup();
		      //add CheckBoxes to ButtonGroup
		      checkBoxGroup.add(jcb3);
		      choosecontcitywindow.add(jcb3);
		      jcb3.setBounds(700,0, 100,100);
		}
	}
	if(jcb1.isSelected()) {
		selectedcity ="Cairo";
	}
	else if(jcb2.isSelected()) {
		selectedcity ="Sparta";
	}
	else if(jcb2.isSelected()) {
		selectedcity ="Rome";
	}
	
	
	
	 nextbutton1 = new JButton();
	 nextbutton1.setText("Next");
	 nextbutton1.setBounds(400,600,150,30);
		choosecontcitywindow.add(nextbutton1);
		nextbutton1.addActionListener(this);
		
		
	
		
		
		
		
		 backbutton1 = new JButton();
		 backbutton1.setText("Back of chosing city");
		 backbutton1.setBounds(600,600,150,30);
			choosecontcitywindow.add(backbutton1);
			backbutton1.addActionListener(this);
		
		
	
	
	}
	
	
	
	public void nextpageafterchoosecontcitywindow() {
		 nextpageafterchoosecontcitywindow = new JFrame();
		nextpageafterchoosecontcitywindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
		nextpageafterchoosecontcitywindow.setLayout(null);
		nextpageafterchoosecontcitywindow.setSize(1050,700);
		nextpageafterchoosecontcitywindow.setResizable(false);
		nextpageafterchoosecontcitywindow.setVisible(true);
		nextpageafterchoosecontcitywindow.add(buildingpanel);
		nextpageafterchoosecontcitywindow.add(upgradepann);
		nextpageafterchoosecontcitywindow.add(recrutepann);
		nextpageafterchoosecontcitywindow.add(buildpann);
		nextpageafterchoosecontcitywindow.add(infopann);
		nextpageafterchoosecontcitywindow.add(backbuttonpann);



		
		
		
		//buttons//
		upgradepann.setBackground(Color.white);
		upgradepann.setBounds(550,25,150,50);
		upgradebutton = new JButton();
		upgradebutton.setText("Upgrade");
		upgradebutton.setPreferredSize(new Dimension (145,45));
		upgradebutton.setForeground(Color.CYAN);;
		upgradebutton.addActionListener(this);
		upgradepann.add(upgradebutton);
		
		recrutepann.setBackground(Color.white);
		recrutepann.setBounds(550,95,150,50);
		recrutebutton = new JButton();
		recrutebutton.setText("Recruit");
		recrutebutton.setPreferredSize(new Dimension (145,45));
		recrutebutton.setForeground(Color.CYAN);;
		recrutebutton.addActionListener(this);
		recrutepann.add(recrutebutton);
		
		buildpann.setBackground(Color.white);
		buildpann.setBounds(550,165,150,50);
		buildbutton = new JButton();
		buildbutton.setText("Build");
		buildbutton.setPreferredSize(new Dimension (145,45));
		buildbutton.setForeground(Color.CYAN);;
		buildbutton.addActionListener(this);
		buildpann.add(buildbutton);
		
		
		backbuttonpann.setBackground(Color.white);
		backbuttonpann.setBounds(550,580,150,50);
		backbutton2 = new JButton();
		backbutton2.setText("Back of city view window");
		backbutton2.setPreferredSize(new Dimension (145,45));
		backbutton2.setForeground(Color.black);;
		backbutton2.addActionListener(this);
		backbuttonpann.add(backbutton2);
		
		//buttons//
		
		
		
		buildingpanel.setBackground(Color.gray);
		buildingpanel.setLayout(new GridLayout(5,1));
		buildingpanel.setBounds(0, 0, 450, 300);
		JLabel bulidinginfolabel = new JLabel();
		bulidinginfolabel.setText("Buildings in the city");
		bulidinginfolabel.setBounds(0, 0, 200, 150);
		bulidinginfolabel.setForeground(Color.cyan);
		buildingpanel.add(bulidinginfolabel);
		
		/////////////////--------
		for(int i =0; i<c.getEconomicalBuildings().size(); i++) {
			if(c.getEconomicalBuildings().get(i) instanceof Farm) {
				DefaultListModel model88 = new DefaultListModel();           
		        JList infolist50 = new JList(model88);                            
		        JScrollPane listScrollPane = new JScrollPane(infolist50);       
		        infolist50.setBounds(10, 30, 200, 150);         
		        model88.addElement("Type Farm Of level"+ c.getEconomicalBuildings().get(i).getLevel());
		        buildingpanel.add(listScrollPane);  
			}
			 else if(c.getEconomicalBuildings().get(i) instanceof Market) {
				DefaultListModel model88 = new DefaultListModel();           
		        JList infolist50 = new JList(model88);                            
		        JScrollPane listScrollPane = new JScrollPane(infolist50);       
		        infolist50.setBounds(10, 60, 200, 150);         
		        model88.addElement("Type Market Of level"+ c.getEconomicalBuildings().get(i).getLevel());
		        buildingpanel.add(listScrollPane);  
			}
			 else {
				 nobulidins = new JLabel();
					nobulidins.setText("no Economical Buildings yet");
					nobulidins.setBounds(0,15,250,150);
					buildingpanel.add(nobulidins);
			 }
			
		}
		for(int i =0; i<c.getMilitaryBuildings().size(); i++) {
			if(c.getMilitaryBuildings().get(i) instanceof ArcheryRange) {
				DefaultListModel model88 = new DefaultListModel();           
		        JList infolist50 = new JList(model88);                            
		        JScrollPane listScrollPane = new JScrollPane(infolist50);       
		        infolist50.setBounds(10, 80, 200, 150);         
		        model88.addElement("Type ArcheryRange Of level"+ c.getMilitaryBuildings().get(i).getLevel());
		        buildingpanel.add(listScrollPane);  
			}
		
			else if(c.getMilitaryBuildings().get(i) instanceof Barracks) {
				
				DefaultListModel model88 = new DefaultListModel();           
		        JList infolist50 = new JList(model88);                            
		        JScrollPane listScrollPane = new JScrollPane(infolist50);       
		        infolist50.setBounds(10, 100, 200, 150);         
		        model88.addElement("Type  Barracks Of level"+ c.getMilitaryBuildings().get(i).getLevel());
		        buildingpanel.add(listScrollPane);
			}
			
			else if(c.getMilitaryBuildings().get(i) instanceof Stable) {
				DefaultListModel model88 = new DefaultListModel();           
		        JList infolist50 = new JList(model88);                            
		        JScrollPane listScrollPane = new JScrollPane(infolist50);       
		        infolist50.setBounds(10, 130, 200, 150);         
		        model88.addElement("Type  Stable Of level"+ c.getMilitaryBuildings().get(i).getLevel());
		        buildingpanel.add(listScrollPane);
			}
			 else {
				 nobulidins2 = new JLabel();
					nobulidins.setText("no Military Buildings yet");
					nobulidins.setBounds(0,25,250,150);
					buildingpanel.add(nobulidins2);
			 }
		}
		
		
		
		
		
		
		
		
		
		
		infopann.setBackground(Color.gray);
		infopann.setLayout(new GridLayout(5,1));
		infopann.setBounds(0,350, 450, 300);
		JLabel abovetextt = new JLabel();
		abovetextt.setText("Upgrade & Recrutment costs ");
		abovetextt.setBounds(0, 0, 200, 150);
		abovetextt.setForeground(Color.cyan);
		infopann.add(abovetextt);
		
		DefaultListModel model88 = new DefaultListModel();           
        JList infolist = new JList(model88);                            
        JScrollPane listScrollPane = new JScrollPane(infolist);       
        infolist.setBounds(10, 30, 200, 150);         
        model88.addElement(" Farm Building Level 2 upgradeCost 700 ,Market Building Level 2 upgradeCost 1000 ,Archer Range Building Level 2 upgradeCost 700 recruitmentCost 450,Farm Building Level 3 upgradeCost - recruitmentCost 500,Barracks Building Level 2 upgradeCost 1500 recruitmentCost 550,Barracks Building Level 3 upgradeCost - recruitmentCost 650");                             
        infopann.add(listScrollPane);  
		

	}
	public void Upgradebuttonpressed() {
		updatebuttonpres= new JFrame();
		updatebuttonpres.setDefaultCloseOperation(EXIT_ON_CLOSE);
		updatebuttonpres.setLayout(null);
		updatebuttonpres.setSize(1050,700);
		updatebuttonpres.setResizable(false);
		updatebuttonpres.setVisible(true);
		updatebuttonpres.add(donebuttonupgpan);
		updatebuttonpres.add(backbuttonpann2);
		
		chosetoupg = new JLabel();
		chosetoupg.setText("chose a bulding to upgrade , you can check the prices in the previous");
		chosetoupg.setBounds(15,15,650,30);
		updatebuttonpres.add(chosetoupg);

		
		backbuttonpann2.setBackground(Color.white);
		backbuttonpann2.setBounds(550,580,150,50);
		backbutton3 = new JButton();
		backbutton3.setText("Back of update bulidings");
		backbutton3.setPreferredSize(new Dimension (145,45));
		backbutton3.setForeground(Color.black);;
		backbutton3.addActionListener(this);
		backbuttonpann2.add(backbutton3);
		
		
		donebuttonupgpan.setBackground(Color.white);
		donebuttonupgpan.setBounds(550,580,150,50);
		doneupgr = new JButton();
		doneupgr.setText("Done");
		doneupgr.setPreferredSize(new Dimension (145,45));
		doneupgr.setForeground(Color.black);;
		doneupgr.addActionListener(this);
		donebuttonupgpan.add(backbutton3);
		
		
		
		for(int i =0; i<c.getEconomicalBuildings().size(); i++) {
			if(c.getEconomicalBuildings().get(i) instanceof Farm) {
				  jcb10 = new JCheckBox("Farm", true);
				  checkBoxGroup = new ButtonGroup();
			      checkBoxGroup.add(jcb10);
			      updatebuttonpres.add(jcb10);
			      jcb10.setBounds(100,0, 100,100);
			}
			else if(c.getEconomicalBuildings().get(i) instanceof Market) {
				  jcb11 = new JCheckBox("Market", false);
				  checkBoxGroup = new ButtonGroup();
			      checkBoxGroup.add(jcb11);
			      updatebuttonpres.add(jcb11);
			      jcb11.setBounds(400,0, 100,100);
			}	
			
		}
		
		
		for(int i =0; i<c.getMilitaryBuildings().size(); i++) {
			if(c.getMilitaryBuildings().get(i) instanceof ArcheryRange) {
				  jcb12 = new JCheckBox("ArcheryRange", false);
				  checkBoxGroup = new ButtonGroup();
			      checkBoxGroup.add(jcb12);
			      updatebuttonpres.add(jcb12);
			      jcb2.setBounds(400,40, 100,100);
			}
		
			else if(c.getMilitaryBuildings().get(i) instanceof Barracks) {
				 jcb13 = new JCheckBox("Barracks", false);
				  checkBoxGroup = new ButtonGroup();
			      checkBoxGroup.add(jcb13);
			      updatebuttonpres.add(jcb13);
			      jcb13.setBounds(700,0, 100,100);
			}
			
			else if(c.getMilitaryBuildings().get(i) instanceof Stable) {
				jcb44 = new JCheckBox("Stable", false);
				  checkBoxGroup = new ButtonGroup();
			      checkBoxGroup.add(jcb44);
			      updatebuttonpres.add(jcb44);
			      jcb44.setBounds(100,40, 100,100);
			}
		}
		
		
		
	}
	
	
	
	
	
	public void recrutebuttonpress() {
		recrutebuttonpress= new JFrame();
		recrutebuttonpress.setDefaultCloseOperation(EXIT_ON_CLOSE);
		recrutebuttonpress.setLayout(null);
		recrutebuttonpress.setSize(1050,700);
		recrutebuttonpress.setResizable(false);
		recrutebuttonpress.setVisible(true);
		recrutebuttonpress.add(donebuttonupgpan);
		recrutebuttonpress.add(backbuttonpann2);
		recrutebuttonpress.add(donebuttonupgpan1);
		recrutebuttonpress.add(backbuttonpann3);
		


		
		backbuttonpann3.setBackground(Color.white);
		backbuttonpann3.setBounds(550,580,150,50);
		backofrecrutr = new JButton();
		backofrecrutr.setText("Back of recrute");
		backofrecrutr.setPreferredSize(new Dimension (145,45));
		backofrecrutr.setForeground(Color.black);;
		backofrecrutr.addActionListener(this);
		backbuttonpann3.add(backofrecrutr);
		
		
		donebuttonupgpan1.setBackground(Color.white);
		donebuttonupgpan1.setBounds(550,380,150,50);
		donerec = new JButton();
		donerec.setText("Done");
		donerec.setPreferredSize(new Dimension (145,45));
		donerec.setForeground(Color.black);;
		donerec.addActionListener(this);
		donebuttonupgpan1.add(donerec);
		
		 jcb20 = new JCheckBox("archer", true);
		  checkBoxGroup = new ButtonGroup();
	      checkBoxGroup.add(jcb20);
	      recrutebuttonpress.add(jcb20);
	      jcb20.setBounds(100,0, 100,100);
	      
	      jcb21 = new JCheckBox("cavalry", false);
		  checkBoxGroup = new ButtonGroup();
	      checkBoxGroup.add(jcb21);
	      recrutebuttonpress.add(jcb21);
	      jcb21.setBounds(400,0, 100,100);
	      
	      jcb22 = new JCheckBox("infantry", false);
		  checkBoxGroup = new ButtonGroup();
	      checkBoxGroup.add(jcb22);
	      recrutebuttonpress.add(jcb22);
	      jcb22.setBounds(700,0, 100,100);
	   
	      
	      
		
		
	      
		
		

	
	}
	
	
	
	
	public void buildbuttonpressed() {
		buildbuttonpressed= new JFrame();
		buildbuttonpressed.setDefaultCloseOperation(EXIT_ON_CLOSE);
		buildbuttonpressed.setLayout(null);
		buildbuttonpressed.setSize(1050,700);
		buildbuttonpressed.setResizable(false);
		buildbuttonpressed.setVisible(true);
		buildbuttonpressed.add(buildbuttonpan);
		buildbuttonpressed.add(backbuttonbuildpan);

		
		
		choseonetobu = new JLabel();
		choseonetobu.setText("Chose one building to build in this city");
		choseonetobu.setBounds(15,15,650,30);
		buildbuttonpressed.add(choseonetobu);
		
		
		 jcb40 = new JCheckBox("Archery Range", true);
		  checkBoxGroup = new ButtonGroup();
	      checkBoxGroup.add(jcb40);
	      buildbuttonpressed.add(jcb40);
	      jcb40.setBounds(100,0, 160,100);
	      
	      jcb41 = new JCheckBox("Barracks", false);
		  checkBoxGroup = new ButtonGroup();
	      checkBoxGroup.add(jcb41);
	      buildbuttonpressed.add(jcb41);
	      jcb41.setBounds(400,0, 100,100);
	      
	      jcb42 = new JCheckBox("Farm", false);
		  checkBoxGroup = new ButtonGroup();
	      checkBoxGroup.add(jcb42);
	      buildbuttonpressed.add(jcb42);
	      jcb42.setBounds(700,0, 100,100);
	      
	      jcb43 = new JCheckBox("Market", false);
		  checkBoxGroup = new ButtonGroup();
	      checkBoxGroup.add(jcb43);
	      buildbuttonpressed.add(jcb43);
	      jcb43.setBounds(100,65, 100,100);
		
	      
	      
	      
	      backbuttonbuildpan.setBackground(Color.white);
	      backbuttonbuildpan.setBounds(550,580,150,50);
			backbuttonbuild = new JButton();
			backbuttonbuild.setText("Back of bulid");
			backbuttonbuild.setPreferredSize(new Dimension (145,45));
			backbuttonbuild.setForeground(Color.black);;
			backbuttonbuild.addActionListener(this);
			backbuttonbuildpan.add(backbuttonbuild);
			
			
			buildbuttonpan.setBackground(Color.white);
			buildbuttonpan.setBounds(400,580,150,50);
			donebuttonbuild = new JButton();
			donebuttonbuild.setText("Done build");
			donebuttonbuild.setPreferredSize(new Dimension (145,45));
			donebuttonbuild.setForeground(Color.black);;
			donebuttonbuild.addActionListener(this);
			buildbuttonpan.add(donebuttonbuild);
		
		
		
		
	}
	



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==recrutebutton) {
			recrutebuttonpress();
			nextpageafterchoosecontcitywindow.setVisible(false);
		}
		if(e.getSource()==endTurn) {
			g.endTurn();
			refreshGenInfo();
		}
		if(e.getSource()==cityviewbutton) {
			choosecontcitywindow();
			firstwindow.setVisible(false);
			
		}
		if(e.getSource()==nextbutton1) {
			nextpageafterchoosecontcitywindow();
			choosecontcitywindow.setVisible(false);
			
		}
		if(e.getSource()==backofrecrutr) {
			nextpageafterchoosecontcitywindow.setVisible(true);

			recrutebuttonpress.setVisible(false);
			
		}
		if(e.getSource()==backbutton2) {
			firstwindow.setVisible(true);
			nextpageafterchoosecontcitywindow.setVisible(false);
		}
		if(e.getSource()==backbutton1) {
			firstwindow.setVisible(true);
			choosecontcitywindow.setVisible(false);
			//nextpageafterchoosecontcitywindow.setVisible(false);
		}
		if(e.getSource()==upgradebutton ) {
			Upgradebuttonpressed();
			choosecontcitywindow.setVisible(false);
			nextpageafterchoosecontcitywindow.setVisible(false);
			
				}
		if(e.getSource()==attackbutton) {
			attackbuttonpresd();
			firstwindow.setVisible(false);
			
		}
		if(e.getSource()==backattak) {
			firstwindow.setVisible(true);
			attackbuttonpresd.setVisible(false);
			
		}
		
		if(e.getSource()==backbutton3 ) {
			nextpageafterchoosecontcitywindow.setVisible(true);
			updatebuttonpres.setVisible(false);
			
		}
		if(e.getSource()==backbuttonbuild ) {
			nextpageafterchoosecontcitywindow.setVisible(true);
			buildbuttonpressed.setVisible(false);
		}
		if(e.getSource()==buildbutton ) {
			buildbuttonpressed.setVisible(true);
			choosecontcitywindow.setVisible(false);
		}
		
		
		if(e.getSource()==doneupgr ) {
			nextpageafterchoosecontcitywindow();
			updatebuttonpres.setVisible(false);
			
			
			if(jcb10.isSelected()) {
				for(int i =0; i<c.getEconomicalBuildings().size(); i++) {
					if(c.getEconomicalBuildings().get(i) instanceof Farm) {
						try {
							p.upgradeBuilding(c.getEconomicalBuildings().get(i));
						} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						};
					}}
			}
			else if(jcb11.isSelected()) {
				
				for(int i =0; i<c.getEconomicalBuildings().size(); i++) {
					if(c.getEconomicalBuildings().get(i) instanceof Market) {
						try {
							p.upgradeBuilding(c.getEconomicalBuildings().get(i));
						} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						};
					}}			}
			else if(jcb12.isSelected()){
				
				for(int i =0; i<c.getMilitaryBuildings().size(); i++) {
					if(c.getMilitaryBuildings().get(i) instanceof ArcheryRange) {
						try {
							p.upgradeBuilding(c.getMilitaryBuildings().get(i));
						} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						};
					}}	
			}
            else if(jcb13.isSelected()){
            	for(int i =0; i<c.getMilitaryBuildings().size(); i++) {
					if(c.getMilitaryBuildings().get(i) instanceof Barracks) {
						try {
							p.upgradeBuilding(c.getMilitaryBuildings().get(i));
						} catch (NotEnoughGoldException | BuildingInCoolDownException | MaxLevelException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						};
					}}	
			}
			}
		if(e.getSource()==donebuttonbuild) {
			if(jcb40.isSelected()) {
				try {
					p.build(jcb40.getText(), selectedcity);
					
				} catch (NotEnoughGoldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(jcb41.isSelected()) {
				try {
					p.build(jcb41.getText(), selectedcity);
				} catch (NotEnoughGoldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if(jcb42.isSelected()) {
				try {
					p.build(jcb42.getText(), selectedcity);
				} catch (NotEnoughGoldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			buildbuttonpressed.setVisible(false);
			nextpageafterchoosecontcitywindow.setVisible(true);	
			
			
			}
		if(e.getSource()==laysiege) {
			
			try {
				p.laySiege(a, c);
			} catch (TargetNotReachedException | FriendlyCityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==autoResolve) {
			try {
				g.autoResolve(a, c.getDefendingArmy());
			} catch (FriendlyFireException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

			
		}
}








	





	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	