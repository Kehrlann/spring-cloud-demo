package wf.garnier.domainservice

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "domain")
class DomainServiceConfiguration(val extensions: MutableList<String> = mutableListOf())