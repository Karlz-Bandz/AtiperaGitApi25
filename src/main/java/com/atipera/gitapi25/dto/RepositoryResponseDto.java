package com.atipera.gitapi25.dto;

import java.util.List;

public record RepositoryResponseDto(
        String repositoryName,
        String ownerLogin,
        List<BranchDto> branches
) {
}
