package dao;

import model.Aluno;
import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImpl implements AlunoDAO {

    @Override
    public boolean save(Aluno aluno) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;

        con = FabricaConexao.getConexaoSchema();
        if (con != null) {
            try {
                con.setAutoCommit(false);

                pstm = con.prepareStatement(INSERT_ALUNO);
                pstm.setLong(1, aluno.getIdAluno());
                pstm.setString(2, aluno.getNome());
                pstm.setString(3, aluno.getCodAluno());

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
    public boolean update(Aluno aluno, long idOld) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;

        con = FabricaConexao.getConexaoSchema();
        if (con != null) {
            try {
                con.setAutoCommit(false);

                pstm = con.prepareStatement(UPDATE);
                pstm.setString(1, aluno.getNome());
                pstm.setString(2, aluno.getCodAluno());
                pstm.setLong(3, idOld);
                
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
    public Aluno recuperaAlunoId(long idAluno) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        Aluno temp = new Aluno(idAluno);
        con = FabricaConexao.getConexaoSchema();

        if (con != null) {
            try {

                Statement stm = con.createStatement();
                pstm = con.prepareStatement(RECUPERA_ALUNO);
                pstm.setLong(1, idAluno);
                res = pstm.executeQuery();

                if (res != null && res.next()) {
                    temp.setNome(res.getNString("nome"));
                    temp.setCodAluno(res.getNString("codAluno"));
 
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
    public List<Aluno> recuperaAluno() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Aluno> temp = new ArrayList<Aluno>();
        con = FabricaConexao.getConexaoSchema();
        if (con != null) {
            try {

                pstm = con.prepareStatement(RECUPERA);
                res = pstm.executeQuery();

                Aluno aluno;
                while (res != null && res.next()) {
                    aluno = new Aluno(res.getLong("idAluno"));
                    aluno.setNome(res.getNString("nome"));
                    aluno.setCodAluno(res.getNString("codAluno"));

                    temp.add(aluno);
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;

    }

    @Override
    public boolean verificaCodAluno(String codAluno) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        boolean temp = false;
        con = FabricaConexao.getConexaoSchema();

        if (con != null) {
            try {

                Statement stm = con.createStatement();
                pstm = con.prepareStatement(VERIFICA_CODALUNO);
                pstm.setString(1, codAluno);
                res = pstm.executeQuery();

                if (res != null && res.next()) {
                    temp = true;
                } else {
                    temp = false;
                }
                con.close();

            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;
    }

    @Override
    public long idCodAluno(String codAluno) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long temp = -1;
        con = FabricaConexao.getConexaoSchema();

        if (con != null) {
            try {

                Statement stm = con.createStatement();
                pstm = con.prepareStatement(VERIFICA_CODALUNO);
                pstm.setString(1, codAluno);
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
    public boolean exclui(long idAluno) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;

        con = FabricaConexao.getConexaoSchema();
        if (con != null) {
            try {

                con.setAutoCommit(false);

                pstm = con.prepareStatement(EXCLUIR);
                pstm.setLong(1, idAluno);

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
