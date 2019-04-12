package com.bodfod.issuesdashboard.events

import org.springframework.data.repository.PagingAndSortingRepository

interface GithubProjectRepository : PagingAndSortingRepository<GithubProject, Long> {

    fun findByRepoName(repoName: String): GithubProject
}