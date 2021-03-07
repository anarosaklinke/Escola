package service;

import dao.DaoFactory;
import model.Curso;
import dao.CursoDAO;
import java.util.List;

public class CursoServiceImpl implements CursoService {

    private final CursoDAO cursoDAO;

    public CursoServiceImpl() {
        this.cursoDAO = DaoFactory.getCursoDAO();
    }

    @Override
    public boolean save(Curso entity) {
        boolean b = false;

        if (entity != null) {
            b = this.cursoDAO.save(entity);
        }

        return b;
    }

    @Override
    public boolean exclui(long idCurso) {
        boolean b = false;

        if (idCurso > 0) {
            b = this.cursoDAO.exclui(idCurso);
        }

        return b;
    }

    @Override
    public boolean update(Curso curso, long idOld) {
        boolean b = false;

        if (curso != null) {
            if (idOld > 0) {
                b = this.cursoDAO.update(curso, idOld);
            }
        }
        return b;
    }

    @Override
    public boolean verificaCodCurso(String codCurso) {
        boolean b = false;
        if (codCurso != null) {
            b = this.cursoDAO.verificaCodCurso(codCurso);
        }
        return b;
    }

    @Override
    public Curso recuperaCursoId(long idCurso) {
        Curso c = null;
        if (idCurso > 0) {
            c = this.cursoDAO.recuperaCursoId(idCurso);
        }
        return c;
    }

    @Override
    public long recuperaUltimoId() {
        long id;
        id = this.cursoDAO.recuperaUltimoId();
        return id;
    }

    @Override
    public List<Curso> recuperaCurso() {
        List<Curso> b;
        b = this.cursoDAO.recuperaCurso();
        return b;
    }

    @Override
    public List<Curso> pesquisa(String chave) {
        List<Curso> b = null;
        if (chave != null) {

            b = this.cursoDAO.pesquisa(chave);
        }
        return b;
    }

    @Override
    public long idCodCurso(String codCurso) {
        long id = -1;
        if (codCurso != null) {
            id = this.cursoDAO.idCodCurso(codCurso);
        }
        return id;
    }
}
