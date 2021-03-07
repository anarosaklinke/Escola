package service;

import java.util.List;
import model.CursoAluno;

public interface CursoAlunoService {

    boolean save(CursoAluno cursoAluno);

    CursoAluno recuperaCursoAlunoId(long idCursoAluno);

    long recuperaUltimoId();

    List<CursoAluno> recuperaCursoAluno();

    boolean verificaAluno(long idaluno);

    boolean exclui(long idCursoAluno);
}
