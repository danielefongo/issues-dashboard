package com.bodfod.issuesdashboard.github

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime

data class RepositoryEvent @JsonCreator constructor(
        @JsonProperty("event") val type: String,
        @JsonProperty("created_at") val creationTime: OffsetDateTime,
        @JsonProperty("actor") val actor: Actor,
        @JsonProperty("issue") val issue: Issue)

data class Actor @JsonCreator constructor(
        @JsonProperty("login") val login: String,
        @JsonProperty("avatar_url") val avatarUrl: String,
        @JsonProperty("html_url") val htmlUrl: String)

data class Issue @JsonCreator constructor(
        @JsonProperty("html_url") val htmlUrl: String,
        @JsonProperty("number") val number: Int,
        @JsonProperty("title") val title: String
)