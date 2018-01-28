package com.example.ShadowSocksShare.service.tasks;

import com.example.ShadowSocksShare.service.ShadowSocksCrawlerService;
import com.example.ShadowSocksShare.service.ShadowSocksSerivce;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 定时抓取 ss 信息
 */
@Slf4j
@Component
public class ShadowSocksTasks {
	@Autowired
	private ShadowSocksSerivce shadowSocksSerivce;

	@Autowired
	@Qualifier("iShadowCrawlerServiceImpl")
	private ShadowSocksCrawlerService iShadowCrawlerServiceImpl;    // ishadow
	@Autowired
	@Qualifier("doubCrawlerServiceImpl")
	private ShadowSocksCrawlerService doubCrawlerServiceImpl;                // https://doub.io
	@Autowired
	@Qualifier("freeSS_EasyToUseCrawlerServiceImpl")
	private ShadowSocksCrawlerService freeSS_EasyToUseCrawlerServiceImpl;                // https://freess.cx/#portfolio-preview
	@Autowired
	@Qualifier("ss8ServiceImpl")
	private ShadowSocksCrawlerService ss8ServiceImpl;                // https://en.ss8.fun/
	@Autowired
	@Qualifier("freeSSRCrawlerServiceImpl")
	private ShadowSocksCrawlerService freeSSRCrawlerServiceImpl;                // https://global.ishadowx.net/
	@Autowired
	@Qualifier("free_ssServiceImpl")
	private ShadowSocksCrawlerService free_ssServiceImpl;                // https://free-ss.site/
	@Autowired
	@Qualifier("ssrBlueCrawlerServiceImpl")
	private ShadowSocksCrawlerService ssrBlueCrawlerServiceImpl;                // http://www.ssr.blue

	@Scheduled(cron = "0 10 0/3 * * ?")
	public void iShadowCrawler() {
		shadowSocksSerivce.crawlerAndSave(iShadowCrawlerServiceImpl);
	}

	@Scheduled(cron = "0 10 0/6 * * ?")
	public void doubCrawler() {
		shadowSocksSerivce.crawlerAndSave(doubCrawlerServiceImpl);
	}

	@Scheduled(cron = "0 10 0/12 * * ?")
	public void freeSS_EasyToUseCrawler() {
		shadowSocksSerivce.crawlerAndSave(freeSS_EasyToUseCrawlerServiceImpl);
	}

	@Scheduled(cron = "0 10 0/4 * * ?")
	public void ss8Crawler() {
		shadowSocksSerivce.crawlerAndSave(ss8ServiceImpl);
	}

	@Scheduled(cron = "0 10 0/6 * * ?")
	public void freeSSRCrawler() {
		shadowSocksSerivce.crawlerAndSave(freeSSRCrawlerServiceImpl);
	}

	@Scheduled(cron = "0 10 0/6 * * ?")
	public void free_ssCrawler() {
		shadowSocksSerivce.crawlerAndSave(free_ssServiceImpl);
	}

	@Scheduled(cron = "0 10 0/3 * * ?")
	public void ssrBlueCrawler() {
		shadowSocksSerivce.crawlerAndSave(ssrBlueCrawlerServiceImpl);
	}

	/**
	 * SS 有效性检查，每 1 小时
	 */
	// @Scheduled(cron = "0 */2 * * * ?")
	@Scheduled(cron = "0 0 0/1 * * ?")
	public void checkValid() {
		shadowSocksSerivce.checkValid();
	}

	/**
	 * 为防止 herokuapp 休眠，每 10 分钟访问一次
	 */
	@Scheduled(cron = "0 0/20 * * * ?")
	public void monitor() throws IOException {
		Jsoup.connect("https://shadowsocks-share.herokuapp.com/count").get();
	}
}
