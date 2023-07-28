<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Details</title>
</head>
<body>
   <h2>Flight Details</h2>
   Flight Number: ${flight.flightNumber}<br>
   Operating Airlines: ${flight.operatingAirlines}<br>
   Operating Airlines: ${flight.operatingAirlines}<br>
   Departure City: ${flight.departureCity}<br>
   Arrival City: ${flight.arrivalCity}<br>
   Date Of Departure: ${flight.dateOfDeparture}<br>
   Estimated Departure Time: ${flight.estimatedDepartureTime}<br>
   <h2>Enter Passenger Details</h2>
   <form action="confirmReservation" method="post">
        <pre style="color:skyblue">
            First Name<input type="text" name="firstName"/>
            Last Name<input type="text" name="lastName"/>
            Middle Name<input type="text" name="middleName"/>
            Email Id<input type="text" name="email"/>
            Phone No<input type="number" name="phone"/>
            <input type="hidden" name="flightId" value="${flight.id }"/>
            <h2>Enter The Payment Details</h2>
            Name On The Card<input type="text" name="nameOfTheCard"/>
            Card Number<input type="number" name="cardNumber"/>
            CVV<input type="number" name="cvv"/>
            Expiry Date<input type="text" name="expiryDate"/>
            <input type="submit" value="completereservation"/>
        </pre>
   </form>
</body>
</html>