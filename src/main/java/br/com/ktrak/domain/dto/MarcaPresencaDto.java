package br.com.ktrak.domain.dto;

import br.com.ktrak.domain.converters.DiaLetivoConverter;
import br.com.ktrak.domain.converters.MatriculaConverter;
import br.com.ktrak.domain.entities.AlunoEntity;
import br.com.ktrak.domain.entities.PresenciamentoEntity;
import br.com.ktrak.domain.services.AlunoService;
import br.com.ktrak.domain.services.DiaLetivoService;
import br.com.ktrak.domain.services.MatriculaService;
import br.com.ktrak.domain.services.TurmaService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class MarcaPresencaDto {

    private String username;
    private String key;

    public MarcaPresencaDto() {
    }
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private MatriculaService matriculaService;
    @Autowired
    private DiaLetivoService diaLetivoService;
    @Autowired
    private TurmaService turmaService;
    @Autowired
    private DiaLetivoConverter diaLetivoConverter;

    @Autowired
    private MatriculaConverter matriculaConverter;

    public MarcaPresencaDto(String username, String key) {
        this.username = username;
        this.key = key;
    }
    public PresenciamentoEntity toEntity() {
        PresenciamentoEntity entity = new PresenciamentoEntity();

        AlunoDto alunoDto=alunoService.buscaPorUsername(username);
        List<TurmaDto> turmas=turmaService.buscaTodasAsTurmasPorAluno(alunoDto.getId());
        List<MatriculaDto> matriculas= matriculaService.buscaTudoPorAluno(alunoDto);

        List<DiaLetivoDto> diasLetivos=new ArrayList<>();
        turmas.forEach(t -> diasLetivos.addAll(diaLetivoService.buscaTudoPorTurmaId(t.getId())));

        MatriculaDto matricula=null;
        DiaLetivoDto diaLetivo=null;
        for(int i=0;i<diasLetivos.size();i++){
            for(int j=0;j<matriculas.size();j++){
                if(matriculas.get(i).getTurma()== diasLetivos.get(i).getTurma()){
                    matricula=matriculas.get(i);
                    diaLetivo=diasLetivos.get(i);

                }
            }
        }
        entity.setMatricula(matriculaConverter.toEntity(matricula));
        entity.setDiaLetivo(diaLetivoConverter.toEntity(diaLetivo));

        entity.setIsPresente(true);
        return entity;
    }
}
