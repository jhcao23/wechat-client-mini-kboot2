package technology.touchmars.feign.wechat.client.api

import org.springframework.cloud.openfeign.FeignClient
import technology.touchmars.outside.feign.wechat.config.WechatMiniProgramCommonConfiguration
import technology.touchmars.outside.feign.wechat.config.WechatMiniProgramRequestInterceptorConfiguration

@FeignClient(name = "miniProgramApiClient", url = MiniProgramConstant.URL_BASE, configuration = [ WechatMiniProgramRequestInterceptorConfiguration::class, WechatMiniProgramCommonConfiguration::class ])
interface MiniProgramApiClient : MiniProgramApi
