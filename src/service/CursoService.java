package service;

import java.util.List;
import model.Curso;

public interface CursoService {

    boolean save(Curso curso);

    Curso recuperaCursoId(long idCurso);

    long recuperaUltimoId();

    List<Curso> recuperaCurso();
    
    List<Curso> pesquisa(String chave);

    boolean verificaCodCurso(String codCurso);

    long idCodCurso(String codCurso);

    boolean update(Curso curso, long idOld);

    boolean exclui(long idCurso);
}
