class Main {
  public static void main(String[] args) {
    Node s = new Node("S",0, 10);
    Node s_a = new Node("A", 3, 5);
    Node s_b = new Node("B",7, 8);
    Node a_c = new Node("C", 1, 3);
    Node a_d = new Node("D", 6, 2);
    Node b_e = new Node("E", 1,4);
    Node b_g2 = new Node("G2", 9, 0);
    Node c_d = new Node("D", 4,2);
    Node d_b = new Node("B", 3,8);
    Node d_g1 = new Node("G1", 6,0);
    Node g1_c = new Node("C", 2,3);
    Node e_g2 = new Node("G2", 5,0);

    //Exemplo 1
    s.setNoEsquerdo(s_a);
    s.setNoDireito(s_b);
    s_a.setNoEsquerdo(a_c);
    s_a.setNoDireito(a_d);
    s_b.setNoEsquerdo(b_e);
    s_b.setNoDireito(b_g2);
    a_c.setNoEsquerdo(c_d);
    c_d.setNoEsquerdo(d_b);
    c_d.setNoDireito(d_g1);
    d_g1.setNoEsquerdo(g1_c);
    //g1_c.setNoEsquerdo(c_d);
    d_b.setNoEsquerdo(b_e);
    d_b.setNoDireito(b_g2);
    b_e.setNoEsquerdo(e_g2);

    try {
      
      //new BuscaEmProfundidade("G2").buscarResultado(s);
      new BuscaAEstrela("G2").buscarResultado(s);
      
      } catch(Exception except) {
        System.out.println(except.getMessage());
    }
  }
}