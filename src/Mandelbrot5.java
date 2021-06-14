
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Mandelbrot5 extends JFrame{
     private final int MAX_ITER = 570;
    private final double ZOOM = 200;
    private BufferedImage I;
    private double zx, zy, cX, cY, tmp;
 
    public Mandelbrot5() {
        super("Mandelbrot Set 5");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                zx = zy = 0;
                cX = (x - 400) / ZOOM;
                cY = (y - 300) / ZOOM;
                int iter = MAX_ITER;
                while (zx * zx + zy * zy < 4 && iter > 0) {     
          tmp = Math.pow(zx, 5)-10*Math.pow(zx, 3) * Math.pow(zy, 2)+5*zx*Math.pow(zy,4)+cX;
          zy = 5 * Math.pow(zx, 4)*zy-10*Math.pow(zx, 2)*Math.pow(zy, 3)+Math.pow(zy, 5)+cY;
          
          zx = tmp;
          iter--;
        }
                I.setRGB(x, y, iter | (iter << 8));
            }
        }
    }
 
    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }
 
    public static void main(String[] args) {
        new Mandelbrot5().setVisible(true);
    }
}
