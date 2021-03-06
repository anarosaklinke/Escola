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


}
