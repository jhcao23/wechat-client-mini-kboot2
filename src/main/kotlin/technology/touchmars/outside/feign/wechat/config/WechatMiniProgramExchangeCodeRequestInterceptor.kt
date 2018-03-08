package technology.touchmars.outside.feign.wechat.config

import feign.RequestInterceptor
import feign.RequestTemplate

/**
 * the request format is:
 * `https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code`
 *
 * @author jhcao
 */
class WechatMiniProgramExchangeCodeRequestInterceptor(private val clientId: String, private val secret: String) : RequestInterceptor {

    @Override
    override fun apply(template: RequestTemplate) {
        template
                .query(PARAM_NAME_APP_ID, clientId)
                .query(PARAM_NAME_SECRET, secret)
                .query(PARAM_NAME_GRANT_TYPE, PARAM_VALUE_GRANT_TYPE)
    }

    companion object {

        const val PARAM_NAME_APP_ID = "appid"
        const val PARAM_NAME_SECRET = "secret"
        const val PARAM_NAME_GRANT_TYPE = "grant_type"
        const val PARAM_VALUE_GRANT_TYPE = "authorization_code"
    }

}
