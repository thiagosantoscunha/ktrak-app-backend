package br.com.ktrak.domain.converters;

import br.com.ktrak.domain.dto.MatriculaDto;
import br.com.ktrak.domain.entities.MatriculaEntity;
import org.springframework.stereotype.Service;

@Service
public class MatriculaConverter extends Converter<MatriculaDto, MatriculaEntity> {
    public MatriculaConverter() {
        super(fromDto -> {
            MatriculaEntity entity = new MatriculaEntity();
            entity.setId(fromDto.getId());
            entity.setAluno(new AlunoConverter().toEntity(fromDto.getAluno()));
            entity.setTurma(new TurmaConverter().toEntity(fromDto.getTurma()));
            return entity;
        }, fromEntity -> new MatriculaDto(
                fromEntity.getId(),
                new AlunoConverter().toDto(fromEntity.getAluno()),
                new TurmaConverter().toDto(fromEntity.getTurma())
        ));
    }
}
