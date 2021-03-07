package service;

import dao.CursoAlunoDAO;
import dao.DaoFactory;
import java.util.List;
import model.CursoAluno;

public class CursoAlunoServiceImpl implements CursoAlunoService {

    private final CursoAlunoDAO CursoAlunoDAO;

    public CursoAlunoServiceImpl() {
        this.CursoAlunoDAO = DaoFactory.getCursoAlunoDAO();
    }

    @Override
    public boolean save(CursoAluno cursoAluno) {
        boolean b = false;

        if (cursoAluno != null) {
            b = this.CursoAlunoDAO.save(cursoAluno);
        }

        return b;
    }

    @Override
    public boolean exclui(long idCursoAluno) {
        boolean b = false;

        if (idCursoAluno > 0) {
            b = this.CursoAlunoDAO.exclui(idCursoAluno);
        }

        return b;
    }

    @Override
    public boolean verificaAluno(long idaluno) {
        boolean b = false;
        if (idaluno >0) {
            b = this.CursoAlunoDAO.verificaAluno(idaluno);
        }
        return b;
    }

    @Override
    public CursoAluno recuperaCursoAlunoId(long idCursoAluno) {
        CursoAluno c = null;
        if (idCursoAluno > 0) {
            c = this.CursoAlunoDAO.recuperaCursoAlunoId(idCursoAluno);
        }
        return c;
    }

    @Override
    public List<CursoAluno> recuperaCursoAluno() {
        List<CursoAluno> b;
        b = this.CursoAlunoDAO.recuperaCursoAluno();
        return b;
    }

    @Override
    public long recuperaUltimoId() {
        long id;
        id = this.CursoAlunoDAO.recuperaUltimoId();
        return id;
    }

}
