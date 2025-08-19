package minecraft2d;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

//TALVEZ TENHA QUE MUDAR O DIRETORIO DAS IMAGENS

public class Janela extends JFrame implements KeyListener {
    private final int size = 400, rows = 20, cols = 20;
    private final String avatar = "C:/Users/lukas/OneDrive/Área de Trabalho/dafssefs/Trabalho de POO 1/ATV8/Minecraft2D/src/minecraft2d/ImagensMine/Herobrine.jpg";
    private final String bloco_terra = "C:/Users/lukas/OneDrive/Área de Trabalho/dafssefs/Trabalho de POO 1/ATV8/Minecraft2D/src/minecraft2d/ImagensMine/BlocoGama.png";
    private final String bloco_flor = "C:/Users/lukas/OneDrive/Área de Trabalho/dafssefs/Trabalho de POO 1/ATV8/Minecraft2D/src/minecraft2d/ImagensMine/BlocoFlor.jpg";
    private final String bloco_madeira = "C:/Users/lukas/OneDrive/Área de Trabalho/dafssefs/Trabalho de POO 1/ATV8/Minecraft2D/src/minecraft2d/ImagensMine/BlocoMadeira.jpg";
    private final String bloco_verde = "C:/Users/lukas/OneDrive/Área de Trabalho/dafssefs/Trabalho de POO 1/ATV8/Minecraft2D/src/minecraft2d/ImagensMine/BlocoFolha.jpg";
    private final String fundo_azul = "C:/Users/lukas/OneDrive/Área de Trabalho/dafssefs/Trabalho de POO 1/ATV8/Minecraft2D/src/minecraft2d/ImagensMine/BlocoCeu.png";
    private final String bloco_pedra = "C:/Users/lukas/OneDrive/Área de Trabalho/dafssefs/Trabalho de POO 1/ATV8/Minecraft2D/src/minecraft2d/ImagensMine/BlocoPedra.jpg";
    private final String bloco_areia = "C:/Users/lukas/OneDrive/Área de Trabalho/dafssefs/Trabalho de POO 1/ATV8/Minecraft2D/src/minecraft2d/ImagensMine/BlocoAreia.jpg";
    private final String bloco_porta = "C:/Users/lukas/OneDrive/Área de Trabalho/dafssefs/Trabalho de POO 1/ATV8/Minecraft2D/src/minecraft2d/ImagensMine/BlocoPorta.jpg";
    private final String bloco_tabua = "C:/Users/lukas/OneDrive/Área de Trabalho/dafssefs/Trabalho de POO 1/ATV8/Minecraft2D/src/minecraft2d/ImagensMine/BlocoTAbua.jpg";
    private final String bloco_escadaleft = "C:/Users/lukas/OneDrive/Área de Trabalho/dafssefs/Trabalho de POO 1/ATV8/Minecraft2D/src/minecraft2d/ImagensMine/BlocoEscadaLeft.png";
    private final String bloco_escadaright = "C:/Users/lukas/OneDrive/Área de Trabalho/dafssefs/Trabalho de POO 1/ATV8/Minecraft2D/src/minecraft2d/ImagensMine/BlocoEscadaRight.png";


    private final MyPanel[] myPanels;
    private final int[] tipoBloco;
    private final ImageIcon av;
    private final ImageIcon fundo;
    private final ImageIcon blc;
    private final ImageIcon blc2;
    private final ImageIcon blc3;
    private final ImageIcon blc4;
    private final ImageIcon blc5;
    private final ImageIcon blc6;
    private final ImageIcon blc7;
    private final ImageIcon blc8;
    private final ImageIcon blc9;
    private final ImageIcon blc10;
    
    private int posAv;
    private final boolean[] blocosSolidos = new boolean[size];

    public Janela() {
        
        //JANELA DO JOGO
        this.addKeyListener(this);
        this.setTitle("MINECRAFT 2D");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(cols, rows));

