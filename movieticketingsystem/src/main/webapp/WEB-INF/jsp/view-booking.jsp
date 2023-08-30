<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Bookings</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <style>
            .container {
                margin: 20px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-md bg-dark navbar-dark">

            <a class="navbar-brand" href="/" style="margin-left: 20px;">Movie Ticketing System</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item"><a class="nav-link" href="/movieticketingsystem/user/shows.htm">Shows</a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="/movieticketingsystem/user/bookShow/viewBooking.htm">View Bookings</a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/movieticketingsystem">Log Out</a></li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <h3>Your Bookings!</h3>
            <hr/>
            <br/>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">MOVIE TITLE</th>
                        <th scope="col">SCREEN</th>
                        <th scope="col">TIME</th>
                        <th scope="col">SEATS</th>
                        <th scope="col">TYPE</th>
                        <th scope="col">AMOUNT</th>
                        <th scope="col">ACTION</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="b" items="${booking}">
                        <tr>
                            <tr>
                                <td>${b.movietitle}</td>
                                <td>${b.screen}</td>
                                <td>${b.time}</td>
                                <td>${b.numberOfPpl}</td>
                                <td>${b.seatType}</td>
                                <td>${b.price}</td>
                                <td><a href="/movieticketingsystem/user/bookShow/delete/id=${b.bookingID}"
                                    class="btn btn-outline-danger">Cancel</a> 
                            </tr>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/movieticketingsystem/user/bookShow/ticket.pdf" class="btn btn-outline-dark">Download Ticket</a> 
        </div>
    </body>
</html>