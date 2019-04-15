package com.bodfod.issuesdashboard.events

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class GithubProject(@Id @GeneratedValue val id: Long = 0,
                         val orgName: String = "",
                         @Column(unique = true) val repoName: String = "")