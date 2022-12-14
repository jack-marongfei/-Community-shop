package com.imooc.service;

import java.io.IOException;
import java.util.List;

import com.imooc.dto.HeadLineExecution;
import com.imooc.dto.ImageHolder;
import com.imooc.entity.HeadLine;

public interface HeadLineService {
	public static final String HLLISTKEY = "headlinelist";

	/**
	 * 根据传入的条件返回指定的头条列表
	 * 
	 * @param headLineCondition
	 * @return
	 * @throws IOException
	 */
	List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException;

}
