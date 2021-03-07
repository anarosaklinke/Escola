package dao;

import java.util.List;
import model.CursoAluno;

public interface CursoAlunoDAO {

    final String INSERT_CURSOALUNO = "INSERT INTO curso_aluno ("
            + "idcurso_aluno, Curso_idCurso, Aluno_idAluno) "
            + "VALUES (?, ?, ?)";

    final String RECUPERA_ID = "select Max(idcurso_aluno) from curso_aluno";

    final String RECUPERA_CURSOALUNO = "SELECT * FROM curso_aluno WHERE idcurso_aluno = ? ";

    final String RECUPERA = "SELECT * FROM curso_aluno ";

    final String VERIFICA_ALUNO = "SELECT * FROM curso_aluno WHERE Aluno_idAluno = ?";
    
    final String EXCLUIR = "DELETE FROM curso_aluno "
            + "WHERE Aluno_idAluno = ? ";

    public boolean save(CursoAluno cursoAluno);

    public boolean exclui(long idCursoAluno);

    public CursoAluno recuperaCursoAlunoId(long idCursoAluno);

    public long recuperaUltimoId();

    public List<CursoAluno> recuperaCursoAluno();

    public boolean verificaAluno(long idaluno);


}
