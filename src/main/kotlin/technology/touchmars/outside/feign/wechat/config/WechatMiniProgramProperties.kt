/**
 *
 */
package technology.touchmars.outside.feign.wechat.config

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * @author jhcao
 */
@ConfigurationProperties(prefix = "wechat.mini")
class WechatMiniProgramProperties {
    val clientId: String? = null
    val secret: String? = null
}
