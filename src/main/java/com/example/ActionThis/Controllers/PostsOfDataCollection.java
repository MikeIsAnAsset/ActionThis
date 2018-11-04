package com.example.ActionThis.Controllers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostsOfDataCollection {

	@RequestMapping("/ObservedProperty")
	public String requestPostObservedProperty() throws Exception {

		JSONObject json = new JSONObject();
		json.put("name", "Traffic Accident");
		json.put("description", "Traffic Accident on Jefferson");
		json.put("definition", "http://www.ObservedPropertyAtJefferson.com");

		String requestJSON = json.toString();

		HttpURLConnection connection = null;
		InputStream is = null;

		try {
			// Create connection
			URL url = new URL("https://stlouis18-03341.sensorup.com/v1.0/ObservedProperties");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			/*
			 * //TODO may be prod or preprod api key if
			 * (apikey.equals(Constants.APIKEY_PREPROD)) {
			 * connection.setRequestProperty("Authorization", Constants.APIKEY_PREPROD); }
			 * if (apikey.equals(Constants.APIKEY_PROD)){
			 * connection.setRequestProperty("Authorization", Constants.APIKEY_PROD); }
			 */
			connection.setRequestProperty("Content-Length", Integer.toString(requestJSON.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoOutput(true);

			// Send request
			System.out.println(requestJSON);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(requestJSON);
			wr.close();

			// Get Response

			try {
				is = connection.getInputStream();
				System.out.println("This try worked");
			} catch (IOException ioe) {
				if (connection instanceof HttpURLConnection) {
					HttpURLConnection httpConn = (HttpURLConnection) connection;
					int statusCode = httpConn.getResponseCode();
					if (statusCode != 200) {
						is = httpConn.getErrorStream();
					}
				}
			}

			BufferedReader rd = new BufferedReader(new InputStreamReader(is));

			StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			System.out.println(response.toString());
			return response.toString();
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	@RequestMapping("/Sensors")
	public String requestPostSensor() throws Exception {

		JSONObject json = new JSONObject();
		json.put("name", "Jefferson Traffic Light");
		json.put("description", "Sensor at Jefferson");
		json.put("encodingType", "application/pdf");
		json.put("metadata", "ttps://cdn-shop.SensorAtJefferson.pdf");

		String requestJSON = json.toString();

		HttpURLConnection connection = null;
		InputStream is = null;

		try {
			// Create connection
			URL url = new URL("https://stlouis18-03341.sensorup.com/v1.0/Sensors");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			/*
			 * //TODO may be prod or preprod api key if
			 * (apikey.equals(Constants.APIKEY_PREPROD)) {
			 * connection.setRequestProperty("Authorization", Constants.APIKEY_PREPROD); }
			 * if (apikey.equals(Constants.APIKEY_PROD)){
			 * connection.setRequestProperty("Authorization", Constants.APIKEY_PROD); }
			 */
			connection.setRequestProperty("Content-Length", Integer.toString(requestJSON.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoOutput(true);

			// Send request
			System.out.println(requestJSON);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(requestJSON);
			wr.close();

			// Get Response

			try {
				is = connection.getInputStream();
				System.out.println("This try worked");
			} catch (IOException ioe) {
				System.out.println("This was a catch");
				if (connection instanceof HttpURLConnection) {
					HttpURLConnection httpConn = (HttpURLConnection) connection;
					int statusCode = httpConn.getResponseCode();
					if (statusCode != 200) {
						is = httpConn.getErrorStream();
					}
				}
			}

			BufferedReader rd = new BufferedReader(new InputStreamReader(is));

			StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			System.out.println(response.toString());
			return response.toString();
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	@RequestMapping("/Things")
	public String requestPostThings() throws Exception {

		JSONObject innerJSON = new JSONObject();
		innerJSON.put("Deployment Condition", "Deployed in Travis' hand");
		innerJSON.put("Case Used", "none");

		JSONObject json = new JSONObject();
		json.put("name", "Travis cellphone");
		json.put("description", "The THING is Travis Cellphone");
		json.put("properties", innerJSON);

		String requestJSON = json.toString();

		HttpURLConnection connection = null;
		InputStream is = null;

		try {
			// Create connection
			URL url = new URL("https://stlouis18-03341.sensorup.com/v1.0/Things");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			/*
			 * //TODO may be prod or preprod api key if
			 * (apikey.equals(Constants.APIKEY_PREPROD)) {
			 * connection.setRequestProperty("Authorization", Constants.APIKEY_PREPROD); }
			 * if (apikey.equals(Constants.APIKEY_PROD)){
			 * connection.setRequestProperty("Authorization", Constants.APIKEY_PROD); }
			 */
			connection.setRequestProperty("Content-Length", Integer.toString(requestJSON.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoOutput(true);

			// Send request
			System.out.println(requestJSON);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(requestJSON);
			wr.close();

			// Get Response

			try {
				is = connection.getInputStream();
				System.out.println("This try worked");
			} catch (IOException ioe) {
				System.out.println("This was a catch");
				if (connection instanceof HttpURLConnection) {
					HttpURLConnection httpConn = (HttpURLConnection) connection;
					int statusCode = httpConn.getResponseCode();
					if (statusCode != 200) {
						is = httpConn.getErrorStream();
					}
				}
			}

			BufferedReader rd = new BufferedReader(new InputStreamReader(is));

			StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			System.out.println(response.toString());
			return response.toString();
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	@RequestMapping("/Datastreams")
	public String requestPostDataStreams() throws Exception {

		JSONObject innerMeasurementJSON = new JSONObject();
		innerMeasurementJSON.put("name", "Degree Celsius");
		innerMeasurementJSON.put("symbol", "degC");
		innerMeasurementJSON.put("definition", "http://www.qudt.org/qudt/owl/1.0.0/unit/Instances.html#DegreeCelsius");

		JSONObject innerThingJSON = new JSONObject();
		innerThingJSON.put("@iot.id", 20);

		JSONObject innerObservedPropertyJSON = new JSONObject();
		innerObservedPropertyJSON.put("@iot.id", 18);

		JSONObject innerSensorJSON = new JSONObject();
		innerSensorJSON.put("@iot.id", 19);

		JSONObject json = new JSONObject();
		json.put("name", "DataStream Incident Reporting");
		json.put("description", "DataStream Traffic Incident");
		json.put("observationType", "http://www.JeffersonTrafficIncident/OGC-OM/2.0/OM_Measurement");
		json.put("unitOfMeasurement", innerMeasurementJSON);
		json.put("Thing", innerThingJSON);
		json.put("ObservedProperty", innerObservedPropertyJSON);
		json.put("Sensor", innerSensorJSON);

		String requestJSON = json.toString();

		HttpURLConnection connection = null;
		InputStream is = null;

		try {
			// Create connection
			URL url = new URL("https://stlouis18-03341.sensorup.com/v1.0/Datastreams");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			// TODO may be prod or preprod api key
			/*
			 * if (apikey.equals(Constants.APIKEY_PREPROD)) {
			 * connection.setRequestProperty("Authorization", Constants.APIKEY_PREPROD); }
			 * if (apikey.equals(Constants.APIKEY_PROD)){
			 * connection.setRequestProperty("Authorization", Constants.APIKEY_PROD); }
			 */
			connection.setRequestProperty("Content-Length", Integer.toString(requestJSON.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoOutput(true);

			// Send request
			System.out.println(requestJSON);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(requestJSON);
			wr.close();

			// Get Response

			try {
				is = connection.getInputStream();
				System.out.println("This try worked");
			} catch (IOException ioe) {
				System.out.println("This was a catch");
				if (connection instanceof HttpURLConnection) {
					HttpURLConnection httpConn = (HttpURLConnection) connection;
					int statusCode = httpConn.getResponseCode();
					if (statusCode != 200) {
						is = httpConn.getErrorStream();
					}
				}
			}

			BufferedReader rd = new BufferedReader(new InputStreamReader(is));

			StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			System.out.println("This is the first TRY");
			System.out.println(response.toString());
			return response.toString();
		} catch (Exception e) {
			System.out.println("This is the first catch");
			e.printStackTrace();
			return null;

		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	@RequestMapping("/FeaturesOfInterest")
	public String requestPostFeaturesOfInterest() throws Exception {

		String strCoordinates = "[-114.133, 51.08]";
		JSONArray featureArray = new JSONArray(strCoordinates);
		System.out.println(featureArray.toString());

		JSONObject innerFeatureJSON = new JSONObject();
		innerFeatureJSON.put("type", "Point");
		innerFeatureJSON.put("coordinates", featureArray);

		JSONObject json = new JSONObject();
		json.put("name", "FeatureOfInterest intersection of Jefferson and Olive");
		json.put("description", "FeaturesOfInterest traffic light intersection");
		json.put("encodingType", "application/vnd.geo+json");
		json.put("feature", innerFeatureJSON);

		String requestJSON = json.toString();

		HttpURLConnection connection = null;
		InputStream is = null;

		try {
			// Create connection
			URL url = new URL("https://stlouis18-03341.sensorup.com/v1.0/FeaturesOfInterest");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			/*
			 * //TODO may be prod or preprod api key if
			 * (apikey.equals(Constants.APIKEY_PREPROD)) {
			 * connection.setRequestProperty("Authorization", Constants.APIKEY_PREPROD); }
			 * if (apikey.equals(Constants.APIKEY_PROD)){
			 * connection.setRequestProperty("Authorization", Constants.APIKEY_PROD); }
			 */
			connection.setRequestProperty("Content-Length", Integer.toString(requestJSON.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoOutput(true);

			// Send request
			System.out.println(requestJSON);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(requestJSON);
			wr.close();

			// Get Response

			try {
				is = connection.getInputStream();
				System.out.println("This try worked");
			} catch (IOException ioe) {
				System.out.println("This was a catch");
				if (connection instanceof HttpURLConnection) {
					HttpURLConnection httpConn = (HttpURLConnection) connection;
					int statusCode = httpConn.getResponseCode();
					if (statusCode != 200) {
						is = httpConn.getErrorStream();
					}
				}
			}

			BufferedReader rd = new BufferedReader(new InputStreamReader(is));

			StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			System.out.println(response.toString());
			return response.toString();
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	@RequestMapping("/Observations")
	public String requestPostObservations() throws Exception {

		JSONObject innerDatastreamJSON = new JSONObject();
		innerDatastreamJSON.put("@iot.id", 23);

		JSONObject innerFeatureOfInterestJSON = new JSONObject();
		innerFeatureOfInterestJSON.put("@iot.id", 24);

		JSONObject json = new JSONObject();
		json.put("phenomenonTime", "2017-02-07T18:02:00.000Z");
		json.put("resultTime", "2017-02-07T18:02:05.000Z");
		json.put("result", "The location of the thing is at the corner of Jefferson and Olive");
		json.put("Datastream", innerDatastreamJSON);
		json.put("FeatureOfInterest", innerFeatureOfInterestJSON);

		String requestJSON = json.toString();

		HttpURLConnection connection = null;
		InputStream is = null;

		try {
			// Create connection
			URL url = new URL("https://stlouis18-03341.sensorup.com/v1.0/Observations");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			/*
			 * //TODO may be prod or preprod api key if
			 * (apikey.equals(Constants.APIKEY_PREPROD)) {
			 * connection.setRequestProperty("Authorization", Constants.APIKEY_PREPROD); }
			 * if (apikey.equals(Constants.APIKEY_PROD)){
			 * connection.setRequestProperty("Authorization", Constants.APIKEY_PROD); }
			 */
			connection.setRequestProperty("Content-Length", Integer.toString(requestJSON.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");
			connection.setUseCaches(false);
			connection.setDoOutput(true);

			// Send request
			System.out.println(requestJSON);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(requestJSON);
			wr.close();

			// Get Response

			try {
				is = connection.getInputStream();
				System.out.println("This try worked");
			} catch (IOException ioe) {
				if (connection instanceof HttpURLConnection) {
					HttpURLConnection httpConn = (HttpURLConnection) connection;
					int statusCode = httpConn.getResponseCode();
					if (statusCode != 200) {
						is = httpConn.getErrorStream();
					}
				}
			}

			BufferedReader rd = new BufferedReader(new InputStreamReader(is));

			StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
			String line;
			while ((line = rd.readLine()) != null) {
				response.append(line);
				response.append('\r');
			}
			rd.close();
			System.out.println(response.toString());
			return response.toString();
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

}
