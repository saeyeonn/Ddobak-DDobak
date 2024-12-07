package org.itm.ddobak.swagger

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders

@Configuration
class SwaggerConfig {
    @Configuration
    class SwaggerConfig {
        @Bean
        fun openAPI(): OpenAPI {
            val info = Info()
                .title("또박또박")
                .version("v1.0.0")
                .description("OnTime 인터페이스 설계")

            return OpenAPI()
                .info(info)
        }
    }
}