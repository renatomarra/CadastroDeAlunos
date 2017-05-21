package unipac.com.br.cadastrodealuno.entidade;

/**
 * Created by rogeriofontes on 08/05/17.
 */

public class Aluno {
    private Long id;
    private String nome;
    private String curso;

    //Aula Banco - Acrescentar o construtor
    public Aluno(Long id, String nome, String curso) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
    }

    public Aluno() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }
}
