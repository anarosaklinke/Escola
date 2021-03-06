package dao;

import model.Login;

public interface LoginDAO {

    final String INSERT_LOGIN = "INSERT INTO login (idLogin, "
            + "usuario, senha, admin) VALUES (?, ?, ?, ?)";
    final String RECUPERA_ID = "select Max(idLogin) from login";
    final String CONSULTA_LOGIN = "SELECT * FROM login where usuario = ?";
    final String LOGIN_USUARIO = "SELECT usuario FROM login "
            + "INNER JOIN pessoa "
            + "ON pessoa.idPessoa = ? AND login.idLogin = pessoa.Login_idLogin  ";

    final String IDLOGIN_USUARIO = "SELECT idLogin FROM login "
            + "INNER JOIN pessoa "
            + "ON pessoa.idPessoa = ? AND login.idLogin = pessoa.Login_idLogin  ";

    final String UPDATE = "UPDATE login SET "
            + "usuario = ?, senha = ? "
            + "WHERE idLogin = ? ";

    final String EXCLUIR = " DELETE FROM login WHERE (idLogin = ?)";

    final String CRIAR_ALUNO = "CREATE TABLE IF NOT EXISTS escola.aluno ("
            + "  idAluno bigint NOT NULL, "
            + "  codAluno varchar(50) NOT NULL, "
            + "  nome varchar(50) NOT NULL, "
            + "  PRIMARY KEY (idAluno) "
            + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 ";

    final String CRIAR_CURSO = "CREATE TABLE IF NOT EXISTS escola.curso ( "
            + "  idCurso bigint NOT NULL, "
            + "  codCurso varchar(50) NOT NULL, "
            + "  descricao varchar(50) DEFAULT NULL, "
            + "  ementa text, "
            + "  PRIMARY KEY (idCurso) "
            + ") ENGINE=InnoDB DEFAULT CHARSET=utf8";

    final String CRIAR_CURSOALUNO = "CREATE TABLE IF NOT EXISTS escola.curso_aluno ( "
            + "  idcurso_aluno bigint NOT NULL, "
            + "  Curso_idCurso bigint NOT NULL, "
            + "  Aluno_idAluno bigint NOT NULL, "
            + "  PRIMARY KEY (idcurso_aluno), "
            + "  KEY fk_curso_aluno_Curso1_idx (Curso_idCurso), "
            + "  KEY fk_curso_aluno_Aluno1_idx (Aluno_idAluno), "
            + "  CONSTRAINT fk_curso_aluno_Aluno1 FOREIGN KEY (Aluno_idAluno) REFERENCES escola.aluno (idAluno), "
            + "  CONSTRAINT fk_curso_aluno_Curso1 FOREIGN KEY (Curso_idCurso) REFERENCES escola.curso (idCurso) "
            + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 ";

    final String CRIAR_LOGIN = "CREATE TABLE IF NOT EXISTS escola.login ( "
            + "  idLogin bigint NOT NULL, "
            + "  usuario varchar(45) DEFAULT NULL, "
            + "  senha varchar(45) DEFAULT NULL, "
            + "  admin int DEFAULT NULL, "
            + "  PRIMARY KEY (idLogin), "
            + " UNIQUE KEY (usuario) "            
            + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

    final String CRIAR_PESSOA = "CREATE TABLE IF NOT EXISTS escola.pessoa ( "
            + "  idPessoa bigint NOT NULL, "
            + "  nome varchar(50) DEFAULT NULL, "
            + "  idade int DEFAULT NULL, "
            + "  dataNascimento date DEFAULT NULL, "
            + "  Login_idLogin bigint NOT NULL, "
            + "  sexo varchar(50) DEFAULT NULL, "
            + "  cpf varchar(50) DEFAULT NULL, "
            + "  PRIMARY KEY (idPessoa), "
            + "  KEY fk_Login (Login_idLogin), "
            + "  CONSTRAINT fk_Pessoa_Login1 FOREIGN KEY (Login_idLogin) REFERENCES escola.login (idLogin) "
            + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 ";

    final String CRIAR_BANCO = "CREATE DATABASE  IF NOT EXISTS escola";
    
    final String CRIAR_USUARIO = "INSERT IGNORE INTO escola.Login(idLogin, "
            + " usuario, senha, admin) VALUES (1, 'admin', 'admin', 1) "
            + " ON DUPLICATE KEY UPDATE usuario=VALUES(usuario)";

    public boolean save(Login login);

    public boolean exclui(long idLogin);

    public long recuperaUltimoId();

    public int consultaLogin(String usuario, String senha);

    public String consultaLoginUsuario(long idPessoa);

    public boolean verificaUsuario(String usuario);

    public long consultaLongUsuario(long idPessoa);

    public boolean update(Login login, long idOld);

    public void criarBancoDados();
}
