package com.atipera.gitapi25.dto;

public record RepositoryDto(
        String name,
        boolean fork,
        OwnerDto owner
) {
}
