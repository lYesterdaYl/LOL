import java.awt.*;

import javax.swing.*;
import java.awt.event.*;


public class LOLTimer extends JFrame{
    private JButton blue, red,dragon,baron;
    private JLabel bluecount,redcount,dragoncount,baroncount, creater;
    private Timer timer;
    public LOLTimer(){
    	setLayout(new GridLayout(5,4,1,1));
    	setBackground(Color.WHITE);
    //	setUndecorated(true);

    	
    	blue = new JButton("Blue");
    	add(blue);    	
    	bluecount = new JLabel("Waiting");
        add(bluecount);
        bluecount.setForeground(Color.BLACK);
    	
    	red = new JButton("Red");
    	add(red);
    	redcount = new JLabel("Waiting");
        add(redcount);
        redcount.setForeground(Color.BLACK);

    	ImageIcon dragon1 = new ImageIcon("lol_dragon.jpg");
        dragon = new JButton("Dragon"/*,dragon1*/);
        add(dragon);
        dragoncount = new JLabel("Waiting");
        add(dragoncount);
        dragoncount.setForeground(Color.BLACK);

        
        baron = new JButton("Baron");
        add(baron);
        baroncount = new JLabel("Waiting");
        add(baroncount);
        baroncount.setForeground(Color.BLACK);

        
/*        creater = new JLabel("Made by Oliver Du");
        creater.setForeground(Color.BLACK);        
		add(creater);*/
                
        event e = new event();
        blue.addActionListener(e);
        red.addActionListener(e);
        dragon.addActionListener(e);
        baron.addActionListener(e);
        
    }
    public class event implements ActionListener{
    public void actionPerformed(ActionEvent e){
    	int blue1 = 0,red1 = 0, dragon1 = 0, baron1 = 0;
    if (e.getSource()== blue){
	blue1 = 300;
	bluecount.setText("Time Left: "+ blue1/60+":"+blue1%60);
	}else if (e.getSource()== red){
    	red1 = 300;
    	redcount.setText("Time Left: "+ red1/60+":"+red1%60);
    }else if (e.getSource()== dragon){
    	dragon1 = 360;
    	dragoncount.setText("Time Left: "+ dragon1/60+":"+dragon1%60);
    }else if (e.getSource()== baron){
        	baron1 = 420;
        	baroncount.setText("Time Left: "+ baron1/60+":"+baron1%60);
    }
	
	TimeClass tc = new TimeClass(blue1,red1,dragon1,baron1);
	timer = new Timer(1000, tc);
	timer.start();
             }
    	}
    
    public class TimeClass implements ActionListener{
    	int bluecounter,redcounter,dragoncounter,baroncounter;
    	
    	public TimeClass(int bluecounter,int redcounter, int dragoncounter, int baroncounter) {
    		this.bluecounter = bluecounter;		
    		this.redcounter = redcounter;		
    		this.dragoncounter = dragoncounter;		
    		this.baroncounter = baroncounter;		

    		}
		
    	public void actionPerformed(ActionEvent tc){
    		bluecounter--;
    		redcounter--;
    		dragoncounter--;
    		baroncounter--;
    		
    		if(bluecounter >0){
    			bluecount.setText("Timer left: " + bluecounter/60+":"+bluecounter%60);
    		}else if(redcounter >0){
    			redcount.setText("Timer left: " + redcounter/60+":"+redcounter%60);
    		}else if(dragoncounter >0){
    			dragoncount.setText("Timer left: " + dragoncounter/60+":"+dragoncounter%60);
    		}else if(baroncounter>0){
    			baroncount.setText("Timer left: " + baroncounter/60+":"+baroncounter%60);
    		}else if(bluecounter == 0){
    			bluecount.setText("Done");
    			Toolkit.getDefaultToolkit().beep();
    		}else if(redcounter == 0){
    			redcount.setText("Done");
    			Toolkit.getDefaultToolkit().beep();
    		}else if(dragoncounter == 0){
    			dragoncount.setText("Done");
    			Toolkit.getDefaultToolkit().beep();
    		}else if(baroncounter == 0){
    			baroncount.setText("Done");
    			Toolkit.getDefaultToolkit().beep();
    		}
    	}
    	
    }


public static void main(String[] args) throws Exception {
	JFrame LOLTimer = new LOLTimer();
	   LOLTimer.setTitle("LOL Timer");
	   LOLTimer.setSize(300,200);
	   LOLTimer.setVisible(true);
	   LOLTimer.setAlwaysOnTop(true);
	   LOLTimer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	   
	   LOLTimer.setLocationByPlatform(true);
}

	
}

