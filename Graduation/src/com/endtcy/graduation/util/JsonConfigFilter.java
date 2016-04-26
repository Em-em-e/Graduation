package com.endtcy.graduation.util;

import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

/**
 *	用来生成JsonConfig实例
 *  以过滤不需要转换的属性（关联属性必须过滤，否则会发生异常）
 * @author Administrator
 *
 */
public class JsonConfigFilter {
	public static JsonConfig getConfig(String[] param){
		//通过jsonConfig过滤不需要转换的属性，避免关联属性转换死循环
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setIgnoreDefaultExcludes(false);//设置默认忽略
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);//设置循环策略为忽略
		//要忽略的属性数组
		jsonConfig.setExcludes(param);
		return jsonConfig;
	}
}
