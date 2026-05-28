package com.atipera.gitapi25;

public record BranchDto(
        String name,
        CommitDto commit
) {
}
