package week4;

import acm.program.GraphicsProgram;
import acm.graphics.GImage;
import acm.program.*;

/* this program takes the famous milkmaid painting and flips it horizontally*/
public class ImageProcessing extends GraphicsProgram {

	public void run() {
		GImage image = new GImage("milkmaid.jpg");
		GImage flipHorizontalImage = createFlipHorizontalImage(image);
		
		//image.scale(1.0);
		//add(image, 10, 50);
		
		flipHorizontalImage.scale(1.0);
		add(flipHorizontalImage, 200, 50);
		
	}

	
	/*creates the fliphorizontal version of the original image */
	private GImage createFlipHorizontalImage(GImage image) {
		/* gets copy of pixel array from image*/
		int[][] array = image.getPixelArray();
		
		
		int height = array.length; /* number of rows in grid */
	
		
		int [][] newarray = new int [height][];
		
		for (int x = 0; x < height; x++) {
			int width = array[x].length; /* number of columns in a row */
			newarray [x] = new int[width];
			for (int y = 0; y < width; y++) {
				int pixel = array[x][y];
				newarray[x][width - y - 1] = pixel;
		}
		}
		GImage newimage = new GImage(newarray);
		return newimage;
	}
}
