/*package com.example.ActionThis.Controllers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class DataCollecting {

	@RequestMapping("/Observations")
	public String sendPostObservation() throws Exception {

		JSONObject innerDatastreamJSON = new JSONObject();
		innerDatastreamJSON.put("@iot.id", 14);
		
		JSONObject innerFeatureOfInterestJSON = new JSONObject();
		innerFeatureOfInterestJSON.put("@iot.id", 16);
		
		JSONObject json = new JSONObject();
		json.put("phenomenonTime", "2017-02-07T18:02:00.000Z");
		json.put("resultTime", "2017-02-07T18:02:05.000Z");
		json.put("result", "MIKE IS A BADASS");
		json.put("Datastream", innerDatastreamJSON);
		json.put("FeatureOfInterest", innerFeatureOfInterestJSON);
		
		String requestJSON = json.toString();
	
		  HttpURLConnection connection = null;
	        InputStream is = null;

	        try {
	            //Create connection
	            URL url = new URL("https://stlouis18-03341.sensorup.com/v1.0/Observations");
	            connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("POST");
	            connection.setRequestProperty("Content-Type", "application/json");
	            //TODO may be prod or preprod api key
	            if (apikey.equals(Constants.APIKEY_PREPROD)) {
	                connection.setRequestProperty("Authorization", Constants.APIKEY_PREPROD);
	            }
	            if (apikey.equals(Constants.APIKEY_PROD)){
	                connection.setRequestProperty("Authorization", Constants.APIKEY_PROD);
	            }
	            connection.setRequestProperty("Content-Length", Integer.toString(requestJSON.getBytes().length));
	            connection.setRequestProperty("Content-Language", "en-US");  
	            connection.setUseCaches(false);
	            connection.setDoOutput(true);

	            //Send request
	            System.out.println(requestJSON);
	            DataOutputStream wr = new DataOutputStream (
	            connection.getOutputStream());
	            wr.writeBytes(requestJSON);
	            wr.close();

	            //Get Response  

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
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		final String USER_AGENT = "Mozilla/5.0";

			String url = "https://stlouis18-03341.sensorup.com/v1.0/Observations";
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = jsonStr;
			
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());

		}

	
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JSONObject json = new JSONObject();
		json.put("phenomenonTime", "2017-02-07T18:02:00.000Z");
		json.put("resultTime", "2017-02-07T18:02:05.000Z");
		json.put("result", "21.6");

		json.put("Datastream", json.put("@iot.id", 8));

		

		URL url = new URL("https://stlouis18-03341.sensorup.com/v1.0/Observations");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestMethod("POST");

		OutputStream os = conn.getOutputStream();
		os.write(dataJSON.getBytes("UTF-8"));
		os.close();

		// read the response
		InputStream in = new BufferedInputStream(conn.getInputStream());
		String result = new BufferedReader(new InputStreamReader(in)).lines().collect(Collectors.joining("\n"));

		in.close();
		conn.disconnect();
		
		
		String dataJSON = json.toString();
		System.out.println("This is a first test");
		System.out.println(result);
		System.out.println("This is a test");
		return result;

	}
}
		
		
		
		
		
		

 * 
 * consumes=MediaType.APPLICATION_JSON_VALUE,
 * 
 * @RequestMapping(value="/v1.0/FeaturesOfInterest", method=RequestMethod.POST)
 * 
 * public void
 * givenRequestParam_whenUTF8Scheme_thenDecodeRequestParams(@RequestBody String
 * testUrl) {
 * 
 * try { String result = URLDecoder.decode(testUrl, "UTF-8");
 * System.out.println("It has decoded: " + result);
 * System.out.println(result.substring(8)); JSONObject jObjectFromString = new
 * JSONObject(result.substring(8));
 * System.out.println(jObjectFromString.toString()); } catch
 * (UnsupportedEncodingException ex) { ex.printStackTrace(); }
 
*/