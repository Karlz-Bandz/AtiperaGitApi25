package com.atipera.gitapi25;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class GitClient {

    private final RestClient restClient;

    public GitClient() {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.github.com")
                .build();
    }

    List<RepositoryDto> getUserRepos(String username) {
        try {
            return this.restClient.get()
                    .uri("/users/{username}/repos", username)
                    .retrieve()
                    .body(new ParameterizedTypeReference<List<RepositoryDto>>() {});
        } catch (HttpClientErrorException.NotFound ex) {
            throw new UserNotFoundException("User not found!");
        }
    }

    List<BranchDto> getBranches(String owner, String repo) {
        return this.restClient.get()
                .uri("/repos/{owner}/{repo}/branches", owner, repo)
                .retrieve()
                .body(new ParameterizedTypeReference<List<BranchDto>>() {});
    }
}
