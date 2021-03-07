package dao;

import java.util.List;
import model.Curso;

public interface CursoDAO {

    final String INSERT_CURSO = "INSERT INTO Curso (idCurso, descricao, ementa, codCurso) "
            + "VALUES(?, ?, ?, ?)";

    final String RECUPERA_ID = "select Max(idCurso) from Curso";

    final String RECUPERA_CURSO = "SELECT * FROM Curso WHERE idCurso = ? ";

    final String RECUPERA = "SELECT * FROM Curso ";

    final String VERIFICA_CODCURSO = "SELECT * FROM Curso WHERE codCurso = ?";

    final String UPDATE = "UPDATE Curso SET "
            + " descricao = ?, ementa = ?,  codCurso = ? "
            + " WHERE idCurso = ? ";

    final String EXCLUIR = "DELETE FROM Curso "
            + "WHERE idCurso = ? ";
    
        final String CHAVE = "SELECT * FROM curso WHERE "
            + " descricao LIKE ? OR "
            + " ementa LIKE ? OR "
            + " codCurso LIKE ? ";

    public boolean save(Curso curso);

    public boolean exclui(long idCurso);

    public Curso recuperaCursoId(long idCurso);

    public long recuperaUltimoId();

    public List<Curso> recuperaCurso();
    
    public List<Curso> pesquisa(String chave);

    public boolean verificaCodCurso(String codCurso);

    public long idCodCurso(String codCurso);

    public boolean update(Curso pessoa, long idOld);
}
