/**
 *
 */
package technology.touchmars.feign.wechat.client.config

import feign.codec.DecodeException

/**
 * @author jhcao
 */
@SuppressWarnings("serial")
class WechatClientException : DecodeException {

    var errorCode: Int? = 0
        private set

    constructor(modelApiResponse: SimpleResponse) : super(modelApiResponse.errmsg) {
        this.errorCode = modelApiResponse.errcode
    }

    constructor(errCode: Int, errMsg: String) : super(errMsg) {
        this.errorCode = errCode
    }

    @Override
    override fun toString(): String {
        return String.format("WechatClientException::\n errorCode = %s, errorMsg = %s", errorCode, message)
    }
}
