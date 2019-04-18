package io.spring.demo.issuesdashboard.events

import com.bodfod.issuesdashboard.events.GithubProject
import com.bodfod.issuesdashboard.github.RepositoryEvent

class DashboardEntry(val project: GithubProject, val events: List<RepositoryEvent>)