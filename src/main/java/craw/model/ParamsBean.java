package craw.model;

import java.util.Properties;

import org.springframework.stereotype.Component;

@Component
public class ParamsBean {

	private String url;
	private Properties info;

	public ParamsBean() {
	}

	public ParamsBean(String url, Properties info) {
		this.url = url;
		this.info = info;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Properties getInfo() {
		return info;
	}

	public void setInfo(Properties info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "ParamsBean [url=" + url + ", info=" + info + "]";
	}

}
