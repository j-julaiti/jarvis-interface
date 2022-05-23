package main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;


public class Interface extends JFrame implements ActionListener 
{	
	AudioClip audio3;
	AudioClip audio2;
	AudioClip audio4;
	int max = 0,min =0;
    volatile int divider;
	private static final long serialVersionUID=1L;
	public static int min1 =0;	
	public boolean continueRecorde;
	public static int w = 1440;
	public static int h=880;

	int number=w;
	int point[] = null;	
	final int panHeight=h/10-10;
	JScrollBar timeLocationScrollBar;
	public boolean jsbActive;
	byte bufferAll[];
    int bufferAllIndex;
    int vRate,hRate;
	public static String[] name=new String[60];
	public static String[] path = new String[60]; 
	
 	
	public static int ii=0;
	public static int jj=1;
	public int numofbotton=27;
	public static main.cofig cdM;
	static main.FollowFocus cdsetting;
	
	public void initData()
    {
        point=new int[w];
        Arrays.fill(point, 0);
        number=w;
        bufferAll=new byte[130*1024*1024];
        bufferAllIndex=0;
        vRate=h/10-10;
        hRate=1;          
        continueRecorde=true;
        jsbActive=false;
    }
	public void nameandpath(String[] name1, String[] path1)
	{
		int l = name1.length;
		//System.out.println(l);		
		for(int i =0;i<l;i++)
		{
			name[i]=name1[i];
		 	path[i]=path1[i];
		}
		ii=1;jj=2;		
	}
	public void refresh()
	{
//		double button = 9*Math.random();
//		URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
//		if(button<=1){
//		jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
//		if(button>1&&button<=2){
//		jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
//		if(button>2&&button<=3){
//		jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
//		if(button>3&&button<=4){
//		jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
//		if(button>4&&button<=5){
//		jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
//		if(button>5&&button<=6){
//		jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
//		if(button>6&&button<=7){
//		jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
//		if(button>7&&button<=8){
//		jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
//		if(button>8&&button<=9){
//		jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
//		audio2 = Applet.newAudioClip(jarvis2); 
//    	audio2.play();
	}
	
	

