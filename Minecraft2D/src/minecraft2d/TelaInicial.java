package minecraft2d;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//CLASSE QUE CRIA O BACKGROUND
class BackgroundPanel extends JPanel {
    
    private Image backgroundImage;

    // CONSTRUTOR DO FUNDO
    public BackgroundPanel(String imagePath) {
        
        backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
        
    }
        
    // DESENHA UMA IMAGEM COMO O BACKGROUND
    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        
    }
}
//ESSA CLASSE É UMA CLASSE INTERNA A CLASSE TelaInicial

//CLASSE QUE CRIA A TELA DO JOGO
public class TelaInicial extends JFrame {

    public TelaInicial() {
        
        //CONFIGURAÇÃO DA JANELA
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //CRIAÇÃO DO BACKGROUND COM UMA IMAGEM SALVA
        BackgroundPanel backgroundPanel = new BackgroundPanel("/minecraft2d/ImagensMine/FundoTelaInicial.png");
        backgroundPanel.setLayout(new GridBagLayout());

        //CRIAÇÃO BOTÃO JOGAR
        JButton jogarButton = new JButton("JOGAR");
        jogarButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // FECHA A TELA INICIAL E DEPOIS ABRE O JOGO
                dispose();
                new Janela();
                
            }
            
        });

        // CONFIGURAÇÕES DO BOTÃO
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1; 
        gbc.anchor = GridBagConstraints.CENTER;
        jogarButton.setPreferredSize(new Dimension(150, 30));
        backgroundPanel.add(jogarButton, gbc);

        // ADICIONA O BACKGROUND
        add(backgroundPanel);

        setTitle("Minecraft 2D - Tela Inicial");
        setVisible(true);
    }

}
