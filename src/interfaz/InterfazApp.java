package interfaz;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controlador.Controlador;
import win.Win;


public class InterfazApp extends JFrame 
{
 // Atributos
	private PanelGame pnlGame;
	private PanelCommands pnlCommands;
	
 // Atributo controlador
	Controlador Ctrl;
 // Constructor
    public InterfazApp(Controlador Ctrl) 
    { setTitle( "Bouncing ball." );  
   	  getContentPane( ).setLayout( null );
   	
   	//Icono JFrame
   			Toolkit mipantalla=  Toolkit.getDefaultToolkit();
   			Image MiIcono=mipantalla.getImage("imagenes/O.png");//Icono
   			setIconImage(MiIcono);
   			
   // Integra el Controlador. 
   	  this.Ctrl=Ctrl;
   // Instancia los paneles 
      pnlGame    = new PanelGame(Ctrl);
      pnlGame.setBounds(1, 1, 350, 300);
      pnlGame.setFocusable(true);
      pnlCommands = new PanelCommands();
      pnlCommands.setBounds(1, 301, 350, 28);
   	        
   // Organizar el panel principal. 
      getContentPane( ).add( pnlGame ); 
      getContentPane( ).add( pnlCommands );
      
   // Conecta objetos al controlador.
      Ctrl.conectar(pnlCommands,pnlGame);
      
   // Propiedades de la interfaz.   
      setSize( 358, 352 );
      setResizable( false );
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   
  //  Centrar ventana.
      Win.centrarVentana( this );
    }    
    
//  Ejecucion.		
    public static void main(String args[])
    { InterfazApp frmMain = new InterfazApp( new Controlador());
      frmMain.setVisible( true );	  
    }
}
 