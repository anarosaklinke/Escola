package service;

import java.util.List;
import model.Aluno;

public interface AlunoService {

    boolean save(Aluno aluno);

    Aluno recuperaAlunoId(long idAluno);

    long recuperaUltimoId();

    List<Aluno> recuperaAluno();

    boolean verificaCodAluno(String codAluno);

    long idCodAluno(String codAluno);

    boolean update(Aluno aluno, long idOld);

    boolean exclui(long idAluno);
}
