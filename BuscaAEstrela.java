import java.util.*;

class BuscaAEstrela extends Busca {
  
  private List<Node> listaNos;
	
	public BuscaAEstrela(String valorBusca) {
    this.listaNos = new ArrayList<>();
		this.valorBusca = valorBusca;
    System.out.println(" - - - - - - - - - - - - - - - - - - - - - -");
    System.out.println("Nó procurado: " + valorBusca);
	}

	@Override
	public boolean buscarResultado(Node no) {
    new Arvore().desenharNo(no);

    if(this.isResultadoBusca(no)){
      this.obterResultado(no);
			return true;
    } else {
      
      if(!this.listaNos.isEmpty()){
        this.listaNos.remove(no);
      }
      
      if (no.getNoDireito() != null) {
				this.listaNos.add(no.getNoDireito());
			}
      
			if (no.getNoEsquerdo() != null) { 
				this.listaNos.add(no.getNoEsquerdo());
			}

      Node menorNodeFn = null;
      for(Node nodeFn : this.listaNos) {
        if(menorNodeFn == null && nodeFn.getFn() > 0) {
          menorNodeFn = nodeFn;
        } else if((menorNodeFn.getFn() > nodeFn.getFn()) && nodeFn.getFn() > 0) {
          menorNodeFn = nodeFn;
        }
      }
    
     buscarResultado(menorNodeFn);
    }
	  return false;
	}
}