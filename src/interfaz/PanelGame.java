package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

public class PanelGame extends JPanel
{

 // Constantes
	private static final String BLOCK = "imagenes/Block.gif";
	private static final String BALL = "imagenes/O.png";
	private static final String Game = "imagenes/Gameover.png";
	
 // Atributos de instancia 		
    private JLabel lblBlock, lblBall,lblGameOver,lblPuntaje;
    private int left;
    private ImageIcon imgBlock, imgBall,Gameover;
    private KeyBoardEvent keyEvent;
    private Controlador ctrl;
    private int color;
    
 // Constructor   
    public PanelGame(Controlador ctrl) 
    {   	
    // ..............................................( T, L, B, R ).............................................
       setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
       setLayout( null );
       this.setBackground(Color.white);
	
       setBackground(Color.GRAY.darker().darker().darker().darker());
    // Integra el Controlador   
      this.ctrl=ctrl;
       
    // Instancia los JLabel
       left = 1;
       lblBlock = new JLabel();
       imgBlock = new ImageIcon( BLOCK );
       lblBlock.setIcon( imgBlock );
       lblBlock.setBounds(left, 283, 20, 15); //282
       add( lblBlock );
       
       lblBall  = new JLabel();
       imgBall  = new ImageIcon( BALL );
       lblBall.setIcon( imgBall );
       lblBall.setBounds(1, 1, 50, 50);
       add( lblBall );
       
       lblGameOver = new JLabel();
	   Gameover = new ImageIcon( Game );
	   lblGameOver.setIcon( null );
	   lblGameOver.setBounds(25, 70, 250, 80);
       add(lblGameOver);
       
       lblPuntaje = new JLabel();
       Font auxFont=lblPuntaje.getFont();
       lblPuntaje.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 35));
       lblPuntaje.setForeground(Color.YELLOW);
       lblPuntaje.setBounds(158, 150, 150, 50);
       add(lblPuntaje);
       
       keyEvent = new KeyBoardEvent(ctrl);
       addKeyListener(keyEvent);

    }
    
    public void setBall(int left, int top)
    { 
    	
    	lblBall.setBounds(left, top, 50, 50);
    } 
    public void setGameover ( )   { lblGameOver.setIcon(new ImageIcon("imagenes/Gameover.png")); }
    public void setGameoverv ( )   { lblGameOver.setIcon(new ImageIcon("")); }
    public void setPuntajefinal(String puntaje)   { lblPuntaje.setText(puntaje); }
    
    public void setColor(int a)
    {
    	color=a;
    	if(color==1)
    	{
    		setBackground(Color.BLUE);
    	}
    	else if(color==2)
    	{
    		setBackground(Color.GRAY);
    	}
    	else if(color==3)
    	{
    		setBackground(Color.GREEN);
    	}
    	else if(color==4)
    	{
    		setBackground(Color.YELLOW.darker());
    	}
    	else if(color ==6)
    	{
    		setBackground(Color.GRAY.darker().darker().darker().darker());
    	}
    }
    public void keyPressed(int key)
    { if (key == 39) // move right
      {   if (left < 326)
    	      left+=5;
    	  lblBlock.setBounds(left, 283, 20, 15);
    	  ctrl.moveBlock(left);
      }
      else
      if (key == 37) // move left	  
      {   if (left > 3)
    	      left-=5;
    	  lblBlock.setBounds(left, 283, 20, 15);
    	  ctrl.moveBlock(left);
      }
    }
}


class KeyBoardEvent implements KeyListener
{
	private Controlador ctrl;
	
    public KeyBoardEvent(Controlador ctrl) 
    { this.ctrl = ctrl;    	
    }
    
	public void keyPressed(KeyEvent e) 
	{ if (e.getKeyCode() == 37 || e.getKeyCode() == 39) 
	  {    ctrl.keyPressed(e.getKeyCode());
	  }
	  else
	  if (e.getKeyCode() == 32)
	  {	  try { ctrl.pause(); }
	      catch (InterruptedException ex)
	      { }
	  }	
	}
	
	

	public void keyReleased(KeyEvent e) 
	{ // No hacer nada, no se esta utlizando pero deben estar aquí!!
	}

	public void keyTyped(KeyEvent e) 
	{ // No hacer nada, no se esta utlizando pero deben estar aquí!!
	}	
}