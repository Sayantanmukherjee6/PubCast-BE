package me.muan.pubcast.core.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotBlank

@Validated
@Configuration
@ConfigurationProperties(prefix = "auth0")
class Auth0Config {

    @NotBlank
    var domain: String = ""

    @NotBlank
    var audience: String = ""

    @NotBlank
    var clientId: String = ""

    @NotBlank
    var clientSecret: String = ""

}
