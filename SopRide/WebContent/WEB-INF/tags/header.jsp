<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SopRide</title>
    <link href="res/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="res/custom/css/main.css" rel="stylesheet">

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <%-- TODO : change to bootstrap.min.js in the production version --%>
    <!--<script src="res/bootstrap/js/bootstrap.js"></script>-->
</head>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a id="headerLogo" class="navbar-brand" href="home">SopRide</a>
        </div>

        <c:choose>
            <c:when test="${userCtrl.isConnected()}" >
                <div id="navbar2" class="navbar-collapse collapse navbar-right">
                    <a href="userProfile" id="aNavbar2">Bienvenue, ${sessionScope.loggedInUser.email}</a> <br>
                    <form class="navbar-form navbar-right" role="form" action="disconnect" method="GET">
                        <button type="submit" id="disconnectButton" class="btn btn-fail">Se deconnecter</button>
                    </form>
                </div>
            </c:when>
            <c:otherwise>

                <div id="navbar" class="navbar-collapse collapse">
                    <form class="navbar-form navbar-right" role="form" action="login" method="GET">
                        <button type="submit" id="connectButton" class="btn btn-success">Se connecter</button>
                    </form>
                </div>
            </c:otherwise>
        </c:choose>
        </div>


    </div>
</nav>