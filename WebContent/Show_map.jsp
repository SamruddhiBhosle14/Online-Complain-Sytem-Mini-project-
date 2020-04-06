<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Marker Clustering</title>
    <style>
      /* Always set the map height explicitly to define the size of the div
       * element that contains the map. */
      #map {
        height: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  </head>
  <body>
    <div id="map"></div>
	<script src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
    <script>

      function initMap() {

        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 5,
          center: {lat: 28.589212504086536, lng: 77.20771801471709}
        });

        // Create an array of alphabetical characters used to label the markers.
        var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

        // Add some markers to the map.
        // Note: The code uses the JavaScript Array.prototype.map() method to
        // create an array of markers based on a given "locations" array.
        // The map() method here has nothing to do with the Google Maps API.
        var markers = locations.map(function(location, i) {
          return new google.maps.Marker({
            position: location,
            label: labels[i % labels.length]
          });
        });

        // Add a marker clusterer to manage the markers.
        var markerCluster = new MarkerClusterer(map, markers,
            {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
      }
      
      
      var locations = [];
      
      
      
      
      <% 
    	String url = "jdbc:mysql://localhost:3306/SIH";
		String uname = "root";
		String pass = "root";
		String querry = "select * from MapLocation;";
		
		Class.forName("com.mysql.jdbc.Driver");	//Step 2
		
		Connection con = DriverManager.getConnection(url , uname , pass);	//Step 3
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(querry);
		
		while(rs.next()) {
		
			out.println("var obj = {};");
			out.println("obj[\"lat\"] = "+rs.getString(4)+"; obj[\"lng\"] = "+rs.getString(5)+";");
			out.println("locations.push(obj);");
			
		}
		
    
    %>
    </script>
    <!-- Replace following script src -->
    <script src="/maps/documentation/javascript/examples/markerclusterer/markerclustererplus@4.0.1.min.js">
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC9_9GHa9OBZJtwix4OtxBert-A8Ar8T2k&callback=initMap">
    </script>
  </body>
</html>