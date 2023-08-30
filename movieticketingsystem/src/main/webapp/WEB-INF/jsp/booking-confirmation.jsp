<html>
    <head>
        <title>Booking Confirmation</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <style>
            .content {
                margin: 20px;
            }
            .container {
                margin-left: 40%;
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
        <div class="content">
            <h3>
                ${requestScope.username},
                <br/>
                Please confirm the details and make the payment
            </h3>
            <hr />
            <br />
            <div class="container">
                <div class="mb-3">
                    <label for="title" class="form-label">Movie:</label>
                    ${requestScope.movietitle}
                </div>
                <div class="mb-3">
                    <label for="screen" class="form-label">Screen:</label>
                    ${requestScope.screen}
                </div>
                <div class="mb-3">
                    <label for="time" class="form-label">Time:</label>
                    ${requestScope.time}
                </div>
                <div class="mb-3">
                    <label for="title" class="form-label">Seat Type:</label>
                    ${requestScope.type}
                </div>
                <div class="mb-3">
                    <label for="num" class="form-label">Number of seats:</label>
                    ${requestScope.num}
                </div>
                <div class="mb-3">
                    <label for="time" class="form-label">Price: $</label>
                    ${requestScope.price}
                </div>
                <br />
                <div class="mb-3" style="margin-left: 70px;">
                    <a href="payment.htm" class="btn btn-outline-dark" role="button">Make payment</a>
                </div>
    </body>
</html>