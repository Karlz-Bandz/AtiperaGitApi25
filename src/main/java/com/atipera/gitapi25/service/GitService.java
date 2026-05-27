package com.atipera.gitapi25.service;

import com.atipera.gitapi25.client.GitClient;
import com.atipera.gitapi25.dto.RepositoryDto;
import com.atipera.gitapi25.dto.RepositoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GitService {

    private final GitClient gitClient;

    public List<RepositoryResponseDto> getRepositories(String username) {

        List<RepositoryDto> repositories = gitClient.getUserRepos(username);

        return repositories.stream()
                .filter(r -> !r.fork())
                .map(r ->
                        new RepositoryResponseDto(
                                r.name(),
                                r.owner().login(),
                                gitClient.getBranches(r.owner().login(), r.name())
                        ))
                .toList();
    }
}
