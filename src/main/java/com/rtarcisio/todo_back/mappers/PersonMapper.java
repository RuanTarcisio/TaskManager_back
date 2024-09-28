package com.rtarcisio.todo_back.mappers;


import com.rtarcisio.todo_back.domains.Person;
import com.rtarcisio.todo_back.dtos.input.UsuarioInput;
import com.rtarcisio.todo_back.dtos.PersonDto;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

	public Person inputToPerson(UsuarioInput input) {


		return Person.builder()
				.cpf(input.getCpf())
				.email(input.getEmail())
				.dataNascimento(input.getDataNascimento())
				.nomeCompleto(input.getNomeCompleto())
				.passwd(input.getPasswd())
				.build();
				
	}

	 public PersonDto personToDTO(Person person){
	        return PersonDto.builder()
					.id(person.getId())
					.cpf(person.getCpf())
					.email(person.getEmail())
					.nomeCompleto(person.getNomeCompleto())
					.dataNascimento(person.getDataNascimento())
	                .build();
	    }
}
