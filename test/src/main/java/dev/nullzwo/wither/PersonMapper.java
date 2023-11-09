package dev.nullzwo.wither;

import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {

    PersonDto map(Person person);
}