        av = new ImageIcon(getClass().getResource("/minecraft2d/ImagensMine/Herobrine.jpg"));
        fundo = new ImageIcon(getClass().getResource("/minecraft2d/ImagensMine/BlocoCeu.png"));
        blc = new ImageIcon(getClass().getResource("/minecraft2d/ImagensMine/BlocoFlor.jpg"));
        blc2 = new ImageIcon(getClass().getResource("/minecraft2d/ImagensMine/BlocoMadeira.jpg"));
        blc3 = new ImageIcon(getClass().getResource("/minecraft2d/ImagensMine/BlocoGama.png"));
        blc4 = new ImageIcon(getClass().getResource("/minecraft2d/ImagensMine/BlocoFolha.jpg"));
        blc5 = new ImageIcon(getClass().getResource("/minecraft2d/ImagensMine/BlocoPedra.jpg"));
        blc6 = new ImageIcon(getClass().getResource("/minecraft2d/ImagensMine/BlocoAreia.jpg"));
        blc7 = new ImageIcon(getClass().getResource("/minecraft2d/ImagensMine/BlocoPorta.jpg"));
        blc8 = new ImageIcon(getClass().getResource("/minecraft2d/ImagensMine/BlocoTabua.jpg"));
        blc9 = new ImageIcon(getClass().getResource("/minecraft2d/ImagensMine/BlocoEscadaLeft.png"));
        blc10 = new ImageIcon(getClass().getResource("/minecraft2d/ImagensMine/BlocoEscadaRight.png"));

        tipoBloco = new int[size];
        myPanels = new MyPanel[size];
        
        //SETA O FUNDO PARA A IMAGEM DE FUNDO
        for (int i = 0; i < size; i++) {
            
            myPanels[i] = new MyPanel(fundo);          
            this.add(myPanels[i]);
            
        }
        //SETA OS BLOCOS DE PEDRA DO CHÃO 
        for (int i = rows * (cols - 3); i < size; i++) {
            
            blocosSolidos[i] = true;
            tipoBloco[i] = 5;
            myPanels[i].setIcon(blc5);
            
        }
        

        
        //SETA OS BLOCOS DE TERRA NO CHÃO
        for (int i = 16 * rows; i < 17 * rows; i++) {
            
            blocosSolidos[i] = true;
            tipoBloco[i] = 3;
            myPanels[i].setIcon(blc3);
            
        }
        
