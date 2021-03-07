package dao;

import model.Curso;
import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoDAOImpl implements CursoDAO {

    @Override
    public boolean save(Curso curso) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;

        con = FabricaConexao.getConexaoSchema();
        if (con != null) {
            try {
                con.setAutoCommit(false);

                pstm = con.prepareStatement(INSERT_CURSO);
                pstm.setLong(1, curso.getIdCurso());
                pstm.setString(2, curso.getDescricao());
                pstm.setString(3, curso.getEmenta());
                pstm.setString(4, curso.getCodCurso());

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
    public boolean update(Curso curso, long idOld) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;

        con = FabricaConexao.getConexaoSchema();
        if (con != null) {
            try {
                con.setAutoCommit(false);

                pstm = con.prepareStatement(UPDATE);
                pstm.setString(1, curso.getDescricao());
                pstm.setString(2, curso.getEmenta());
                pstm.setString(3, curso.getCodCurso());
                pstm.setLong(4, idOld);

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
    public Curso recuperaCursoId(long idCurso) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        Curso temp = new Curso(idCurso);
        con = FabricaConexao.getConexaoSchema();

        if (con != null) {
            try {

                Statement stm = con.createStatement();
                pstm = con.prepareStatement(RECUPERA_CURSO);
                pstm.setLong(1, idCurso);
                res = pstm.executeQuery();

                if (res != null && res.next()) {
                    temp.setDescricao(res.getNString("descricao"));
                    temp.setEmenta(res.getNString("ementa"));
                    temp.setCodCurso(res.getNString("codCurso"));

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
    public List<Curso> recuperaCurso() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Curso> temp = new ArrayList<Curso>();
        con = FabricaConexao.getConexaoSchema();
        if (con != null) {
            try {

                pstm = con.prepareStatement(RECUPERA);
                res = pstm.executeQuery();

                Curso curso;
                while (res != null && res.next()) {
                    curso = new Curso(res.getLong("idCurso"));
                    curso.setDescricao(res.getNString("descricao"));
                    curso.setEmenta(res.getNString("ementa"));
                    curso.setCodCurso(res.getNString("codCurso"));

                    temp.add(curso);
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;

    }

    @Override
    public boolean verificaCodCurso(String codCurso) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        boolean temp = false;
        con = FabricaConexao.getConexaoSchema();

        if (con != null) {
            try {

                Statement stm = con.createStatement();
                pstm = con.prepareStatement(VERIFICA_CODCURSO);
                pstm.setString(1, codCurso);
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
    public long idCodCurso(String codCurso) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long temp = -1;
        con = FabricaConexao.getConexaoSchema();

        if (con != null) {
            try {

                Statement stm = con.createStatement();
                pstm = con.prepareStatement(VERIFICA_CODCURSO);
                pstm.setString(1, codCurso);
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
    public boolean exclui(long idCurso) {
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;

        con = FabricaConexao.getConexaoSchema();
        if (con != null) {
            try {

                con.setAutoCommit(false);

                pstm = con.prepareStatement(EXCLUIR);
                pstm.setLong(1, idCurso);

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
    public List<Curso> pesquisa(String chave) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Curso> temp = new ArrayList<Curso>();
        con = FabricaConexao.getConexaoSchema();
        if (con != null) {
            try {
                chave = "%" + chave + "%";
                
                pstm = con.prepareStatement(CHAVE);
                pstm.setString(1, chave);
                pstm.setString(2, chave);
                pstm.setString(3, chave);

                res = pstm.executeQuery();

                Curso curso;
                while (res != null && res.next()) {
                    curso = new Curso(res.getLong("idCurso"));
                    curso.setDescricao(res.getNString("descricao"));
                    curso.setEmenta(res.getNString("ementa"));
                    curso.setCodCurso(res.getNString("codCurso"));

                    temp.add(curso);
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;

    }

}
