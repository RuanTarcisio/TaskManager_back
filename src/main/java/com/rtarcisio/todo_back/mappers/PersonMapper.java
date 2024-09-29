package com.rtarcisio.todo_back.mappers;


import com.rtarcisio.todo_back.domains.Person;
import com.rtarcisio.todo_back.dtos.input.UsuarioInput;
import com.rtarcisio.todo_back.dtos.PersonDto;
import com.rtarcisio.todo_back.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

	public Person inputToPerson(UsuarioInput input) {

		String encryptedPassword = new BCryptPasswordEncoder().encode(input.getPasswd());
		UserRole role;
		if (input.getIsAdmin() == true) {
			role = UserRole.ADMIN;
		}else role = UserRole.USER;

			return Person.builder()
				.cpf(input.getCpf())
				.email(input.getEmail())
				.dataNascimento(input.getDataNascimento())
				.name(input.getName())
				.passwd(encryptedPassword)
				.role(role)
				.build();
				
	}

	 public PersonDto personToDTO(Person person){
	        return PersonDto.builder()
					.id(person.getId())
					.cpf(person.getCpf())
					.email(person.getEmail())
					.nomeCompleto(person.getName())
					.dataNascimento(person.getDataNascimento())
	                .build();
	    }
}
