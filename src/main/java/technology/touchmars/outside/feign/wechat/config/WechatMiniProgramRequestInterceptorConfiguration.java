package technology.touchmars.outside.feign.wechat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class WechatMiniProgramRequestInterceptorConfiguration {

	@Autowired
	private WechatMiniProgramProperties miniProgramProperties;
	
	@Bean
	public RequestInterceptor wechatMiniProgramExchangeCodeRequestInterceptor() {
		return new WechatMiniProgramExchangeCodeRequestInterceptor(
			miniProgramProperties.getClientId(), miniProgramProperties.getSecret()
		);
	}

}
