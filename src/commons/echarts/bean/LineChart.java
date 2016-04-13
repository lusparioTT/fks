package commons.echarts.bean;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.nutz.lang.Stopwatch;

import com.alibaba.fastjson.JSON;

import cn.edu.gdut.zaoying.EChartsAnnotationProcessor;
import cn.edu.gdut.zaoying.SingleChart;
import cn.edu.gdut.zaoying.Option.series.line.DataArray;
import cn.edu.gdut.zaoying.Option.series.line.NameString;

@SingleChart(exportTo="lineChart")
public class LineChart {
	@NameString
	int id;
	
	@DataArray
	double[] data;
	
	String name;
	int age;
	
	public static void main(String[] args) {
		LineChart lineChart=new LineChart();
		lineChart.name="线型图标";
		lineChart.data = new double[]{1,2,3,4};
		
		Object jsonObject = EChartsAnnotationProcessor.parseChart(lineChart);
		
		//nutz json
		Stopwatch stopwatch1=Stopwatch.beginNano();
		System.out.println(Json.toJson(jsonObject, JsonFormat.forLook()));
		stopwatch1.stop();
		System.out.println(stopwatch1.getDuration());
		
		//alibaba fastjson
		Stopwatch stopwatch2=Stopwatch.beginNano();
		System.out.println(JSON.toJSONString(jsonObject));
		stopwatch2.stop();
		System.out.println(stopwatch2.getDuration());
	}
}
