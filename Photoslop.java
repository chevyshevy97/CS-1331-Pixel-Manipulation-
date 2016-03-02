//Shivani Upadhayay
//supadhayay3@gatech.edu / 903133182
//I worked on this assignment alone, using only this semester's course materials. 

import java.io.IOException;
public class Photoslop {
    public static void main(String... args) throws IOException {
        if (args.length < 3) {
            printUsage();
            System.exit(0);
        }
        try {

            if (args[0].equals("-g")) {

                Pic picture = new Pic(args[1]);               
                ImageProcessor grey = new ImageProcessor(picture);
                Pic newPicture = grey.greyScale();
                newPicture.save(args[3]);

            } else if (args[0].equals("-i")) { 

                Pic picture2 = new Pic(args[1]);
                ImageProcessor inv = new ImageProcessor(picture2);
                Pic newInvert = inv.invert();
                newInvert.save(args[3]);

            } else if (args[0].equals("-c")) {

                Pixel chromaKey = new Pixel(26, 185, 19, 1);
                Pic picture3 = new Pic(args[1]);
                ImageProcessor chr = new ImageProcessor(picture3);
                Pic chrOutput = chr.chroma(chromaKey, 20, 40, 20);

                Pic backDropPic = new Pic(args[2]);
                ImageProcessor back = new ImageProcessor(chrOutput);
                Pic result = back.background(backDropPic);
                result.save(args[3]);

            } else {
                printUsage();
            }
        } catch (IOException ex) {
            System.out.println("One of the files you referenced does not exist,"
                + " or is corrupted. Double-check and try again.");
        }
    }

    private static void printUsage() {
        System.out.println("Greyscale mode: ");
        System.out.println("java Photoslop -g imageFile outputFileName");
        System.out.println("");
        System.out.println("Invert mode: ");
        System.out.println("java Photoslop -i imageFile outputFileName");
        System.out.println("");
        System.out.println("Greenscreen mode: ");
        System.out.println("java Photoslop -c imageFile backgroundFile"
            + " outputFileName");
    }
}
