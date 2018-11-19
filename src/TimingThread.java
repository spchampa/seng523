
public class TimingThread extends Thread{
		
	public boolean timing_done;
	private int secounds;
	@SuppressWarnings("deprecation")
	public void run() {
        
        // Loop for ten iterations.
        
            
            // Sleep for a while
            try {
            	timing_done = false;
            	secounds = 0;
            	for(int i = 0; i< 3 ;i ++) {
            		secounds++; 
            		Thread.sleep(3000);
            	}
            	
            		timing_done = true;
            		
            		//this is important
            		//this.notify();
               
            } catch (InterruptedException e) {
                // Interrupted exception will occur if
                // the Worker object's interrupt() method
                // is called. interrupt() is inherited
                // from the Thread class.
            }
        
    }
}
