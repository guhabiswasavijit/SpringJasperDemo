package com.spring.jrrepo.config;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.customizers.shape.Point;
import net.sf.jasperreports.customizers.shape.ShapePoints;


public class StarShapePoints extends ShapePoints 
{
	public static final StarShapePoints INSTANCE = new StarShapePoints();
	
	private StarShapePoints()
	{
		List<Point> points = new ArrayList<Point>();
		points.add(new Point(0, 707));
		points.add(new Point(747, 707));

		points.add(new Point(971, 0));
		points.add(new Point(1201, 707));
		points.add(new Point(1943, 707));
		points.add(new Point(1343, 1143));
		points.add(new Point(1572, 1849));
		points.add(new Point(971, 1414));
		points.add(new Point(371, 1849));
		points.add(new Point(600, 1143));
		points.add(new Point(0, 707));
		setPoints(points);
	}
}
