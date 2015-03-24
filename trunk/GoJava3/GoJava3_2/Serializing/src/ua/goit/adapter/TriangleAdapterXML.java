package ua.goit.adapter;

import ua.goit.model.ContainerShapes;
import ua.goit.model.Triangle;
import ua.goit.serializers.Serializer;

public class TriangleAdapterXML implements Serializer {

  public String serialize(ContainerShapes object) {
    Triangle triangle = (Triangle) object;
    StringBuilder xml = new StringBuilder();
    xml.append("<triangle>");

    xml.append("<point1>");
    xml.append("<x>" + triangle.getPoint1().x + "</x>");
    xml.append("<y>" + triangle.getPoint1().y + "</y>");
    xml.append("</point1>");

    xml.append("<point2>");
    xml.append("<x>" + triangle.getPoint2().x + "</x>");
    xml.append("<y>" + triangle.getPoint2().y + "</y>");
    xml.append("</point2>");

    xml.append("<point3>");
    xml.append("<x>" + triangle.getPoint3().x + "</x>");
    xml.append("<y>" + triangle.getPoint3().y + "</y>");
    xml.append("</point3>");

    xml.append("</triangle>");

    return xml.toString();
  }

}