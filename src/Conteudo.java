// essa classe representa um conteúdo
public class Conteudo {
  
  // para deixar esses atributos inalterável após serem crados use o final
  private final String titulo;
  private final String urlImagem;

  // criando o construtor
  public Conteudo(String titulo, String urlImagem) {
    this.titulo = titulo;
    this.urlImagem = urlImagem;
  }

  // criando os métodos getters
  public String getTitulo() {
    return titulo;
  }
  
  public String getUrlImagem() {
    return urlImagem;
  }

}
