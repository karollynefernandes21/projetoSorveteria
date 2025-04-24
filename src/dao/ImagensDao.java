
package dao;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class ImagensDao extends JDesktopPane{
    
    private Image imagem;

    public ImagensDao() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/logoSorveteria.jpg.jpg"));
        imagem = icon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
    }
}
