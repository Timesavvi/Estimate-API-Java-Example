import java.io.IOException;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.MediaType;
import java.util.concurrent.TimeUnit;

public class Main {
	public static final String[] postalCode = new String[] {"H3T1N8", "H3V1Hb", "H3W1W6", "H3W2N5", "H3W2P9", "H3T1E7", "H3T1C6"}; 
	public static final int[] plannedSequence = new int[] {1, 2, 3, 4, 5, 6, 7}; 
	public static String[] streetName = new String[] {"Avenue Louis Colin", "Queen Mary", "Queen Mary", "Avenue Victoria", "Avenue Victoria", "Avenue Dupuis", "Cote Sainte Catherine"};
	public static String[] firstName = new String[] {"Mike"};
	public static String[] lastName = new String[] {"Clark"};
	public static String[] dateOfBirth = new String[] {"April 7, 2000"};
	public static String[] routeDate = new String[] {"Jan 1, 2017"};
	public static String[] departureTime = new String[] {"8:00"};
	public static String[] isOnTheGo = new String[] {"true"};
	public static String[] gender = new String[] {"male"};
	public static String[] imageURL = new String[] {"www.MikePhoto.com"};
	public static int[] streetNo = new int[] {5255, 3535, 4570, 5145, 5497, 3975, 3350};
	public static double[] latitude = new double[] {45.500218, 45.4954042, 45.4910077, 45.489036, 45.4916368, 45.495733, 45.499834};
	public static double[] longitude = new double[] {-73.617769, -73.6189376, -73.6226881, -73.625646, -73.6316545, -73.628542, -73.626329};
	public static String[] trackingNo = new String[] {"TSV01", "TSV02", "TSV03", "TSV04", "TSV05", "TSV06", "TSV07"};
	
	public static void main(String[] args) throws IOException {
		//------------------------------------------------------------------------------
		//Set customers' locations ----------------------------------------------------- 
		for (int i = 1; i<=7; i++){
			OkHttpClient client = new OkHttpClient();
			
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, 
					"{\"location_ID\":"+i+
					",\"postal_code\":\""+postalCode[i-1]+
					"\",\"street_name\":\""+streetName[i-1]+
					"\",\"street_No\":"+streetNo[i-1]+
					",\"y_coordinate\":"+latitude[i-1]+
					",\"x_coordinate\":"+ longitude[i-1]+"}");		
			Request request = new Request.Builder()
			  .url("https://api.us.apiconnect.ibmcloud.com/timesavvi-test/sb/api/locations")
			  .post(body)
			  .addHeader("x-ibm-client-id", "Client-ID")
			  .addHeader("x-ibm-client-secret", "Client-secret")
			  .addHeader("content-type", "application/json")
			  .addHeader("accept", "application/json")
			  .build();			
			
			client.newCall(request).enqueue(new Callback() {

	            @Override
	            public void onFailure(Request request, IOException e) {
	                System.out.println(e.getMessage());	               
	            }

	            @Override
	            public void onResponse(Response response) throws IOException {
	                try {
	                    String resp = response.body().string();
	                    System.out.println(resp);

	                    if (response.isSuccessful()) {
	                    } else {

	                    }
	                } catch (IOException e) {
	                    System.out.println("Exception caught" + e.getMessage());
	                }
	            }
	        });
		}		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//---------------------------------------------------------------------------------------
		//Set customers' packages & binding corresponding location IDs--------------------------- 
		for (int i = 1; i<8; i++){
			
			OkHttpClient client = new OkHttpClient();

			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, "{\"tracking_No\":\""+trackingNo[i-1]+"\",\"location_ID\":"+i+"}");			

			Request request = new Request.Builder()
			  .url("https://api.us.apiconnect.ibmcloud.com/timesavvi-test/sb/api/packages")
			  .post(body)
			  .addHeader("x-ibm-client-id", "Client-ID")
			  .addHeader("x-ibm-client-secret", "Client-secret")
			  .addHeader("content-type", "application/json")
			  .addHeader("accept", "application/json")
			  .build();
			
			
			
			
			
