  <!-- Navigator -->
   <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="${contextRoot}/home">
                    <i class="fa fa-play-circle"></i> <span class="light">SalesRack.in</span>
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <!-- <li class="hidden">
                        <a href="#page-top"></a>
                    </li> -->
                    <li id="about">
                        <a class="page-scroll" href="${contextRoot}/about">About</a>
                    </li>
                    <li id="contact">
                        <a class="page-scroll" href="${contextRoot}/contact">Contact</a>
                    </li>
                    <li id="manageProduct">
                        <a class="page-scroll" href="${contextRoot}/show/all/products">View Products</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>