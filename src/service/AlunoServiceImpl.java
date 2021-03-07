package service;

import dao.DaoFactory;
import model.Aluno;
import dao.AlunoDAO;
import java.util.List;

public class AlunoServiceImpl implements AlunoService {

    private final AlunoDAO alunoDAO;

    public AlunoServiceImpl() {
        this.alunoDAO = DaoFactory.getAlunoDAO();
    }

    @Override
    public boolean save(Aluno entity) {
        boolean b = false;

        if (entity != null) {
            b = this.alunoDAO.save(entity);
        }

        return b;
    }

    @Override
    public boolean exclui(long idAluno) {
        boolean b = false;

        if (idAluno > 0) {
            b = this.alunoDAO.exclui(idAluno);
        }

        return b;
    }

    @Override
    public boolean update(Aluno aluno, long idOld) {
        boolean b = false;

        if (aluno != null) {
            if (idOld > 0) {
                b = this.alunoDAO.update(aluno, idOld);
            }
        }
        return b;
    }

    @Override
    public boolean verificaCodAluno(String codAluno) {
        boolean b = false;
        if (codAluno != null) {
            b = this.alunoDAO.verificaCodAluno(codAluno);
        }
        return b;
    }

    @Override
    public Aluno recuperaAlunoId(long idAluno) {
        Aluno c = null;
        if (idAluno > 0) {
            c = this.alunoDAO.recuperaAlunoId(idAluno);
        }
        return c;
    }

    @Override
    public long recuperaUltimoId() {
        long id;
        id = this.alunoDAO.recuperaUltimoId();
        return id;
    }

    @Override
    public List<Aluno> recuperaAluno() {
        List<Aluno> b;
        b = this.alunoDAO.recuperaAluno();
        return b;
    }

    @Override
    public long idCodAluno(String codAluno) {
        long id = -1;
        if (codAluno != null) {
            id = this.alunoDAO.idCodAluno(codAluno);
        }
        return id;
    }
}
