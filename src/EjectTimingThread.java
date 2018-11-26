/**
 * 
 */

/**
 * @author Miniphee
 *
 */
public class EjectTimingThread extends Thread {
	
	public ATM_GUI gui;
	public void run() {        
            
     
            try {
            	
            	Thread.sleep(5000);
            	gui.Welcome();
            	
               
            } catch (InterruptedException e) {
                // Interrupted exception will occur if
                // the Worker object's interrupt() method
                // is called. interrupt() is inherited
                // from the Thread class.
            	
            }
        
    }
}
