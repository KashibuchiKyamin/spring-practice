package com.kashibuchikyamin.spring_practice.presentation.ui.top;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * トップ画面に関するコントローラー
 */
@Controller
public class TopController {

	/**
	 * トップ画面を表示する
	 * @return トップ画面のテンプレート名
	 */
	@GetMapping("/top")
	public String showTop() {
		return "top";
	}
}
