class Node {
  
  private String nome;
  //Valor do Vertice
  private int valor;
  //valor Heurístico
  private int custo;

  private Integer somaVertice;
  
  private Node noEsquerdo;
  private Node noDireito;
  private Node noPai;

  public Node(int valor, int custo){
    this.valor = valor;
    this.custo = custo;
  }

  public Node(String nome, int valor, int custo){
    this.valor = valor;
    this.custo = custo;
    this.nome = nome;
    this.somaVertice = valor;
  }

  public Node(Node no){
    this.nome = no.getNome();
    this.valor = no.getValor();
    this.custo = no.getCusto();
    this.noPai = no.getNoPai();
  }

  public void setValor(int valor){
    this.valor = valor;
  }

  public int getValor(){
    return this.valor;
  }

  public void setCusto(int custo){
    this.custo = custo;
  }

  public int getCusto(){
    return this.custo;
  }

  public Integer getFn(){
    return this.custo + this.somaVertice;
  }

  public Integer getSomaVertice(){
    return this.somaVertice;
  }

  public void setSomaVertice(Integer somaVertice) {
    this.somaVertice = somaVertice;
  }

  public String getNome(){
    return this.nome;
  }

  public Node getNoPai(){
    return this.noPai;
  }

  public void setNoEsquerdo(Node no){
    this.noEsquerdo = no;
    this.noEsquerdo.noPai = this;
    this.noEsquerdo.setSomaVertice(this.getSomaVertice() + no.getValor());
  }

  public Node setNoEsquerdoDireito(Node noEsq, Node noDir){
    this.noEsquerdo = noEsq;
    this.noDireito = noDir;
    
    if(this.noEsquerdo != null){
      this.noEsquerdo.noPai = this;
    }
    
    if(this.noDireito != null){
      this.noDireito.noPai = this;
    }
    
    return this;
  }

  public Node getNoEsquerdo(){
    return this.noEsquerdo;
  }

  public void setNoDireito(Node no){
    this.noDireito = no;
    this.noDireito.noPai = this;
  }

  public Node getNoDireito(){
    return this.noDireito;
  }

  @Override
  public String toString(){
    var atual = "Nó: "+ nome + " { Valor: " + this.valor + " | Custo: " +  this.custo + " } \n";

    var pai = this.noPai != null ? "Nó Pai: "+ this.noPai.nome + " { Valor: " + this.noPai.valor + " | Custo: " +  this.noPai.custo + " | F(n) = " + this.noPai.getFn() + " } \n" : "Nó Pai: N/A  \n";
    
    var filhoEsq = this.noEsquerdo != null ? "Nó F Esq: "+ this.noEsquerdo.nome + " { Valor: " + this.noEsquerdo.valor + " | Custo: " +  this.noEsquerdo.custo + " | F(n) = " + this.noEsquerdo.getFn() + " } \n" : "Nó F Esq: N/A  \n";

    var filhoDir = this.noDireito != null ? "Nó F Dir: "+ this.noDireito.nome + " { Valor: " + this.noDireito.valor + " | Custo: " +  this.noDireito.custo + " | F(n) = " + this.noDireito.getFn() + " } \n" : "Nó F Dir: N/A  \n";
    
    return pai + atual + filhoEsq + filhoDir;
	}
}