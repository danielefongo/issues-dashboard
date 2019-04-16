package com.bodfod.issuesdashboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(GithubProperties::class)
class IssuesDashboardApplication

fun main(args: Array<String>) {
	runApplication<IssuesDashboardApplication>(*args)
}
