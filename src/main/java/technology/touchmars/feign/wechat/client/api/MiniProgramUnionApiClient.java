package technology.touchmars.feign.wechat.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import technology.touchmars.outside.feign.wechat.config.WechatMiniProgramCommonConfiguration;

import static technology.touchmars.feign.wechat.client.api.MiniProgramConstant.URL_BASE;

@FeignClient(name="miniProgramUnionApiClient", url=URL_BASE,
	configuration={WechatMiniProgramCommonConfiguration.class}
)
public interface MiniProgramUnionApiClient extends MiniProgramUnionApi {

}
