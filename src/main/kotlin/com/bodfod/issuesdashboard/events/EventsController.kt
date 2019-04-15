package com.bodfod.issuesdashboard.events

import com.bodfod.issuesdashboard.github.GithubClient
import com.bodfod.issuesdashboard.github.RepositoryEvent
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class EventsController(val githubClient: GithubClient, val repository: GithubProjectRepository) {

    @GetMapping("/events/{repoName}")
    @ResponseBody
    fun fetchEvents(@PathVariable repoName: String): Array<RepositoryEvent> {

        val githubProject = repository.findByRepoName(repoName)

        //RepositoryEvent("123", OffsetDateTime.MAX, Actor("123", "123", "123"), Issue())

        return githubClient.fetchEvents(githubProject.orgName, githubProject.repoName).body!!
    }
}