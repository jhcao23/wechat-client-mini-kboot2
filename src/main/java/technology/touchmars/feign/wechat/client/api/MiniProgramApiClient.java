package technology.touchmars.feign.wechat.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import technology.touchmars.outside.feign.wechat.config.WechatMiniProgramCommonConfiguration;
import technology.touchmars.outside.feign.wechat.config.WechatMiniProgramRequestInterceptorConfiguration;

import static technology.touchmars.feign.wechat.client.api.MiniProgramConstant.URL_BASE;

@FeignClient(name="miniProgramApiClient", url=URL_BASE,
	configuration={WechatMiniProgramRequestInterceptorConfiguration.class, WechatMiniProgramCommonConfiguration.class}
)
public interface MiniProgramApiClient extends MiniProgramApi {

}
