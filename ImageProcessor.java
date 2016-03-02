/* Put your ImageProcessor class here */
//Shivani Upadhayay
//supadhayay3@gatech.edu / 903133182
//I worked on this assignment alone, using only this semester's course materials 

public class ImageProcessor {

	private static int width;
	private static int height;
    private static Pic pic;

	public ImageProcessor(Pic pic) {
		this.pic = pic; 
		width = pic.getWidth();
		height = pic.getHeight();
	}

	public static Pic chroma(Pixel key, int dr, int dg, int db) {
		int col, row;
		Pixel pixel1;
		Pic newPic1 = pic.deepCopy();
		Pixel pixel2;

		for (col =0; col < width; ++col) {
			for (row = 0; row < height; ++row) {
				pixel1 = pic.getPixel(col, row); 

				boolean testRed;
				boolean testGreen;
				boolean testBlue;

				testRed = (pixel1.getRed() - key.getRed() < dr);
				testGreen = (pixel1.getGreen() - key.getGreen() < dg);
				testBlue = (pixel1.getBlue() - key.getBlue() < db);
				pixel2 = newPic1.getPixel(col, row);

				if ((testRed && testGreen && testBlue)) {
					pixel2.setAlpha(0);

				}

			}

		}

		return newPic1;
	}

	public static Pic background(Pic bg) {

		Pic result = pic.deepCopy();
		Pixel outcome;
		Pixel pixel2;

		for (int col = 0; col < width; ++col) {
			for (int row = 0; row < height; ++row) {
				outcome = bg.getPixel(col, row);
				pixel2 = result.getPixel(col, row);
				if (pixel2.getAlpha() == 0) {
					pixel2.setRed(outcome.getRed());
					pixel2.setGreen(outcome.getGreen());
					pixel2.setBlue(outcome.getBlue());
					pixel2.setAlpha(outcome.getAlpha());

				}
			}
		}
	
	return result;

	}

	public Pic greyScale() {
		int rVal, gVal, bVal, grey;
		
		Pic change = pic.deepCopy();
		Pixel pixel2;

		for (int col = 0; col < width; ++col) {
			for (int row = 0; row < height; ++row) {
				Pixel pixel1 = pic.getPixel(col, row);

				rVal = pixel1.getRed();
				gVal = pixel1.getGreen();
				bVal = pixel1.getBlue();
				grey = (rVal + gVal + bVal)/3;

				pixel2 = change.getPixel(col, row);

				pixel2.setRed(grey);
				pixel2.setGreen(grey);
				pixel2.setBlue(grey);

			}

		}

		return change;

	}

	public Pic invert() {

		Pixel pixel1;
		int rr, gg, bb;
		
		Pic change = pic.deepCopy();
		Pixel pixel2;

		for (int col =0; col < width; ++col){
			for (int row = 0; row < height; ++row){
				pixel1 = pic.getPixel(col, row);

				rr = pixel1.getRed();
				gg = pixel1.getGreen();
				bb = pixel1.getBlue();
				
				rr = (255 - rr);
				gg = (255 - gg);
				bb = (255 - bb);

				pixel2 = change.getPixel(col, row);

				pixel2.setRed(rr);
				pixel2.setGreen(gg);
				pixel2.setBlue(bb);


			}

		}

		return change;

	}

} 