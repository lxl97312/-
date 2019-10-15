package com.thunisoft.mail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.thunisoft.mail.utils.MailUtils;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailApplication.class, args);
		MailUtils mail=new MailUtils();
		try {
			
			StringBuffer msg=new StringBuffer();
			msg.append("预警1：<br>");
			msg.append("业务类别：食品 <br> 指标名称：投诉举报数量 <br> 计算区间：单月内  正常范围：20件-50件  同比正常范围：10%-20%  环比正常范围：10%-20%	单位：广西自治区市场监管局  上期（2019 -08 -01至2019 -08 -31）：10件  同期（2018 -08 -01至2018 -08 -31） ：\"\n" + 
					"					+ \"30件  上年（2018 -01 -01至2018 -12 -31）：500件   本年（2019 -01 -01至2019-09 -30）：300件  本期（2019 -09 -01至2019 -09 -30）：60件↑  同比：100%↑  环比：500%↑\"");
			
System.out.println(msg);
String msg1=msg.toString();
			mail.sendMail("liuxiaolin@thunisoft.com", "预警提醒：投诉举报数量；抽检不合格数量等", msg1);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
