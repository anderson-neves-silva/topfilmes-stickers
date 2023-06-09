import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
  
  public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

    // leitura da imagem
    // InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
    // InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json").openStream();
    
    BufferedImage imagemOriginal = ImageIO.read(inputStream);
 
    // cria nova imagem em memória com transparência e com tamanho novo
    int largura  = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar a imagem original pra nova imagem (em memória)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    // configurar a fonte
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 65);
    graphics.setFont(fonte);
    graphics.setColor(Color.RED);

    // escrever uma frase na nova imagem
    graphics.drawString("TOPZERA", 160, novaAltura - 70);

    // escrever a nova imagem em um aquivo
    ImageIO.write(novaImagem, "png", new File(nomeArquivo));
  }

}
