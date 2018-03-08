package technology.touchmars.feign.wechat.client.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

import technology.touchmars.feign.wechat.client.model.SessionKeyToken

interface MiniProgramUnionApi {

    @GetMapping(value = "/sns/jscode2session", headers = [ "Content-Type=application/json", "Accept=application/json" ])
    fun exchangeCode(
            @RequestParam(name = "appid", required = true) appId: String,
            @RequestParam(name = "secret", required = true) secret: String,
            @RequestParam(name = "js_code", required = true) code: String,
            @RequestParam(name = "grant_type", required = false, defaultValue = "authorization_code") grantType: String
    ): ResponseEntity<SessionKeyToken>
}
