package com.bodfod.issuesdashboard.github

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.web.client.RestTemplate
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class GithubClient {
    private val restTemplate: RestTemplate

    private val EVENT_ISSUES_URL = "https://api.github.com/repos/{owner}/{repo}/issues/events"

    constructor(builder: RestTemplateBuilder) {
        this.restTemplate = builder.build()
    }

    fun fetchEvents(orgName: String, repoName: String): ResponseEntity<Array<RepositoryEvent>> {
        return this.restTemplate.getForEntity(EVENT_ISSUES_URL, Array<RepositoryEvent>::class.java, orgName, repoName)
    }
}