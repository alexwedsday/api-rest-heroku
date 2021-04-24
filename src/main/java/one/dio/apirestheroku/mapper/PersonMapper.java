package one.dio.apirestheroku.mapper;

import one.dio.apirestheroku.dto.request.PersonDTO;
import one.dio.apirestheroku.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper  INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
