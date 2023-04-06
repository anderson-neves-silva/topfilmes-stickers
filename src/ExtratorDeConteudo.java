import java.util.List;

// tudo em uma interface é público, nomes dos métodos, as assinaturas, as excessões se tiver, etc
public interface ExtratorDeConteudo {
  
  public List<Conteudo> extraiConteudos(String json);
  
}
