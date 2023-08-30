<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    <html>

    <head>
        <title>Add Movie Form</title>
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
                    <li class="nav-item"><a class="nav-link" href="/movieticketingsystem/admin/movie/add.htm">Add
                            Movie</a></li>
                    <li class="nav-item"><a class="nav-link" href="/movieticketingsystem/admin/show/add.htm">Add
                            Show</a></li>
                    <li class="nav-item"><a class="nav-link" href="/movieticketingsystem/admin/show/view.htm">View
                            Shows</a></li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link" href="/movieticketingsystem">Log Out</a></li>
                </ul>
            </div>
        </nav>
        <div class="content">
            <h3>Add a New Movie</h3>
            <hr />
            <br />
            <div class="container">
                <form:form modelAttribute="movie" method="post" enctype="multipart/form-data">
                    <div class="mb-3">
                        <label for="title" class="form-label">Movie Title:</label><br />
                        <form:input path="title" size="30" />
                        <font color="red">
                            <form:errors path="title" />
                        </font>
                    </div>
                    <div class="mb-3">
                        <label for="lang" class="form-label">Movie Language:</label><br />
                        <form:input path="lang" size="30" />
                        <font color="red">
                            <form:errors path="lang" />
                        </font>
                    </div>
                    <div class="mb-3">
                        <label for="lang" class="form-label">Select Poster:</label><br />
                        <form:input type="file" path="poster" size="30" />
                    </div>
                    <br />
                    <div class="mb-3" style="margin-left: 70px;">
                        <button type="submit" class="btn btn-outline-dark">Create Movie</button>
                    </div>
                </form:form>
            </div>
        </div>
    </body>

    </html>