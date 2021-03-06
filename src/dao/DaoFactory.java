package dao;

public class DaoFactory {

    private DaoFactory() {
    }

    public static LoginDAO getLoginDAO() {
        return new LoginDAOImpl();
    }



    public static PessoaDAO getClienteDAO() {
        return new PessoaDAOImpl();
    }



}
