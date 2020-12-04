
package edu.citytech.cst.securities.s23356435;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLUtility {

	public static <T> Stream<T> process(final String fileName, final String mainElement,
			final Function<Element, T> function) {

		List<T> list = new ArrayList<>();

		try {

			File fXmlFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(mainElement);

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Element element = (Element) nList.item(temp);
				T row = function.apply(element);
				list.add(row);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list.stream();
	}

}