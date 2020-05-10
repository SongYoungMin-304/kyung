package com.song.kyung.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.kyung.Mapper.NoticeMapper;
import com.song.kyung.Vo.Notice;

@Service
public class NoticeService {
	
	@Autowired 
	NoticeMapper noticeMapper;
	
	public int addNoticeAction(Notice notice)
	{
		return noticeMapper.addNoticeAction(notice);
	}
	
	public List<Notice> getNotices()
	{
		return noticeMapper.getNotices();
	}
	
	public Notice getNoticeById(int id)
	{
		return noticeMapper.getNoticeById(id);
	}
	
	public int deleteNoticeById(int id)
	{
		return noticeMapper.deleteNoticeById(id);
	}
	
	public int setNoticeById(Notice notice)
	{
		return noticeMapper.setNoticeById(notice);
	}
	
	public int addReadCount(int id)
	{
		return noticeMapper.addReadCount(id);
	}

}
