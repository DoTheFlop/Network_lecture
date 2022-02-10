package chap8;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class QueryString {
	private StringBuilder query = new StringBuilder();
	public QueryString() {		
	}
	public synchronized void add(String name, String value) {
		query.append('&');
		encode(name, value);
	}
	private synchronized void encode(String name, String value) {
		try {
			query.append(URLEncoder.encode(name, "UTF-8"));
			query.append('=');
			query.append(URLEncoder.encode(value, "UTF-8"));
		} catch (UnsupportedEncodingException ex) {
			throw new RuntimeException("Broken VM does not support UTF-8");
		}
	}
	public synchronized String getQuery() {
		return query.toString();
	}
	@Override
	public String toString() {
		return getQuery();
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		QueryString qs = new QueryString();
		qs.add("h1", "en");
		qs.add("as_q", "Java");
		qs.add("as_epq", "I/O");
		qs.add("q", "ÇÑ¹ç");
		String url = "http://www.google.com/serch?" + qs;
		System.out.println(url);
		
		String input = "http://www.google.com/" + "serch?h1=en&as_q=Java&as_epq=I%2FO";
		String output = URLDecoder.decode(input, "UTF-8");
		System.out.println(output);
		
	}
}