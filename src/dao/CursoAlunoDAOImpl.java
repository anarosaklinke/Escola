package dao;

import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.CursoAluno;

public class CursoAlunoDAOImpl implements CursoAlunoDAO {

    @Override
    public boolean save(CursoAluno cursoAluno) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;

        con = FabricaConexao.getConexaoSchema();
        if (con != null) {
            try {
                con.setAutoCommit(false);

                pstm = con.prepareStatement(INSERT_CURSOALUNO);
                pstm.setLong(1, cursoAluno.getIdCursoAluno());
                pstm.setLong(2, cursoAluno.getIdCurso());
                pstm.setLong(3, cursoAluno.getIdAluno());

                pstm.executeUpdate();

                con.commit();
                con.close();
                b = true;
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }
        return b;
    }

    @Override
    public CursoAluno recuperaCursoAlunoId(long idCursoAluno) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        CursoAluno temp = new CursoAluno(idCursoAluno);
        con = FabricaConexao.getConexaoSchema();

        if (con != null) {
            try {

                Statement stm = con.createStatement();
                pstm = con.prepareStatement(RECUPERA_CURSOALUNO);
                pstm.setLong(1, idCursoAluno);
                res = pstm.executeQuery();

                if (res != null && res.next()) {
                    temp.setIdCursoAluno(res.getLong("idcurso_aluno"));
                    temp.setIdCurso(res.getLong("Curso_idCurso"));
                    temp.setIdAluno(res.getLong("Aluno_idAluno"));
 
                } else {
                    temp = null;
                }
                con.close();

            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;
    }

    @Override
    public long recuperaUltimoId() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long temp = -1;
        con = FabricaConexao.getConexaoSchema();

        if (con != null) {
            try {

                Statement stm = con.createStatement();
                pstm = con.prepareStatement(RECUPERA_ID);
                res = pstm.executeQuery();

                if (res != null && res.next()) {
                    temp = res.getLong(1);
                } else {
                    temp = -1;
                }
                con.close();

            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;
    }

    @Override
    public List<CursoAluno> recuperaCursoAluno(long idcurso) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<CursoAluno> temp = new ArrayList<CursoAluno>();
        con = FabricaConexao.getConexaoSchema();
        if (con != null) {
            try {

                pstm = con.prepareStatement(RECUPERA);
                pstm.setLong(1, idcurso);
                
                res = pstm.executeQuery();

                CursoAluno cursoAluno;
                while (res != null && res.next()) {
                    cursoAluno = new CursoAluno(res.getLong("idcurso_aluno"));
                    cursoAluno.setIdCurso(res.getLong("Curso_idCurso"));
                    cursoAluno.setIdAluno(res.getLong("Aluno_idAluno"));

                    temp.add(cursoAluno);
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;

    }

    @Override
    public boolean verificaAluno(long idaluno, long idcurso) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        boolean temp = false;
        con = FabricaConexao.getConexaoSchema();

        if (con != null) {
            try {

                Statement stm = con.createStatement();
                pstm = con.prepareStatement(VERIFICA_ALUNO);
                pstm.setLong(1, idaluno);
                pstm.setLong(2, idcurso);
                res = pstm.executeQuery();
                
                if (res != null && res.next()) {
                    temp = true;
                } 
                
                con.close();

            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;
    }


    @Override
    public boolean exclui(long aluno, long curso) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;

        con = FabricaConexao.getConexaoSchema();
        if (con != null) {
            try {

                con.setAutoCommit(false);

                pstm = con.prepareStatement(EXCLUIR);
                pstm.setLong(1, aluno);
                pstm.setLong(2, curso);

                pstm.executeUpdate();

                con.commit();
                con.close();
                b = true;
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }
        return b;
    }
    



}