        //SPAWNA O PERSONAGEM NO CENTRO
        posAv = (310);
        myPanels[posAv].setIcon(av);
        
        
    }


    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        //COLOCA OS BLOCOS ONDE O PERSONAGEM ESTÁ
        switch (e.getKeyCode()) {
            case KeyEvent.VK_1:
                
                criarBlocoNC(posAv, 1);
                moverAvatarParaCima();
                
                break;
                
            case KeyEvent.VK_2:
                
                criarBloco(posAv, 2);
                moverAvatarParaCima();
                
                break;
                
            case KeyEvent.VK_3:
                
                criarBloco(posAv, 3);
                moverAvatarParaCima();

                break;
                
            case KeyEvent.VK_4:
                
                criarBloco(posAv, 4);
                moverAvatarParaCima();

                break;
                
            case KeyEvent.VK_5:
                
                criarBloco(posAv, 5);
                moverAvatarParaCima();

                break;
                
            case KeyEvent.VK_6:
                
                criarBloco(posAv, 6);
                moverAvatarParaCima();

                break;
                
            case KeyEvent.VK_7:
                
                criarBlocoNC(posAv, 7);
                moverAvatarParaCima();

                break;
                
            case KeyEvent.VK_8:
                
                criarBloco(posAv, 8);
                moverAvatarParaCima();

                break;
 
            case KeyEvent.VK_9:
                
                criarBloco(posAv, 9);
                moverAvatarParaCima();

                break;
                
            case KeyEvent.VK_0:
                
                criarBloco(posAv, 10);
                moverAvatarParaCima();

                break;
                
            //QUEBRA OS BLOCOS DEPENDENDO DA DIREÇÃO SELECIONADA
            case KeyEvent.VK_SPACE:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_RIGHT:
                quebrarBlocoNaDirecao(e.getKeyCode());
                
                break;
                
            default:
                
                break;
                
        }
        
        moverAvatar(e.getKeyCode());
    }
    
    //CRIA OS BLOCOS E COLOCA COLISÃO NELES
    private void criarBloco(int posicao, int tipoBlocoNovo) {
        
        if (tipoBloco[posicao] == 0) {
            
            tipoBloco[posicao] = tipoBlocoNovo;
            myPanels[posicao].setIcon(getIcon(posicao));
            blocosSolidos[posicao] = true;
            
        }
    }
    
        private void criarBlocoNC(int posicao, int tipoBlocoNovo) {
        
        if (tipoBloco[posicao] == 0) {
            
            tipoBloco[posicao] = tipoBlocoNovo;
            myPanels[posicao].setIcon(getIcon(posicao));
            
        }
    }
    
    //TODA VEZ QUE UM BLOCO É COLOCADO O PERSONAGEM É MOVIDO PARA CIMA
    private void moverAvatarParaCima() {
        
    int novaPosicao = posAv - rows;
    
    if (novaPosicao >= 0 && !blocosSolidos[novaPosicao]) {
        
        myPanels[posAv].setIcon(getIcon(posAv));
        posAv = novaPosicao;
        myPanels[posAv].setIcon(av);
        
    }
}

    //FUNÇÃO QUEBRA BLOCO DEPENDENDO DA DIREÇÃO
    private void quebrarBlocoNaDirecao(int keyCode) {
        
        int posicao;

        switch (keyCode) {
            
            case KeyEvent.VK_DOWN:
                
                posicao = posAv + rows;
                
                break;
                
            case KeyEvent.VK_LEFT:
                
                posicao = posAv - 1;
                
                break;
                
            case KeyEvent.VK_UP:
                
                posicao = posAv - rows;
                
                break;
                
            case KeyEvent.VK_RIGHT:
                
                posicao = posAv + 1;
                
                break;
                
            default:
                
                return;
                
        }
        //RETIRA A COLISÃO QUANDO O BLOCO É QUEBRADO
       if (posicao >= 0 && posicao < size && tipoBloco[posicao] != 0) {
           
            tipoBloco[posicao] = 0;
            myPanels[posicao].setIcon(getIcon(posicao));
            blocosSolidos[posicao] = false;
            
        }
    }

    //FUNÇÃO QUE MOVIMENTA O PERSONAGEM NO WASD
    private void moverAvatar(int keyCode) {
        
        int posicao;

        switch (keyCode) {
            
            case KeyEvent.VK_D:
                
                posicao = posAv + 1;
                
                break;
                
            case KeyEvent.VK_A:
                
                posicao = posAv - 1;
                
                break;
                
            case KeyEvent.VK_S:
                
                posicao = posAv + rows;
                
                break;
                
            case KeyEvent.VK_W:
                
                posicao = posAv - rows;
                
                break;
                
            default:
                
                return;
                
        }
        //VERIFICAÇÃO SE EXISTE UM BLOCO COM COLISÃO A ONDE O PERSONAGEM IRA PASSAR
        if (posicao >= 0 && posicao < size && !blocosSolidos[posicao]) {
            
            myPanels[posAv].setIcon(getIcon(posAv));
            posAv = posicao;
            myPanels[posAv].setIcon(av);
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    //RETORNO DOS BLOCOS NA TELA
    private ImageIcon getIcon(int tipo) {
        
        switch (tipoBloco[tipo]) {
            
            case 1:
                return blc;
            case 2:
                return blc2;
            case 3:
                return blc3;
            case 4:
                return blc4;
            case 5:
                return blc5;            
            case 6:
                return blc6;
            case 7:
                return blc7;            
            case 8:
                return blc8;
            case 9:
                return blc9;
            case 10:
                return blc10;
            default:
                return fundo;
        }
    }

}