package com.nexum.backend.services.freelancer;

import com.google.gson.Gson;
import com.nexum.backend.domain.controle.acesso.FreelancerEntity;
import com.nexum.backend.domain.controle.acesso.RoleEntity;

import com.nexum.backend.domain.endereco.EnderecoEntity;
import com.nexum.backend.dto.freelancer.FreelancerDTO;
import com.nexum.backend.dto.freelancer.endereco.request.EnderecoDTOUpdateRequest;
import com.nexum.backend.mappers.freelancer.FreelancerDTOMapper;

import com.nexum.backend.enums.RoleName;

import com.nexum.backend.repositories.shared.controle.acesso.SpringRoleRepository;
import com.nexum.backend.repositories.freelancer.SpringFreelancerRepository;

import com.nexum.backend.services.freelancer.interfaces.FreelancerServicePort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class FreelancerService implements FreelancerServicePort {

    private final SpringFreelancerRepository springFreelancerRepository;
    private final SpringRoleRepository springRoleRepository;

    public FreelancerService(SpringFreelancerRepository springFreelancerRepository, SpringRoleRepository springRoleRepository) {
        this.springFreelancerRepository = springFreelancerRepository;
        this.springRoleRepository = springRoleRepository;
    }

    @Override
    public void create(FreelancerDTO freelancer) {
        FreelancerEntity user = new FreelancerEntity(freelancer.getNome(), freelancer.getEmail(), freelancer.getSenha(), freelancer.getCelular());

        RoleEntity role = springRoleRepository.findByRoleName(RoleName.ROLE_FREELANCER);

        user.getRoles().add(role);

        springFreelancerRepository.save(user);
    }

    @Modifying
    @Transactional
    public void updateAddress(String cep, Long id_freelancer) throws IOException {
        URL url = new URL("https://viacep.com.br/ws/"+cep+"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

        String cep2 = "";
        StringBuilder jsonCep = new StringBuilder();

        while ((cep2 = br.readLine()) != null){
            jsonCep.append(cep2);
        }

        EnderecoDTOUpdateRequest enderecoDTOUpdateRequest =
                new Gson().fromJson(jsonCep.toString(), EnderecoDTOUpdateRequest.class);

        Optional<FreelancerEntity> freelancerEntity = springFreelancerRepository.findById(id_freelancer);

        if(freelancerEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Freelancer não encontrado");
        }

        EnderecoEntity enderecoEntity = new EnderecoEntity(
                enderecoDTOUpdateRequest.getLocalidade(),
                enderecoDTOUpdateRequest.getUf()
        );

        freelancerEntity.get().setEndereco(enderecoEntity);

        springFreelancerRepository.save(freelancerEntity.get());

    }

    @Override
    public Collection<FreelancerDTO> listAll() {
        return springFreelancerRepository
                    .findAll()
                    .stream()
                    .map((freelancer -> FreelancerDTOMapper.toFreelancerDTO(freelancer)))
                    .collect(Collectors.toList());
    }

    @Override
    public Collection<FreelancerDTO> listAllWithImage() {
        return null;
    }

    @Override
    public Integer countNumberFreelancers() {
        return springFreelancerRepository.countNumberFreelancers();
    }

    @Override
    public FreelancerDTO getById(Long id) {

        Optional<FreelancerEntity> optionalFreelancer = springFreelancerRepository.findById(id);

        if (optionalFreelancer.isPresent()) {
            return FreelancerDTOMapper.toFreelancerDTO(optionalFreelancer.get());
        }

        return null;
    }
}
