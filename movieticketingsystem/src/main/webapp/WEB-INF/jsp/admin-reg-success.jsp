<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Admin Created Successfully</title>
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
            <ul class="navbar-nav justify-content-end" style="margin-left: 80%;">
                <li class="nav-item"><a class="nav-link" href="/movieticketingsystem">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="/movieticketingsystem/admin/login.htm">Log In</a></li>
                <li class="nav-item"><a class="nav-link" href="/movieticketingsystem/admin/add.htm">Register</a></li>
            </ul>
        </div>
    </nav>
    <div class="container">
        <h3>New Admin Created Successfully: ${admin.fname}<br></h3>
        <h4>Please Login!</h4>
    </div>
</body>

</html>