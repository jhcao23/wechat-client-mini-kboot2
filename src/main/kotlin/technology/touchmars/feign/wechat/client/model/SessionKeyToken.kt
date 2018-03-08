package technology.touchmars.feign.wechat.client.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Sample output:
 * {"session_key":"oy2x8R1XYz9soGBTKoMzWQ==","expires_in":7200,"openid":"oHF4L0SJMT9PJJse6qNSqGZeESzo"}
 *
 * Connection →keep-alive
 * Content-Length →100
 * Content-Type →text/plain
 *
 * @author jhcao
 */
class SessionKeyToken {

    @JsonProperty("openid")
    val openId: String? = null

    @JsonProperty("session_key")
    val sessionKey: String? = null

    @JsonProperty("unionid")
    val unionId: String? = null

    @JsonProperty("expires_in")
    val expiresIn: Integer? = null

}
