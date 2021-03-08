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
    public boolean exclui(long aluno, long curso) {
        boolean b = false;

        if (aluno > 0) {
            if (curso > 0) {
                b = this.CursoAlunoDAO.exclui(aluno, curso);
            }
        }

        return b;
    }

    @Override
    public boolean verificaAluno(long idaluno, long idcurso) {
        boolean b = false;
        if (idaluno > 0) {
            if (idcurso > 0) {
                b = this.CursoAlunoDAO.verificaAluno(idaluno, idcurso);
            }
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
    public List<CursoAluno> recuperaCursoAluno(long idcurso) {
        List<CursoAluno> b = null;
            if (idcurso > 0) {
                b = this.CursoAlunoDAO.recuperaCursoAluno(idcurso);
        }
        return b;
    }
    
    @Override
    public List<CursoAluno> recuperaAluno(long idaluno) {
        List<CursoAluno> b = null;
            if (idaluno > 0) {
                b = this.CursoAlunoDAO.recuperaAluno(idaluno);
        }
        return b;
    }

    @Override
    public long recuperaUltimoId() {
        long id;
        id = this.CursoAlunoDAO.recuperaUltimoId();
        return id;
    }

}
