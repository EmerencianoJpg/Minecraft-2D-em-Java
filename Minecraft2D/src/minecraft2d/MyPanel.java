package minecraft2d;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

// CLASSE MyPanel
public class MyPanel extends JPanel {
    
    private ImageIcon icon;

    // CONSTRUTOR DA CLASSE COM PARAMETRO
    public MyPanel(ImageIcon icon) {
        
        this.icon = icon;
        
    }

    // CONSTRUTOR DA CLASSE SEM PARAMETRO
    public MyPanel() {
        
         icon = new ImageIcon(getClass().getResource("/minecraft2d/ImagensMine/Herobrine.jpg"));
        
    }
    
    //DESENHA A IMAGEM NO PAINEL
    public void setIcon(ImageIcon icon) {
        
        this.icon = icon;
        repaint(); 
        
    }
    
    @Override
    public void paint(Graphics g) {
        
        g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        
    }
}

