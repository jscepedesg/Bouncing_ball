package mundo;

public class Ball implements Runnable
{
	
// Atributos de instancia	
   private boolean paused, stopped;
   private int mseg;

// Relacion con el mundo
   private BouncingBall bouncing;

   public Ball(BouncingBall bouncingBall)
   { 	this.paused = this.stopped = false;
   		this.bouncing=bouncingBall;
     
   }
   
   public void setSleep(int mseg) { this.mseg = mseg; }
   
   public void start(int mseg)
   { new Thread(this, "Player").start(); this.mseg = mseg; }
   
   public synchronized void pause() 
   { if (paused) resume();
     else paused = true;
    
   }

   public synchronized void resume()
   { paused = false; notify(); } 
   
   public synchronized void stop() 
   { stopped = true; notify(); }
   
   public void run()
   { while (!stopped)
     { try 
       { synchronized (this) 
	     { if (paused) 
	       {   wait(); }
	     }
         Thread.sleep(this.mseg); 
         bouncing.move();				// Metodo que actualiza el mundo 
       } 
       catch (InterruptedException ex)
       { System.out.println(ex);
       }
     }    
   }
}
