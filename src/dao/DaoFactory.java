package dao;

public class DaoFactory {

    private DaoFactory() {
    }

    public static LoginDAO getLoginDAO() {
        return new LoginDAOImpl();
    }

    public static PessoaDAO getPessoaDAO() {
        return new PessoaDAOImpl();
    }

    public static AlunoDAO getAlunoDAO() {
        return new AlunoDAOImpl();
    }
    
    public static CursoDAO getCursoDAO() {
        return new CursoDAOImpl();
    }

}
