package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	public void run() {
		while (frontIsClear()) {
			move();
		
		if (beepersPresent()) {
	
			turnRight(); //triedthis
			move();
		}else{
			turnRight(); //triedthis
			move();
			while (beepersPresent()) {
			pickBeeper();
			}
			turnAround(); //triedthis
			move();
			move();
			while (beepersPresent()) {
				pickBeeper();
			}
			turnAround(); //tried this
			move();
			while (beepersPresent()) {
				pickBeeper();
			}
			turnLeft();
			move();
		}
			
		if (beepersPresent()) {
				turnAround(); //triedthis
				move();
				move();
			}else {
				turnAround(); //triedthis
				move();
				move();
				while (beepersPresent()) {
					pickBeeper();
					turnAround(); //triedthis
					move();
				while (beepersPresent()) {
					pickBeeper();
				}
					turnLeft(); //triedthis
					move();
				}
			}
			if (beepersPresent()) {
				turnAround(); //triedthis
				move();
				turnLeft(); //triedthis
				move();
				} else { 
				turnAround();  //tried this
				move();
				move();
				while (beepersPresent()) {
					pickBeeper();
					turnAround(); //tried this
					move();
				}
				while (beepersPresent()) {
					pickBeeper(); 
					turnRight();
					move();
				}
	}
}
}
}