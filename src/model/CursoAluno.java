/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PICHAU
 */
public class CursoAluno {
    
    private long idCursoAluno;
    private long idAluno;
    private long idCurso;
    
    public CursoAluno(long idCursoAluno) {
        this.idCursoAluno = idCursoAluno;
    }

    public long getIdCursoAluno() {
        return idCursoAluno;
    }

    public void setIdCursoAluno(long idCursoAluno) {
        this.idCursoAluno = idCursoAluno;
    }

    public long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(long idAluno) {
        this.idAluno = idAluno;
    }

    public long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(long idCurso) {
        this.idCurso = idCurso;
    }
    
    
    
}
