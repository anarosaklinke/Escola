package service;

import java.util.List;
import model.CursoAluno;

public interface CursoAlunoService {

    boolean save(CursoAluno cursoAluno);

    CursoAluno recuperaCursoAlunoId(long idCursoAluno);

    long recuperaUltimoId();

    List<CursoAluno> recuperaCursoAluno(long idcurso);

    boolean verificaAluno(long idaluno, long idcurso);

    boolean exclui(long aluno, long cursoo);
}
