package com.bodfod.issuesdashboard.github

import com.bodfod.issuesdashboard.GithubProperties
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.web.client.RestTemplate
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.util.Base64Utils
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpRequest
import java.io.IOException
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.util.StringUtils

@Component
class GithubClient {
    private val restTemplate: RestTemplate

    private val EVENT_ISSUES_URL = "https://api.github.com/repos/{owner}/{repo}/issues/events"

    constructor(builder: RestTemplateBuilder, properties: GithubProperties) {
        this.restTemplate = builder.additionalInterceptors(GithubAppTokenInterceptor(properties.token)).build()
    }

    fun fetchEvents(orgName: String, repoName: String): ResponseEntity<Array<RepositoryEvent>> {
        return this.restTemplate.getForEntity(EVENT_ISSUES_URL, Array<RepositoryEvent>::class.java, orgName, repoName)
    }

    private class GithubAppTokenInterceptor internal constructor(private val token: String) : ClientHttpRequestInterceptor {
        @Throws(IOException::class)
        override fun intercept(request: HttpRequest, body: ByteArray, execution: ClientHttpRequestExecution): ClientHttpResponse {
            if (StringUtils.hasText(this.token)) {
                val basicAuthValue = this.token.toByteArray()
                request.headers.set(HttpHeaders.AUTHORIZATION,
                        "Basic " + Base64Utils.encodeToString(basicAuthValue))
            }
            return execution.execute(request, body)
        }
    }

}