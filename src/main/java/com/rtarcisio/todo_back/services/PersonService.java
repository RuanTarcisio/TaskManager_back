package com.rtarcisio.todo_back.services;


import com.rtarcisio.todo_back.domains.Foto;
import com.rtarcisio.todo_back.domains.Person;
import com.rtarcisio.todo_back.dtos.input.UsuarioInput;
import com.rtarcisio.todo_back.dtos.PersonDto;
import com.rtarcisio.todo_back.mappers.ImageMapper;
import com.rtarcisio.todo_back.mappers.PersonMapper;
import com.rtarcisio.todo_back.repositories.FotoRepository;
import com.rtarcisio.todo_back.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private ImageMapper imgMapper;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private FotoRepository fotoRepository;

    @Transactional
    public Person savePerson(UsuarioInput usuarioInput) {

        Person person = new Person();

        if (usuarioInput.getArquivo() != null) {
            try {
                MultipartFile midia = usuarioInput.getArquivo();
                Foto foto = imgMapper.mapToImage(midia);
                person = personMapper.inputToPerson(usuarioInput);
                person = personRepository.saveAndFlush(person);

                foto.setPerson(person);
                foto = fotoRepository.save(foto);
                person.setFoto(foto);
                return personRepository.saveAndFlush(person);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        person = personMapper.inputToPerson(usuarioInput);
        return personRepository.save(person);


    }


    public PersonDto buscarPorId(Long id) {

        Optional<Person> toFind = personRepository.findById(id);
//        if(!toFind.isPresent())
//            throw new RuntimeException("usuario nao encontrado");

        Optional<Foto> foto = fotoRepository.findByPersonId(id);
        PersonDto dto = personMapper.personToDTO(toFind.get());
        MultipartFile arquivo = null;
        try {
            arquivo = ImageMapper.mapToMultipartFile(foto.get());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        dto.setArquivo(arquivo);

        return dto;
    }
}
