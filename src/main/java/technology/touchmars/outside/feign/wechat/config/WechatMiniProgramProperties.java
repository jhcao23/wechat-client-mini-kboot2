/**
 * 
 */
package technology.touchmars.outside.feign.wechat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * @author jhcao
 *
 */
@Data
@ConfigurationProperties(prefix = "wechat.mini")
public class WechatMiniProgramProperties {
	private String clientId;
	private String secret;
}
