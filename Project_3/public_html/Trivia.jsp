<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sean Fiscus Development</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css" type="text/css">

    <!-- Plugin CSS -->
    <link rel="stylesheet" href="css/animate.min.css" type="text/css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/creative.css" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top">

    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a class="page-scroll" href="#about">About</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#services">Services</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#portfolio">Portfolio</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1>Sean Fiscus</h1>
                <hr>
                <h3>Mobile & Web Developer</h3>
                <a href="#about" class="btn btn-primary btn-xl page-scroll">Find Out More</a>
            </div>
        </div>
    </header>

    <section class="bg-primary" id="about">
        <div class="container">
            <div class="row">
                <h1><u>A Country Capitals Trivia </u><h1><br/><br/>
                <h2 class="question"> What is the capital of :</h2>
                <form name="capitals" action="mvc-challenge-servlet" method="get">
                <table cellspacing="10" cellpadding="10" style="font-weight: bold; width:100%; border: 5px solid white;"><tr><td>
                <h2 class="question">1. Iceland </h2>
                <input type="radio" name="Iceland" value="Reykjavik">Reykjavik</input><br/>
                <input type="radio" name="Iceland" value="Kopavogur">Kopavogur</input><br/>
                <input type="radio" name="Iceland" value="Hafnarfjorour">Hafnarfjorour</input><br/>
                <input type="radio" name="Iceland" value="Akureyri">Akureyri</input><br/>
                <input type="radio" name="Iceland" value="Garoabaer">Garoaer</input></td>
                
                <td>
                <h2 class="question">2. Oman </h2>
                <input type="radio" name="Oman" value="Adam">Adam</input><br/>
                <input type="radio" name="Oman" value="Muscat">Muscat</input><br/>
                <input type="radio" name="Oman" value="Barka">Barka</input><br/>
                <input type="radio" name="Oman" value="Sur">Sur</input><br/>
                <input type="radio" name="Oman" value="Doha">Doha</input></td>
                
                <td>
                <h2 class="question">3. Ukraine </h2>
                <input type="radio" name="Ukraine" value="Donetsk">Donetsk</input><br/>
                <input type="radio" name="Ukraine" value="Luhansk">Luhansk</input><br/>
                <input type="radio" name="Ukraine" value="Makiivka">Makiivka</input><br/>
                <input type="radio" name="Ukraine" value="Sevastopol">Sevastopol</input><br/>
                <input type="radio" name="Ukraine" value="Kiev">Kiev</input></td></tr>
                
                <tr><td>
                <h2 class="question">4. Bosnia </h2>
                <input type="radio" name="Bosnia" value="Modrica">Modrica</input><br/>
                <input type="radio" name="Bosnia" value="Tuzla">Tuzla</input><br/>
                <input type="radio" name="Bosnia" value="Pale">Pale</input><br/>
                <input type="radio" name="Bosnia" value="Sarajevo">Sarajevo</input><br/>
                <input type="radio" name="Bosnia" value="Konjic">Konjic</input></td>
                
                <td colspan="1">
                <h2 class="question">5. Denmark </h2>
                <input type="radio" name="Denmark" value="Aarhus">Aarhus</input><br/>
                <input type="radio" name="Denmark" value="Copenhagen">Copenhagen</input><br/>
                <input type="radio" name="Denmark" value="Viborg">Viborg</input><br/>
                <input type="radio" name="Denmark" value="Slagelse">Slagelse</input><br/>
                <input type="radio" name="Denmark" value="Ringsted">Ringsted</input>
                
                <td><input style="color:black;" type="submit" value="Submit"/></td>

                </td></tr>
                
                </table>
                        
                </form>
            </div>
        </div>
    </section>

    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Experience</h2>
                    <hr class="primary">
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 text-center">
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="" data-wow-delay=".1s"></i>
                        <h3>Mobile Development</h3>
                        <p class="text-muted">Implementing your ideas</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                    <div class="service-box">
                        <i class="" data-wow-delay=".2s"></i>
                        <h3>Website Development</h3>
                        <p class="text-muted">Transforming your vision</p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 text-center">
                </div>
            </div>
        </div>
    </section>

    <section class="no-padding" id="portfolio">
        <div class="container-fluid">
            <div class="row no-gutter">
                <div class="col-lg-4 col-sm-6">
                    <a href="linkingDemo.html" class="portfolio-box">
                        <img src="images/pexels_phone.jpeg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Advanced Java
                                </div>
                                <div class="project-name">
                                    Unit 2
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="https://github.com/sfiscus/Web-Development" class="portfolio-box">
                        <img src="images/pexels_office_2.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Advanced Java
                                </div>
                                <div class="project-name">
                                    Unit 3
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <a href="https://github.com/sfiscus/Advanced-Java" class="portfolio-box">
                        <img src="images/pexels_office_3.jpg" class="img-responsive" alt="">
                        <div class="portfolio-box-caption">
                            <div class="portfolio-box-caption-content">
                                <div class="project-category text-faded">
                                    Advanced Java
                                </div>
                                <div class="project-name">
                                    Unit 4
                                </div>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </section>

    <aside class="bg-dark">
        <div class="container text-center">
            <div class="call-to-action">
            </div>
        </div>
    </aside>

    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2 text-center">
                    <h2 class="section-heading">Let's Get In Touch!</h2>
                    <hr class="primary">
                    <p> Send me an email and I will get back to you as soon as possible!
                    </p>
                </div>
                <div class="col-lg-4 col-lg-offset-2 text-center">
                    <i class=""></i>
                    <p>TBA</p>
                </div>
                <div class="col-lg-4 text-center">
                    <i class="" data-wow-delay=".1s"></i>
                    <p><a href="mailto:admin@seanfiscus.com">sfiscus@madisoncollege.edu</a></p>
                </div>
            </div>
        </div>
    </section>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/jquery.fittext.js"></script>
    <script src="js/wow.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/creative.js"></script>

</body>

</html>
