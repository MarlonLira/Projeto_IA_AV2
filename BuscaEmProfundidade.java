import java.util.Stack;

public class BuscaEmProfundidade extends Busca {

	private Stack<Node> pilhaNos;
	
	public BuscaEmProfundidade(String valorBusca) {
		this.pilhaNos = new Stack<>();
		this.valorBusca = valorBusca;
    System.out.println(" - - - - - - - - - - - - - - - - - - - - - -");
    System.out.println("Nó procurado: " + valorBusca);
	}

	@Override
	public boolean buscarResultado(Node no) {
    new Arvore().desenharNo(no);
    
		if (isResultadoBusca(no)) {
			// Exibir o caminho
			this.obterResultado(no);
			return true;
		} else {
			// Expandir os próximos nós (esquerda -> direita)
			if (no.getNoDireito() != null) {
				this.pilhaNos.push(no.getNoDireito());
			}
			if (no.getNoEsquerdo() != null) { 
				this.pilhaNos.push(no.getNoEsquerdo());
			}
			
		}
		Node noPonta = this.pilhaNos.pop();
		if (noPonta != null && buscarResultado(noPonta)) {
			return true;
		}
		return false;
	}
		
}