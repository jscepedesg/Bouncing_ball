package mundo;
import java.awt.Color;

import controlador.Controlador;
import interfaz.PanelCommands;

public class BouncingBall 
{
 // Atributos de instancia
	private int x, y, lrud,x1,a=0,b,g,color,v;
	private int c=0,i=1,p=100,j,t=0,s;
	private String game[][];
	private boolean ver;
	
 // Relaciones	
	private Ball ball;
	private Controlador ctrl;
	
	/*
	 * Constructor
	 */
    public BouncingBall()
    {	s=1;color=1;
    	x = 200; y = 1; lrud = 1;x1=1;j=3;p=100;ver=true;
      game = new String[350][300];
    }
    
    public void setSleep(int mseg) { ball.setSleep(mseg); }
    public void setBlock(int x) {game[x][298] = "Block";b=x;}
    
    public void initThread(Controlador controlador)
    { 
    	this.ctrl=controlador;
    	 ball = new Ball(this);
    		 ball.start(5);
    }
    
    public void pause()
    { 
    	if(t==1)
    	{
    		c=0;
    		p=100;
    		a=0;
    		x1=1;
    		x=200;
    		y=1;
    		t=0;
    		j=3;
    		i=1;
    		lrud = 1;
    		ver=true;
    		ctrl.setPonercara(9);
    		ctrl.setPonercara(2);
    		ctrl.setPonercara(3);
    		ctrl.setPuntaje(c);
    		ctrl.setQuitarPuntaje();
    		ball.pause();
    		
    	}
    	ball.pause();
    	
    
    }
    
    public void move()
    { if (lrud == 1) rightDown();
      else
      if (lrud == 2) rightUp();
      else
      if (lrud == 3) leftUp();
      else
      if (lrud == 4) leftDown();
    }
    
    /* --------------------------------------------------
     * minTop 1; maxbotton 253; minleft 1; maxRight  309 
     * -------------------------------------------------- 
     */
    
    private void rightDown() // (1)
    {
    	 if(x<309&&y<253)//253
    	{	x++;
    		y++;
    		ctrl.moveBall(x, y);
    		//System.out.println(x+" one 1  "+y+" "+x1);
    	}
    	
    	else if(x==309)
    	{	//System.out.println(x+" one 2  "+y+" "+x1);
    		if(x1==2)
    		{
    			x1=3;
    		}
    		
    		lrud = 4;
    		leftDown();
    	}
    	else if(y==253)
    	{	//System.out.println(x+" one 3  "+y+" "+x1);
    		x1=2;
    		//System.out.println(x+" one 4  "+y+" "+x1);
    		lrud = 4;
    		//if(a==2)
    		//{
    		//	crash();
    		//}
    		//System.out.println(x+" - "+y);
    		y=y-13;
    		bounce();
    		leftDown();
    	}
    	
    	
    	
    }
    
    private void rightUp() // (2)	 
    { 
    	if(y>0&&x1==1&&x>0)
    	{	
    		x--;
    		y--;
    		ctrl.moveBall(x, y);
    		//System.out.println(x+" two 1 "+y+" "+x1);
    	}
    	else if(y==0)
    	{	//System.out.println(x+"two 2"+y+" "+x1);
    		lrud = 3;
    		 leftUp();
    	}
    	if(x>0&&x1==2&&y<253)
    	{	x--;
    		y++;
    		ctrl.moveBall(x, y);
    		//System.out.println(x+" two 3 "+y+" "+x1);
    	}
    	else if(x1==2&&y==253)
    	{	x1=1;
    		lrud = 2;
    		//System.out.println(x+" two 4 "+y+" "+x1);
    		//if(a==1)
    		//{
    			//crash();
    		//}
    		//System.out.println(x+" - "+y);
    		y=y-13;
    		bounce();
    		rightUp();
    	}
    	else if(x==0)
    	{	lrud = 4; 
    		leftDown();
    	}
    }
    
