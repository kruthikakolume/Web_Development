<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    <html>

    <head>
        <title>Add Admin Form</title>
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
                <ul class="navbar-nav justify-content-end" style="margin-left: 80%;">
                    <li class="nav-item"><a class="nav-link" href="/movieticketingsystem">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="/movieticketingsystem/admin/login.htm">Log In</a>
                    </li>
                    <li class="nav-item"><a class="nav-link" href="/movieticketingsystem/admin/add.htm">Register</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="content">
            <h3>Register a New Admin</h3>
            <hr/>
            <br/>
            <div class="container">
            <form:form modelAttribute="admin" method="post">
                <div class="mb-3">
                    <label for="fname" class="form-label">First Name:</label><br />
                    <form:input path="fname" size="30" />
                    <font color="red">
                        <form:errors path="fname" />
                    </font>
                </div>
                <div class="mb-3">
                    <label for="lname" class="form-label">Last Name:</label><br />
                    <form:input path="lname" size="30" />
                    <font color="red">
                        <form:errors path="lname" />
                    </font>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email address</label><br />
                    <form:input path="email" size="30" />
                    <font color="red">
                        <form:errors path="email" />
                    </font>
                </div>
                <div class="mb-3">
                    <label for="pw" class="form-label">Password</label><br />
                    <form:password path="password" size="30" />
                    <font color="red">
                        <form:errors path="password" />
                    </font>
                </div>
                <br/>
                <div class="mb-3" style="margin-left: 70px;">
                    <button type="submit" class="btn btn-outline-dark">Create Admin</button>
                </div>
            </form:form>
        </div>
        </div>
    </body>

    </html>