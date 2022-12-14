package com.imooc.service.impl;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.imooc.dao.HeadLineDao;
import com.imooc.entity.HeadLine;
import com.imooc.service.HeadLineService;


@Service
public class HeadLineServiceImpl implements HeadLineService {
	@Autowired
	private HeadLineDao headLineDao;

	@Override
	@Transactional
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException{
		return headLineDao.queryHeadLine(headLineCondition);
	}

}
