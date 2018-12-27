package controlador;

import mundo.BouncingBall;
import interfaz.PanelCommands;
import interfaz.PanelGame;

public class Controlador 
{
 // Atributos de instancia
	private boolean paused;
	
 // Relaciones	
	private BouncingBall bouncingBall;
    private PanelCommands pnlCommands;
    private PanelGame pnlGame;
    private int a =0,v=1,f=1,ca=0,color;
    private boolean pau;
    
	public Controlador()
	{ 
		bouncingBall = new BouncingBall();
		paused = false;
	}
	
	public void conectar(PanelCommands pnlCommands, PanelGame pnlGame)
	{ 
	  this.pnlCommands=pnlCommands;
	  this.pnlGame=pnlGame;
	  bouncingBall.initThread(this);
	}
	
	public void keyPressed(int key)
	{ if (!paused) pnlGame.keyPressed(key);	
	}

	public void pause() throws InterruptedException
	{ bouncingBall.pause(); paused = !paused;	
	}
	
    public void moveBall(int left, int top)
    {
    	pnlGame.setBall(left, top);
	}
    
    public void moveBlock(int x) { bouncingBall.setBlock(x); }
    
    public void setQuitacarita(int a)
    {
    	//System.out.println(a);
    	if(a==6)
    	{
    		f=2;
    		pnlCommands.setCaritav6();
    		ca=5;
    		setColor(3);
    		bouncingBall.setcarita2(ca);
    		bouncingBall.setSleep(6);
    		//System.out.println(ca);
    	}
    	else if(a==5)
    	{
    		f=3;
    		pnlCommands.setCaritav5();
    		ca=4;
    		setColor(2);
    		bouncingBall.setSleep(7);
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if(a==4)
    	{
    		f=4;
    		pnlCommands.setCaritav4();
    		ca=3;
    		bouncingBall.setSleep(8);
    		setColor(1);
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if(a==3)
    	{
    		f=5;
    		pnlCommands.setCaritav3();
    		ca=2;
    		setColor(4);
    		bouncingBall.setSleep(9);
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if(a==2)
    	{
    		f=6;
    		pnlCommands.setCaritav2();
    		ca=1;
    		setColor(2);
    		bouncingBall.setSleep(10);
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if(a==1)
    	{
    		f=7;
    		pnlCommands.setCaritav1();
    		ca=0;
    		setColor(6);
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if (a==5)
    	{
    		f=2;
    		pnlCommands.setCaritav5();
    		ca=4;
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if (a==4)
    	{
    		f=3;
    		pnlCommands.setCaritav4();
    		ca=3;
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if (a==3)
    	{
    		f=4;
    		pnlCommands.setCaritav3();
    		ca=2;
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if (a==2)
    	{
    		f=5;
    		pnlCommands.setCaritav2();
    		ca=1;
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if (a==1)
    	{
    		f=6;
    		pnlCommands.setCaritav1();
    		ca=0;
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if (a==4)
    	{
    		f=2;
    		pnlCommands.setCaritav4();
    		ca=3;
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if (a==3)
    	{
    		f=3;
    		pnlCommands.setCaritav3();
    		ca=2;
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if (a==2)
    	{
    		f=4;
    		pnlCommands.setCaritav2();
    		ca=1;
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if (a==1)
    	{
    		f=5;
    		pnlCommands.setCaritav1();
    		ca=0;
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    		
    	}
    	else if (a==3)
    	{
    		f=2;
    		pnlCommands.setCaritav3();
    		ca=2;
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if (a==2)
    	{
    		f=3;
    		pnlCommands.setCaritav2();
    		ca=1;
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    	}
    	else if (a==1)
    	{
    		f=4;
    		pnlCommands.setCaritav1();
    		ca=0;
    		bouncingBall.setcarita2(ca);
    		//System.out.println(ca);
    		
    	}
    	
    }
    
    public void setPonercara(int h)
    {
    	
    	if(h==2)
    	{
    		pnlCommands.setCarita2();
    	}
    	else if(h==3)
    	{
    		pnlCommands.setCarita3();
    	}
    	else if(h==4)
    	{
    		pnlCommands.setCarita4();
    	}
    	else if(h==5)
    	{
    		pnlCommands.setCarita5();
    	}
    	else if(h==6)
    	{
    		pnlCommands.setCarita6();
    	}
    	else if(h==9)
    	{
    		pnlCommands.setCarita1();
    	}
    }
    
    public void setPuntaje(int a){ 
    	
    	pnlCommands.setPuntaje(a+"");
    	//System.out.println(a);
    }
    public void setPuntajefinal(int c)
    {
    	pnlGame.setGameover();
    	pnlGame.setPuntajefinal(c+"");
    }
    public void setQuitarPuntaje()
    {
    	pnlGame.setGameoverv();
    	pnlGame.setPuntajefinal(null);
    }
    public void setColor(int c)
    {
    	color=c;
    	pnlGame.setColor(color);
    }
}

