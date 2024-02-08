package bank;

public class Cliente {

    private String nome;
    private String endereco;
    private int id;  

    public Cliente (int id, String nome, String endereco){
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
     public void setDados(String Dados){
        this.Dados = Dados;
     }
    public int getDados(){
        return Dados;
    }
        
}
