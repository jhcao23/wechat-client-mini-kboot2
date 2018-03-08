package technology.touchmars.feign.wechat.client.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import technology.touchmars.feign.wechat.client.model.SessionKeyToken;

public interface MiniProgramUnionApi {

	@GetMapping(value="/sns/jscode2session",
			headers = {"Content-Type=application/json","Accept=application/json"})
	public ResponseEntity<SessionKeyToken> exchangeCode(
		@RequestParam(name = "appid", required = true) String appId,
		@RequestParam(name = "secret", required = true) String secret,
		@RequestParam(name = "js_code", required = true) String code,
		@RequestParam(name = "grant_type", required = false, defaultValue="authorization_code") String grantType
	);
}
