class Arvore {
  private String SPACE_MAX = "                ";
  private String SPACE_VERTICE = "                ";
  
  public void desenharNo(Node no){
    System.out.println(" - - - - - - - - - - - - - - - - - - - - - -");
    System.out.println(SPACE_MAX + "(" + no.getNome() + ")");
    
    if(no.getNoEsquerdo() != null && no.getNoDireito() != null) {
      this.desenharVerticesEsquerdoDireito();
      this.desenharNoEsquerdoDireito(no.getNoEsquerdo(), no.getNoDireito());
    } else if(no.getNoEsquerdo() != null) {
      this.desenharVerticeEsquerdo();
      this.desenharNoEsquerdo(no.getNoEsquerdo());
    } else if(no.getNoDireito() != null) {
      this.desenharVerticeDireito();
      this.desenharNoDireito(no.getNoDireito());
    }
    
    System.out.println("");
    System.out.println(no);
  }

  private void desenharNoEsquerdoDireito(Node noEsq, Node noDir){
    System.out.println(SPACE_MAX.replaceFirst("    ", "") + "(" + noEsq.getNome() + ")     (" + noDir.getNome() + ")");
  }

  private void desenharNoEsquerdo(Node noEsq){
    System.out.println(SPACE_MAX.replaceFirst("    ", "") + "(" + noEsq.getNome() + ")");
  }

  private void desenharNoDireito(Node noDir){
    System.out.println(SPACE_MAX.replaceFirst("    ", "") + "        (" + noDir.getNome() + ")");
  }

  private void desenharVerticeEsquerdo(){
    String Space = SPACE_VERTICE.replaceFirst(" ", "");
    System.out.println(Space + "/   ");
    
    Space = Space.replaceFirst(" ", "");
    System.out.println(Space + "/    ");
  }

  private void desenharVerticeDireito(){
    String Space = SPACE_VERTICE.replaceFirst(" ", "");
    System.out.println(Space + "    \\");
    
    Space = Space.replaceFirst(" ", "");
    System.out.println(Space + "      \\");
  }

  private void desenharVerticesEsquerdoDireito(){
    String Space = SPACE_VERTICE.replaceFirst(" ", "");
    System.out.println(Space + "/   \\");
    
    Space = Space.replaceFirst(" ", "");
    System.out.println(Space + "/     \\");
  }
}