				client.newCall(request).enqueue(new Callback() {

	            @Override
	            public void onFailure(Request request, IOException e) {
	                System.out.println(e.getMessage());	               
	            }

	            @Override
	            public void onResponse(Response response) throws IOException {
	                try {
	                    String resp = response.body().string();
	                    System.out.println(resp);

	                    if (response.isSuccessful()) {
	                    } else {

	                    }
	                } catch (IOException e) {
	                    System.out.println("Exception caught" + e.getMessage());
	                }
	            }
	        });
		}

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		//---------------------------------------------------------------------------------------		
		//Set drivers' info---------------------------------------------------------------------- 
		
		
		
		for (int i = 1; i<2; i++){
			
			OkHttpClient client = new OkHttpClient();
//			",\"postal_code\":\""+postalCode[i-1]+"\",\"
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, "{\"driver_ID\":"+i+",\"first_name\":\""+firstName[i-1]+"\",\"last_name\":\""+lastName[i-1]+"\",\"date_of_birth\":\""+dateOfBirth[i-1]+"\",\"gender\":\""+gender[i-1]+"\",\"image_url\":\""+imageURL[i-1]+"\"}");
			//RequestBody body = RequestBody.create(mediaType, "{\"tracking_No\":"+i+",\"location_ID\":"+i+",\"weight\":1,\"width\":1,\"length\":1,\"thickness\":1}");
			Request request = new Request.Builder()
			  .url("https://api.us.apiconnect.ibmcloud.com/timesavvi-test/sb/api/drivers")
			  .post(body)
			  .addHeader("x-ibm-client-id", "Client-ID")
			  .addHeader("x-ibm-client-secret", "Client-secret")
			  .addHeader("content-type", "application/json")
			  .addHeader("accept", "application/json")
			  .build();
			
			
			
				client.newCall(request).enqueue(new Callback() {

	            @Override
	            public void onFailure(Request request, IOException e) {
	                System.out.println(e.getMessage());	               
	            }

	            @Override
	            public void onResponse(Response response) throws IOException {
	                try {
	                    String resp = response.body().string();
	                    //Log.v(TAG_REGISTER, resp);
	                    System.out.println(resp);

	                    if (response.isSuccessful()) {
	                    } else {

	                    }
	                } catch (IOException e) {
	                    System.out.println("Exception caught" + e.getMessage());
	                }
	            }
	        });
		}
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		
		//---------------------------------------------------------------------------------------		
		//Set routes' info---------------------------------------------------------------------- 
		
		
		for (int i = 1; i<2; i++){
			
			OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, "{\"route_ID\":"+i+",\"date\":\""+routeDate[i-1]+"\",\"driver_ID\":1,\"vehicle_ID\":1,\"hub_ID\":1,\"departure_time\":\""+departureTime[i-1]+"\",\"is_on_the_go\":"+isOnTheGo[i-1]+"}");
			Request request = new Request.Builder()
			  .url("https://api.us.apiconnect.ibmcloud.com/timesavvi-test/sb/api/routes")
			  .post(body)
			  .addHeader("x-ibm-client-id", "Client-ID")
			  .addHeader("x-ibm-client-secret", "Client-secret")
			  .addHeader("content-type", "application/json")
			  .addHeader("accept", "application/json")
			  .build();
			
			
			
			client.newCall(request).enqueue(new Callback() {

	            @Override
	            public void onFailure(Request request, IOException e) {
	                System.out.println(e.getMessage());	               
	            }

	            @Override
	            public void onResponse(Response response) throws IOException {
	                try {
	                    String resp = response.body().string();
	                    System.out.println(resp);

	                    if (response.isSuccessful()) {
	                    } else {

	                    }
	                } catch (IOException e) {
	                    System.out.println("Exception caught" + e.getMessage());
	                }
	            }
	        });
		}
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}		
		
		//---------------------------------------------------------------------------------------		
		//Set routes' packages table and binding package-IDs and route-IDs to routes---------------------------------------------------------------------- 
		
		
		for (int i = 1; i<8; i++){
			
			OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, "{\"route_package_ID\":"+i+",\"route_ID\":1,\"tracking_No\":\""+trackingNo[i-1]+"\",\"planned_sequence\":"+plannedSequence[i-1]+",\"real_sequence\":"+plannedSequence[i-1]+",\"real_service_time\":1,\"is_on_the_go\":true}");

			Request request = new Request.Builder()
			  .url("https://api.us.apiconnect.ibmcloud.com/timesavvi-test/sb/api/routes_packages")
			  .post(body)
			  .addHeader("x-ibm-client-id", "Client-ID")
			  .addHeader("x-ibm-client-secret", "Client-secret")
			  .addHeader("content-type", "application/json")
			  .addHeader("accept", "application/json")
			  .build();
			
			
			
			client.newCall(request).enqueue(new Callback() {

	            @Override
	            public void onFailure(Request request, IOException e) {
	                System.out.println(e.getMessage());	               
	            }

	            @Override
	            public void onResponse(Response response) throws IOException {
	                try {
	                    String resp = response.body().string();
	                    //Log.v(TAG_REGISTER, resp);
	                    System.out.println(resp);

	                    if (response.isSuccessful()) {
	                    } else {

	                    }
	                } catch (IOException e) {
	                    System.out.println("Exception caught" + e.getMessage());
	                }
	            }
	        });
		}

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		
		//---------------------------------------------------------------------------------------
		//Set routes' locations table------------------------------------------------------------ 
		
		
		for (int i = 1; i<8; i++){
			
			OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, "{\"is_on_the_go\":true,\"location_ID\":"+i+",\"planned_sequence\":"+plannedSequence[i-1]+",\"route_ID\":1,\"route_location_ID\":"+i+",\"real_sequence\":"+plannedSequence[i-1]+"}");

			Request request = new Request.Builder()
			  .url("https://api.us.apiconnect.ibmcloud.com/timesavvi-test/sb/api/routes_locations")
			  .post(body)
			  .addHeader("x-ibm-client-id", "Client-ID")
			  .addHeader("x-ibm-client-secret", "Client-secret")
			  .addHeader("content-type", "application/json")
			  .addHeader("accept", "application/json")
			  .build();
			
			
			
			client.newCall(request).enqueue(new Callback() {

	            @Override
	            public void onFailure(Request request, IOException e) {
	                System.out.println(e.getMessage());	               
	            }

	            @Override
	            public void onResponse(Response response) throws IOException {
	                try {
	                    String resp = response.body().string();
	                    System.out.println(resp);

	                    if (response.isSuccessful()) {
	                    } else {

	                    }
	                } catch (IOException e) {
	                    System.out.println("Exception caught" + e.getMessage());
	                }
	            }
	        });
		}

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	
		
		
	}
}
