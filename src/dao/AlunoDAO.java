package dao;

import java.util.List;
import model.Aluno;

public interface AlunoDAO {

    final String INSERT_ALUNO = "INSERT INTO Aluno (idAluno, nome, codAluno) "
            + "VALUES(?, ?, ?)";

    final String RECUPERA_ID = "select Max(idAluno) from Aluno";

    final String RECUPERA_ALUNO = "SELECT * FROM Aluno WHERE idAluno = ? ";

    final String RECUPERA = "SELECT * FROM Aluno ";

    final String VERIFICA_CODALUNO = "SELECT * FROM Aluno WHERE codAluno = ?";

    final String UPDATE = "UPDATE Aluno SET "
            + "nome = ?, codAluno = ? "
            + "WHERE idAluno = ? ";

    final String EXCLUIR = "DELETE FROM Aluno "
            + "WHERE idAluno = ? ";

    public boolean save(Aluno aluno);

    public boolean exclui(long idAluno);

    public Aluno recuperaAlunoId(long idAluno);

    public long recuperaUltimoId();

    public List<Aluno> recuperaAluno();

    public boolean verificaCodAluno(String codAluno);

    public long idCodAluno(String codAluno);

    public boolean update(Aluno pessoa, long idOld);
}
