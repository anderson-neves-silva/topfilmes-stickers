import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar ps top 250 filmes
        //String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // após criar as classes dos extratores, aqui eu crio um extrator da nasa
        //ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();
        //List<Conteudo> conteudos = extrator.extraiConteudos(json);

        // fazendo a chamada para o extrator do IMDB
        ExtratorDeConteudoDoIMDB extrator = new ExtratorDeConteudoDoIMDB();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        // exibir e manipular os dados
        System.out.println("======================================================================================");

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            var geradora = new GeradoraDeFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
