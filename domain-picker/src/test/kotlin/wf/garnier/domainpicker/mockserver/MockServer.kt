package wf.garnier.domainpicker.mockserver

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

class MockServer {
    val server = MockWebServer()

    fun addJsonResponse(json: String) {
        val response = MockResponse()
                .setBody(json)
                .setHeader("Content-type", "application/json")
        server.enqueue(response)
    }

    fun url() = server.url("/").toString()

    fun requestUrl() = server.takeRequest().requestUrl.toString()
}