package com.bodfod.issuesdashboard

import com.bodfod.issuesdashboard.github.GithubClient
import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.stereotype.Component

@Component
class GithubHealthIndicator(private val githubClient: GithubClient) : HealthIndicator {
    override fun health(): Health {
        try {
            val response = this.githubClient.fetchEvents("spring-projects", "spring-boot")
            if (response.statusCode.is2xxSuccessful)
                return Health.up().build()

            return Health.outOfService().build()
        } catch(e: Exception) {
            return Health.down(e).build()
        }
    }
}