
public class TimingThread extends Thread{
		
	public ATM_GUI gui;
	public boolean timing_done;
	private int secounds;

	public void run() {
        
        // Loop for ten iterations.
        
            
            // Sleep for a while
            try {
            	timing_done = false;
            	//secounds = 0;
            	for(int i = 0; i< 1 ;i ++) {
            		//secounds++; 
            		Thread.sleep(8000);
            	}
            	if(timing_done == false)
            		gui.clearData();
            		
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
