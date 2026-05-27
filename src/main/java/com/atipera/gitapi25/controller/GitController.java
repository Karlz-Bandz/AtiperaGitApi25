package com.atipera.gitapi25.controller;

import com.atipera.gitapi25.dto.RepositoryResponseDto;
import com.atipera.gitapi25.service.GitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/repositories")
public class GitController {

    private final GitService service;

    @GetMapping("/{username}")
    public List<RepositoryResponseDto> getRepositories(@PathVariable String username) {
        return service.getRepositories(username);
    }
}
