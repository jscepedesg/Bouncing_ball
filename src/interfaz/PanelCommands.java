package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import mundo.BouncingBall;

public class PanelCommands extends JPanel
{
	
	private static final String BLOCK = "imagenes/Carita.png";
	
  // Atributos de instancia 		
	 private JSpinner spnTimer;
	 private SpinnerNumberModel mdlTimer;
     private JLabel lblScore,lblcarita1,lblcarita2,lblcarita3,lblcarita4,lblcarita5,lblcarita6;
     private ImageIcon carita;
     private int q=1,v=0;

  // Constructor   
	 public PanelCommands(  ) 
	 {   	
	// ..............................................( T, L, B, R ).............................................
	   setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new TitledBorder( "" ) ) );
	   setLayout( null );
	   setBackground(Color.GRAY.darker().darker().darker());
	// Instancia los componentes   
      /* mdlTimer = new  SpinnerNumberModel(50, 1, 200, 1);
       spnTimer = new JSpinner( mdlTimer );  spnTimer.setOpaque(true);      
       spnTimer.setBounds(05, 3, 40, 18);
       spnTimer.setEnabled(false);*/
	  
	   
	   
		   lblcarita1 = new JLabel();
		   carita = new ImageIcon( BLOCK );
		   lblcarita1.setIcon( carita );
		   lblcarita1.setBounds(05, 3, 40, 18);
		   
	  
		   
		   lblcarita2 = new JLabel();
		   carita = new ImageIcon( BLOCK );
		   lblcarita2.setIcon( carita );
		   lblcarita2.setBounds(30, 3, 40, 18);
		   
	  
	   
	   
		   lblcarita3 = new JLabel();
		   carita = new ImageIcon( BLOCK );
		   lblcarita3.setIcon( carita );
		   lblcarita3.setBounds(55, 3, 40, 18);
		   
		   lblcarita4 = new JLabel();
		   carita = new ImageIcon( BLOCK );
		   lblcarita4.setIcon( null );
		   lblcarita4.setBounds(80, 3, 40, 18);
		   
		   lblcarita5 = new JLabel();
		   carita = new ImageIcon( BLOCK );
		   lblcarita5.setIcon( null );
		   lblcarita5.setBounds(105, 3, 40, 18);
		   
		   lblcarita6 = new JLabel();
		   carita = new ImageIcon( BLOCK );
		   lblcarita6.setIcon( null );
		   lblcarita6.setBounds(130, 3, 40, 18);
	   
	  
	   
	   
       lblScore = new JLabel("0");
       Font auxFont=lblScore.getFont();
       lblScore.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
       lblScore.setForeground(Color.YELLOW);
       lblScore.setHorizontalAlignment( JLabel.RIGHT );
       lblScore.setBounds(305, 4, 35, 20);
       
	// Agrega los atributos al panel   
       add( lblcarita1 );add(lblcarita2);add(lblcarita3);add(lblcarita4);add(lblcarita5);add(lblcarita6);
	   add( lblScore );        
	 }
	 
  // Metodos de la clase
	 public void activarTimer()
	 { spnTimer.setEnabled( true );
	 }
	    
	 public int getTimer()
	 { return mdlTimer.getNumber().intValue();
	 }
	 
	 public void setCarita1 ( )   { lblcarita1.setIcon(new ImageIcon("imagenes/Carita.png")); }
	 public void setCarita2 ( )   { lblcarita2.setIcon(new ImageIcon("imagenes/Carita.png")); }
	 public void setCarita3 ( )   { lblcarita3.setIcon(new ImageIcon("imagenes/Carita.png")); }
	 public void setCarita4 ( )   { lblcarita4.setIcon(new ImageIcon("imagenes/Carita.png")); }
	 public void setCarita5 ( )   { lblcarita5.setIcon(new ImageIcon("imagenes/Carita.png")); }
	 public void setCarita6 ( )   { lblcarita6.setIcon(new ImageIcon("imagenes/Carita.png")); }
	 
	 public void setCaritav1 ( )   { lblcarita1.setIcon(new ImageIcon("")); }
	 public void setCaritav2 ( )   { lblcarita2.setIcon(new ImageIcon("")); }
	 public void setCaritav3 ( )   { lblcarita3.setIcon(new ImageIcon("")); }
	 public void setCaritav4 ( )   { lblcarita4.setIcon(new ImageIcon("")); }
	 public void setCaritav5 ( )   { lblcarita5.setIcon(new ImageIcon("")); }
	 public void setCaritav6 ( )   { lblcarita6.setIcon(new ImageIcon("")); }
	 
	 public void setPuntaje(String puntaje)   { lblScore.setText(puntaje); }
}
