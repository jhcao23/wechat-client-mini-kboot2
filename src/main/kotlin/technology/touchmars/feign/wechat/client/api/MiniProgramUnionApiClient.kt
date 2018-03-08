package technology.touchmars.feign.wechat.client.api

import org.springframework.cloud.openfeign.FeignClient
import technology.touchmars.outside.feign.wechat.config.WechatMiniProgramCommonConfiguration

@FeignClient(name = "miniProgramUnionApiClient", url = MiniProgramConstant.URL_BASE, configuration = [WechatMiniProgramCommonConfiguration::class])
interface MiniProgramUnionApiClient : MiniProgramUnionApi
