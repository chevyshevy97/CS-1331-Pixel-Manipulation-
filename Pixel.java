//Shivani Upadhayay
//supadhayay3@gatech.edu / 903133182
//I worked on this assignment alone, using only this semester's course materials.
/* Put your Pixel class here */
public class Pixel {
	private int R, G, B, A;

	public Pixel(int red, int green, int blue, int alpha) {
		if (red > 255) {
			R = 255;
		}
		if (red < 0) {
			R = 0;
		}
		if (green > 255) {
			R=255;
		}
		if (green < 0) {
			R = 0;
		} 
		if (blue > 255) {
			R = 255;
		}
		if (blue < 0) {
			R = 0;
		}
		if (alpha > 255) {
			R = 255;
		}
		if (alpha < 0) {
			R = 0;
		}
		
		R = red;
		G = green;
		B = blue;
		A = alpha;
	}

	public void setRed(int a) {
		this.R = a;
	}

	public int getRed() {
		return R;
	}

	public void setGreen(int b) {
		this.G = b;
	}

	public int getGreen() {
		return G;
	}

	public void setBlue(int c) {
		this.B = c;
	}

	public int getBlue() {
		return B;
	}

	public void setAlpha(int d) {
		this.A = d;
	}

	public int getAlpha() {
		return A;
	}
}
