package com.senpure.base.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Dom4jUtil {




	/**
	 * <b>乱序结构无法解析</b>
	 * 
	 * @param in
	 * @return
	 * @throws DocumentException
	 */
	public static Map<String, Object> xmlToMap(InputStream in) throws DocumentException {


		return xmlToMap(in, true);
	}


	public static Map<String, Object> xmlToMap(InputStream in, boolean skipRoot) throws DocumentException {

		SAXReader reader = new SAXReader();

		Document document = reader.read(in);
		Element root = document.getRootElement();
		return xmlToMap(root,skipRoot);
	}


	public static Map<String, Object> xmlToMap(String xmlStr, boolean skipRoot) throws DocumentException {

		Document document = DocumentHelper.parseText(xmlStr);
		return xmlToMap(document.getRootElement(),skipRoot);
	}



	public static Map<String, Object> xmlToMap(String xmlStr) throws DocumentException {

		return xmlToMap(xmlStr, true);
	}


	private static Map<String, Object> xmlToMap(Element root, boolean skipRoot) {
		Map<String, Object> xml = new HashMap<>();

		xmlToMap(root, xml, skipRoot);
		return xml;
	}

	private static void xmlToMap(Element e, Map<String, Object> xml, boolean skipRoot) {
		boolean root = e.isRootElement();
		List<Element> es = e.elements();
		int size = es.size();
		if (size == 0) {
			xml.put(e.getName(), e.getStringValue());
		} else if (size == 1) {

			Element _e = es.get(0);
			if (root && skipRoot) {
				xmlToMap(_e, xml, false);
			} else {
				Map<String, Object> _xml = new HashMap<>();
				xmlToMap(_e, _xml, false);
				xml.put(e.getName(), _xml);
			}

		} else {

			if (root && skipRoot) {

				for (Element _e : es) {
					xmlToMap(_e, xml, false);

				}

			}

			else {
				List<Map<String, Object>> _xmls = new ArrayList<>();

				for (Element _e : es) {

					Map<String, Object> _xml = new HashMap<>();
					xmlToMap(_e, _xml, false);
					_xmls.add(_xml);
				}
				xml.put(es.get(0).getName(), _xmls);
			}

		}
	}


	public static String mapToXmlString(Map<String, Object> map) {

		StringBuilder sb = new StringBuilder();

		mapToXmlString(map, sb);
		return sb.toString();
	}


	private static void mapToXmlString(Map<String, Object> map, StringBuilder sb) {

		for (Entry<String, Object> entry : map.entrySet()) {
			sb.append("<").append(entry.getKey()).append(">");

			Object o = entry.getValue();
			if (o instanceof Map) {

				mapToXmlString((Map<String, Object>) o, sb);
			} else {
				sb.append("<![CDATA[");
				sb.append(entry.getValue().toString());
				sb.append("]]>");
			}
			sb.append("</").append(entry.getKey()).append(">");
		}

	}

	public static void main(String[] args) throws Exception {

		SAXReader reader = new SAXReader();

		try {
			Document document = reader.read(new File("D:\\xml.xml"));

			System.out.println(document.getRootElement().elements());

			Map<String, Object> map = xmlToMap(document.getRootElement(), false);
			System.out.println(map);

			System.out.println(mapToXmlString(map));

		} catch (DocumentException e) {


			e.printStackTrace();
		}
	}

}
