package service;

public class ServiceFactory {

    private ServiceFactory() {
    }

    public static PessoaService getPessoaService() {
        return new PessoaServiceImpl();
    }

    public static LoginService getLoginService() {
        return new LoginServiceImpl();
    }

    public static AlunoService getAlunoService() {
        return new AlunoServiceImpl();
    }
    
    public static CursoService getCursoService() {
        return new CursoServiceImpl();
    }
}
