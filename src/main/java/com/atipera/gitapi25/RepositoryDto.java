package com.atipera.gitapi25;

record RepositoryDto(
        String name,
        boolean fork,
        OwnerDto owner
) {
}
