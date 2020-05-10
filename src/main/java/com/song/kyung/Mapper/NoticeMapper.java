package com.song.kyung.Mapper;

import java.util.List;

import com.song.kyung.Vo.Notice;

public interface NoticeMapper {
	public int addNoticeAction(Notice notice);

	public List<Notice> getNotices();

	public Notice getNoticeById(int id);
	
	public int deleteNoticeById(int id);
	
	public int setNoticeById(Notice notice);
	
	public int addReadCount(int id);
}
