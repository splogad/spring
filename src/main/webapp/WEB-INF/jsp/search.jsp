<%@include file="includes/header.jsp"%>
    <link rel="stylesheet" href="./css/search/search.css">
    <div class="container">
      <div class="example" id="the-basics">       
          <div class="example" id="scrollable-dropdown-menu">
             <div class="demo">
		  <span class="" style="position: relative; display: inline-block;">
			<input class="typeahead tt-hint" type="text" readonly="" autocomplete="off" spellcheck="false" tabindex="-1" style="position: absolute; top: 0px; left: 0px; border-color: transparent; box-shadow: none; opacity: 1; 
				background: none 0% 0% / auto repeat scroll 	padding-box border-box rgb(255, 255, 255);" dir="ltr">
			<input class="typeahead tt-input" type="text" placeholder="Countries" autocomplete="off" spellcheck="false" dir="auto" style="position: relative; vertical-align: top; background-color: transparent;">
		  </span>
		</div>        
	    </div>   
	</div>
    </div>

    <script src="./js/search/handlebars.js"></script>
    <script src="./js/search/jquery-1.10.2.min.js"></script>
    <script src="./js/search/typeahead.bundle.js"></script>
    <script src="./js/search/examples.js"></script>
    <script>
      (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

      ga('create', 'UA-31893438-2', 'auto');
      ga('send', 'pageview');
    </script>
  
<%@include file="includes/footer.jsp"%>