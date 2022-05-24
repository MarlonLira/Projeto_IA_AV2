
import java.util.*;

public abstract class Busca {

	public String valorBusca;
	private String textoResposta;
  private List<String> caminhoPercorrido = new ArrayList<>(); 
	
	public abstract boolean buscarResultado(Node no);
	
	protected void obterResultado(Node no) {
    try{
      if(no != null) {
        if(this.textoResposta == null) {
          this.textoResposta = no.getNome();
        } else {
          this.textoResposta += " " + no.getNome();
        }
    		
        this.obterResultado(no.getNoPai());
      } else {
        this.exibirTextoResultado();
      }
   } catch(Exception except) {
      this.exibirTextoResultado();
      System.out.println(except.getMessage());
   }
	}
	
	public void exibirTextoResultado() {
    System.out.println(" - - - - - - - - - - - - - - - - - - - - - -");
		if (this.textoResposta != null) {
      List<String> list = Arrays.asList(this.textoResposta.split(" "));
      Collections.reverse(list);
			System.out.println("Caminho percorrido: " + caminhoPercorrido);
			System.out.println("Melhor caminho: " + list);
		} else {
			System.out.println("O valor " + this.valorBusca + " não foi encontrado.");
		}
    System.out.println(" - - - - - - - - - - - - - - - - - - - - - -");
	}
	
	public String getTextoResposta() {
		return textoResposta;
	}

	public void setTextoResposta(String textoResposta) {
		this.textoResposta = textoResposta;
	}
	
	public void setValorBusca(String valorBusca) {
		this.valorBusca = valorBusca;
	}
	
	public boolean isResultadoBusca(Node no) {
    this.caminhoPercorrido.add(no.getNome());
		return no.getNome() == valorBusca;
	}
	
	public String getValorBusca() {
		return valorBusca;
	}
	
}