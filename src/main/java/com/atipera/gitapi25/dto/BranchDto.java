package com.atipera.gitapi25.dto;

public record BranchDto(
        String name,
        String lastCommitSha
) {
}
