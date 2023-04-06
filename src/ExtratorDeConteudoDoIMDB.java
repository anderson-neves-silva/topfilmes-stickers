import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
- agora como já criei a interface, preciso dizer que essa classe segue aquele contrato ou implementa aquela 
interface criada a ExtratorDeConteudo, a classe da nasa também precisa fazer isso
*/ 
public class ExtratorDeConteudoDoIMDB implements ExtratorDeConteudo {
  
  public List<Conteudo> extraiConteudos(String json) {

    // extrair só os dados que interessam (titulo, poster, classificação)
    var parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = parser.parse(json);

    List<Conteudo> conteudos = new ArrayList<>();

    // precisamos popular a lista de conteúdos
    for (Map<String, String> atributos : listaDeAtributos) {
      String titulo = atributos.get("title");
      String urlImagem = atributos.get("image")
      .replaceAll("(@+)(.*).jpg$", "$1.jpg");

      // aqui criamos o conteúdo
      var conteudo = new Conteudo(titulo, urlImagem);

      conteudos.add(conteudo);
    }

    return conteudos;
  }
}
