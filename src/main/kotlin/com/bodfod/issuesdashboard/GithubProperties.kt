package com.bodfod.issuesdashboard

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.Pattern

@ConfigurationProperties("github")
@Validated
data class GithubProperties (@Pattern(regexp="\\w+:\\w+") var token: String = "")