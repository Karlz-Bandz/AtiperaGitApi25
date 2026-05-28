package com.atipera.gitapi25;

public record RepositoryDto(
        String name,
        boolean fork,
        OwnerDto owner
) {
}
