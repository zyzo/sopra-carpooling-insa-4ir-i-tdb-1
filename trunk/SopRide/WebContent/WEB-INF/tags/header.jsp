<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>SopRide</title>
    <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/jumbotron/jumbotron.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
</head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">Sopride</a>
        </div>

        <div id="navbar2" class="navbar-collapse collapse navbar-right">
            <a href="user_profile.html" id="aNavbar2"></a> <br>
            <a id="disconnectButton" href="index.html" onclick="sessionStorage.setItem('signedIn', false)">Disconnect</a>
        </div><!--/.navbar-collapse -->
        <div id="navbar" class="navbar-collapse collapse">
            <form class="navbar-form navbar-right" role="form" action="user_profile.html">
                <div class="form-group">
                    <input type="text" placeholder="Email" class="form-control" id="Email" required="true">
                </div>
                <div class="form-group">
                    <input type="password" placeholder="Password" class="form-control">
                </div>
                <button type="submit" class="btn btn-success" onclick="sessionStorage.setItem('signedIn', $('#Email').val())">Sign in</button>
            </form>
        </div><!--/.navbar-collapse -->


    </div>
</nav>

<script>
    if (sessionStorage.getItem('signedIn') == null || sessionStorage.getItem('signedIn') == 'false') {
        $('#navbar2').attr('style', 'display : none! important');
        $('#navbar').attr("style", "display : block");
    } else {
        $('#navbar').attr('style', 'display : none! important');
        $('#navbar2').attr("style", "display : block");
        $('#aNavbar2').text("Welcome back, " + sessionStorage.getItem('signedIn'));
    }
</script>