    private void leftUp() // (3)
    { 
    	
    	if(x>0&&y<253)
    	{	x--;
    		y++;
    		ctrl.moveBall(x, y);
    		//System.out.println(x+" three 1 "+y+" "+x1);
    	}
    	else if(x==0)
    	{	//System.out.println(x+" three 2 "+y+" "+x1);
    		x1=2;
    		lrud = 1;	
    	}
    	else if(y==253)
    	{	lrud = 2;
    		//System.out.println(x+" - "+y);
    		y=y-13;
    		bounce();
    		rightUp();
    	}
    	
    }
    
    private void leftDown() // (4)
    { //System.out.println(x1);
    	if(y<253&& x1==1&&x>0)
    	{	x--;
    		y++;
    		ctrl.moveBall(x, y);
    		//System.out.println(x+" four  1 "+y+" "+x1);
    	}
    	else if(y==253&&x1==1)
    	{	//System.out.println(x+" four 2 "+y+" "+x1);
    		lrud = 2;
    		//crash();
    		//System.out.println(x+" - "+y);
    		 y=y-13;
    		 bounce();
    		rightUp();
    	}
    else if(y<=253&&x1==2&&x<309&&y>0)
    	{	//System.out.println(x1);
    		x++;
    		y--;
    		ctrl.moveBall(x, y);
    		//System.out.println(x+" four 3 "+y+" "+x1);
    	}
     else if(x==309&&x1==2)
       {	x1=1;
    		lrud = 2;
    		rightUp();
       }
     else if(y==0&&x1==2)
       {	lrud = 1;
     		rightDown();//g
       }
     else if(y>0&&x1==3)
     {	lrud = 2;
    	x1=2;
    	rightUp();
     }
     else if(x==0&&x1==1)
     {	x1=2; }
    	
  	
   }
    
    
    /**
     * Rebota en bloque inferior, incrementa puntuación.
     */
    public void bounce()
    { 
    	 
    	
    	 v=x-b;
    	//System.out.println("Hola "+c+" "+b+" "+v);
    	if(v>-26&&v<20)
    	{
    		c+=50;    		
    		System.out.println(s);
    		s=6;
    	
    		if(j==3&&p==c)
    		{
    			p+=100;
    			j=4;
    			color=1;
    			setSleep(8);
    			ctrl.setColor(color);
    			ctrl.setPonercara(j);
    		}

    		else if(j==4&&p==c)
    		{
    			p+=100;
    			j=5;
    			color=2;
    			setSleep(7);
    			ctrl.setColor(color);
    			ctrl.setPonercara(j);
    		}
    		 else if(j==5&&p==c)
    		{
    			p+=100;
    			j=6;
    			color=3;
    			setSleep(6);
    			ctrl.setColor(color);
    			ctrl.setPonercara(j);
    		}
    		 else if(j==2&&c>=100&&p==c)
    		 {
    			p+=100;
    			j=3;
    			color=4;
    			setSleep(9);
    			ctrl.setColor(color);
    			ctrl.setPonercara(j);
    		 }
    		 else if(j==1&&c>=100&&p==c)
    		 {
    			 p+=100;
    			 j=2;
    			 color=3;
    			 setSleep(10);
    			 ctrl.setColor(color);
    			 ctrl.setPonercara(j);
    		 }
    		 else if(j==6&p==c)
    		 {
    			 color=6;
    			 setSleep(4);
    			 ctrl.setColor(color);
    			 p+=100;
    		 }
    		
    		
    		
    		
    		
    		 
    		
    		ctrl.setPuntaje(c);
    		System.out.println(p);
    	}
    	else
    	{
    		if(j==1)
    		{
    			setPuntajefinal();
    			
    			
    		}
    		crash();
    		
    		//System.out.println("Mal");
    	}
    	
    	
    }
    
    /**
     * Disminuye una vida.
     */
    public void crash()
    {
    	x=150;
    	y=0;
      ctrl.setQuitacarita(j);
   	//System.out.println("Crash...."+i);
    }
    public void setcarita2(int j)
    {
    	
    	this.j=j;
    	System.out.println(j);
    	
    }
    public void setPuntajefinal()
    {
    	t=1;
    	ball.pause();
    	ctrl.setPuntajefinal(c);
    	System.out.println("Perdiste: "+c);
    }
   
    
    

}