	public Interface() 
	{	
		
		super();					
		setTitle("J.A.R.V.I.S");
		setResizable(false);
		setAlwaysOnTop(false);

		setBounds(0, 0, w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final MPanel panel = new MPanel(this.getClass().getResource("/img/wall_0.png"));
		initData();

       
        timeLocationScrollBar=new JScrollBar();
        timeLocationScrollBar.setOrientation(JScrollBar.HORIZONTAL);
        timeLocationScrollBar.setMaximum(0);
        timeLocationScrollBar.setMinimum(0);
        timeLocationScrollBar.setValue(0);       
        
		panel.setBackground(Color.getHSBColor((float)4.68,(float)0.00,(float)0.00));		
		panel.setLayout(null);
		panel.setRequestFocusEnabled(false);
		panel.setEnabled(false);
		panel.setFocusable(false);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		Icon[] icon; icon = new Icon[numofbotton];	
		JButton[] jbutton; jbutton = new JButton[numofbotton];
		JButton[] jbutton0; jbutton0 = new JButton[numofbotton];
		JButton[] jbutton1; jbutton1 = new JButton[numofbotton];
		
		//setting Interface Icon&&Button	
		for(int i = 0; i < numofbotton; i++)
		{
			if(i<6)
				{
				icon[i]=new ImageIcon(this.getClass().getResource("/icon/1.png"));
				jbutton[i] = new JButton(icon[i]);
				jbutton[i].setContentAreaFilled(false); 
				jbutton[i].setBorderPainted(false);
				jbutton[i].setDisabledIcon(icon[i]);
				jbutton[i].setDisabledSelectedIcon(icon[i]);
				}
			else if(i>=6&&i<12)
				{
				icon[i]=new ImageIcon(this.getClass().getResource("/icon/2.png"));
				jbutton[i] = new JButton(icon[i]);
				jbutton[i].setContentAreaFilled(false); 
				jbutton[i].setBorderPainted(false);
				jbutton[i].setDisabledIcon(icon[i]);
				jbutton[i].setDisabledSelectedIcon(icon[i]);
				}
			else if(i>=12&&i<18)
			{
				icon[i]=new ImageIcon(this.getClass().getResource("/icon/"+(i-9)+".png"));
				jbutton[i] = new JButton(icon[i]);
				jbutton[i].setContentAreaFilled(false); 
				jbutton[i].setBorderPainted(false);
				jbutton[i].setDisabledIcon(icon[i]);
				jbutton[i].setDisabledSelectedIcon(icon[i]);
			}
			else if(i>=18)
			{

				icon[i]=new ImageIcon(this.getClass().getResource("/icon/"+(i-11)+".png"));
				jbutton[i] = new JButton(icon[i]);
				jbutton[i].setContentAreaFilled(false); 
				jbutton[i].setBorderPainted(false);
				jbutton[i].setDisabledIcon(icon[i]);
				jbutton[i].setDisabledSelectedIcon(icon[i]);
			}
		}
		
		int buttionh1=60,buttonw1=20;
		//up-left && up-right buttons
		jbutton[0].setBounds(300, 62,  buttionh1, buttonw1 );
		jbutton[1].setBounds(308, 113, buttionh1, buttonw1 );
		jbutton[2].setBounds(285, 155, buttionh1, buttonw1 );
		jbutton[3].setBounds(273, 225, buttionh1, buttonw1 );
		jbutton[4].setBounds(250, 297, buttionh1, buttonw1 );
		jbutton[5].setBounds( 12, 233, buttionh1, buttonw1 );

		jbutton[6].setBounds(w-330, 15,  buttionh1, buttonw1 );
		jbutton[7].setBounds(w-345, 85,  buttionh1, buttonw1 );
		jbutton[8].setBounds(w-355, 130, buttionh1, buttonw1 );
		jbutton[9].setBounds(w-375, 172, buttionh1, buttonw1 );
		jbutton[10].setBounds(w-370,222, buttionh1, buttonw1 );
		jbutton[11].setBounds(w-75,80,  buttionh1, buttonw1 );		
		
		jbutton0[0] = new JButton("Recently");
		jbutton0[1] = new JButton("Download");
		jbutton0[2] = new JButton("Code");
		jbutton0[3] = new JButton("CourseraF");
		jbutton0[4] = new JButton("PythonF");
		jbutton0[5] = new JButton("Application");
		jbutton0[6] = new JButton("Pmail");
		jbutton0[7] = new JButton("Gmail");
		jbutton0[8] = new JButton("Angel");
		jbutton0[9] = new JButton("Coursera");
		jbutton0[10] = new JButton("Database");
		jbutton0[11] = new JButton("WebApp");
		
		for(int iii=0;iii<12;iii++)
		{
			jbutton0[iii].setForeground(Color.white);
			jbutton0[iii].setFont(new Font(" ", Font.PLAIN, 1));
			jbutton0[iii].setContentAreaFilled(false); 
			jbutton0[iii].setBorderPainted(false);
			jbutton0[iii].setFocusable(false);
			jbutton1[iii] = new JButton(name[iii]);
			jbutton1[iii].setForeground(Color.white);
			jbutton1[iii].setFont(new Font(" ", Font.PLAIN, 9));
			jbutton1[iii].setContentAreaFilled(false); 
			jbutton1[iii].setBorderPainted(false);
			jbutton1[iii].setFocusable(false);
		}
		int buttionh0=100,buttonw0=20;
		int v = 380,wtv=10,wty=8;			
		wtv=10;	
		jbutton1[0].setBounds(290-wty, 441-v, buttionh0, buttonw0);
		jbutton1[1].setBounds(297-wty, 483-v+9, buttionh0, buttonw0);
		jbutton1[2].setBounds(273-wty, 525-v+9,buttionh0, buttonw0);
		jbutton1[3].setBounds(262-wty, 595-v+9, buttionh0, buttonw0);
		jbutton1[4].setBounds(241-wty, 667-v+8,buttionh0, buttonw0);
		jbutton1[5].setBounds(2-wty, 603-v+10,buttionh0, buttonw0);
		jbutton1[6].setBounds(w-340-wty, 15,buttionh0, buttonw0);
		jbutton1[7].setBounds(w-355-wty, 75+wtv,buttionh0, buttonw0);
		jbutton1[8].setBounds(w-366-wty, 120+wtv,buttionh0, buttonw0);
		jbutton1[9].setBounds(w-385-wty, 162+wtv,buttionh0, buttonw0);
		jbutton1[10].setBounds(w-380-wty, 212+wtv,buttionh0, buttonw0);
		jbutton1[11].setBounds(w-90-wty, 70+wtv, buttionh0, buttonw0);
	
		
		for(int iii=0;iii<12;iii++)
		{
			panel.add(jbutton0[iii]);jbutton0[iii].addActionListener(this);
			panel.add(jbutton1[iii]);
			panel.add(jbutton[iii]);		
		}
		jbutton0[0].setBounds(290, 441-v, buttionh0, buttonw0);
		jbutton0[1].setBounds(297, 483-v+9, buttionh0, buttonw0);
		jbutton0[2].setBounds(273, 525-v+9,buttionh0, buttonw0);
		jbutton0[3].setBounds(262, 595-v+9, buttionh0, buttonw0);
		jbutton0[4].setBounds(241, 667-v+8,buttionh0, buttonw0);
		jbutton0[5].setBounds(2, 603-v+10,buttionh0, buttonw0);
		jbutton0[6].setBounds(w-340, 15,buttionh0, buttonw0);
		jbutton0[7].setBounds(w-355, 75+wtv,buttionh0, buttonw0);
		jbutton0[8].setBounds(w-366, 120+wtv,buttionh0, buttonw0);
		jbutton0[9].setBounds(w-385, 162+wtv,buttionh0, buttonw0);
		jbutton0[10].setBounds(w-380, 212+wtv,buttionh0, buttonw0);
		jbutton0[11].setBounds(w-90, 70+wtv, buttionh0, buttonw0);
		
		
		
		//left down && right down buttons

		JButton[] jbutton00; jbutton00 = new JButton[19];
		JButton[] jbutton01; jbutton01 = new JButton[19];
		jbutton00[0] = new JButton("Coffine");
		jbutton00[1] = new JButton("MemClean");
		jbutton00[2] = new JButton("CleanMac");
		jbutton00[3] = new JButton("Player");
		jbutton00[4] = new JButton("AppStore");
		jbutton00[5] = new JButton("LaunchPad");
		jbutton00[6] = new JButton("Terminal");
		jbutton00[7] = new JButton("Eclipse");
		jbutton00[8] = new JButton("Python");
		jbutton00[9] = new JButton("Octave");
		jbutton00[10] = new JButton("Gaphi");
		jbutton00[11] = new JButton("GraphCal");
		jbutton00[12] = new JButton("Anylogic");
		jbutton00[13] = new JButton("Dict");
		jbutton00[14] = new JButton("Sublime");
		jbutton00[15] = new JButton("Pages");
		jbutton00[16] = new JButton("MS.Word");
		jbutton00[17] = new JButton("KeyNote");
		jbutton00[18] = new JButton("PPT");
		for(int iii=0;iii<19;iii++)
		{
			jbutton00[iii].setForeground(Color.white);
			jbutton00[iii].setFont(new Font(" ", Font.PLAIN, 0));
			jbutton00[iii].setContentAreaFilled(false); 
			jbutton00[iii].setBorderPainted(false);
			jbutton00[iii].setFocusable(false);
			jbutton01[iii] = new JButton(name[12+iii]);
			jbutton01[iii].setForeground(Color.white);
			jbutton01[iii].setFont(new Font(" ", Font.PLAIN, 8));
			jbutton01[iii].setContentAreaFilled(false); 
			jbutton01[iii].setBorderPainted(false);
			jbutton01[iii].setFocusable(false);
		}
		int vy=85,gao=90;
		jbutton00[0].setBounds(15, h-475, gao, 20);
		jbutton00[1].setBounds(67, h-475, gao, 20);
		jbutton00[2].setBounds(94, h-428, gao, 20);
		jbutton00[3].setBounds(68, h-383, gao, 20);
		jbutton00[4].setBounds(146, h-335, gao, 20);
		jbutton00[5].setBounds(120, h-288, gao, 20);
		jbutton00[6].setBounds(201, h-243, gao, 20);
		jbutton00[7].setBounds(w-241+vy, h-473, gao, 20);
		jbutton00[8].setBounds(w-188+vy, h-473, gao, 20);
		jbutton00[9].setBounds(w-270+vy, h-428, gao, 20);
		jbutton00[10].setBounds(w-216+vy, h-428, gao, 20);
		jbutton00[11].setBounds(w-295+vy, h-380, gao, 20);	
		jbutton00[12].setBounds(w-242+vy, h-380, gao, 20);	
		jbutton00[13].setBounds(w-321+vy, h-335, gao, 20);
		jbutton00[14].setBounds(w-268+vy, h-335, gao, 20);
		jbutton00[15].setBounds(w-346+vy, h-288, gao, 20);	
		jbutton00[16].setBounds(w-296+vy, h-288, gao, 20);	
		jbutton00[17].setBounds(w-373+vy, h-243, gao, 20);
		jbutton00[18].setBounds(w-322+vy, h-243, gao, 20);
		
		for(int iii=0;iii<19;iii++)
		{
			panel.add(jbutton00[iii]);jbutton00[iii].addActionListener(this);
			panel.add(jbutton01[iii]);
		}
		
		jbutton01[0].setBounds(15, h-475, gao, 20);
		jbutton01[1].setBounds(67, h-475, gao, 20);
		jbutton01[2].setBounds(94, h-428, gao, 20);
		jbutton01[3].setBounds(68, h-383, gao, 20);
		jbutton01[4].setBounds(146, h-335, gao, 20);
		jbutton01[5].setBounds(120, h-288, gao, 20);
		jbutton01[6].setBounds(201, h-243, gao, 20);
		jbutton01[7].setBounds(w-241+vy, h-473, gao, 20);
		jbutton01[8].setBounds(w-188+vy, h-473, gao, 20);
		jbutton01[9].setBounds(w-270+vy, h-428, gao, 20);
		jbutton01[10].setBounds(w-216+vy, h-428, gao, 20);
		jbutton01[11].setBounds(w-295+vy, h-380, gao, 20);	
		jbutton01[12].setBounds(w-242+vy, h-380, gao, 20);	
		jbutton01[13].setBounds(w-321+vy, h-335, gao, 20);
		jbutton01[14].setBounds(w-268+vy, h-335, gao, 20);
		jbutton01[15].setBounds(w-346+vy, h-288, gao, 20);	
		jbutton01[16].setBounds(w-296+vy, h-288, gao, 20);	
		jbutton01[17].setBounds(w-373+vy, h-243, gao, 20);
		jbutton01[18].setBounds(w-322+vy, h-243, gao, 20);
	
		v = 380;
		jbutton[12].setBounds(110, 100, 87, 87); 
		jbutton[13].setBounds(w-205, 143, 87, 87); 
		jbutton[14].setBounds(30, 20, 369, 342);
		jbutton[15].setBounds(w-410, -30, 369, 342);		
		panel.add(jbutton[12]);
		panel.add(jbutton[13]);
		panel.add(jbutton[14]);
		panel.add(jbutton[15]);

		jbutton[16].setBounds(30, h-495, 163, 156);
		jbutton[17].setBounds(w-273, h-356, 163, 156);
		jbutton[18].setBounds(110, h-356, 163, 156);
		jbutton[19].setBounds(w-194, h-495, 163, 156);		
		panel.add(jbutton[16]);
		panel.add(jbutton[17]);
		panel.add(jbutton[18]);
		panel.add(jbutton[19]);

		int setx=w/2+180,sety=h-150;
		jbutton[22].setBounds(w/2-240, sety, 64, 52);
		JButton button42a = new JButton("setting");
        button42a.setForeground(Color.white);
		button42a.setFont(new Font(" ", Font.PLAIN, 0));
        button42a.setContentAreaFilled(false); 
        button42a.setBorderPainted(false);
		panel.add(button42a);button42a.addActionListener(this);
		panel.add(jbutton[22]);
		button42a.setBounds(w/2-240, sety, 64, 52);
		
		jbutton[25].setBounds(setx,sety, 64, 52);
		JButton button5a = new JButton("-");
		button5a.setForeground(Color.white);
		button5a.setFont(new Font(" ", Font.PLAIN, 1));
        button5a.setContentAreaFilled(false); 
        button5a.setBorderPainted(false);
        button5a.setFocusable(false);
		panel.add(button5a);button5a.addActionListener(this);
		panel.add(jbutton[25]);
		button5a.setBounds(setx, sety, 64, 52);
		
		Display timedisplay = new Display();
	    timedisplay.start();
	}

	class ExitButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0){

		}
		
	}
		
	class LandButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
		  
			
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{

	    if(e.getActionCommand()=="Interface")
	    	{
	    		new Interface();
	    	}
	    if(e.getActionCommand()=="ShutDown")
	    {
			URL jarvis4 = this.getClass().getResource("/img/Seeyou.wav");
			audio4 = Applet.newAudioClip(jarvis4); 
	    	audio4.play();
	    	SysteTray.main(null);
	    	min1=1;
	    	dispose();
	    }	    
	    
	    if(e.getActionCommand()=="Recently")
	    {	
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Recently.main(null);
	    }
	    
	    if(e.getActionCommand()=="Download")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Download.main(null);
	    }
	    if(e.getActionCommand()=="Code")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Code.main(null);
	    }
	    if(e.getActionCommand()=="CourseraF")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	CourseraF.main(null);
	    }
	    if(e.getActionCommand()=="PythonF")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	PythonF.main(null);
	    }
	    if(e.getActionCommand()=="Application")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Application.main(null);
	    }
	    if(e.getActionCommand()=="Pmail")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Pmail.main(null);
	    }
	    
	    if(e.getActionCommand()=="Gmail")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Gmail.main(null);
	    }
	    
	    if(e.getActionCommand()=="Angel")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Angel.main(null);
	    }
	    if(e.getActionCommand()=="Coursera")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Coursera.main(null);
	    }
	    if(e.getActionCommand()=="Database")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Database.main(null);
	    }
	    if(e.getActionCommand()=="WebApp")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();

	    	WebApp.main(null);
	    }
	    

	    if(e.getActionCommand()=="Coffine")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Coffine.main(null);
	    }

	    if(e.getActionCommand()=="MemClean")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	MemClean.main(null);
	    }

	    if(e.getActionCommand()=="Player")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Player.main(null);
	    }

	    if(e.getActionCommand()=="CleanMac")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	CleanMac.main(null);
	    }

	    if(e.getActionCommand()=="Terminal")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Terminal.main(null);
	    }

	    if(e.getActionCommand()=="AppStore")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	AppStore.main(null);
	    }
	    
	    if(e.getActionCommand()=="LaunchPad")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	LaunchPad.main(null);
	    }

	    if(e.getActionCommand()=="Eclipse")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Eclipse.main(null);
	    }

	    if(e.getActionCommand()=="Python")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Python.main(null);
	    }

	    if(e.getActionCommand()=="Octave")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Octave.main(null);
	    }

	    if(e.getActionCommand()=="Gaphi")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Gaphi.main(null);
	    }

	    if(e.getActionCommand()=="GraphCal")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	GraphCal.main(null);
	    }

	    if(e.getActionCommand()=="Anylogic")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Anylogic.main(null);
	    }

	    if(e.getActionCommand()=="Dict")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Dict.main(null);
	    }

	    if(e.getActionCommand()=="Sublime")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Sublime.main(null);
	    }
	    
	    if(e.getActionCommand()=="Pages")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	Pages.main(null);
	    }
	    
	    if(e.getActionCommand()=="MS.Word")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	MSWord.main(null);
	    }
	    
	    if(e.getActionCommand()=="KeyNote")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	KeyNote.main(null);
	    }
	    
	    if(e.getActionCommand()=="PPT")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	PPT.main(null);
	    }
	    
	    if(e.getActionCommand()=="-")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	      	SysteTray.main(null);
	    	min1=1;
	    	dispose();
	    }
	    
	    if(e.getActionCommand()=="_")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	shutdown.main(null);
	    }
	    
	    if(e.getActionCommand()==".")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	restart.main(null);
	    }
	    
	    if(e.getActionCommand()==",")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	look.main(null);
	    }
	    if(e.getActionCommand()=="setting")
	    {
	    	double button = 9*Math.random();
			URL jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");			
			if(button<=1){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_1.wav");}
			if(button>1&&button<=2){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_2.wav");}
			if(button>2&&button<=3){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_3.wav");}
			if(button>3&&button<=4){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_4.wav");}
			if(button>4&&button<=5){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_5.wav");}
			if(button>5&&button<=6){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_6.wav");}
			if(button>6&&button<=7){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_7.wav");}
			if(button>7&&button<=8){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_8.wav");}
			if(button>8&&button<=9){
			jarvis2 = this.getClass().getResource("/img/caged_confirm_9.wav");}
			audio2 = Applet.newAudioClip(jarvis2); 
	    	audio2.play();
	    	dispose();
	    	setting.main(null);
	    }
	    
	}
	public class Display extends Thread implements ActionListener 
	{
		public Display()
		{
			//this.panel=panel;
		}
		
		public void run()
		{
			try 
            {
                Thread.sleep(0);
                play();
                
            } catch (InterruptedException e) 
            {
                System.out.println("sleep error!!");
                e.printStackTrace();
            }
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	}
	
	public static void main(String args[]) 
	{
		if(ii==0&&jj==1)
  		{
  		cdM = new cofig();
  		try {cdM.main(ii,jj);} catch (IOException | URISyntaxException e) 
  		{e.printStackTrace();}
  		ii =1;
  		}	
		ii =1;
		try {
			cdsetting = new FollowFocus();
			w = Integer.parseUnsignedInt(name[31]);
			h = Integer.parseUnsignedInt(path[31]);
			JFrame frame = new Interface();
			frame.setVisible(true);			
			AudioClip audio3;
			double welcome = 7*Math.random();
			URL jarvis3 = frame.getClass().getResource("/img/caged_intro_a1.wav");
			if(welcome<=1){
			jarvis3 = frame.getClass().getResource("/img/caged_intro_2.wav");}
			if(welcome>1&&welcome<=2){
			jarvis3 = frame.getClass().getResource("/img/caged_intro_a1.wav");}
			if(welcome>2&&welcome<=3){
			jarvis3 = frame.getClass().getResource("/img/caged_trs9.wav");}
			if(welcome>3&&welcome<=4){
			jarvis3 = frame.getClass().getResource("/img/caged_update_available_0.wav");}
			if(welcome>4&&welcome<=5){
			jarvis3 = frame.getClass().getResource("/img/caged_update_available_1.wav");}
			if(welcome>5&&welcome<=6){
			jarvis3 = frame.getClass().getResource("/img/caged_welcome.wav");}
			if(welcome>6){
			jarvis3 = frame.getClass().getResource("/img/caged_intro_a1.wav");}
			audio3 = Applet.newAudioClip(jarvis3); 
			audio3.play();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}	
	
	public void play() 
    {
    }
	
}


//point with terminal command
class Recently 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
	    p = Runtime.getRuntime().exec("open "+Interface.path[0]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Download 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
			System.out.println("open "+Interface.path[1]);	
		    p = Runtime.getRuntime().exec("open "+Interface.path[1]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Code
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[2]);
	    
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class CourseraF 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[3]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class PythonF 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[4]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Application 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[5]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Pmail 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[6]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Gmail 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[7]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Angel 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[8]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Coursera 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[9]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Database 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[10]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class WebApp 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[11]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}



class Coffine 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[12]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class MemClean 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[13]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}
class CleanMac 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[14]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Player 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[15]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class AppStore 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[16]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class LaunchPad 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[17]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Terminal 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[18]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}


class Eclipse 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[19]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Python
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[20]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}
class Octave 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[21]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Gaphi 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[22]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}
class GraphCal 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[23]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}
class Anylogic 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[24]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Dict 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[25]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}


class Sublime 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[26]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class Pages 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[27]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}


class MSWord 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
		    p = Runtime.getRuntime().exec("open "+Interface.path[28]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class KeyNote 
{
	public static void main(String[] args) {
	   try {
		@SuppressWarnings("unused")
	    Process p = null;
	    p = Runtime.getRuntime().exec("open "+Interface.path[29]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class PPT 
{
	public static void main(String[] args) {
	   try {
		@SuppressWarnings("unused")
	    Process p = null;
	    p = Runtime.getRuntime().exec("open "+Interface.path[30]);
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}


class SysteTray {  
    public static void main(String args[])
    {  
        TrayIcon trayIcon = null;  
        if (SystemTray.isSupported()) 
        {  
            SystemTray tray = SystemTray.getSystemTray();   
            URL imgURL = Interface.class.getResource("/img/tab1.png");  
            Image image = Toolkit.getDefaultToolkit().getImage(imgURL);
            ActionListener listener = new ActionListener() 
            {  
                public void actionPerformed(ActionEvent e) 
                {  
                     
        			JFrame frame = new Interface();
                    frame.setVisible(true); 
                    
                    
                }  
            };  
  
            
            PopupMenu popup = new PopupMenu();  
            MenuItem defaultItem = new MenuItem("Interface");
            defaultItem.addActionListener(listener);             
            MenuItem exitItem = new MenuItem("ShutDown");  
            exitItem.addActionListener(new ActionListener() 
            {  
                public void actionPerformed(ActionEvent e) 
                {  
                    System.exit(0);  
                }  
            });  
            popup.add(defaultItem);  
            popup.add(exitItem);  
            trayIcon = new TrayIcon(image, " ", popup); 
            trayIcon.addActionListener(listener);  
            try {  
            	if(Interface.min1 == 0)
            	{
                tray.add(trayIcon);
            	}
            } catch (AWTException e1) {  
                e1.printStackTrace();  
            }  
        }  
    }  
}  

class look 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
	    p = Runtime.getRuntime().exec("CMD.exe /C start taskmgr");
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class setting 
{
	static main.FollowFocus cdsetting;
	@SuppressWarnings("static-access")
	public static void main(String[] args) 
	{		
		cdsetting.main(null);
   }
}

class shutdown 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
	    p = Runtime.getRuntime().exec("sudo halt");
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}

class restart 
{
	public static void main(String[] args) {
	   try {
			@SuppressWarnings("unused")
		    Process p = null;
	    p = Runtime.getRuntime().exec("sudo reboot");
	   } catch (Exception e) 
	   {
	    e.printStackTrace();
	   }	
   }
}
