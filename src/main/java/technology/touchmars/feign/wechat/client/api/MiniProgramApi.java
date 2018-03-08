package technology.touchmars.feign.wechat.client.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import technology.touchmars.feign.wechat.client.model.SessionKeyToken;

public interface MiniProgramApi {

	@GetMapping(value="/sns/jscode2session")
	public ResponseEntity<SessionKeyToken> exchangeCode(
			@RequestParam(value = "js_code", required = true) String code);
}
