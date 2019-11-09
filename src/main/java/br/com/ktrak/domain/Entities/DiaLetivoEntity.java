package br.com.ktrak.domain.entities;

import java.util.Date;
import java.util.List;

public class DiaLetivoEntity {
    private Long id;
    private Date data;
    private TurmaEntity turma;
    private List<MatriculaDiaLetitvoEntity> matriculaDiaLetivos;
}
