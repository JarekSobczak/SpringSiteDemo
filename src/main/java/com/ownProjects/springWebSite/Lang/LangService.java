package com.ownProjects.springWebSite.Lang;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class LangService {
    LangRepository repository;

    LangService(LangRepository repository){
        this.repository=repository;
    }
    List<LangDTO>findAll(){
        return repository.findAll().stream()
                .map(LangDTO::new)
                .collect(Collectors.toList());
    }
}
